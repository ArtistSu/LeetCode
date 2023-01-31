package JavaCode;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class test {
    public static void main(String[] args) {
        String[] str = new String[]{"int a = 2;", "int b = 47;/*37;*///41;", "int c = 3/*4//5*/;", "return a / b * c/*a /* b / c*/;"};
        System.out.println(new test().solution(str));
    }

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * @return
     */
    public static int solution(String[] source) {
        int res = 0;
        int flag = 0, flag2 = 0;
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < source.length; i++){
            String str = source[i];
            char[] chars = str.toCharArray();
            for(char ch: chars){

                // Handle //
                if(ch == ';' && flag2 > 0){
                    while(flag2 > 0){
                        if(ch == '/' && stack.peek() == '/'){
                            flag2--;
                        }
                        if(ch == '*' && stack.peek() == '/'){
                            flag--;
                        }
                        ch = stack.pop();
                        res--;
                    }
                    continue;
                }
                if(!stack.isEmpty()){
                    // Record /* //
                    if(stack.peek() == '/' && ch == '*'){
                        flag += 1;
                    }
                    if(stack.peek() == '/' && ch == '/'){
                        flag2 += 1;
                    }

                    // Handle /*
                    if(stack.peek() == '*' && ch == '/' && flag > 0){
                        while(flag > 0){
                            if(ch == '*' && stack.peek() == '/'){
                                flag--;
                            }
                            if(ch == '/' && stack.peek() == '/'){
                                flag2--;
                            }
                            ch = stack.pop();
                            res--;
                        }
                        continue;
                    }
                }


                if(ch != ' '){
                    stack.push(ch);
                    res++;
                }
            }
        }
        return res;

    }

}
