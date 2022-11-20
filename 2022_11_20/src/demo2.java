import java.util.Arrays;

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
     * 用双向链表实现队列
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

    public static class MyQueue<T>{
        
    }
}


























