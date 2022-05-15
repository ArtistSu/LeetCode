package JavaCode;

import java.util.Arrays;

public class Java706 {
    /**
     * @topic Design HashMap
     * @author ArtistS
     */
    int size = (int)Math.pow(10, 6)+1;
    int[] map;
    public Java706() {
        map = new int[size];
        Arrays.fill(map, -1);
    }

    public void put(int key, int value) {
        map[key] = value;
    }

    public int get(int key) {
        return map[key];
    }

    public void remove(int key) {
        map[key] = -1;
    }
}
