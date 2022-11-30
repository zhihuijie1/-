import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class demo {
    /**
     * top k 问题
     */
    // 建立大根堆堆顶是最大的，只要比堆顶小就放进去，弹出堆顶，
    // 最后将堆中的元素一个一个的弹出来
    public static int[] smallestK(int[] arr, int k) {
        if(k == 0 || arr == null) {
            return new int[]{};
        }
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>( new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int i = 0; i < arr.length; i++) {
            if(priorityQueue.size() < k) {
                priorityQueue.add(arr[i]);
            }else {
                if(arr[i] < priorityQueue.peek()) {
                    priorityQueue.poll();
                    priorityQueue.add(arr[i]);
                }
            }
        }
        int[] array = new int[priorityQueue.size()];
        for (int i = 0; i < k; i++) {
            array[i] = priorityQueue.poll();
        }
        return array;
    }
}
