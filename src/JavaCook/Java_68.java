package JavaCook;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ArtistS
 * @tag
 * @prb
 * @TimeComplexity
 * @SpaceComplexity
 */
public class Java_68 {
    /**
     * @TimeComplexity O(N)
     * @SpaceComplexity O(N)
     */
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<List<String>> rows = new ArrayList<>();
        List<Integer> space = new ArrayList<>();
        int currIdx = 0;

        //1. Greedy line breaking
        while (currIdx < words.length) {
            List<String> row = new ArrayList<>();
            int count = 0;

            while (currIdx < words.length && count + words[currIdx].length() + Math.max(row.size(), row.size() - 1) <= maxWidth) {
                String currWord = words[currIdx];
                row.add(currWord);
                count += currWord.length();
                currIdx++;
            }
            rows.add(row);
            space.add(maxWidth - count);
        }

        List<String> res = new ArrayList<>();

        // 2. Format each line
        for (int i = 0; i < rows.size(); i++) {
            List<String> rowWords = rows.get(i);
            int remainSpace = space.get(i);
            int numWords = rowWords.size();
            StringBuilder sb = new StringBuilder();

            // Determine whether it is the last line
            boolean isLastLine = (i == rows.size() - 1);

            // Left-justify: Place one space between words and pad the remaining spaces at the end.
            if (isLastLine || numWords == 1) {
                for (int j = 0; j < numWords; j++) {
                    sb.append(rowWords.get(j));
                    if (j < numWords - 1) {
                        sb.append(" ");
                    }
                }
                while (sb.length() < maxWidth) {
                    sb.append(" ");
                }
            } else {
                // Fully justify: Distribute spaces evenly between words
                int interval = numWords - 1;
                int spaceNum = remainSpace / interval;
                int extraSpace = remainSpace % interval;

                for (int j = 0; j < numWords; j++) {
                    sb.append(rowWords.get(j));
                    if (j < interval) {
                        int currSpace = spaceNum + (j < extraSpace ? 1 : 0);
                        sb.append(addSpace(currSpace));
                    }
                }

            }
            res.add(sb.toString());
        }
        return res;
    }

    public String addSpace(int num) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < num; i++) {
            sb.append(" ");
        }
        return sb.toString();
    }
}