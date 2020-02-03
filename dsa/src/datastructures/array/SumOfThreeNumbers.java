package datastructures.array;

import java.util.*;

class SumOfThreeNumbers {
	
	public static void main(String[] args) {
		int[] test = new int[]{8, 10, -2, 49, 14};
		List<Integer[]> result = threeNumberSum(test, 57);
		result.forEach(array ->{
			List.of(array).forEach(System.out::print);
		});
	}

	public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {
		List<Integer[]> list = new ArrayList<>();
		for (int i = 0; i < array.length - 2; i++) {
			Integer current = i;
			Integer next = i + 1;
			Integer last = array.length - 1;
			while (next < last) {
				if (array[current] + array[next] + array[last] == targetSum) {
					list.add(new Integer[]{array[current],array[next],array[last]});
					last--;
					next++;
				} else if (array[current] + array[next] + array[last] > targetSum) {
					last--;
				} else {
					next++;
				}
			}
		}
		return list;
	}
}
