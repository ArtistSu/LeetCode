package JavaCode;

public class Java1422 {
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * @topic Maximum Score After Splitting a String
     * @author ArtisstS
     * @method Traverse
     * @related LeetCode2155
     * @param s
     * @return
     */
    public int maxScore2(String s) {
        //分数=1的总数+max(前缀长度-2*前缀1的个数)
        char c[]=s.toCharArray();
        int count=0,max=-c.length+1;//1的个数、min(前缀长度-2*前缀1的个数)
        for(int i=0;i<c.length;i++){
            count+=c[i]-'0';
            if(i<c.length-1){max=Math.max(max,i+1-2*count);}
        }
        return count+max;
    }
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * @topic Maximum Score After Splitting a String
     * @author ArtisstS
     * @method Traverse
     * @param s
     * @return
     */
    public int maxScore(String s) {
        int left = 0, right = 0;
        for(int i = 1; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '1'){
                right++;
            }
        }
        int sum = right;
        for(int i = 1; i < s.length()-1; i++){
            char ch = s.charAt(i);
            if(ch == '0'){
                left++;
            }
            if(ch == '1'){
                right--;
            }
            sum = Math.max(sum, left+right);
        }
        if(s.charAt(0) == '0'){
            sum++;
        }
        return sum;
    }
}
