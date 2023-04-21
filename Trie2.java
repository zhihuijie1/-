package algorithmbasic.class9;


import java.util.HashMap;

public class Trie2 {
    // 内部类
    public static class Node {
        int pass;
        int end;
        HashMap<Integer, Node> map;

        public Node() {
            this.pass = 0;
            this.end = 0;
            this.map = new HashMap<>();
        }
    }

    // 属性：
    static Node root;

    // 构造器：
    public Trie2() {
        root = new Node();
    }

    // 方法：
    public static void insert(String word) {
        if (word == null) {
            return;
        }
        char[] str = word.toCharArray();
        Node cur = root;
        cur.pass++;
        for (char c : str) {
            int path = c - 'a';
            if (cur.map.get(path) == null) {
                cur.map.put(path, new Node());
            }
            cur = cur.map.get(path);
            cur.pass++;
        }
        cur.end++;
    }

    public static int search(String word) {
        if(word == null) {
            return 0;
        }
        char[] str = word.toCharArray();
        Node cur = root;
        for (char c : str) {
            int path = c - 'a';
            if (cur.map.get(path) == null) {
                return 0;
            }
            cur = cur.map.get(path);
        }
        return cur.end;
    }

    public static int prodix
}
