/**
 * 自主实现
 */
public class demo2 {
    /**
     * 归并排序的递归实现
     */
    public static void mergeSort1(int[] array) {
        if(array == null || array.length < 2) {
            return;
        }
        // 进行归并排序
        process(array , 0 , array.length-1);
    }

    public static void process(int[] array , int L , int R) {
        if(L == R) {
            return;
        }
        int mid = L + (R - L) / 2; // 确定中点下标
        process(array , 0 , mid);
        process(array , mid+1 , R);
        merge(array , L , mid , R);
        // merge函数 : 将两个有序的数组合成一个有序的数组
        // 传参的考究： 将两个数组的的范围要传过去
    }

    public static void merge(int[] arr , int L , int mid , int R) {
        int[] help = new int[R - L + 1];
        // 先创建一个临时数组
        int i = 0;
        // 一个指针，指向临时数组待放元素的位置
        int left = L;
        int right = mid + 1;
        // 两个指针left 与 right 分别指向两个有序数组的头节点
        while(left <= L && right <= R) {
            if(arr[left] > arr[right]) {
                help[i] = arr[right];
                i++;
                right++;
            }else {
                help[i] = arr[left];
                i++;
                left++;
            }
        }
        while(left <= mid) {
            help[i] = arr[left];
            left++;
            i++;
        }
        while(right <= R) {
            help[i] = arr[right];
            right++;
            i++;
        }

        for (int j = 0; j < help.length; j++) {
            arr[L + i] = help[j];
        }
    }
    /**
     * 分析一下时间复杂度：
     * 大问题被均分成了2个小问题，而且每个小问题的规模是一样的，所以对于递归时间复杂度分析可以使用master公式
     * T(N) = 2 * T( N / 2 ) + O(N)
     *  a = 2 , b = 2 , d = 1
     *  logb的a = log 2 的 2 == 1 ，d == 1 所以 logb的a==b 所以时间复杂度是：N^b * logN == n*logN
     */


    /**
     * 归并排序的非递归实现方法
     */
    public static void mergeSort2(int[] array) {
        int N = array.length;
        int step = 1;
        // 定义一个步长，意思是：几个数一组
        while(step < N) {
            int left = 0;
            while(left < N) {
                int mid = left + step -1;
                if(mid >= N-1) {
                    break;
                }
                int right = Math.min(mid + step , N-1);
                // 创建三个指针，来标识两个数组的范围
                merge(array , left , mid , right);
                // 出来之后就有序了
                left = right + 1;
            }
            // 防止溢出
            if(step  > N / 2) {
                break;
            }
            /**
             * 防溢出设计：
             *
             * 当数组的长度非常大时，step*2可能会越界，比如超出整数范围，这样step就会变成负数，这样的话程序就出现错误
             *
             *
             * 当数组长度 N 是偶数时：当step = (N/2) 时就已经可以,此时step < N
             * 当数组长度 N 是奇数时：当step = (N/2)*2 时才可以,此时step < N
             * 即 step小于N就已经排好序了
             *
             *
             */
            step <<= 1;
        }
    }
}























