package JavaCook;


/**
 * @author ArtistS
 * @tag String Backtracking Stack Greedy
 * @prb https://leetcode.com/problems/construct-smallest-number-from-di-string/description/
 * Time complexity: O(n!)
 * Space complexity: O(n)
 */
public class Java_2375{
    int res = Integer.MAX_VALUE;
    public String smallestNumber(String pattern) {
        char[] chars = pattern.toCharArray();
        boolean[] used = new boolean[10];

        for(int i = 1 ; i <= 9; i++){
            used[i] = true;
            findFitPattern(used,chars,new StringBuilder().append(i),0);
            used[i] = false;
        }

        return String.valueOf(res);
    }

    public void findFitPattern(boolean[] used,char[] chars,StringBuilder tempStr, int index){
        if(tempStr.length() == chars.length+1){
            res = Math.min(Integer.parseInt(tempStr.toString()),res);
            return;
        }
        if(chars[index] == 'I'){
            System.out.println(tempStr.charAt(tempStr.length()-1)-'0'+1);

            for(int start = tempStr.charAt(tempStr.length()-1)-'0'+1; start<=9;start++){
                if(!used[start]){
                    tempStr.append(start);
                    used[start] = true;
                    findFitPattern(used,chars,tempStr,index+1);
                    used[start] = false;
                    tempStr.deleteCharAt(tempStr.length()-1);
                }
            }
        }else{
            System.out.println(tempStr.charAt(tempStr.length()-1)-'0');
            for(int start = 1; start<tempStr.charAt(tempStr.length()-1)-'0';start++){
                if(!used[start]){
                    tempStr.append(start);
                    used[start] = true;
                    findFitPattern(used,chars,tempStr,index+1);
                    used[start] = false;
                    tempStr.deleteCharAt(tempStr.length()-1);
                }
            }
        }
    }

    public static void main(String[] args) {
        new Java_2375().smallestNumber("IIIDIDDD");
    }
}