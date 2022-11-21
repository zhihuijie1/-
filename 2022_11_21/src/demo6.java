import java.util.Stack;

public class demo6 {
    /**
     * 两个栈实现队列
     */
    public static class  TwoStackQueue {
        Stack<Integer> stackPush;
        Stack<Integer> stackPop;

        public TwoStackQueue() {
            stackPush = new Stack<>();
            stackPop = new Stack<>();
        }

        public void offer(int value) {
            stackPush.push(value);
        }
        public int poll() {
            if(stackPop.isEmpty()) {
                stackPushToPop();
            }
            return stackPop.pop();
        }
        public void stackPushToPop() {
            while(!stackPush.isEmpty()) {
                stackPop.push(stackPush.pop());
            }
        }
        public int peek() {
            if(stackPop.isEmpty()) {
                stackPushToPop();
            }
            return stackPop.peek();
        }
    }
}
