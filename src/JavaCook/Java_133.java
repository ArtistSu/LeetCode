package JavaCook;

import java.util.*;

/**
 * @author ArtistS
 * @tag
 * @prb
 * @TimeComplexity
 * @SpaceComplexity
 */
public class Java_133{
    /**
     * @TimeComplexity O(N + M) - N is the number of nodes, M is the number of edges
     * @SpaceComplexity O(N)
     */
    public Node cloneGraph_google_l4(Node node) {
        if (node == null) {
            return null;
        }

        Map<Node, Node> visited = new HashMap<>();
        Queue<Node> queue = new ArrayDeque<>();

        queue.offer(node);
        visited.put(node, new Node(node.val, new ArrayList<>()));

        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            Node clonedCurr = visited.get(curr);

            for (Node neighbor : curr.neighbors) {
                if (!visited.containsKey(neighbor)) {
                    visited.put(neighbor, new Node(neighbor.val, new ArrayList<>()));
                    queue.offer(neighbor);
                }
                clonedCurr.neighbors.add(visited.get(neighbor));
            }
        }

        return visited.get(node);
    }

    class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}