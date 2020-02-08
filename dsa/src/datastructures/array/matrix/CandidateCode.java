package datastructures.array.matrix;

/* Read input from STDIN. Print your output to STDOUT*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class CandidateCode {
	private static int result = 0;
	private static int batSize = 0;
	private static final Map<Integer, List<List<WeightPrice>>> visited = new HashMap<>();

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Integer cricketers = scan.nextInt();
		Integer bats = scan.nextInt();
		List<WeightPrice> batsList = new ArrayList<>();
		List<WeightPrice> cricketersList = new ArrayList<>();
		for (int i = 0; i < cricketers; i++) {
			cricketersList.add(new WeightPrice(scan.nextInt(), scan.nextInt()));
		}

		for (int i = 0; i < bats; i++) {
			batsList.add(new WeightPrice(scan.nextInt(), scan.nextInt()));
		}
		scan.close();
		List<List<WeightPrice>> finalList = getSelectedBats(batsList, cricketersList);
		batSize = batsList.size();
		findMaxCombination(finalList, finalList.get(0), 0, new ArrayList<WeightPrice>(), 0);
		System.out.println(result);
	}

	private static List<List<WeightPrice>> getSelectedBats(List<WeightPrice> batsList,
			List<WeightPrice> cricketersList) {
		List<List<WeightPrice>> finalList = new ArrayList<>();
		for (WeightPrice cricketer : cricketersList) {
			List<WeightPrice> selectedList = new ArrayList<>();
			for (WeightPrice bat : batsList) {
				if (bat.getPrice() <= cricketer.getPrice() && bat.getWeight() > cricketer.getWeight()) {
					selectedList.add(bat);
				}
			}
			if (!selectedList.isEmpty()) {
				finalList.add(selectedList);
			}
		}
		return finalList;
	}

	private static void findMaxCombination(List<List<WeightPrice>> finalList, List<WeightPrice> list, int count,
			List<WeightPrice> listTobeRemoved, int finalCount) {

		if (count != 0 && checkIfCombinationAlreadyChecked(count, listTobeRemoved)) {
			return;
		}
		List<WeightPrice> temp = new ArrayList<>();
		list.removeAll(listTobeRemoved);
		for (WeightPrice currElem : listTobeRemoved) {
			if (list.remove(currElem)) {
				temp.add(currElem);
			}
		}

		if (count == finalList.size() - 1) {
			if (list.isEmpty()) {
				if (result < finalCount) {
					result = finalCount;
				}
			} else {
				if (result < finalCount + 1) {
					result = finalCount + 1;
				}
			}
			if (result == batSize) {
				System.out.println(result);
				System.exit(0);
			}
			if (list.size() != temp.size()) {
				list.addAll(temp);
			}
			return;
		}
		if (!list.isEmpty()) {
			for (int i = 0; i < list.size(); i++) {
				listTobeRemoved.add(list.get(i));
				findMaxCombination(finalList, finalList.get(count + 1), count + 1, listTobeRemoved, finalCount + 1);
				if (list.size() != temp.size()) {
					list.addAll(temp);
				}
				listTobeRemoved.remove(list.get(i));
			}
		} else {
			findMaxCombination(finalList, finalList.get(count + 1), count + 1, listTobeRemoved, finalCount);
			if (list.size() != temp.size()) {
				list.addAll(temp);
			}

		}

	}

	private static boolean checkIfCombinationAlreadyChecked(int count, List<WeightPrice> listTobeRemoved) {
		List<List<WeightPrice>> visitedLists = visited.get(count);
		if (visitedLists != null && !listTobeRemoved.isEmpty()) {
			for (List<WeightPrice> visitedList : visitedLists) {
				if (visitedList.containsAll(listTobeRemoved)) {
					return true;
				}
			}
			visitedLists.add(listTobeRemoved);
		} else if (!listTobeRemoved.isEmpty()) {
			List<List<WeightPrice>> newList = new ArrayList<>();
			newList.add(newList.size(), listTobeRemoved);
			visited.put(count, newList);
		}
		return false;
	}

	public static class WeightPrice {
		private Integer weight;
		private Integer price;

		public WeightPrice(Integer weight, Integer price) {
			this.weight = weight;
			this.price = price;
		}

		public Integer getWeight() {
			return weight;
		}

		public void setWeight(Integer weight) {
			this.weight = weight;
		}

		public Integer getPrice() {
			return price;
		}

		public void setPrice(Integer price) {
			this.price = price;
		}

		@Override
		public int hashCode() {
			return 1;
		}

		@Override
		public boolean equals(Object obj) {
			return this == obj;
		}

	}
}