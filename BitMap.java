package Novice_class;

import java.util.HashSet;

// 实现位图
public class BitMap {
    private long[] bits;
    public BitMap(int max) {
        // max + 64 -> 当max == 63时，我们需要1个空间，当max == 0时我们需要1个空间
        bits = new long[(max + 64) >> 6];
    }

    public void add(int num) {
        /*
        // 属于哪个数组的下标
        int flg1 = num >> 6;
        // 属于当前数组下标下的哪个位置
        int flg2 = num & 63;
        bits[flg1] = (1L << flg2) | bits[flg1];
        */
        bits[num >> 6] |= (1L << (num & 63));
        // bits[num >> 6] |= (1L << (num & 63));

    }

    public void delete(int num) {
        /**
         * int flg1 = num >> 6;
         * int flg2 = num & 63;
         * bits[flg1] = bits[flg1] & ~(1L << flg2);
         */
        bits[num >> 6] &= ~(1L << (num & 63));
        // bits[num >> 6] &= ~(1L << (num & 63));
    }

    public boolean contains(int num) {
        return (bits[num >> 6] & (1L << (num & 63))) != 0;
        // return (bits[num >> 6] & (1L << (num & 63))) != 0;
    }

    public static void main(String[] args) {
        int testTime = 1000000;
        int maxValue = 1000000;
        BitMap bitMap = new BitMap(maxValue);
        HashSet<Integer> hashSet = new HashSet<>();
        System.out.println("测试开始");
        for (int i = 0; i < testTime; i++) {
            int value = (int)(Math.random()*maxValue);
            double decide = Math.random();
            if(decide < 0.333) {
                bitMap.add(value);
                hashSet.add(value);
            }else if(decide < 0.666) {
                bitMap.delete(value);
                hashSet.remove(value);
            }else {
                if(bitMap.contains(value) != hashSet.contains(value)) {
                    System.out.println("OOPS");
                    break;
                }
            }
        }

        for (int i = 0; i < maxValue; i++) {
            if(bitMap.contains(i) != hashSet.contains(i)) {
                System.out.println("OOPS");
            }
        }
        System.out.println("测试结束");
    }

}
