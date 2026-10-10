package JavaCook;

/**
 * @author ArtistS
 * @tag
 * @prb
 * @TimeComplexity
 * @SpaceComplexity
 */
public class Java_208_google_l4 {

    private static class TireNode {
        private boolean isEnd;
        private TireNode[] children;

        public TireNode() {
            this.isEnd = isEnd;
            this.children = new TireNode[26];
        }
    }

    private final TireNode root;

    public Java_208_google_l4() {
        root = new TireNode();
    }

    public void insert(String word) {
        TireNode curr = root;
        for (char ch : word.toCharArray()) {
            int idx = ch - 'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new TireNode();
            }
            curr = curr.children[idx];
        }
        curr.isEnd = true;
    }

    public boolean search(String word) {
        TireNode node = searchPrefix(word);
        return node != null && node.isEnd;
    }

    public boolean startsWith(String prefix) {
        return searchPrefix(prefix) != null;
    }

    private TireNode searchPrefix(String prefix) {
        TireNode curr = root;
        for (char ch : prefix.toCharArray()) {
            int idx = ch - 'a';
            if (curr.children[idx] == null) {
                return null;
            } else {
                curr = curr.children[idx];
            }
        }
        return curr;
    }

}