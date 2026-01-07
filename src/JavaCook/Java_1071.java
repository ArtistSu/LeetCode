package JavaCook;

/**
 * @author ArtistS
 * @tag Math String LC75
 * @prb https://leetcode.com/problems/greatest-common-divisor-of-strings/?envType=study-plan-v2&envId=leetcode-75
 * Time complexity:
 * Space complexity:
 */
public class Java_1071{
    // m is str1.length(), n is str2.length()
    // Time Complexity: O(Min(m,n)*(m + n))
    // Space Complexity: O(Min(m,n))
    public String gcdOfStrings(String str1, String str2) {
        int len1 = str1.length(), len2=str2.length();

        for(int i = Math.min(len1,len2); i>=1; i--){
            if(valid(str1,str2,i)){
                return str1.substring(0,i);
            }
        }
        return "";
    }

    // k is the length of the base
    public boolean valid(String str1, String str2, int k){
        int len1 = str1.length(), len2 = str2.length();
        if(len1 % k != 0 || len2 % k != 0){
            return false;
        }else{
            String base = str1.substring(0,k);
            return str1.replace(base,"").isEmpty() && str2.replace(base,"").isEmpty();
        }
    }

    // Method 2 Euclidean Algorithm
    public String gcdOfStringsM2(String str1, String str2) {
        if(str1.equals(str2)){
            return str1;
        }
        if(str2.length()>str1.length()){
            return gcdOfStrings(str2,str1);
        }

        if(str1.startsWith(str2)){
            return gcdOfStrings(str1.substring(str2.length()),str2);
        }
        return "";
    }

}