package com.sangbill.leecode.dict;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        Tri tri = new Tri();
        for (int i = 0; i < dictionary.size(); i++) {
            tri.insert(dictionary.get(i));
        }

        StringBuilder sb = new StringBuilder();
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            sb.append(tri.replaceWord(words[i])+" ");
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }

    public class Tri {
        Node root;

        public Tri() {
            root = new Node(0);
        }

        public void insert(String word) {
            int k;
            char[] c = word.toCharArray();
            Node cur = root;
            for (int i = 0; i < c.length; i++) {
                k = c[i] - 'a';
                if (cur.next[k] == null) {
                    cur.next[k] = new Node(k);
                }
                cur = cur.next[k];
            }
            cur.end = true;
        }

        public String replaceWord(String word) {
            int k;
            Node cur = root;
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

    public class Node {
        int k;
        boolean end;
        Node[] next;

        public Node(int k) {
            this.k = k;
            this.end = false;
            this.next = new Node[26];
        }
    }

    public static void main(String[] args) {
        String[] dictionary = {"a", "aa", "aaa", "aaaa"};
        List list = Arrays.stream(dictionary).collect(Collectors.toList());
        String sentence = "a aa a aaaa aaa aaa aaa aaaaaa bbb baba abab";
        Solution su = new Solution();
        String rs = su.replaceWords(list,sentence);
        System.out.println(rs);
    }
}