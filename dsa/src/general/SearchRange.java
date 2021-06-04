package com.example.demo5;

public class SearchRange {

    public static void main(String[] args) {
        System.out.println(searchForRange(new int[]{0,
                1,
                21,
                33,
                45,
                45,
                45,
                45,
                45,
                45,
                61,
                71,
                73}, 45)[0]);
        System.out.println(searchForRange(new int[]{0,
                1,
                21,
                33,
                45,
                45,
                45,
                45,
                45,
                45,
                61,
                71,
                73}, 45)[1]);
    }

    public static int[] searchForRange(int[] array,
                                       int target) {
        int[] output = new int[]{-1,
                -1};
        int low = 0;
        int high = array.length - 1;
        int pivot = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (array[mid] > target) {
                high = mid - 1;
            } else if (array[mid] < target) {
                low = mid + 1;
            } else {
                pivot = mid;
                break;
            }
        }
        low = 0;
        high = pivot;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (mid -1 != -1 && array[mid] == target && array[mid - 1]  < target) {
                output[0] = mid;
                break;
            } else if (array[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        low = pivot + 1;
        high = array.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (mid + 1 != array.length && array[mid+1] > target && array[mid] == target) {
                output[1] = mid;
                break;
            } else if (array[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        if(output[0] == -1){
            output[0] = 0;
        }
        if(output[1] == -1){
            output[1] = array.length -1;
        }
        return output;
    }
}
