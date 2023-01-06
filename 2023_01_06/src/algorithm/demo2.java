package algorithm;
/**
 * 荷兰国旗问题
 */
public class demo2 {
    // arr[L...R] 玩荷兰国旗问题的划分，以arr[R]做划分值
    // <arr[R] ==arr[R] > arr[R]
    public static int[] netherlandsFlag(int[] arr, int L, int R) {
        if(L > R) {
            return new int[]{ -1,  -1 };
        }
        if(L == R) {
            return new int[]{ L , R };
        }
        int stand = arr[R]; // 最后一个数作为标准
        int less = L - 1; // < stand 的区域
        int more = R; // > stand 的区域
        int index = L; // 指向当前数
        while(index < more) {
            if(arr[index] == stand) {
                index++;
            }else if(arr[index] < stand) {
                swap(arr, less + 1, index);
                less++;
                index++;
            }else {
                swap(arr, index, more + 1);
                more++;
            }
        }
        swap(arr, R, more);
        return new int[]{ less + 1, more };
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
/**
 * 1：分析时间复杂度：
 *    index不回退，时间复杂度是 N
 * 2：刚开始index指向的数，有三种可能性，1：> stand 2: < stand 3: = stand
 *    < stand: less++  --->  index++
 *    > stand: swap(arr, index, more-1), more-- 交换完之后，现在more前面的数一定 > stand , 但是 现在index位置上的数 不知道 大小
 *    所以这个位置需要再次判断
 *    = stand： index++   --->    < stand 被左区域吃了，> stand 被右区域吃了 = stand的不吃。
 *
 *    下一次 index 指向的数，也是有三种情况，并且index有可能在less前一个，也可能在less的前几个
 *    分析：---->  假设index现在在less的前几个： index 指向的数，有三种情况，
 *                    --->   < stand 的处理方法  --->  分析： less前面的数，
 *                                                    ---> 首先less前面的数我们都判断过，如果是 >stand 话一定被右区域吃了
 *                                                         如果是 <stand 的话一定被左区域吃了，所以less前面的数一定是 =stand 的
 *                                              --->  解决： swap(arr, index, less+1); less++ , index++
 *                    --->   > stand 与 = stand 的处理方法跟上后面一致
 */
