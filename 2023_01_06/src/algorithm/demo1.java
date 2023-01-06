package algorithm;
/**
 * 荷兰国旗问题
 */
public class demo1 {

    // arr[L..R]上，以arr[R]位置的数做划分值
    // <= X > X
    // <= X X
    public static int partition(int[] arr, int L, int R) {
        if(L < R) {
            return -1;
        }
        if(L == R) {
            return L;
        }
        int stand = arr[R]; // 以最后一个作为标准
        int less = L - 1; // 左边界区域，主要是放 <= X 的数
        int index = L; // 下标index主要是当前的指向
        while(index < R) {
            if(arr[index] <= stand) {
                swap(arr, less+1, index);
                less++;
                index++;
            }else {
                index++;
            }
        }
        swap(arr, less+1, R);
        less++;
        return less;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
