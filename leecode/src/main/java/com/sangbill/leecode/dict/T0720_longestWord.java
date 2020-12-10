package com.sangbill.leecode.dict;

public class T0720_longestWord {
    public String longestWord(String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
        int N = trie.dfs();
        char[] str = new char[N];
        for (int i = 0; i < N; i++) {
            str[i] = (char) (trie.idx + 97);
            trie = trie.next[trie.idx];
        }
        return new String(str);
    }

    public class Trie {
        boolean end;
        Trie[] next;
        int idx;

        public Trie() {
            idx = -1;
            end = false;
            next = new Trie[26];
        }

        public void insert(String s) {
            Trie cur = this;
            for (char c : s.toCharArray()) {
                int k = c - 97;
                if (cur.next[k] == null){
                    cur.next[k] = new Trie();
                }
                cur = cur.next[k];
            }
            cur.end = true;
        }

        public int dfs() {
            int max = 0;
            for (int i = 0; i < 26; i++) {
                if (next[i] == null || !next[i].end) {
                    continue;
                }
                int k = 1 + next[i].dfs();
                if (k > max) {
                    max = k;
                    idx = i;
                }
            }
            return max;
        }
    }
}
