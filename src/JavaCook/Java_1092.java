package JavaCook;

/**
 * @author ArtistS
 * @tag
 * @prb
 * Time complexity:
 * Space complexity:
 */
public class Java_1092{
    public String shortestCommonSupersequence(String str1, String str2) {
        StringBuilder sb1 = new StringBuilder(str1);
        StringBuilder sb2 = new StringBuilder(str2);

        String res = str1+str2;
        if(str1.contains(str2)){
            res = sb1.toString();
        }

        if(str2.contains(str1)){
            if(str1.length() < res.length()){
                res = str1;
            }
            return res;
        }

        // concat str1+str2 str2+str1
        for(int i = 1; i < str1.length() && i < str2.length(); i++){
            String subStr = str1.substring(i);
            if(str2.startsWith(subStr)){
                String newRes = str1.substring(0,i) + str2;
                if(newRes.length() < res.length()) res = newRes;
            }
        }

        // concat str2+str1
        for(int i = 1; i < str1.length() && i < str2.length(); i++){
            String subStr = str2.substring(i);
            if(str1.startsWith(subStr)){
                String newRes = str2.substring(0,i) + str1;
                if(newRes.length() < res.length()) res = newRes;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        new Java_1092().shortestCommonSupersequence("abac", "ab");
    }
}