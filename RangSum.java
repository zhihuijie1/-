package Novice_class;

/**
 * 前缀和数组
 */
public class RangSum {
    public static int[] help;
    public static int rangSum(int[] array, int L, int R) {
        help = new int[array.length];
        help[0] = array[0];
        for (int i = 1; i < array.length; i++) {
            help[i] = help[i-1] + array[i];
        }
        return L == 0 ? help[R] : help[R] - help[L - 1];
    }

}
