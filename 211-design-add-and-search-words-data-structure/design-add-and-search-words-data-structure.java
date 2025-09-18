class WordDictionary {
    public class Node {
        Node children[];
        boolean eow;

        public Node() {
            children = new Node[26];
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
            eow = false;
        }
    }

    private Node root;

    public WordDictionary() {
        root = new Node();
    }

    public void addWord(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';

            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }

            if (i == word.length() - 1) {
                curr.children[idx].eow = true;
            }

            curr = curr.children[idx];
        }
    }

    public boolean search(String word) {
        Node curr = root;
        return matchDotAndSearch(word, curr);
    }

    private boolean matchDotAndSearch(String word, Node start) {
        Node curr = start;

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);

            if (ch == '.') {
                // try all 26 possible children
                for (int j = 0; j < 26; j++) {
                    if (curr.children[j] != null &&
                            matchDotAndSearch(word.substring(i + 1), curr.children[j])) {
                        return true;
                    }
                }
                return false; // no match found for '.'
            } else {
                int idx = ch - 'a';

                if (curr.children[idx] == null) {
                    return false; // path breaks
                }
               
                curr = curr.children[idx]; // ✅ move forward
            }
        }

        return curr.eow; // ✅ if loop finishes without failure
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */