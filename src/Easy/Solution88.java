
/**
 *@PackageName:Easy
 *@ClassName:Solution88
 *@Decription:Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as
 * one sorted array.The number of elements initialized in nums1 and nums2 are m and n
 * respectively.You may assume that nums1 has enough space (size that is greater or equal
 * to m + n) to hold additional elements from nums2.
 *@author SuJiexi
 *@date 2019/5/12 10:24
 */
public class Solution88 {

    //TimeComplexity:O(n^2)
    //SpaceComplexity:O(m)
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < nums2.length ; i++) {
            nums1[nums1.length-1-i]=nums2[i];
        }

        for (int i = 1; i <nums1.length ; i++) {
            int temp = nums1[i];
            for (int j = i; j > 0 ; j--) {
                if(nums1[j-1]>temp){
                    nums1[j]=nums1[j-1];
                    nums1[j-1]=temp;
                }else{
                    break;
                }
            }
        }
    }

    //TimeComplexity:O(log2 (n-1))
    //SpaceComplexity:O(1)
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        if(nums1 == null ){
            if(nums2 == null){
                return;
            }
            return;
        }
        int nums1Capacity = m+n-1;
        int orderNumber1= m-1;
        int orderNumber2 =n-1;
        while(orderNumber1 >= 0 && orderNumber2 >= 0){

            nums1[nums1Capacity--] = nums1[orderNumber1]>nums2[orderNumber2] ?nums1[orderNumber1--]:nums2[orderNumber2--];
        }
        while(orderNumber1 == -1 && orderNumber2 >=0){
            nums1[orderNumber2]=nums2[orderNumber2--];
        }


    }
}
