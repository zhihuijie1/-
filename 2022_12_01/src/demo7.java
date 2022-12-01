import java.util.Arrays;

/**
 * 归并排序（非递归实现）
 */
public class demo7 {
    public static void mergeSor(int[] array) {
        int gap = 1;
        while(gap < array.length) {
            for(int i = 0; i< array.length; i = i+gap*2) {
                /**
                 这里的i就是left，进行一堆一堆的合并
                 left是不会越界的。但是mid与right可能会存在越界
                 */
                int left = i;
                int mid = left+gap-1;
                int right = mid + gap;
                //如果mid越界就调整一下
                if(mid >= array.length) {
                    mid = array.length-1;
                }
                //如果right越界就调整一下
                if(right >= array.length) {
                    right = array.length-1;
                }
                combine(array,left,right,mid);
            }
            gap = gap*2;
        }
    }

    public static void combine(int[] array,int left ,int right, int mid) {
        //将两个有序数组合并为一个有序数组
        int sl = left;
        int el = mid;
        int sr = mid+1;
        int er = right;

        int[] arr = new int[right-left+1];
        int k =0;

        while(sl <= el && sr <= er) {
            if(array[sl] < array[sr]) {
                arr[k] = array[sl];
                k++;
                sl++;
            }else{
                arr[k] = array[sr];
                k++;
                sr++;
            }
        }
        while(sl <= el) {
            arr[k] = array[sl];
            sl++;
            k++;
        }
        while(sr <= er) {
            arr[k] = array[sr];
            sr++;
            k++;
        }
        for(int j = 0; j < k; j++) {
            array[j+left] = arr[j];
            /**
             注意：arr数组中的下标是从0-k的，而array数组的下标是从left到right的，
             所以赋值的时候用array[j+left] = arr[j];
             */
            array[j+left] = arr[j];
        }
    }
    // 对数器
    public static void main(String[] args) {
        int testTime = 10000; // 测试的次数
        int MaxValue = 100; // 随机生成数的取值范围是[-100,100]
        int MaxLength = 30; // 随机产生的数组的长度 [0, 200]
        for (int i = 0; i < testTime; i++) {
            int ArrayLength = (int)(Math.random() * MaxLength + 1); // 随机产生的数组的长度[1,200]
            int[] arr = new int[ArrayLength];
            for (int j = 0; j < ArrayLength; j++) {
                int value = (int)(Math.random() * MaxValue + 1) - (int)(Math.random() * MaxValue + 1); // 随机生成数的取值范围是[-100,100]
                arr[j] = value;
            }
            int[] arr2 = Arrays.copyOf(arr,arr.length);
            mergeSor(arr);
            Arrays.sort(arr2);
            if(!Arrays.equals(arr,arr2)) {
                System.out.println("数据有误");
                System.out.println(Arrays.toString(arr));
                System.out.println(Arrays.toString(arr2));
                break;
            }
        }
        System.out.println("测试成功");
    }
}
