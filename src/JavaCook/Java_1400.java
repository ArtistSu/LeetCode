package JavaCook;

/**
 * @author ArtistS
 * @tag
 * @prb
 * Time complexity:
 * Space complexity:
 */
public class Java_1400 {
    public boolean canConstruct(String s, int k) {
        if(s.length() < k){
            return false;
        }

        char[] chars = s.toCharArray();
        int[] res = new int[26];
        for(int i = 0; i < chars.length;i++){
            char ch = chars[i];
            res[ch-'a']++;
        }

        int singular = 0;
        for(int count: res){
            if(count%2 == 1){
                singular++;
            }
        }

        return singular <= k;
    }
}