/*
 * Copyright (c) 2019 innoWake gmbh Germany. All rights reserved.
 */
package innowake.mining.plugin.annotation.ui.view;

import static innowake.lib.core.lang.Assert.assertNotNull;
import static innowake.mining.plugin.client.ApiClient.annotationService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.eclipse.core.resources.IProject;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.IViewSite;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.ui.plugin.AbstractUIPlugin;

import innowake.lib.core.api.lang.Nullable;
import innowake.mining.client.MiningServiceExecutor;
import innowake.mining.plugin.MiningPlugin;
import innowake.mining.plugin.base.ui.EditorActionUtil;
import innowake.mining.plugin.base.ui.EditorPartListener;
import innowake.mining.plugin.base.ui.LastSelectedProjectListener;
import innowake.mining.plugin.base.ui.LinkWithEditorAction;
import innowake.mining.plugin.base.ui.WorkbenchUtil;
import innowake.mining.plugin.client.ApiClient;
import innowake.mining.shared.model.Annotation;
import innowake.mining.shared.model.AnnotationCategory;
import innowake.mining.shared.model.AnnotationState;
import innowake.mining.shared.model.ModuleLocation;

/**
 * View used to manage the editor decorations.
 */
public class AnnotationSearchView extends ViewPart {
	
	/**
	 * Public ID to identify this view.
	 */
	public static final String ID = "innowake.mining.annotation.view.annotationSearch";

	final LastSelectedProjectListener projectSelectionListener = new LastSelectedProjectListener();

	@Nullable private AnnotationTableViewer tableViewer;
	private boolean linkedWithEditor = false;
	
	private final EditorPartListener editorListener;
	
	public AnnotationSearchView(){
		editorListener = new EditorPartListener();
		editorListener.addEditorChangeConsumer(this::refreshAnnotationIfLinkedWithEditor);
	}

	@Override
	public void init(@Nullable final IViewSite site, @Nullable final IMemento memento) throws PartInitException {
		super.init(site, memento);
		editorListener.activate(assertNotNull(site).getPage());
	}

	private void refreshAnnotationIfLinkedWithEditor(@Nullable final FileEditorInput input) {
		if (linkedWithEditor) {
			assertNotNull(input, "name field in FileEditorInput should not be null.");
			populateAnnotations(projectSelectionListener.getLastSelectedProject().orElse(null), new AnnotationState[0],
					new Long[0], input.getName().substring(0, input.getName().lastIndexOf('.')));
		}
	}

	@Override
	public void createPartControl(@Nullable final Composite parent) {
		assertNotNull(parent).setLayout(new GridLayout(1, false));
		
		final AnnotationTableViewer tableViewerCreated = new AnnotationTableViewer(assertNotNull(parent), SWT.BORDER | SWT.FULL_SELECTION | SWT.V_SCROLL);
		
		final Menu menuArtifactTable = new Menu(tableViewerCreated.getTable());
		tableViewerCreated.getTable().setMenu(menuArtifactTable);
		tableViewerCreated.getTable().setSortDirection(SWT.UP);
		tableViewerCreated.setComparator(new AnnotationTableViewerComparator());
		tableViewerCreated.addDoubleClickListener(event -> ((AnnotationTableElement) ((StructuredSelection) event.getSelection()).getFirstElement()).openInEditor());
		tableViewer = tableViewerCreated;
		
		final FilterAction filterAction = new FilterAction();
		filterAction.setToolTipText("Filter");
		filterAction.setImageDescriptor(AbstractUIPlugin.imageDescriptorFromPlugin(MiningPlugin.ID, "icons/filter.png"));
		getViewSite().getActionBars().getToolBarManager().add(filterAction);
		getViewSite().getActionBars().getToolBarManager().add(new LinkWithEditorAction(linkedWithEditor, this::linkWithEditor));
		final IWorkbenchPage page = getSite().getPage();
		page.addPostSelectionListener(projectSelectionListener);
		IWorkbenchPart activePart = page.getActivePart();
		if (activePart == null) {
			activePart = page.getActiveEditor();
		}
		projectSelectionListener.selectionChanged(activePart, page.getSelection());
	}
	
