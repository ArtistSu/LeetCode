package JavaCook;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

/**
 * @author ArtistS
 * @tag
 * @prb
 * @TimeComplexity
 * @SpaceComplexity
 */
public class Java_71{
    /**
     * @TimeComplexity O(N) N is the length of String path
     * @SpaceComplexity O(N)
     */
    public String simplifyPath(String path) {
        // Defensive check
        if(path == null || path.isEmpty()) return "/";

        Deque<String> stack = new ArrayDeque<>();
        String[] dirs = path.split("/+");

        for(String dir : dirs){
            if(dir.equals("..")){
                if(!stack.isEmpty()){
                    stack.pop();
                }
            }else if (!dir.isEmpty() && !dir.equals(".")) {
                stack.push(dir);
            }
        }

        // Stack is empty return root directory
        if (stack.isEmpty()) {
            return "/";
        }

        // Combine
        StringBuilder sb = new StringBuilder();
        for(Iterator<String> it = stack.descendingIterator(); it.hasNext();){
            sb.append("/").append(it.next());
        }
        return sb.toString();
    }
}