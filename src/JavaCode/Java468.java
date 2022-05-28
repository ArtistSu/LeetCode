package JavaCode;

import java.util.regex.Pattern;

public class Java468 {
    /**
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     * @method regular expression
     * @topic Validate IP Address
     * @author ArtistS
     * @param queryIP
     * @return
     */
    public String validIPAddress(String queryIP) {
        String ipv4Pattern = "((2(5[0-5]|[0-4]\\d))|(1([0-9][0-9]))|[1-9][0-9]?|[0-9])(.((2(5[0-5]|[0-4]\\d))|(1([0-9][0-9]))|[1-9][0-9]?|[0-9])){3}";
        String ipv6Pattern = "([0-9a-fA-F]{1,4})(:[0-9a-fA-F]{1,4}){7}";

        if(queryIP.indexOf(".") > 0 && (queryIP.matches(ipv4Pattern))){
            return "IPv4";
        }
        if(queryIP.indexOf(":") > 0 && (queryIP.matches(ipv6Pattern))){
            return "IPv6";
        }
        return "Neither";
    }
}
