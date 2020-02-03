package datastructures.array;

import java.util.HashMap;
import java.util.Map;

public class LargestRange {

	public static void main(String[] args) {
		int[] result = largestRange(new int[] { 1, 11, 3, 0, 15, 5, 2, 4, 10, 7, 12, 6 });
		for (int curr : result) {
			System.out.print(curr);
		}
	}

	public static int[] largestRange(int[] array) {
		int[] result = new int[2];
		if(array.length == 1){
			result[0] = array[0];
			result[1] = array[0];
		} else if(array.length == 2){
			result[0] = array[0] > array[1] ? array[1] : array [0];
			result[1] = array[0] > array[1] ? array[0] : array [1];
		}
		else{
			
		Map<Integer, Boolean> numberMap = new HashMap<>();
		int actualMin = Integer.MAX_VALUE;
		int actualMax = Integer.MIN_VALUE;
		for (int i = 0; i < array.length; i++) {
			numberMap.put(array[i], true);
		}
		for (int i = 0; i < array.length; i++) {
			Boolean goBack = true;
			int countBack = 1;
			while (goBack) {
				goBack = numberMap.containsKey(array[i] - countBack) && numberMap.get(array[i] - countBack);
				if (goBack) {
					numberMap.put(array[i] - countBack, false);
					countBack++;
				}
			}
			int min = array[i] - countBack + 1;
			Boolean goFront = true;
			int countFront = 1;
			while (goFront) {
				goFront = numberMap.containsKey(array[i] + countFront) && numberMap.get(array[i] + countFront);
				if (goFront) {
					numberMap.put(array[i] - countFront, false);
					countFront++;
				}
			}
			int max = array[i] + countFront - 1;

			if (max - min > actualMax - actualMin) {
				actualMax = max;
				actualMin = min;
			}

		}
		result[0] = actualMin;
		result[1] = actualMax;
		}
		return result;
	}
}
