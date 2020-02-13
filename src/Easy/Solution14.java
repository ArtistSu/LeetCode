package Easy;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.min;

/**
 * @author SuJiexi
 * @version V1.0
 * @Package Easy
 * @date 2019-05-09 17:02
 * @Description Write a function to find the longest common
 * prefix string amongst an array of strings.If there is no
 * common prefix, return an empty string "".
 */
public class Solution14 {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0){
            return "";
        }
        String prefix = strs[0];
        for (int i = 0; i < strs.length; i++) {
            while(strs[i].indexOf(prefix) !=0){
                prefix = prefix.substring(0,prefix.length()-1);
                if (prefix.isEmpty()){
                    return "";
                }
            }
        }
        return prefix;
    }
    }

