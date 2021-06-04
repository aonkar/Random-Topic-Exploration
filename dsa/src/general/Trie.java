package com.example.demo5;

public class Trie {

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
            if(curr.nextCharacters[input.charAt(i) - 'a'] == null) {
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
