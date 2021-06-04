package com.example.demo5;

import java.util.ArrayList;
import java.util.List;

public class PrefixTest {

    public static void main(String[] args) {
        multiStringSearch("this is a big string", new String[]{"this",
                "yo",
                "is",
                "a",
                "bigger",
                "string",
                "kappa"});
    }

    public static List<Boolean> multiStringSearch(String bigString,
                                                  String[] smallStrings) {
        Trie trie = new Trie();
        String[] inputArray = bigString.split(" ");
        for (int i = 0; i < inputArray.length; i++) {
            trie.populateWord(inputArray[i]);
        }
        List<Boolean> output = new ArrayList<>();
        for (int i = 0; i < smallStrings.length; i++) {
            output.add(trie.searchWord(smallStrings[i]));
        }
        return output;
    }

    public static class Trie {

        private final TrieNode rootNode;

        public Trie() {
            this.rootNode = new TrieNode('\0', false);
        }

        public void populateWord(final String input) {
            TrieNode curr = rootNode;
            for (int i = 0; i < input.length(); i++) {
                final int index = input.charAt(i) - 'a';
                if (curr.nextCharacters[input.charAt(i) - 'a'] == null) {
                    curr.nextCharacters[input.charAt(i) - 'a'] = new TrieNode(input.charAt(i), false);
                }
                curr = curr.nextCharacters[input.charAt(i) - 'a'];
            }
            curr.setWordEnd(true);
        }

        public boolean searchWord(final String input) {
            TrieNode node = getNode(input);
            return node != null && node.isWordEnd();
        }

        private TrieNode getNode(final String input) {
            TrieNode curr = rootNode;
            for (int i = 0; i < input.length(); i++) {
                if (curr.nextCharacters[input.charAt(i) - 'a'] == null) {
                    return null;
                }
                curr = curr.nextCharacters[input.charAt(i) - 'a'];
            }
            return curr;
        }

        private class TrieNode {
            private final Character data;
            private final TrieNode[] nextCharacters;
            private boolean wordEnd = false;

            private TrieNode(final Character data,
                             final boolean wordEnd) {
                this.data = data;
                this.wordEnd = wordEnd;
                this.nextCharacters = new TrieNode[26];
            }

            public TrieNode[] getNextCharacters() {
                return nextCharacters;
            }

            public Character getData() {
                return data;
            }

            public boolean isWordEnd() {
                return wordEnd;
            }

            public void setWordEnd(final boolean wordEnd) {
                this.wordEnd = wordEnd;
            }
        }
    }
}
