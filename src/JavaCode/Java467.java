package JavaCode;

import java.util.HashSet;
import java.util.Set;

public class Java467 {
    public int findSubstringInWraproundString(String p) {
        int res = 0;
        Set<String> sub= new HashSet<>();
        for(int left = 0; left < p.length(); left++){
            int right = left;
            while(right < p.length()){
                if(right == left){
                    if(!sub.contains(p.substring(left, right+1))){
                        sub.add(p.substring(left, right+1));
                        right++;
                        res++;
                    }else{
                        right++;
                        continue;
                    }
                }
                char rightCh = p.charAt(right);
                char leftCh = p.charAt(left);
                if(!sub.contains(p.substring(left, right+1)) && (Math.abs(rightCh-leftCh)==25 || rightCh-leftCh == 1)){
                    sub.add(p.substring(left, right+1));
                    res++;
                    right++;
                }
            }
        }
        return res;
    }
}