	private void linkWithEditor(final Boolean state) {
		linkedWithEditor = state.booleanValue();
	}
	
	@Override
	public void setFocus() {
		/* do nothing */
	}
	
	@Override
	public void dispose() {
		getSite().getPage().removePostSelectionListener(projectSelectionListener);
		super.dispose();
	}

	private class AnnotationTableViewerComparator extends ViewerComparator {

		@Override
		public int compare(@Nullable Viewer viewer, @Nullable Object e1, @Nullable Object e2) {
			
			if (e1 != null && e2 != null && viewer != null && e1 instanceof AnnotationTableElement && 
					e2 instanceof AnnotationTableElement && viewer instanceof AnnotationTableViewer) {
				final Table table = ((AnnotationTableViewer) viewer).getTable();
				final AnnotationTableElement element1 = (AnnotationTableElement) e1;
				final AnnotationTableElement element2 = (AnnotationTableElement) e2;
				final int sortDirectionCorrection = table.getSortDirection() == SWT.UP ? 1 : -1;
				switch (table.getSortColumn().getText()) {
					case AnnotationTableViewer.TYPE:
						return sortDirectionCorrection * element1.getTypeLabel().compareTo(element2.getTypeLabel());
					case AnnotationTableViewer.STATE:
						return sortDirectionCorrection * element1.getStateLabel().compareTo(element2.getStateLabel());
					case AnnotationTableViewer.RESOURCE:
						final String resourceLabel = element1.getResourceLabel();
						return resourceLabel != null ? sortDirectionCorrection * resourceLabel.compareTo(element2.getResourceLabel()) : super.compare(viewer, e1, e2);
					case AnnotationTableViewer.DESCRIPTION:
						return sortDirectionCorrection * element1.getDescriptionLabel().compareTo(element2.getDescriptionLabel());
					case AnnotationTableViewer.CATEGORY:
						final String categoryLabel = element1.getCategoryLabel();
						return categoryLabel != null ? sortDirectionCorrection * categoryLabel.compareTo(element2.getCategoryLabel()) : super.compare(viewer, e1, e2);
					default:
				}
			}
			return super.compare(viewer, e1, e2);
		}
	}

	private class AnnotationTableViewer extends TableViewer {

		private static final String DESCRIPTION = "Description";
		private static final String STATE = "State";
		private static final String RESOURCE = "Resource";
		private static final String CATEGORY = "Category";
		private static final String TYPE = "Type";
		private TableViewerColumn tvcType;
		private TableViewerColumn tvcCategory;
		private TableViewerColumn tvcResource;
		private TableViewerColumn tvcState;
		private TableViewerColumn tvcDescription;

		private AnnotationTableViewer(final Composite parent, final int style) {
			super(parent, style);
			setContentProvider(ArrayContentProvider.getInstance());
			getTable().setLinesVisible(true);
			getTable().setHeaderVisible(true);
			getTable().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));		

			tvcType = new TableViewerColumn(this, SWT.NONE);
			final TableColumn tvcTypeColumn = tvcType.getColumn();
			getTable().setSortColumn(tvcTypeColumn);
			tvcType.setLabelProvider(new ColumnLabelProvider() {
				
			    @Override
			    @Nullable
			    public String getText(@Nullable final Object element) {
			    	return element instanceof AnnotationTableElement ? ((AnnotationTableElement) element).getTypeLabel() : null;
			    }
			});
			tvcTypeColumn.setWidth(200);
			tvcTypeColumn.setText(TYPE);
			tvcTypeColumn.addSelectionListener(new ColumnSelectionListener(tvcTypeColumn));
			
