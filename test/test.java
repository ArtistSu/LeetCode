
import java.util.*;
import java.util.regex.Pattern;


public class test {
    public int maxDistance(String s, int k) {

        Map<Character,Integer> dir = new HashMap<>();
        int tmp_res = 0;
        int res = Integer.MIN_VALUE;
        for(char ch : s.toCharArray()){
            dir.put(ch,dir.getOrDefault(ch,0)+1);
            if(ch == 'E' || ch == 'N'){
                tmp_res++;
            }else{
                tmp_res--;
            }
            res = Math.max(res,Math.abs(tmp_res));
        }

        // Max(N S)
        int min_ns = Math.min(dir.getOrDefault('N',0),dir.getOrDefault('S',0));
        // Max(W E)
        int min_we = Math.min(dir.getOrDefault('W',0),dir.getOrDefault('E',0));

        if(k == 0){
            return res;
        }
        if(min_ns+min_we >= k){
            return s.length() - (min_ns+min_we-k)*2;
        }

        return s.length();
    }

    public static void main(String[] args) {
        System.out.println(new test().maxDistance("EEWWS",1));
    }


}

