package datastructures.array;

import java.util.Arrays;
import java.util.List;

public class MoveNumbersToRight {

	public static void main(String[] args) {
		List<Integer> array = Arrays.asList(5, 5, 5, 5, 5, 5, 1, 2, 3, 4, 6, 7, 8, 9, 10, 11, 12);
		quickSort(array, 5);
		array.forEach(System.out::print);

	}

	public static List<Integer> quickSort(List<Integer> array, Integer toMove) {
		Integer index1 = 0;
		Integer index2 = 0;
		for (int i = 0; i < array.size(); i++) {
			if (array.get(i) == toMove) {
				index2++;

			} else {
				if (index1 != index2)
					swap(array, index1, index2);
				index1++;
				index2++;
			}
		}
		return array;
	}

	private static void swap(List<Integer> array, Integer index1, Integer index2) {
		Integer temp = array.get(index2);
		array.set(index2, array.get(index1));
		array.set(index1, temp);
	}
}