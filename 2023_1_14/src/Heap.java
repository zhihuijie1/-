import java.util.Comparator;
import java.util.PriorityQueue;

public class Heap {
    // 内部类
    public static class MyMaxHeap {
        public int[] heap; // 堆本质上就是一个数组
        public final int limit; // 堆数组的最大长度
        public int usedSize; // usedSize指针 指定出堆的使用范围
        public MyMaxHeap(int limit) {
            heap = new int[limit];
            this.limit = limit;
            usedSize = 0;
        }

        public boolean isFull() {
            return this.limit == usedSize;
        }

        public boolean isEmpty() {
            return this.usedSize == 0;
        }
        // push:是从后面塞入的
        public void push(int value) {
            if(isFull()){
                throw new RuntimeException("this heap is Full");
            }
            // 先判断是否满了
            this.heap[usedSize] = value;
            usedSize++;
            heapInsert(this.heap, usedSize);
        }

        // 向上调整
        private void heapInsert(int[] heap, int usedSize) { // 把堆传进来， 把当前要调整的位置传进来
            int index = usedSize - 1; // 当前需要调整的位置
            int father = (index -1) / 2; // 所对应的父亲位置
            while(heap[index] > heap[father]) {
                /*
                 截止条件其实包含两部分，
                 1：heap[index] <= heap[father]停止
                 2：index = father = 0 停止
                 */
                swap(heap, index, father);
                index = father;
                father = (index -1) / 2;
            }
        }

        private void swap(int[] arr, int index, int father) {
            arr[index] = arr[index] ^ arr[father];
            arr[father] = arr[index] ^ arr[father];
            arr[index] = arr[index] ^ arr[father];
        }

        // pop:是从头上弹出的，如果是大根堆，弹出的永远是最大的
        public int pop() {
            if(isEmpty()){
                throw new RuntimeException("this heap is empty");
            }
            int ans = heap[0];
            swap(this.heap, usedSize-1, 0);
            usedSize--;
            heapify(this.heap, usedSize);
            return ans;
        }

        // 向下调整
        public void heapify(int[] heap, int usedSize) {
            int father = 0;
            int left = father * 2 + 1;
            while(left < usedSize) {
                int large = left+1 < usedSize && heap[left] < heap[left+1] ? left+1 : left;
                    // 有右孩子并且右孩子大于左孩子 ---> 反过来：1：有右孩子，右孩子小于等于左孩子
                    //                                    2：没有右孩子
                    //                              所以反过来全是左孩子的事。
                if(heap[large] > heap[father]) {
                    swap(this.heap, large, father);
                }else {
                    break;
                }
                father = large;
                left = father * 2 + 1;
            }
        }
    }

    public static class RightMaxHeap {
        private int[] arr;
        private final int limit;
        private int size;

        public RightMaxHeap(int limit) {
            arr = new int[limit];
            this.limit = limit;
            size = 0;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return size == limit;
        }

        public void push(int value) {
            if (size == limit) {
                throw new RuntimeException("heap is full");
            }
            arr[size++] = value;
        }

        public int pop() {
            int maxIndex = 0;
            for (int i = 1; i < size; i++) {
                if (arr[i] > arr[maxIndex]) {
                    maxIndex = i;
                }
            }
            int ans = arr[maxIndex];
            arr[maxIndex] = arr[--size];
            return ans;
        }

    }



    public static void main(String[] args) {
        int value = 1000; // 数字的最大值是1000
        int limit = 100; // 最大的数组长度是100
        int testTime = 100000; // 测试的次数
        for (int i = 0; i < testTime; i++) {
            int curLimit = (int)(Math.random() * limit + 1); // curLimit:[0,100]
            // 当前的数组长度
            MyMaxHeap my = new MyMaxHeap(curLimit);
            RightMaxHeap test = new RightMaxHeap(curLimit);
            int curOpTimes = (int)(Math.random() * limit); // curOpTimes:[0,limit)
            // 当前的操作次数
            for (int j = 0; j < curOpTimes; j++) {
                if(my.isEmpty() != test.isEmpty()) {
                    System.out.println("OOPS");
                    break;
                }
                if(my.isFull() != test.isFull()) {
                    System.out.println("OOPS");
                    break;
                }
                if(my.isEmpty()) {
                    int curValue = (int)(Math.random() * value + 1);
                    my.push(curValue);
                    test.push(curValue);
                }else if(my.isFull()) {
                    if(my.pop() != test.pop()) {
                        System.out.println("OOPS");
                        break;
                    }
                }else {
                    double nub = Math.random();
                    if(nub < 0.5) {
                        int curValue = (int)(Math.random() * value + 1);
                        my.push(curValue);
                        test.push(curValue);
                    }else {
                        if(my.pop() != test.pop()) {
                            System.out.println("OOPS");
                            break;
                        }
                    }
                }
            }
        }
        System.out.println("FINSH");
    }
}