			tvcCategory = new TableViewerColumn(this, SWT.NONE);
			tvcCategory.setLabelProvider(new ColumnLabelProvider() {
				
			    @Override
			    @Nullable
			    public String getText(@Nullable final Object element) {
			    	return element instanceof AnnotationTableElement ? ((AnnotationTableElement) element).getCategoryLabel() : null;
			    }
			});
			final TableColumn tvcCategoryColumn = tvcCategory.getColumn();
			tvcCategoryColumn.setWidth(200);
			tvcCategoryColumn.setText(CATEGORY);
			tvcCategoryColumn.addSelectionListener(new ColumnSelectionListener(tvcCategoryColumn));

			tvcResource = new TableViewerColumn(this, SWT.NONE);
			tvcResource.setLabelProvider(new ColumnLabelProvider() {
				
			    @Override
			    @Nullable
			    public String getText(@Nullable final Object element) {
			    	return element instanceof AnnotationTableElement ? ((AnnotationTableElement) element).getResourceLabel() : null;
			    }
			});
			final TableColumn tvcResourceColumn = tvcResource.getColumn();
			tvcResourceColumn.setWidth(200);
			tvcResourceColumn.setText(RESOURCE);
			tvcResourceColumn.addSelectionListener(new ColumnSelectionListener(tvcResourceColumn));
			
			tvcState = new TableViewerColumn(this, SWT.NONE);
			tvcState.setLabelProvider(new ColumnLabelProvider() {
				
			    @Override
			    @Nullable
			    public String getText(@Nullable final Object element) {
			    	return element instanceof AnnotationTableElement ? ((AnnotationTableElement) element).getStateLabel() : null;
			    }
			});
			final TableColumn tvcStateColumn = tvcState.getColumn();
			tvcStateColumn.setWidth(200);
			tvcStateColumn.setText(STATE);
			tvcStateColumn.addSelectionListener(new ColumnSelectionListener(tvcStateColumn));
			
