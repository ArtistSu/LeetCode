package JavaCode;

import java.util.*;

public class Java1408 {
    /**
     * Time Complexity: O(n^2) {@param n} is the length of {@param words}
     * Space Complexity: O(1)
     * @topic String Matching in an Array
     * @author ArtistS
     * @param words
     * @return
     */
    public List<String> stringMatching(String[] words) {
        Set<String> set = new HashSet<>();

        //Sort in ascending
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });


        for(int i = 0; i < words.length; i++){
            for(int j = 0; j < i; j++){
                if(words[i].contains(words[j])){
                    set.add(words[j]);
                }
            }
        }
        List<String> list = new ArrayList<>(set);
        return list;
    }
}
