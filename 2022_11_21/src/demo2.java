import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class demo2 {
    /**
     * 链表实现栈与队列
     * 以及其对数器的实现
     */
    public static class Node<T> {
        public T value;
        public demo2.Node<T> last;
        public demo2.Node<T> next;

        public Node(T data) {
            value = data;
        }
    }

    /**
     * 用双向链表实现一个队列既可以头插也可以尾插，既可以头出也可以尾出
     */
    public static class DoubleEndsQueue<T> {
        public Node<T> head;
        public Node<T> tail;
        // 从头部进行插入
        public void addFromHead(T value){
            Node<T> node = new Node<>(value);
            if(isEmpty()) {
                head = node;
                tail = node;
            }else {
                head.last = node;
                node.next = head;
                head = node;
            }
        }
        //从尾部进行插入
        public void addFromBottom(T value){
            Node<T> node = new Node<>(value);
            if(isEmpty()) {
                head = node;
                tail = node;
            }else {
                node.last = tail;
                tail.next = head;
                tail = node;
            }
        }
        // 从头部进行删除（重点注意一下这个）
        // 保证删除完的节点与tail和head没有丝毫联系
        public T popFromHead(){
            if(isEmpty()) {
                return null;
            }
            Node<T> cur = head; // cur保存要删除的节点
            if(tail == head) {
                tail = null;
                head = null;
            }else {
                head = head.next;
                head.last = null;
                cur.next = null;
            }
            return cur.value;
        }
        //从尾部开始删除节点
        public T popFromBottom(){
            if(isEmpty()) {
                return null;
            }
            Node<T> cur = tail;
            if(head == tail) {
                head = null;
                tail = null;
            }else {
                tail = tail.last;
                tail.next = null;
                cur.last = null;
            }
            return cur.value;
        }

        public boolean isEmpty(){
            if(head == null) {
                return true;
            }
            return false;
        }
    }

    /**
     * 用队列来实现栈的功能
     */
    public static class MyStack<T> {
        private DoubleEndsQueue<T> queue;
        public MyStack(){
            queue = new DoubleEndsQueue<T>();
        }
        public void push(T value) {
            queue.addFromHead(value);
        }
        public T pop() {
            return queue.popFromHead();
        }
        public boolean isEmpty(){
            return queue.isEmpty();
        }
    }

    /**
     * 用双向链表实现队列
     */

    public static class MyQueue<T> {
        private DoubleEndsQueue<T> queue;
        public MyQueue() {
            queue = new DoubleEndsQueue<>();
        }
        public void push (T value) {
            queue.addFromHead(value);
        }
        public T poll() {
            return queue.popFromBottom();
        }
        public boolean isEmpty() {
            return queue.isEmpty();
        }
    }
    /**
    对数器
    */
    public static void main(String[] args) {
        int testTimes = 10000; //测试次数
        int oneTimeTestNum = (int)((Math.random()*51)+50); // [50,100] 一次测试的要产生的数目
        int maxValue = 100; // 每个数的最大取值
        for (int i = 0; i < testTimes; i++) {
            MyStack<Integer> myStack = new MyStack<>();
            MyQueue<Integer> myQueue = new MyQueue<>();
            Stack<Integer> stack = new Stack<>();
            Queue<Integer> queue = new LinkedList<>();
            for (int j = 0; j < oneTimeTestNum; j++) {
                int value = (int)(Math.random()*maxValue); // 产生的数的范围：[0,99]
                if(myStack.isEmpty() && stack.isEmpty()) {
                    stack.push(value);
                    myStack.push(value);
                }else {
                    if(Math.random() < 0.5) {
                        stack.push(value);
                        myStack.push(value);
                    }else {
                        int a1 = stack.pop();
                        int a2 = myStack.pop();
                        if(!isEmpty(a1,a2)) {
                            System.out.println("栈有误");
                            break;
                        }
                    }
                }
                int numq = (int) (Math.random() * value);
                if (queue.isEmpty()) {
                    myQueue.push(numq);
                    queue.offer(numq);
                } else {
                    if (Math.random() < 0.5) {
                        myQueue.push(numq);
                        queue.offer(numq);
                    } else {
                        if (!isEmpty(myQueue.poll(), queue.poll())) {
                            System.out.println("队列有误");
                            break;
                        }
                    }
                }
            }
        }
        System.out.println("正确");
    }
    public static boolean isEmpty(Integer o1,Integer o2) {
        if(o1 == null && o2 == null) {
            return true;
        }
        if(o1 == null || o2 == null) {
            return false;
        }
        return o1.equals(o2);
    }

}
