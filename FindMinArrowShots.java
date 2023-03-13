package P1_Heap;

import java.util.Arrays;
import java.util.Comparator;

public class FindMinArrowShots {
    /*
     452. 用最少数量的箭引爆气球
       有一些球形气球贴在一堵用 XY 平面表示的墙面上。墙面上的气球记录在整数数组 points ,
       其中points[i] = [xstart, xend] 表示水平直径在 xstart 和 xend之间的气球。你不知道气球的确切 y 坐标。
       一支弓箭可以沿着 x 轴从不同点 完全垂直 地射出。在坐标 x 处射出一支箭，
       若有一个气球的直径的开始和结束坐标为 xstart，xend， 且满足  xstart ≤ x ≤ xend，则该气球会被 引爆 。可以射出的弓箭的数量 没有限制 。 弓箭一旦被射出之后，可以无限地前进。
       给你一个数组 points ，返回引爆所有气球所必须射出的 最小 弓箭数 。
    */
    // 区间调度问题
    public int findMinArrowShots(int[][] points) {
        // 有多少个不重叠 -> 以通一个数为边也算重叠
        // 就是多少只箭
        Arrays.sort(points,new MyComparater());
        int x_end = points[0][1];
        int count = 1;
        for(int i = 1 ; i < points.length ; i++) {
            if(points[i][0] > x_end) { // 注意这个地方等于也算重叠
                count++;
                x_end = points[i][1];
            }
        }
        return count;
    }

    static class MyComparater implements Comparator<int[]> {
        public int compare(int[] o1, int[] o2) {
            // end从小到大排序
            return o1[1] - o2[1];
        }
    }


    /*
    * 435. 无重叠区间
    * 给定一个区间的集合 intervals ，其中 intervals[i] = [starti, endi] 。
    * 返回 需要移除区间的最小数量，使剩余区间互不重叠 。*/

    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, new MyCompater());
        int count = 1;
        int x_end  = intervals[0][1];
        for (int i = 0; i < intervals.length; i++) {
            if(intervals[i][0] > x_end) {
                count++;
                x_end = intervals[i][1];
            }
        }
        return count;
    }

    static class MyCompater implements Comparator<int[]> {
        @Override
        //从小到大排序
        public int compare(int[] o1, int[] o2) {
            return o1[1] - o2[1];
        }
    }
}
