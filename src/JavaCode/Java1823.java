package JavaCode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Java1823 {
    /**
     * Time Complexity; O(1)
     * Space Complexity: O(n)
     * @topic Find the Winner of the Circular Game
     * @author ArtistS
     * @param n
     * @param k
     * @return
     */
    public int findTheWinner(int n, int k) {
        // Initialise
        List<Integer> friends = new ArrayList();
        for(int i = 1; i <= n; i++){
            friends.add(i);
        }
        int remainingFriends = n;
        int start = 0;
        int step = k;
        while(remainingFriends > 1){
            if(k > remainingFriends){
                step = k % remainingFriends;
            }
            if(start == 0 && step == 0){
                start = remainingFriends - 1;
            }else{
                start = start + step - 1;
                if(start >= remainingFriends){
                    start = start % remainingFriends;
                }
            }
            friends.remove(start);
            remainingFriends--;
        }
        Queue<Integer> q = new ArrayDeque<>();
        return friends.get(0);

    }
}
