package com.example.demo5;

import java.util.HashMap;
import java.util.Map;

public class PalindromicPartitionMinCut {

    public static void main(String[] args) {
        System.out.println(palindromePartitioningMinCuts("apjesgpsxoeiokmqmfgvjslcjukbqxpsobyhjpbgdfruqdkeiszrlmtwgfxyfostpqczidfljwfbbrflkgdvtytbgqalguewnhvvmcgxboycffopmtmhtfizxkmeftcucxpobxmelmjtuzigsxnncxpaibgpuijwhankxbplpyejxmrrjgeoevqozwdtgospohznkoyzocjlracchjqnggbfeebmuvbicbvmpuleywrpzwsihivnrwtxcukwplgtobhgxukwrdlszfaiqxwjvrgxnsveedxseeyeykarqnjrtlaliyudpacctzizcftjlunlgnfwcqqxcqikocqffsjyurzwysfjmswvhbrmshjuzsgpwyubtfbnwajuvrfhlccvfwhxfqthkcwhatktymgxostjlztwdxritygbrbibdgkezvzajizxasjnrcjwzdfvdnwwqeyumkamhzoqhnqjfzwzbixclcxqrtniznemxeahfozp"));
    }

    public static int palindromePartitioningMinCuts(String str) {
        if (isPalindrome(str,0, str.length() -1))
            return 0;
        return getMinCuts(str, 0, str.length() -1, new HashMap<>());
    }

    private static int getMinCuts(String str, int low, int high, Map<String,Integer> cache){
        if(cache.containsKey(low + " " + high)){
            return cache.get(low + " " + high);
        }
        System.out.println("Hi");
        if(low > high){
            return 0;
        }
        if(isPalindrome(str, low, high)){
            return 0;
        }

        int min = Integer.MAX_VALUE;
        for(int k = low; k < high;k++){
            int left = 0;
            int right = 0;
            if(cache.containsKey(low + " " + k)){
                left = cache.get(low + " " + k);
            } else{
                left = getMinCuts(str,low,k, cache);
                cache.put(low + " " + k, left);
            }
            int dummy = k + 1;
            if(cache.containsKey(dummy + " " + high)){
                right = cache.get(dummy + " " + high);
            } else{
                right = getMinCuts(str,k+1,high, cache);
                cache.put(dummy + " " + high, right);
            }
            int temp = left + right + 1;
            if(temp != Integer.MAX_VALUE && min > temp){
                min = temp;
                cache.put(low + " " + high, min);
            }
        }
        return min;
    }

    private static boolean isPalindrome(String string, int i, int j) {
        while (i < j) {
            if (string.charAt(i++) != string.charAt(j--)) {
                return false;
            }
        }
        return true;
    }
}
