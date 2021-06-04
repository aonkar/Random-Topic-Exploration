package com.example.demo5;

public class IndexEqualValues {

    public static void main(String[] args) {
        System.out.println(indexEqualsValue(new int[]{-12, 1, 2, 3, 12}));
    }

    public static int indexEqualsValue(int[] array) {
        int low = 0;
        int high = array.length;
        int index = 0;

        while(low <= high){
            int mid = (high+low)/2;
            if(mid == array[mid]){
                index = mid;
                high = mid -1;
                continue;
            }
            if(mid < array[mid]){
                high = mid -1;
            } else{
                low = mid + 1;
            }
        }
        return index;
    }
}
