class Solution {
       // Trie Node
    static class Node {
        Node[] children = new Node[26];
        boolean eow = false;
    }

    // Insert word into Trie
    private void insert(Node root, String word) {
        Node curr = root;
        for (char ch : word.toCharArray()) {
            int idx = ch - 'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
        }
        curr.eow = true;
    }

    public List<String> findWords(char[][] board, String[] words) {
        Node root = new Node();

        // Build Trie
        for (String w : words) {
            insert(root, w);
        }

        Set<String> result = new HashSet<>();
        boolean[][] visited = new boolean[board.length][board[0].length];

        // Start DFS from each cell
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, root, "", visited, result);
            }
        }
        return new ArrayList<>(result);
    }

    // DFS function
    private void dfs(char[][] board, int i, int j, Node root, String path,
                     boolean[][] visited, Set<String> result) {
        // boundary + visited check
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || visited[i][j]) {
            return;
        }

        char ch = board[i][j];
        if (root.children[ch - 'a'] == null) return;

        // move to next node in trie
        root = root.children[ch - 'a'];
        path += ch;

        if (root.eow) {
            result.add(path);
        }

        // mark visited
        visited[i][j] = true;

        // explore neighbors
        dfs(board, i + 1, j, root, path, visited, result);
        dfs(board, i - 1, j, root, path, visited, result);
        dfs(board, i, j + 1, root, path, visited, result);
        dfs(board, i, j - 1, root, path, visited, result);

        // backtrack
        visited[i][j] = false;
     }

}