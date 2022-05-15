package JavaCode;

import java.util.regex.Pattern;

public class Java535 {
    /**
     * @topic Encode and Decode TinyURL
     * @author ArtistS
     */
    String prefix;
    public String encode(String longUrl) {
        if(longUrl.contains("//")){
            prefix = longUrl.substring(0, longUrl.indexOf("//")+"//".length());
            return longUrl.substring(longUrl.indexOf("//")+"//".length(),longUrl.length());
        }
        return longUrl;

    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        if(prefix == null){
            return shortUrl;
        }
        return prefix + shortUrl;
    }
}
