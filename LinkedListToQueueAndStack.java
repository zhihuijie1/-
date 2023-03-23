package Novice_class;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

// 单链表实现队列和栈
public class LinkedListToQueueAndStack {
    public static class Node<V> {
        public V value;
        Node<V> next;

        public Node(V value) {
            this.value = value;
        }
    }

    public static class MyQueue<V> {

        Node<V> head;
        Node<V> tail;
        int usedSized;

        public MyQueue() {
            head = null;
            tail = null;
            usedSized = 0;
        }

        public boolean isEmpty() {
            return this.usedSized == 0;
        }

        public int size() {
            return usedSized;
        }

        public void offer(V value) {
            Node<V> cur = new Node<>(value);
            if(head == null) {
                head = cur;
                tail = cur;
            }else {
                tail.next = cur;
                tail = cur;
            }
            tail.next = null;
            usedSized++;
        }

        public V poll() {
            if(this.isEmpty()) {
                return null;
            }
            V cur = head.value;
            head = head.next;
            if(head == null) {
                tail = null;
            }
            usedSized--;
            return cur;
        }

        public V peek() {
            return this.isEmpty() ? null : this.head.value;
        }
    }

    public static class MyStack<V> {
        Node<V> head;
        Node<V> tail;
        int usedSize;

        public MyStack() {
            this.head = null;
            this.tail = null;
            this.usedSize = 0;
        }

        public Boolean isEmpty() {
            return this.usedSize == 0;
        }

        public int size() {
            return this.usedSize;
        }

        public void push(V value) {
            Node<V> cur = new Node<>(value);
            if(head == null) {
                head = cur;
                tail = cur;
            }else {
                tail.next = cur;
                tail = cur;
            }
            tail.next = null;
            usedSize++;
        }

        public V pop() {
            if(head == null) {
                return null;
            }
            if(head == tail) {
                V value = this.head.value;
                head = null;
                tail = null;
                usedSize--;
                return value;
            }
            Node<V> cur = head;
            while(cur.next != tail) {
                cur = cur.next;
            }
            V value = this.tail.value;
            tail = cur;
            tail.next = null;
            usedSize--;
            return value;
        }
        public V peek() {
            return this.isEmpty() ? null : this.tail.value;
        }
    }
    public static void testStack() {
        MyStack<Integer> myStack = new MyStack<>();
        Stack<Integer> test = new Stack<>();
        int testTime = 5000000;
        int maxValue = 200000000;
        System.out.println("测试开始！");
        for (int i = 0; i < testTime; i++) {
            if (myStack.isEmpty() != test.isEmpty()) {
                System.out.println("isempty Oops!");
            }
            if (myStack.size() != test.size()) {
                System.out.println("size Oops!");
            }
            double decide = Math.random();
            if (decide < 0.33) {
                int num = (int) (Math.random() * maxValue);
                myStack.push(num);
                test.push(num);
            } else if (decide < 0.66) {
                if (!myStack.isEmpty()) {
                    int num1 = myStack.pop();
                    int num2 = test.pop();
                    if (num1 != num2) {
                        System.out.println("pop Oops!");
                    }
                }
            } else {
                if (!myStack.isEmpty()) {
                    int num1 = myStack.peek();
                    int num2 = test.peek();
                    if (num1 != num2) {
                        System.out.println("isempty Oops!");
                    }
                }
            }
        }
        if (myStack.size() != test.size()) {
            System.out.println("size Oops!");
        }
        while (!myStack.isEmpty()) {
            int num1 = myStack.pop();
            int num2 = test.pop();
            if (num1 != num2) {
                System.out.println("isempty Oops!");
            }
        }
        System.out.println("测试结束！");
    }

    public static void main(String[] args) {
        //testQueue();
        testStack();
    }
}


















