package JavaCook;


public class Java_2379 {
    public int minimumRecolors(String blocks, int k) {
        int res = Integer.MAX_VALUE;
        String subStr = blocks.substring(0, k);
        int ops = 0;
        for (int i = 0; i < subStr.length(); i++) {
            char ch = subStr.charAt(i);
            if (ch == 'W') {
                ops++;
            }
        }
        if (k < blocks.length() && blocks.charAt(k) == 'W'){
            res = ops;
        }

        for (int start = 1; start < blocks.length()-k; start++) {
            if(blocks.charAt(start-1) == 'W'){
                ops--;
            }
            if(blocks.charAt(start+k-1) == 'W'){
                ops++;
            }
            if(start+k <= blocks.length() && blocks.charAt(start+k) == 'W'){
                res =Math.min(res, ops);
            }
        }

        return res == Integer.MAX_VALUE ? 0 : res;
    }

    public static void main(String[] args) {
        new Java_2379().minimumRecolors("WBBWWBBWBW", 7);
    }
}
