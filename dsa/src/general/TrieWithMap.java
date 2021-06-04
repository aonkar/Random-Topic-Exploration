package com.example.demo5;

import java.util.HashMap;
import java.util.Map;

public class TrieWithMap {
    private TrieNode rootNode;

    public TrieWithMap(){
        this.rootNode = new TrieNode('*', false);
    }


    private class TrieNode{
        private final Character data;
        private Map<Character,TrieNode> nextChars;
        private boolean endOfWord;
        TrieNode(Character data, boolean endOfWord){
            this.data = data;
            this.nextChars = new HashMap<>();
            this.endOfWord = endOfWord;
        }

    }
}
