package com.example.demo5;

public class Vowels {

        public static void main(String[] args) {
            System.out.println(longestBeautifulSubstring("aiaeioouaaeeiouuiuieeo"));
        }
        public static int longestBeautifulSubstring(String word) {
            int maxLength = 0;
            int i = 0;
            int j = 0;
            int k = 0;
            Character[] vowels = new Character[]{'a', 'e', 'i', 'o', 'u'};
            while(j < word.length()){
                if(word.charAt(j) == vowels[k]){
                    if(j == word.length() -1 || word.charAt(j+1) != word.charAt(j)){
                        k++;
                    }
                    j++;
                } else{
                    i = j;
                    k = 0;
                    if(word.charAt(j) != vowels[k]){
                        i++;
                        j++;
                    }
                }
                if(k == vowels.length){
                    if((j - i) + 1 > maxLength){
                        maxLength = (j - i);
                    }
                    i = j;
                    k = 0;
                }
            }
            return maxLength;
        }
    }
