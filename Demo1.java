package Novice_class;
// 阶乘
public class Demo1 {

    // 方法一：
    public static long factorial1(int n) {
        long sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += func(i);
        }
        return sum;
    }

    public static long func(int n) {
        long ans = 1;
        for (int i = 1; i <= n; i++) {
            ans = ans * i;
        }
        return ans;
    }

    // 方法二：
    public static long factorial2(int n) {
        long sum = 0;
        long ans = func(1);
        sum += ans;
        for (int i = 2; i <= n; i++) {
            ans = ans * i;
            sum += ans;
        }
        return sum;
    }


    public static void main(String[] args) {
        int n = 5;
        System.out.println(factorial1(n));
        System.out.println(factorial2(n));
    }
}
