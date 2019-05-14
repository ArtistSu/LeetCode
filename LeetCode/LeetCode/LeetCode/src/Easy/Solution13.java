package Easy;

import java.util.HashMap;

/**
 * @author SuJiexi
 * @version V1.0
 * @Package Easy
 * @date 2019-05-09 15:10
 */
public class Solution13 {
    HashMap<Character, Integer> reflect = new HashMap<Character, Integer>();

    public Solution13() {
        reflect.put('I', 1);
        reflect.put('V', 5);
        reflect.put('X', 10);
        reflect.put('L', 50);
        reflect.put('C', 100);
        reflect.put('D', 500);
        reflect.put('M', 1000);
    }

    public int romanToInt(String s) {
        char[] romanArr = s.toCharArray();
        char prev = '0';
        int result = 0;
        for (char c :
                romanArr) {
            if (this.reflect.containsKey(c)) {
                result += this.reflect.get(c);
            } else {
                return 0;
            }

            if (prev != '0' && this.reflect.get(prev) < this.reflect.get(c)) {
                System.out.println("1111");
                result = this.reflect.get(c) - this.reflect.get(prev);
            }
            prev = c;
        }

        return result;
    }

}


