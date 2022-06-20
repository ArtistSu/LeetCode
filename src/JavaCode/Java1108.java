package JavaCode;

public class Java1108 {
    public static void main(String[] args) {
        System.out.println(new Java1108().defangIPaddr("1.1.11.1"));
    }

    /**
     * Time Complexity: O(n) {@code n} is the length of {@param address}
     * Space Complexity: O(1)
     * @method API
     * @topic Defanging an IP Address
     * @author ArtistS
     * @param address
     * @return
     */
    public String defangIPaddr(String address) {
        return address.replace(".","[.]");
    }
}
