package datastructures.heaps;

import java.util.ArrayList;
import java.util.List;

public class MinHeap {

	private final List<Integer> list = new ArrayList<>();

	public void addElement(Integer element) {
		list.add(element);
		Integer index = list.size() - 1;
		while ((index - 1) / 2 >= 0) {
			if (list.get((index - 1) / 2) > list.get(index)) {
				swap((index - 1) / 2, index);
				index = (index - 1) / 2;
			} else {
				break;
			}
		}
	}

	public void deleteElement() {
		if(list.size() == 0) {
			return;
		}
		swap(0, list.size() - 1);
		list.remove(list.size() - 1);
		Integer index = 0;
		while (index * 2 + 1 < list.size()) {
			if (index * 2 + 2 < list.size()) {
				Integer minIndex = list.get(index * 2 + 1) > list.get(index * 2 + 2) ? index * 2 + 2 : index * 2 + 1;
				if (list.get(index) > list.get(minIndex)) {
					swap(index, minIndex);
					index = minIndex;
				} else {
					break;
				}
			} else {
				if (list.get(index) > list.get(index * 2 + 1)) {
					swap(index, index * 2 + 1);
					index = index * 2 + 1;
				} else {
					break;
				}
			}
		}
	}

	public void displayElements() {
		System.out.println(toString());
	}

	private void swap(int index1, Integer index2) {
		Integer temp = list.get(index1);
		list.set(index1, list.get(index2));
		list.set(index2, temp);
	}

	@Override
	public String toString() {
		return "MinHeap [list=" + list + "]";
	}

}
