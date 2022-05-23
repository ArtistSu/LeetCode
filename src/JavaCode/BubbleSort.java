package JavaCode;

public class BubbleSort{
    public static void main(String[] args) {
        int[] arr = new int[]{132,4512,123,5125,58,1231,325311,1,1,3,51,123};
        int[] res = bubbleSort(arr);
        for(int ele: res){
            System.out.print(ele+" ");
        }
    }
    public static int[] bubbleSort(int[] arr){
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr.length -1-i; j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j]=temp;
                }
            }
        }
        return arr;
    }
}
