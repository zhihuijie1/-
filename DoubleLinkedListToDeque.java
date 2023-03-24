package Novice_class;

import java.util.Deque;
import java.util.LinkedList;

// 使用双链表实现双端队列
public class DoubleLinkedListToDeque<V> {

    public static class Node<V> {
        V value;
        Node<V> next;
        Node<V> last;

        public Node(V value) {
            this.value = value;
        }
    }

    Node<V> head;
    Node<V> tail;
    int usedSize;

    public DoubleLinkedListToDeque() {
        head = null;
        tail = null;
        usedSize = 0;
    }

    public boolean isEmpty() {
        return this.usedSize == 0;
    }

    public int size() {
        return this.usedSize;
    }

    public void pushHead(V value) {
        Node<V> cur = new Node<>(value);
        if(head == null) {
            tail = cur;
            head = cur;
        }else {
            cur.next = head;
            head.last = cur;
            head = cur;
        }
        usedSize++;
    }

    public void pushTail(V value) {
        Node<V> cur = new Node<>(value);
        if(head == null) {
            tail = cur;
            head = cur;
        }else {
            tail.next = cur;
            cur.last = tail;
            tail = cur;
        }
        usedSize++;
    }

    public V popHead() {
        if(this.head == null) {
            return null;
        }
        V cur = this.head.value;
        if(this.head == this.tail) {
            this.head = null;
            this.tail = null;
        }else {
            head = head.next;
            head.last = null;
        }
        usedSize--;
        return cur;
    }

    public V popTail() {
        if(this.head == null) {
            return null;
        }
        V cur = this.tail.value;
        if(this.head == this.tail) {
            this.head = null;
            this.tail = null;
        }else {
            tail = tail.last;
            tail.next = null;
        }
        usedSize--;
        return cur;
    }

    public V peekHead() {
        return this.isEmpty() ? null : this.head.value;
    }

    public V peekTail() {
        return this.isEmpty() ? null : this.tail.value;
    }

    // for test

    public static void testDeque() {
        DoubleLinkedListToDeque<Integer> myDeque = new DoubleLinkedListToDeque<>();
        Deque<Integer> test = new LinkedList<>();
        int testTime = 5000000;
        int maxValue = 200000000;
        System.out.println("测试开始！");
        for (int i = 0; i < testTime; i++) {
            if (myDeque.isEmpty() != test.isEmpty()) {
                System.out.println("Oops!");
            }
            if (myDeque.size() != test.size()) {
                System.out.println("Oops!");
            }
            double decide = Math.random();
            if (decide < 0.33) {
                int num = (int) (Math.random() * maxValue);
                if (Math.random() < 0.5) {
                    myDeque.pushHead(num);
                    test.addFirst(num);
                } else {
                    myDeque.pushTail(num);
                    test.addLast(num);
                }
            } else if (decide < 0.66) {
                if (!myDeque.isEmpty()) {
                    int num1 = 0;
                    int num2 = 0;
                    if (Math.random() < 0.5) {
                        num1 = myDeque.popHead();
                        num2 = test.pollFirst();
                    } else {
                        num1 = myDeque.popTail();
                        num2 = test.pollLast();
                    }
                    if (num1 != num2) {
                        System.out.println("Oops!");
                    }
                }
            } else {
                if (!myDeque.isEmpty()) {
                    int num1 = 0;
                    int num2 = 0;
                    if (Math.random() < 0.5) {
                        num1 = myDeque.peekHead();
                        num2 = test.peekFirst();
                    } else {
                        num1 = myDeque.peekTail();
                        num2 = test.peekLast();
                    }
                    if (num1 != num2) {
                        System.out.println("Oops!");
                    }
                }
            }
        }
        if (myDeque.size() != test.size()) {
            System.out.println("Oops!");
        }
        while (!myDeque.isEmpty()) {
            int num1 = myDeque.popHead();
            int num2 = test.pollFirst();
            if (num1 != num2) {
                System.out.println("Oops!");
            }
        }
        System.out.println("测试结束！");
    }

    public static void main(String[] args) {
        testDeque();
    }
}