			tvcDescription = new TableViewerColumn(this, SWT.NONE);
			tvcDescription.setLabelProvider(new ColumnLabelProvider() {
				
			    @Override
			    @Nullable
			    public String getText(@Nullable final Object element) {
			    	return element instanceof AnnotationTableElement ? ((AnnotationTableElement) element).getDescriptionLabel() : null;
			    }
			});
			final TableColumn tvcDescriptionColumn = tvcDescription.getColumn();
			tvcDescriptionColumn.setWidth(600);
			tvcDescriptionColumn.setText(DESCRIPTION);
			tvcDescriptionColumn.addSelectionListener(new ColumnSelectionListener(tvcDescriptionColumn));
		}
	}
	
	private class ColumnSelectionListener implements SelectionListener {
		
		private final TableColumn column;
		
		ColumnSelectionListener(final TableColumn column) {
			 this.column = column;
		}

		@Override
		public void widgetSelected(@Nullable final SelectionEvent e) {
			final AnnotationTableViewer tableViewerNonNull = assertNotNull(tableViewer);
			final Table table = tableViewerNonNull.getTable();
			if (column.equals(table.getSortColumn())) {
				table.setSortDirection(table.getSortDirection() == SWT.UP ? SWT.DOWN : SWT.UP);
			} else {
				table.setSortColumn(column);
				table.setSortDirection(SWT.UP);
			}
			tableViewerNonNull.refresh();
		}

		@Override
		public void widgetDefaultSelected(@Nullable final SelectionEvent e) {
			/* nothing */
		}
	}
	
	private class FilterAction extends Action {
		
		private FilterAction() {
			super("Filter");
		}

		@Override
		public void run() {
			final AnnotationFilterDialog dialog = new AnnotationFilterDialog(WorkbenchUtil.getActiveShell(),
					projectSelectionListener.getLastSelectedProject().orElse(null));
			assertNotNull(getEditorInput(), "FileEditorInput from editor input should not be null.");
			if (linkedWithEditor) {
				dialog.setModuleName(getEditorInput().getName());
			}
			if (dialog.open() == Window.OK) {
				final Filter filter = dialog.getFilter();
				final AnnotationState[] states = filter.states.stream().toArray(AnnotationState[]::new);
				final Long[] categoryIds = filter.categories.stream().map(AnnotationCategory::getId)
						.toArray(Long[]::new);
				String moduleNamePattern;
				if (linkedWithEditor) {
					assertNotNull(getEditorInput().getName(), "name field in FileEditorInput should not be null.");
					moduleNamePattern = getEditorInput().getName().substring(0,
							getEditorInput().getName().lastIndexOf('.'));
				} else {
					moduleNamePattern = filter.resourcePattern;
				}
				populateAnnotations(filter.project, states, categoryIds, moduleNamePattern);
			}
		}
	}
	
	private class AnnotationTableElement {
		
		private static final String OPEN_FILE_ERROR_TITLE = "Failed to open File";
		
		private final IProject project;
		private final Annotation annotation;
		@Nullable
		private final String modulePath;
		
		AnnotationTableElement(final Annotation annnotation, @Nullable final String modulePath, final IProject project) {
			this.project = project;
			this.annotation = annnotation;
			this.modulePath = modulePath;
		}
		
		String getTypeLabel() {
			return annotation.getType().getName();
		}
		
		@Nullable
		String getCategoryLabel() {
			return annotation.getCategoryName();
		}
		
		@Nullable
		String getResourceLabel() {
			return modulePath;
		}
		
		String getStateLabel() {
			return annotation.getState().getName();
		}
		
		String getDescriptionLabel() {
			return annotation.getName();
		}
		
		void openInEditor() {
			ModuleLocation location = annotation.getReference().getFromModuleLocation();
			if (location != null) {
				EditorActionUtil.openEditorAndGotoLine(project.getFile(modulePath), location.getOffset().intValue(), location.getLength().intValue());
			} else {
				MessageDialog.openError(WorkbenchUtil.getActiveShell(), OPEN_FILE_ERROR_TITLE, "No location information was found.");
			}			
		}
	}
	
	
	@Nullable
	private FileEditorInput getEditorInput() {
		@Nullable
		final IEditorPart editor = WorkbenchUtil.getActiveEditor();
		if (editor != null) {
			@Nullable
			final IEditorInput input = editor.getEditorInput();
			if (input instanceof FileEditorInput) {
				return (FileEditorInput) input;
			}
		}
		return null;
	}

	private Map<String, String> loadModulePaths(final Annotation[] annotations, final IProject project) {
		if (annotations.length == 0) {
			return Collections.emptyMap();
		}
		final Map<String, String> modulePaths = new HashMap<>();
		final StringBuilder sql = new StringBuilder("SELECT @rid, path FROM [");
		sql.append(Arrays.stream(annotations).map(element -> element.getReference().getFromId()).collect(Collectors.joining(",")));
		sql.append("]");
		final List<Map<String, String>> modulesResult = MiningServiceExecutor.create(() -> ApiClient.sqlServiceProvider(project)
				.executeSqlStatement().setStatement(sql.toString()))
				.executeWithDefaultErrorHandling()
				.orElse(Collections.emptyList());
		for (final Map<String, String> modulePath : modulesResult) {
			final String rid = modulePath.get("@rid");
			final String path = modulePath.get("path");
			modulePaths.put(rid, path);
		}
		return modulePaths;
	}
	
	private void populateAnnotations(final IProject project, final AnnotationState[] states, final Long[] categoryIds,
			final String moduleNamePattern) {
		final Annotation[] result = MiningServiceExecutor
				.create(() -> annotationService(project).findAllAnnotations().setCategoryIds(categoryIds)
						.setModuleNamePattern(moduleNamePattern).setStates(states))
				.executeWithDefaultErrorHandling().orElse(new Annotation[0]);
		final Map<String, String> modulePaths = loadModulePaths(result, project);
		final AnnotationTableViewer tableViewerNonNull = assertNotNull(tableViewer);
		tableViewerNonNull.getTable().removeAll();
		final List<AnnotationTableElement> annotationTableContent = new ArrayList<>();
		Arrays.stream(result).forEach(element -> annotationTableContent.add(new AnnotationTableElement(element,
				modulePaths.get(element.getReference().getFromId()), project)));
		tableViewerNonNull.setInput(annotationTableContent);
	}
}
