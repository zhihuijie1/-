package Novice_class;
// Math.random(): 等概率的返回[0,1)上的每一个数，注意返回类型是double类型

public class RandToRand {
    //  Math.random() -> x属于[0,1)之间，P[0,x] = x%
    // 现在想设计一个 Math.random() -> x属于[0,1)之间，P[0,x] = x^2%
    public static void func() {
        int testTime = 100000;
        int count1 = 0;
        int count2 = 0;
        int count3 = 0;
        for (int i = 0; i < testTime; i++) {
            double x = 0.3;
            if(Math.random() < x) {
                count1++;
            }
            if(xpoewrx2() < x) {
                count2++;
            }
            if(xpoewrx3() < x) {
                count3++;
            }
        }
        System.out.println(count1 * 1.0 / testTime);
        System.out.println(count2 * 1.0 / testTime);
        System.out.println(count3 * 1.0 / testTime);
    }

    public static double xpoewrx2() {
        return Math.min(Math.random(),Math.random());
    }
    public static double xpoewrx3() {
        return Math.min(Math.max(Math.random(),Math.random()),Math.random());
    }
    // 有f1这么一个函数：等概率返回[1,5]之间的数字
    // 我们想要[0,6]等概率返回一个
    public static int f1() {
        return (int)(Math.random() * 5) + 1;
    }

    // f2: 1，2 -> return 0    4,5 -> return 1   3 -> 重新加载
    // f2就是一个0 , 1发生器,并且是等概率的
    public static int f2() {
        int ans = f1();  // 1,2,3,4,5
        while(ans == 3) {
            ans = f1();
        }
        // 出来之后ans肯定不等于3
        return ans < 3 ? 0 : 1;
    }

    public static int f3() {
        // 000 —— 111 ：0 - 7
        int ans = (f2() << 2) + (f2() << 1) + (f2() << 0);
        // 返回 0 - 7：之间的数字是等概率的
        return ans;
    }

    public static int f4() {
        int ans = f3();
        while(ans == 7) {
            ans = f3();
        }
        // 出来之后肯定没有7
        return ans;
    }


    // 33~57等概率获得一个数,整数
    // 33~57 -> 0 -> 24 -> 1 1000 11111->31

    // 1-24等概率发生器
    public static int t1() {
        return (int)(Math.random() * 24) + 1;
    }

    // t2是一个0，1发生器
    // 12,13是[1,24]的一个中间值
    public static int t2() {
        int ans = t1();
        while(ans == 12 || ans == 13) {
            ans = t1();
        }
        // 出来之后肯定没有12 和 13
        return ans < 12 ? 0 : 1;
    }

    // 等概率的返回[0,24]
    public static int t3() {
        int ans = (t2() << 4) + (t2() << 3) + (t2() << 2) + (t2() << 1) + (t2() << 0);
        // ans : [0,31]
        while(ans > 24){
            ans = (t2() << 4) + (t2() << 3) + (t2() << 2) + (t2() << 1) + (t2() << 0);
        }
        return ans;
    }

    public static int t4() {
        return t3()+33;
    }

    public static void main(String[] args) {
        int[] array = new int[58];
        int testTimes = 100000;
        for (int i = 0; i < testTimes; i++) {
            array[t4()]++;
        }
        for (int i = 33; i <= 57; i++) {
            System.out.println(array[i]);
        }
    }

    // [3 , 19]是等概率的
    // 实现 [20 , 56]是等概率的
    public static int s1() {
        return (int)(Math.random() * 17) + 3;
    }

    // s2: 就是一个0，1发生器
    public static int s2() {
        int ans = s1();
        while(ans == 11) {
            ans = s1();
        }
        return ans < 11 ? 0 : 1;
    }

    // s3:[0 , 36] 是等概率的
    public static int s3() {
        int ans = (s2() << 5) + (s2() << 4) + (s2() << 3) + (s2() << 2) + (s2() << 1) + (s2() << 0);
        while(ans > 36) {
            ans = (s2() << 5) + (s2() << 4) + (s2() << 3) + (s2() << 2) + (s2() << 1) + (s2() << 0);
        }
        return ans;
    }

    // s4:[20 , 56]是等概率的
    public static int s4() {
        return s3() + 20;
    }


    // 你只知道x会以固定的概率返回0或者1，并且返回0/1的概率不同
    public static int x() {
        return Math.random() < 0.84 ? 0 : 1;
    }

    // 等概率的返回 0 / 1
    public static int y() {
        int ans = x();
        while(ans == x()) {
            ans = x();
        }
        return ans;
    }
}




















