package JavaCook;

import java.util.*;

/**
 * @author ArtistS
 * @tag
 * @prb
 * @TimeComplexity
 * @SpaceComplexity
 */
public class Java_380_google_l4 {


    private final Map<Integer, Integer> map;
    private final List<Integer> list;
    private final Random rand;

    public Java_380_google_l4() {
        map = new HashMap<>();
        list = new ArrayList<>();
        rand = new Random();
    }

    public boolean insert(int val) {
        if (!map.containsKey(val)) {
            list.add(val);
            map.put(val, list.size() - 1);
            return true;
        }
        return false;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;

        int lastEle = list.get(list.size() - 1);

        list.set(map.get(val), lastEle);
        map.put(lastEle, map.get(val));
        map.remove(val);
        list.remove(list.size() - 1);

        return true;

    }

    public int getRandom() {
        int randIdx = rand.nextInt(list.size());
        return list.get(randIdx);
    }


/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
}