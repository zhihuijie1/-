public class demo5 {
    /**
     * 归并排序（递归实现）
     */
    public void mergeSort(int[] array) {
        mergeS(array,0,array.length-1);
    }
    public void mergeS(int[] array, int left, int right) {
        if(left >= right) {
            return;
        }
        int mid = (left+right)/2;
        mergeS(array,left,mid);
        mergeS(array,mid+1,right);
        //合并
        combine(array,left,right,mid);
    }
    //合并函数
    public void combine(int[] array,int left ,int right, int mid) {
        //将两个有序数组合并为一个有序数组
        int sl = left;
        int el = mid;
        int sr = mid+1;
        int er = right;

        int[] arr = new int[right-left+1];
        int k =0;

        while(sl <= el && sr <= er) {
            if(array[sl] < array[sr]) {
                arr[k] = array[sl];
                k++;
                sl++;
            }else{
                arr[k] = array[sr];
                k++;
                sr++;
            }
        }
        while(sl <= el) {
            arr[k] = array[sl];
            sl++;
            k++;
        }
        while(sr <= er) {
            arr[k] = array[sr];
            sr++;
            k++;
        }
        for(int j = 0; j < k; j++) {
            array[j+left] = arr[j];
            /**
             注意：arr数组中的下标是从0-k的，而array数组的下标是从left到right的，
             所以赋值的时候用array[j+left] = arr[j];
             */
            array[j+left] = arr[j];
        }
    }

}
