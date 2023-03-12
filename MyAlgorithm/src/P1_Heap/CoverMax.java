package P1_Heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class CoverMax {
    /*
    * 线段最大重合问题
        给定很多线段，每个线段都有两个数[start, end]，
        表示线段开始位置和结束位置，左右都是闭区间
        规定：
        1）线段的开始和结束位置一定都是整数值
        2）线段重合区域的长度必须>=1
        返回线段最多重合区域中，包含了几条线段
    */
    public static int maxCover1(int[][] lines) {
        // 创建两个临时变量，来标识所有线段中的最小开始位置与最大终止位置
        // 标识出线段的范围
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < lines.length; i++) {
            min = Math.min(min, lines[i][0]);
            max = Math.max(max, lines[0][i]);
        }
        // 在[min, max]范围内找每个.5所对应的线段数有多少，找出最大的线段数
        int cover = 0;
        for (double i = min + 0.5; i < lines.length; i = i + 1) {
            int cur = 0;
            for (int j = 0; j < lines.length; j++) {
                if(lines[j][0] < i && i < lines[j][1]) {
                    cur++;
                }
            }
            cover = Math.max(cur,cover);
        }
        return cover;
    }
    /* 此方法的时间复杂度分析：默认10^8是上限边界
       时间复杂度是：（max - min）* N
       特定情况下是可以过的
     */


    /**
     * 思路梳理：有很多的线段，每个线段的开始位置，结束位置都是整数，假设线段重合最多的区域是[a , b]，那a一定是某个线段的开始位置，b也一定是某个线段的结束位置，
     * 但是[a , b]不一定是一个线段。我们找到重合区域[a , b]，然后再计算该区域有多少条线段重合是比较困难的。所以我们就把问题转为 “ 求穿过起始位置最多的线段数 ”
     * 因为 [a , b]是线段重合最多的区域，说明线段 >=a的很多即穿过a的很多。
     * 求每个起始位置穿过的线段的条数
     */
    public static int maxCover2(int[][] m) {
        Line[] lines = new Line[m.length];
        for (int i = 0; i < lines.length; i++) {
            lines[i] = new Line(m[i][0], m[i][1]);
        }
        Arrays.sort(lines,new MyComparator());
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(); // 默认是小根堆
        int cover = 0;
        for (int i = 0; i < lines.length; i++) {
            int cur = 0;
            while(!priorityQueue.isEmpty() && priorityQueue.peek() < lines[i].start) {
                priorityQueue.poll();
            }
            priorityQueue.add(lines[i].end);
            cur = priorityQueue.size();
            cover = Math.max(cur, cover);
        }
        return cover;
    }

    public static class Line {
        int start;
        int end;
        public Line(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static class MyComparator implements Comparator<Line> {
        @Override
        public int compare(Line o1, Line o2) {
            return o1.start - o2.start;
        }
    }
    
}
