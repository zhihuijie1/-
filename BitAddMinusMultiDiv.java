package Novice_class;
// 用位运算实现 + - * /
public class BitAddMinusMultiDiv {

    public static int add(int a, int b) {
        int sum = a;
        while(b != 0) {
            sum = a ^ b; // 无进位相加信息
            b = (a & b) << 1; // 进位信心
            a = sum;
        }
        return sum;
    }

    public static int minus(int a, int b) {
        return add(a,negNum(b));
    }

    public static int multi(int a, int b) {
        int sum = 0;
        while(b != 0) {
            if((b & 1) != 0) {
                sum = add(sum , a);
            }
            b >>>= 1;
            a <<= 1;
        }
        return sum;
    }

    public static int div(int a, int b) {
        int x = isNeg(a) ? negNum(a) : a;
        int y = isNeg(b) ? negNum(b) : b;
        // x / y
        int ans = 0;
        for (int i = 30; i >= 0; i--) {
            if((x >> i) >= y) {
                ans |= (1 << i);
                x = minus(x,y << i);
            }
        }
        return isNeg(a) != isNeg(b) ? negNum(ans) : ans;
    }

    public static int divide(int a, int b) {
        if(a == Integer.MIN_VALUE && b == Integer.MIN_VALUE) {
            return 1;
        }else if(b == Integer.MIN_VALUE) {
            return 0;
        }else if(a == Integer.MIN_VALUE) {
            if(b == negNum(1)) {
                return Integer.MAX_VALUE;
            }else {
                /*
                * c = (a + 1) / b
                * d = a - b * c
                * e = d / b
                * return e + c
                * */
                int c = div(add(a , 1), b);
                return add(c , div(minus(a,multi(b,c)),b));
            }
        }else {
            return div(a , b);
        }
    }

    // 判断是否是负数
    public static boolean isNeg(int n) {
        return n < 0;
    }

    // 取相反数
    public static int negNum(int n) {
        return add((~n),1);
    }
}
