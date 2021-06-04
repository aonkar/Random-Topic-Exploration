package com.example.demo5;

public class ShiftedBinarySearch {

    public static void main(String[] args) {
        System.out.println(shiftedBinarySearch(new int[]{45, 61, 71, 72, 73, 0, 1, 21, 33, 37}, 33));
    }
    public static int shiftedBinarySearch(int[] array,
                                          int target) {
        int low = 0;
        int high = array.length - 1;
        int pivot = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (mid - 1 < 0 || mid + 1 == array.length) {
                break;
            }
            if (array[mid - 1] > array[mid] && array[mid + 1] > array[mid]) {
                pivot = mid;
                break;
            }
            if (array[0] <= array[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        low = 0;
        high = array.length - 1;
        if (pivot == -1) {
            if (array[0] > array[1]) {
                while (low <= high) {
                    int mid = (low + high) / 2;
                    if (array[mid] == target) {
                        return mid;
                    }
                    if (array[mid] > target) {
                        low = mid + 1;
                    } else {
                        high = mid - 1;
                    }
                }
            } else {
                while (low <= high) {
                    int mid = (low + high) / 2;
                    if (array[mid] == target) {
                        return mid;
                    }
                    if (array[mid] > target) {
                        high = mid - 1;

                    } else {
                        low = mid + 1;
                    }
                }
            }
        } else {

            if (array[array.length - 1] < target) {
                low = 0;
                high = pivot - 1;
                while (low <= high) {
                    int mid = (low + high) / 2;
                    if (array[mid] == target) {
                        return mid;
                    }
                    if (array[mid] > target) {
                        high = mid - 1;

                    } else {
                        low = mid + 1;
                    }
                }
            } else {
                low = pivot + 1;
                high = array.length - 1;
                while (low <= high) {
                    int mid = (low + high) / 2;
                    if (array[mid] == target) {
                        return mid;
                    }
                    if (array[mid] > target) {
                        high = mid - 1;

                    } else {
                        low = mid + 1;
                    }
                }
            }
        }
        return -1;
    }
}
