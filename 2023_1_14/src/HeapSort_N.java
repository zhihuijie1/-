public class HeapSort_N {

    public static void heapSort(int[] arr) {
        int index = (arr.length-2) / 2;
        for (int i = index; i >= 0; i--) {
            heapify(arr, index, arr.length); // index：起始位置  arr.length：终止位置
        }
    }

    public static void heapify(int[] arr,int index, int usedSize) { // index:起始位置
        int left = index * 2 + 1;
        while(left < usedSize) {
            int large = left+1 < usedSize && arr[left+1] > arr[left] ? left+1 : left;
            if(arr[large] > arr[index]) {
                swap(arr, large, index);
            }else {
                break;
            }
            index = large;
            left = index * 2 + 1;
        }
    }

    public static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

}
