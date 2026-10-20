package JavaCook;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ArtistS
 * @tag
 * @prb
 * @TimeComplexity
 * @SpaceComplexity
 */
public class Java_36{
    /**
     * @TimeComplexity O(1)
     * @SpaceComplexity O(1)
     */
    public boolean isValidSudoku_google_l4(char[][] board) {
        if(board == null) return false;

        Set<String> seen = new HashSet<>();
        for(int i = 0 ; i < board.length; i++){
            for(int j = 0; j < board[i].length;j++){
                char curr = board[i][j];
                if(curr== '.') continue;

                int boxIdx = (i/3)*3 + (j/3);

                if(!seen.add("Row " + i + " has " + curr) ||
                        !seen.add("Col " + j + " has " + curr) ||
                        !seen.add("Box " + boxIdx + " has " + curr)){
                    return false;
                }
            }
        }
        return true;
    }
}