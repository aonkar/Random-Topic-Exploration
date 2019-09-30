package datastructures.array;

import java.util.Arrays;
import java.util.List;

public class ArrayRotation {

	public static void main(String[] args) {
		final List<Integer> array = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
		final int rotate = 6;
		rotateArrayLeft(array, rotate);

	}

	private static void rotateArrayLeft(final List<Integer> array, final int rotate) {
		final int rotateBy = rotate % array.size();
		reverseArray(array, 0, rotateBy);
		reverseArray(array, rotateBy, array.size());
		reverseArray(array, 0, array.size());
		array.forEach(System.out::print);
	}

	private static void reverseArray(final List<Integer> array, final int start, int end) {
		final int iterations = (start + end) / 2;
		for (int i = start; i < iterations; i++, end--) {
			int temp = array.get(i);
			array.set(i, array.get(end - 1));
			array.set(end - 1, temp);
		}
	}
}
