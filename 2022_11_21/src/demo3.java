public class demo3 {
    /**
     * 用环形数组实现栈和队列
     */
    public static class MyQueue {
        int[] arr;
        int end = 0; // 用来放数的位置
        int begin = 0; // 用来取数的位置
        int size = 0; // 记录数组中数据元素的个数
        public MyQueue(int limit) {
            arr = new int[limit];
        }
        public  void push(int val) {
            if(size == arr.length) {
                throw new RunningtimeException("数组满了");
            }
            arr[end] = val;
            size++;
            end++;
            if(end >= arr.length) {
                end = 0;
            }
        }
        public int poll() {
            if(size == 0) {
                throw new EmptyQueueExpection("空队列异常");
            }
            int ans = arr[begin];
            size--;
            begin++;
            if(begin >= arr.length) {
                begin = 0;
            }
            return ans;
        }
    }
}
