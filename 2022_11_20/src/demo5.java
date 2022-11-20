import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class demo5 {

    public static int onlyKTimes(int[] array,int k, int m) {
        int[] arr = new int[32];
        int ans = 0;
        for(int i = 0; i < array.length; i++) {
            for (int j = 0; j < 32; j++) {
                if((array[i] & (1 << j)) != 0) {
                    arr[j]++;
                }
            }
        }
        for (int i = 0; i < 32; i++) {
            if(arr[i] % m == k) {
                ans = (1 << i) | ans;
            }
        }
        return ans;
    }
    //对比方法
    public static int onlyTimes2(int[] array,int k, int m) {
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if(hashMap.containsKey(array[i])) {
                hashMap.put(array[i],hashMap.get(array[i])+1);
            }else {
                hashMap.put(array[i],1);
            }
        }
        for (int nub : hashMap.keySet()) {
            if(hashMap.get(nub) == k) {
                return nub;
            }
        }
        return -1;
    }

    // 对数器
    public static void main(String[] args) {
        int testTime = 100;
        int nubKinds = 10; //一个数组中数的种类个数
        int maxValues = 100; //[-100 , 100]
        for (int i = 0; i < testTime; i++) {
            int k = (int)(Math.random()*maxValues);
            int m = (int)(Math.random()*maxValues +1);
            while(m <= k) {
                m = (int)(Math.random()*maxValues);
            }
            int[] arr1 = randomArray(nubKinds,maxValues,k,m);
            int[] arr2 = copyOf(arr1);

            int a = onlyKTimes(arr1,k,m);
            int b = onlyTimes2(arr2,k,m);
            if(a != b) {
                System.out.println("error");
                System.out.println(Arrays.toString(arr1));
                break;
            }
        }
        System.out.println("true");
    }
    public static int[] randomArray(int nubKinds,int maxValues,int k,int m) {
        HashSet<Integer> set = new HashSet<>();
        int[] arr = new int[k + m*(nubKinds-1)];
        int knub = (int)(Math.random()*(maxValues+1));
        set.add(knub);
        int i = 0;
        for (i = 0; i < k; i++) {
            arr[i] = knub;
        }
        nubKinds--;
        while(nubKinds > 0) {
            int nub =(int)(Math.random()*(maxValues+1));
            while(set.contains(nub)) {
                nub =(int)(Math.random()*(maxValues+1));
            }
            set.add(nub);
            for (int j = 0; j < m; j++) {
                arr[i] = nub;
                i++;
            }
            nubKinds--;
        }
        for (int j = 0; j < arr.length; j++) {
            int y = (int)(Math.random()*arr.length);
            swap(arr,j,y);
        }
        return arr;
    }
    public static void swap(int[] array,int i,int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    public static int[] copyOf(int[] arr) {
        if(arr == null) {
            return null;
        }
        int[] array = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            array[i] = arr[i];
        }
        return array;
    }

}








