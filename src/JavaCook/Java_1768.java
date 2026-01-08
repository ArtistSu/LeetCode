package JavaCook;

/**
 * @author ArtistS
 * @tag TwoPointers String LC75
 * @prb https://leetcode.com/problems/merge-strings-alternately/?envType=study-plan-v2&envId=leetcode-75
 * Time complexity: O(len1 + len2)
 * Space complexity: O(1) or O(len1 + len2)
 */
public class Java_1768{
    public String mergeAlternately(String word1, String word2) {

        int len1 = word1.length();
        int len2 = word2.length();
        StringBuffer sb = new StringBuffer();
        int point = 0;

        while(point < len1 && point < len2){
            sb.append(word1.charAt(point));
            sb.append(word2.charAt(point));
            point++;
        }

        while(point < len1){
            sb.append(word1.charAt(point));
            point++;
        }

        while(point < len2){
            sb.append(word2.charAt(point));
            point++;
        }

        return sb.toString();

    }

    public String mergeAlternatelyV2(String word1, String word2) {
        int word1Len = word1.length();
        int word2Len = word2.length();
        StringBuilder sb = new StringBuilder();
        int point1 = 0, point2 =0;

        while(point1 < word1Len || point2 < word2Len){
            if(point1 < word1Len){
                sb.append(word1.charAt(point1++));
            }
            if(point2 < word2Len){
                sb.append(word2.charAt(point2++));
            }
        }
        return sb.toString();

    }
}