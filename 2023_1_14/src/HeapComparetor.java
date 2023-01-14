import java.util.Comparator;
import java.util.PriorityQueue;

public class HeapComparetor {
    public static void main(String[] args) {
        PriorityQueue<Integer> p = new PriorityQueue<>(new MyComparator()); // 想要建立一个大根堆
        p.add(1);
        p.add(4);
        p.add(3);
        p.add(0);
        System.out.println(p.poll());
    }
}

class MyComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        return o2 - o1;
    }
}