import java.util.Arrays;

public class demo4 {
    public static void main(String[] args) {
        int[] array = new int[]{6,1,2,7,9,3,4,10,8};
        sort(array,6);
        System.out.println(Arrays.toString(array));
    }
    public static void sort(int[] array,int index) {
        swap(array,0,index);
        int key = array[0];
        int right = array.length-1;
        int left = 0;
        while(left < right) {
            while(left < right && array[right] >= key) {
                right--;
            }
            swap(array,left,right);
            while(left < right && array[left] <= key) {
                left++;
            }
            swap(array,left,right);
        }
        array[left] = key;
    }
    public static void swap(int[] array, int i,int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
