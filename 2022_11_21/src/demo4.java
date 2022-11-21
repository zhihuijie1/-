import java.util.EmptyStackException;
import java.util.Stack;

public class demo4 {
    /**
     * 实现有getMin功能的栈
     */
    public static class MyStack1 {
        Stack<Integer> stack1; //不同的栈
        Stack<Integer> stack2; //单独设计的栈

        public MyStack1() {
            stack1 = new Stack<>();
            stack2 = new Stack<>();
        }

        //保证stack1与stack2的高度一样
        public void push(int newNum) {
            if (stack1.isEmpty()) {
                stack1.push(newNum);
                stack2.push(newNum);
            } else {
                stack1.push(newNum);
                if (newNum < stack2.peek()) {
                    stack2.push(newNum);
                } else {
                    stack2.push(stack2.peek());
                }
            }
        }

        public int pop() {
            if (stack1.isEmpty()) {
                throw new EmptyStackException();
            }
            stack2.pop();
            return stack1.pop();
        }

        public int getmin() {
            if (stack1.isEmpty()) {
                throw new EmptyStackException();
            }
            return stack2.peek();
        }
    }
}
