package JavaCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Java1268 {
    /**
     * Time Complexity: {@code n} is the length of {@param products}, {@code m} is the max length of string under {@param products}
     * O(mnlogn) + O(n) + O((n * m) + O(n*m) = O(mnlogn)
     * Space Complexity: O(n^2)
     * @method: BF Simulation
     * @topic Search Suggestions System
     * @author ArtistS
     * @param products
     * @param searchWord
     * @return
     */
    public List<List<String>> suggestedProducts(String[] products, String searchWord){
        List<List<String>> res = new ArrayList<>();

        //1.. Sort firstLevel
        Arrays.sort(products,(a,b)->{return isBefore(a,b);});

        // 2. Collect the string in the first level
        List<String> firstLevel = new ArrayList<>();
        for(int i = 0; i < products.length; i++){
            String currStr = products[i];
            if(currStr.charAt(0) == searchWord.charAt(0)){
                firstLevel.add(currStr);
            }
        }


        res.add(firstLevel);

        // 3. Collect the string after second level
        for(int i = 1; i < searchWord.length(); i++){
            char ch = searchWord.charAt(i);
            List<String> currLevel = new ArrayList();
            for(int j = 0; j < res.get(i-1).size(); j++){
                String currStr = res.get(i-1).get(j);
                if(i < currStr.length() && currStr.charAt(i) == ch){
                    currLevel.add(res.get(i-1).get(j));
                }
            }
            res.add(currLevel);
        }

        //4.
        for(List<String> str: res){
            for(int j = str.size() -1; j >=3; j--){
                str.remove(j);
            }
        }

        return res;
    }

    public int isBefore(String a,String b){
        if(a.length()<=b.length()){
            for(int i=0;i<a.length();i++){
                if(a.charAt(i)<b.charAt(i)){return -1;}
                else if(a.charAt(i)>b.charAt(i)){return 1;}
            }
            return -1;
        }
        return -isBefore(b,a);
    }
}
