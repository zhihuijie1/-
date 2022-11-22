import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class demo1 {
    /**
     * 两个队列实现栈
     */
    public static class TwoQueueStack<T> {
        Queue<T> queue;
        Queue<T> helper;

        public TwoQueueStack () {
            queue = new LinkedList<>();
            helper = new LinkedList<>();
        }

        public void push(T value) {
            queue.offer(value);
        }

        public T poll() {
            if(queue.isEmpty()) {
                throw new EmptyStackException("空栈异常");
            }else {
                while(queue.size() > 1) {
                    helper.offer(queue.poll());
                }
                T ans = queue.poll();
                Queue<T> temp = queue;
                queue = helper;
                helper = temp;
                return ans;
            }
        }

        public T peek() {
            if(queue.isEmpty()) {
                throw new EmptyStackException("空栈异常");
            }else {
                while(queue.size() > 1) {
                    helper.offer(queue.poll());
                }
                T ans = queue.peek();
                helper.offer(queue.poll());
                Queue<T> temp = queue;
                queue = helper;
                helper = temp;
                return ans;
            }
        }
        public boolean isEmpty() {
            return queue.isEmpty();
        }
    }
    public static void main(String[] args) {
        int testTime = 100000;
        int maxValue = 10000;
        TwoQueueStack<Integer> twoQueueStack = new TwoQueueStack<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < testTime; i++) {
            if(!twoQueueStack.isEmpty() && !stack.isEmpty()) {
                double a = Math.random();
                if(a < 0.25) {
                    int num = (int)(Math.random() * maxValue); //[0,999]
                    stack.push(num);
                    twoQueueStack.push(num);
                }else if(a < 0.5){
                    if(!twoQueueStack.poll().equals(stack.pop())) {
                        System.out.println("2:错误");
                        break;
                    }
                }else if(a < 0.75) {
                    if(!twoQueueStack.peek().equals(stack.peek())) {
                        System.out.println("3:错误");
                        break;
                    }
                }else {
                    if(twoQueueStack.isEmpty() != stack.isEmpty()) {
                        System.out.println("4:错误");
                        break;
                    }
                }
            }else {
                if(twoQueueStack.isEmpty() && stack.isEmpty()) {
                    int num = (int)(Math.random() * maxValue); //[0,999]
                    twoQueueStack.push(num);
                    stack.push(num);
                }else {
                    System.out.println("1:错误");
                    break;
                }
            }
        }
        System.out.println("正确");
    }
}





















