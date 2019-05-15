

/**
 * @author SuJiexi
 * @PackageName:Arithmetic
 * @ClassName:InserationSort
 * @Decription: Implement insertion sort in Java
 * @Date 2019/5/12 9:24
 * @TimeComplexity:O(n) -> 0(n^2)
 * @SpaceComplexity: O(1)
 * @Result:Ascending the method of implement is accending ,the method of implement2 is decending
 */
public class InserationSort {
    public int[] implement(int arr[]) {

        if (arr == null || arr.length < 2) {
            return arr;
        }
        for (int i = 1; i < arr.length; i++) {
            int temp =arr[i];
            for (int j = i; j > 0; j--) {
                if(arr[j]<arr[j-1]){
                    arr[j]=arr[j-1];
                    arr[j-1]=temp;
                }else{
                    break;
                }
            }
        }
        return arr;
    }

    public int[] implement2(int arr[]) {
        int key = arr[0];
        if (arr == null || arr.length < 2) {
            return arr;
        }
        for (int i = 1; i < arr.length; i++) {
            int temp =arr[i];
            for (int j = i; j > 0; j--) {
                if(arr[j]>arr[j-1]){
                    arr[j]=arr[j-1];
                    arr[j-1]=temp;
                }else{
                    break;
                }
            }
        }
        return arr;
    }
}
