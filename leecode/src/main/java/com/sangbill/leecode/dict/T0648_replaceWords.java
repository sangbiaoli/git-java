package com.sangbill.leecode.dict;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class T0648_replaceWords {
    public String replaceWords(List<String> dictionary, String sentence) {
        Trie trie = new Trie(0);
        for (int i = 0; i < dictionary.size(); i++) {
            trie.insert(dictionary.get(i));
        }

        StringBuilder sb = new StringBuilder();
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            sb.append(trie.replaceWord(words[i])+" ");
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }

    public class Trie {
        int k;
        boolean end;
        Trie[] next;

        public Trie(int k) {
            this.k = k;
            this.end = false;
            this.next = new Trie[26];
        }

        public void insert(String word) {
            int k;
            char[] c = word.toCharArray();
            Trie cur = this;
            for (int i = 0; i < c.length; i++) {
                k = c[i] - 'a';
                if (cur.next[k] == null) {
                    cur.next[k] = new Trie(k);
                }
                cur = cur.next[k];
            }
            cur.end = true;
        }

        public String replaceWord(String word) {
            int k;
            Trie cur = this;
            char[] c = word.toCharArray();
            for (int i = 0; i < c.length; i++) {
                k = c[i] - 'a';
                if (cur.next[k] == null) {
                    return word;
                }
                if (cur.next[k].end) {
                    return word.substring(0, i + 1);
                } else {
                    cur = cur.next[k];
                }
            }
            return word;
        }
    }


    public static void main(String[] args) {
        String[] dictionary = {"a", "aa", "aaa", "aaaa"};
        List list = Arrays.stream(dictionary).collect(Collectors.toList());
        String sentence = "a aa a aaaa aaa aaa aaa aaaaaa bbb baba abab";
        T0648_replaceWords su = new T0648_replaceWords();
        String rs = su.replaceWords(list,sentence);
        System.out.println(rs);
    }
}