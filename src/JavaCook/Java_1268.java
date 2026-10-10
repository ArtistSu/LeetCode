package JavaCook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ArtistS
 * @tag
 * @prb
 * @TimeComplexity
 * @SpaceComplexity
 */
public class Java_1268{
    private static class TrieNode{
        private TrieNode[] children;
        private List<String> words;

        public TrieNode(){
            this.children = new TrieNode[26];
            this.words = new ArrayList<>();
        }

        private void insert(String word){
            TrieNode curr = this;
            for (char ch : word.toCharArray()) {
                int idx = ch - 'a';
                if (curr.children[idx] == null) {
                    curr.children[idx] = new TrieNode();
                }
                curr = curr.children[idx];

                // 🌟 L4 级关键优化：每个节点最多只存前 3 个单词！
                if (curr.words.size() < 3) {
                    curr.words.add(word);
                }
            }
        }
    }

    /**
     * N is the length of products
     * L is the avg or max length of string in products
     * M is the length of searchWord
     * @TimeComplexity O(N * L* log(N) + M*L)
     * @SpaceComplexity O(N * L)
     */
    public List<List<String>> suggestedProducts_google_l4(String[] products, String searchWord) {
        Arrays.sort(products);

        TrieNode root = new TrieNode();
        for(String product : products){
            root.insert(product);
        }

        List<List<String>> res = new ArrayList<>();
        TrieNode curr = root;
        boolean found = true; // 标记前缀是否中断

        for(int i = 0 ; i < searchWord.length(); i++){
            char ch = searchWord.charAt(i);
            int idx = ch - 'a';

            List<String> searchRes = new ArrayList<>();

            if (found && curr != null && curr.children[idx] != null) {
                curr = curr.children[idx];
                for (int j = 0; j < Math.min(3, curr.words.size()); j++) {
                    searchRes.add(curr.words.get(j));
                }
            } else {
                found = false; // 一旦断开，后面就全都是空的了
            }

            res.add(searchRes);
        }

        return res;
    }
}