package JavaCook;

import java.util.Stack;

/**
 * @author ArtistS
 * @tag Junior String Stack Recursion
 * @prb https://leetcode.com/problems/decode-string/description/?envType=study-plan-v2&envId=leetcode-75
 * @TimeComplexity O(n)
 * @SpaceComplexity O(n)
 */
public class Java_394{
    public String decodeString(String s) {
        // 1. Define a stack
        Stack<Integer> stackInt = new Stack<>();
        Stack<String> stackStr = new Stack<>();

        int num = 0;
        for(char ch: s.toCharArray()){
            if(Character.isDigit(ch)){
                num = num * 10 + ch - '0';
            }else if(ch == '['){
                stackInt.push(num);
                num = 0;
                stackStr.push(String.valueOf(ch));
            }else if(ch == ']'){
                StringBuilder sb = new StringBuilder();
                while(!stackStr.isEmpty() && !stackStr.peek().equals("[")){
                    sb.insert(0,stackStr.pop());
                }
                stackStr.pop();

                int times = stackInt.pop();
                stackStr.push(sb.toString().repeat(times));
            }else{
                stackStr.push(String.valueOf(ch));
            }
        }

        StringBuilder res = new StringBuilder();
        while(!stackStr.isEmpty()){
            res.insert(0,stackStr.pop());
        }
        return res.toString();
    }

    public static void main(String[] args) {
        new Java_394().decodeString("3[a]2[bc]");
    }
}