package JavaCook;

/**
 * @author ArtistS
 * @tag String Stack Simulation
 * @prb https://leetcode.com/problems/remove-all-occurrences-of-a-substring/description/
 * Time complexity: O(n^2)
 * Space complexity: O(n)
 */
public class Java_1910{
    public String removeOccurrences(String s, String part) {
        if(s.length() < part.length()){
            return s;
        }

        StringBuilder sb = new StringBuilder(s);
        boolean flag = true;
        int start = 0;
        int end = start + part.length();

        while(flag && sb.length() > 0){
            if(sb.substring(start,end).equals(part)){
                for(int i = 0; i < part.length(); i++){
                    sb.deleteCharAt(start);
                }
                start = 0;
                end = start + part.length();
            }else{
                start++;
                end++;
            }
            if(end == sb.length()+1){
                flag = false;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Java_1910().removeOccurrences("daabcbaabcbc","abc"));
    }
}