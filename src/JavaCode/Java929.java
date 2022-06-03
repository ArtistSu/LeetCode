package JavaCode;

import java.util.HashSet;
import java.util.Set;

public class Java929 {
    /**
     * Time Complexity: O(n) {@code n} is the number of characters in local name in {@param emails}
     * Space Complexity: O(m) {@code m} is the length of {@param emails}
     * @topic Unique Email Addresses
     * @author ArtistS
     * @param emails
     * @return
     */
    public int numUniqueEmails(String[] emails) {
        Set<String> records = new HashSet<>();
        for(int i = 0; i < emails.length; i++){
            String[] part = emails[i].split("@");
            StringBuffer sb = new StringBuffer();
            for(int j = 0; j < part[0].length(); j++){
                if(part[0].charAt(j) == '.'){
                    continue;
                }
                if(part[0].charAt(j) == '+'){
                    break;
                }
                sb.append(part[0].charAt(j));
            }
            records.add(sb.append("@").append(part[1]).toString());
        }
        return records.size();
    }
}
