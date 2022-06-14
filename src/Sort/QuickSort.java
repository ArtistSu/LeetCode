package Sort;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = new int[]{2,1,3,3,4,2,1};
        new QuickSort().quickSort(arr,0, arr.length-1);
    }

    public int[] quickSort(int[] arr, int left, int right){
        if(left < right){
            int index = partition(arr, left, right);
            quickSort(arr,left, index-1);
            quickSort(arr,index+1, right);
        }
        return arr;
    }

    public int partition(int[] arr, int left, int right){
        int pivot = left;
        int index = pivot+1;
        if(left < right){
            for(int i = index; i<=right;i++){
                if(arr[i]<arr[pivot]){
                    swap(arr,i,index);
                    index++;
                }
            }
            swap(arr,pivot, index-1);
        }
        return index-1;
    }

    public void swap(int[] arr, int indexA, int indexB){
        int temp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = temp;
    }
}
