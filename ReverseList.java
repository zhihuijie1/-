package Novice_class;

public class ReverseList {
    // 反转链表


    public static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    // 反转单链表
    public static Node reverseLinkedList(Node head) {
        // 注意：这里的head是一个形参，是对实参的一份拷贝，它的指向并不影响实参
        Node pre = null;
        while (head != null) {
            Node next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static class DoubleNode {
        int value;
        DoubleNode next;
        DoubleNode last;

        public DoubleNode(int value) {
            this.value = value;
        }
    }

    // 反转双链表

    public static DoubleNode reverseDoubleList(DoubleNode head) {
        DoubleNode pre = null;
        while (head != null) {
            DoubleNode next = head.next;
            head.next = pre;
            head.last = next;
            pre = head;
            head = next;
        }
        return pre;
    }
}












