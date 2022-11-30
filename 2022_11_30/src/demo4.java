import java.util.Arrays;

public class demo4 {
    /**
     * 选择排序
     */
    public static void slectSort(int[] array) {
        if(array == null || array.length == 1) {
            return;
        }
        for (int left1 = 0; left1 < array.length; left1++) {
            int min = array[left1];
            for (int left2 = left1+1; left2 < array.length; left2++) {
                if(array[left2] < min) {
                    int temp = array[left2];
                    array[left2] = min;
                    min = temp;
                }
            }
            array[left1] = min;
        }
    }
    public static void main(String[] args) {
        int testTime = 100000; // 测试的次数
        int MaxValue = 100; // 随机生成数的取值范围是[-100,100]
        int MaxLength = 200; // 随机产生的数组的长度 [0, 200]
        for (int i = 0; i < testTime; i++) {
            int ArrayLength = (int)(Math.random() * MaxLength + 1); // 随机产生的数组的长度[1,200]
            int[] arr = new int[ArrayLength];
            for (int j = 0; j < ArrayLength; j++) {
                int value = (int)(Math.random() * MaxValue + 1) - (int)(Math.random() * MaxValue + 1); // 随机生成数的取值范围是[-100,100]
                arr[j] = value;
            }
            int[] arr2 = Arrays.copyOf(arr,arr.length);
            slectSort(arr);
            Arrays.sort(arr2);
            if(!Arrays.equals(arr,arr2)) {
                System.out.println("数据有误");
                break;
            }
        }
        System.out.println("测试成功");
    }
}
