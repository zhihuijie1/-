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
            if (head == null) {
                head = cur;
                tail = cur;
            } else {
                tail.next = cur;
                tail = cur;
            }
            tail.next = null;
            usedSized++;
        }

        public V poll() {
            if (this.isEmpty()) {
                return null;
            }
            V cur = head.value;
            head = head.next;
            if (head == null) {
                tail = null;
            }
            usedSized--;
            return cur;
        }

        public V peek() {
            return this.isEmpty() ? null : this.head.value;
        }
    }

    // 单链表实现栈

    public static class MyStack<V> {
        Node<V> head;
        int usedSize;

        public MyStack() {
            this.head = null;
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
            cur.next = head;
            head = cur;
            usedSize++;
        }

        public V pop() {
            if (this.isEmpty()) {
                return null;
            }
            V value = this.head.value;
            head = head.next;
            //usedSize--;
            return value;
        }

        public V peek() {
            return this.isEmpty() ? null : this.head.value;
        }
    }


    // for test
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
            double decide = Math.random(); // 主要作用是判断概率
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
        // 全部弹出
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


    // for test
    public static void testStack2() {
        MyStack<Integer> stack1 = new MyStack<>();
        Stack<Integer> stack2 = new Stack<>();
        int testTime = 1000000;
        int MaxValue = 2200000;
        System.out.println("测试开始");
        for (int i = 0; i < testTime; i++) {
            if (stack1.isEmpty() != stack2.isEmpty()) {
                System.out.println("oops");
            }
            if (stack1.size() != stack2.size()) {
                System.out.println("oops");
            }
            double decide = Math.random();
            if (decide < 0.33) {
                int value = (int) (Math.random() * MaxValue);
                stack1.push(value);
                stack2.push(value);
            } else if (decide < 0.66) {
                if (!stack1.isEmpty()) {
                    int num1 = stack1.pop();
                    int num2 = stack2.pop();
                    if (num1 != num2) {
                        System.out.println("oops");
                    }
                }
            } else {
                if (!stack1.isEmpty()) {
                    int num1 = stack1.peek();
                    int num2 = stack2.peek();
                    if (num1 != num2) {
                        System.out.println("oops");
                    }
                }
            }
        }

        if (stack1.size() != stack2.size()) {
            System.out.println("oops");
        }

        while (!stack1.isEmpty()) {
            if (stack1.pop() != stack2.pop()) {
                System.out.println("oops");
            }
        }
        System.out.println("测试结束");
    }
}


















