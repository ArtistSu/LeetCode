package JavaCode;

public class Java942 {
    /**
     * Time Complexity: O(n) {@code n} is the length of {@param s}
     * Space Complexity: O(n)
     * @topic DI String Match
     * @author ArtistS
     * @param s
     * @return
     */
    public int[] diStringMatch(String s) {
        int[] res = new int[s.length()+1];
        int nbrI = 0, nbrD = res.length - 1;
        for(int i = 0; i < s.length(); i++){
            char currChar = s.charAt(i);
            if(currChar == 'I'){
                res[i] = nbrI;
                nbrI++;
            }else{
                res[i] = nbrD;
                nbrD--;
            }
        }

        res[res.length - 1] = nbrD;

        return res;
    }
}
