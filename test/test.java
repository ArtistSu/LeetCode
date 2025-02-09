
import java.util.*;


public class test {
    public int[] assignElements(int[] groups, int[] elements) {
        int[] assigned = new int[groups.length];
        Arrays.fill(assigned, -1);

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < groups.length; i++) {
            if (map.containsKey(groups[i])) {
                map.get(groups[i]).add(i);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(groups[i], list);
            }
        }

        Map<Integer,Integer> map_ele = new HashMap<>();
        List<Integer> list_ele = new ArrayList<>();
        for (int i= 0; i < elements.length; i++) {
            if (!map_ele.containsKey(elements[i])) {
                list_ele.add(elements[i]);
                map_ele.put(elements[i],i);
            }
        }

        for (int i = 0; i < list_ele.size(); i++) {
            List<Integer> list = new ArrayList<>();

            for (int key : map.keySet()) {
                if (key % list_ele.get(i) == 0) {
                    for (int value : map.get(key)) {
                        assigned[value] = map_ele.get(list_ele.get(i));
                    }
                    list.add(key);
                }
            }
            for (int key : list) {
                map.remove(key);
            }
        }

        return assigned;
    }

    public static void main(String[] args) {
        new test().assignElements(new int[]{8, 4, 3, 2, 4}, new int[]{4, 2});
//        new test().assignElements(new int[]{5}, new int[]{6,6,5});
    }

}

