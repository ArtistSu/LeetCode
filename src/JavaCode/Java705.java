package JavaCode;

import java.util.HashMap;
import java.util.Map;

public class Java705 {
    /**
     * @topic Design HashSet
     * @author ArtistS
     */
    class MyHashSet {
        final Map set;
        public MyHashSet() {
            set = new HashMap();
        }

        public void add(int key) {
            set.put(key,0);
        }

        public void remove(int key) {
            set.remove(key);
        }

        public boolean contains(int key) {
            if(set.containsKey(key)){
                return true;
            }
            return false;
        }
    }
}
