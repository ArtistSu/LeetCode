package JavaCode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Java1202 {
    /**
     * Time Complexity: O((M+N)α(N)+NlogN) 按秩合并 路径压缩
     * Space Complexity: s.length = n, O(3n) = O(n)
     * @topic Smallest String With Swaps
     * @author ArtistS
     * @param s
     * @param pairs
     * @return
     */
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        if(pairs.size() == 0){
            return s;
        }
        // find parents of each character
        int len = s.length();
        UnionFind unionFind = new UnionFind(len);
        for(List<Integer> pair : pairs){
            int indexA = pair.get(0);
            int indexB = pair.get(1);
            unionFind.union(indexA, indexB);
        }

        // aggragate the key-value (root - childs)
        char[] charArray = s.toCharArray();
        Map<Integer, PriorityQueue<Character>> hashMap = new HashMap<>();
        for(int i = 0; i < len; i++){
            int root = unionFind.find(i);
            hashMap.computeIfAbsent(root, value -> new PriorityQueue()).offer(charArray[i]);
        }

        // re-sort
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < len; i++){
            int root = unionFind.find(i);
            stringBuilder.append(hashMap.get(root).poll());
        }

        return stringBuilder.toString();
    }
}

class UnionFind{
    private int[] root;
    private int[] rank;

    public UnionFind(int size){
        root = new int[size];
        rank = new int[size];
        for(int i = 0; i < size; i++){
            root[i] = i;
            rank[i] = i;
        }
    }

    public int find(int x){
        if(x == root[x]){
            return x;
        }
        root[x] = find(root[x]);
        return root[x];
    }

    public void union(int x, int y){
        int rootX = find(x);
        int rootY = find(y);
        if(rootX != rootY){
            if(rank[rootX] >= rank[rootY]){
                root[rootY] = rootX;
                rank[rootX] += rank[rootY];
            }else{
                root[rootX] = rootY;
                rank[rootY] += rank[rootX];
            }
        }
    }
}

