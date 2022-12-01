import java.util.Arrays;

public class demo6 {
    /**
     * 归并排序 (递归实现)
     * 先递归，后归并
     * 递归：递归成一块一块的（1个数或2个数）
     * 归并：两个两个的合并在一块
     */
    public static void mergeSort(int[] array) {
        merge(array,0,array.length-1);
    }
    public static void merge(int[] array, int left, int right) {
        //递归的结束条件
        if(left >= right) {
            return;
        }
        int mid = (left + right) / 2;
        merge(array,left,mid);
        merge(array,mid+1,right);
        //相当于二叉树的后序遍历
        combine(array,left,mid,right);
    }
    public static void combine(int[] array,int left, int mid, int right) {
        int[] arr = new int[right-left+1];
        int L = left;
        int R = mid+1;
        int k = 0;
        while(L <= mid && R <= right) {
            if(array[L] < array[R]) {
                arr[k] = array[L];
                k++;
                L++;
            }else {
                arr[k] = array[R];
                k++;
                R++;
            }
        }
        while(L <= mid) {
            arr[k] = array[L];
            k++;
            L++;
        }
        while(R <= right) {
            arr[k] = array[R];
            k++;
            R++;
        }
        for (int i = left; i <= right; i++) {
            array[i] = arr[i-left];
        }
    }

    // 对数器
    public static void main(String[] args) {
        int testTime = 10000; // 测试的次数
        int MaxValue = 100; // 随机生成数的取值范围是[-100,100]
        int MaxLength = 100; // 随机产生的数组的长度 [0, 200]
        for (int i = 0; i < testTime; i++) {
            int ArrayLength = (int)(Math.random() * MaxLength + 1); // 随机产生的数组的长度[1,200]
            int[] arr = new int[ArrayLength];
            for (int j = 0; j < ArrayLength; j++) {
                int value = (int)(Math.random() * MaxValue + 1) - (int)(Math.random() * MaxValue + 1); // 随机生成数的取值范围是[-100,100]
                arr[j] = value;
            }
            int[] arr2 = Arrays.copyOf(arr,arr.length);
            mergeSort(arr);
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
















