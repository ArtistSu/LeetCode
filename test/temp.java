import java.util.HashMap;
        import java.util.Map;

public class temp {
    public static boolean subSum(int[] n, int T,int totalNumber){
        if(totalNumber <= 0 || T<0){
            return false;
        }
        if(T==0){
            return true;
        }
        boolean res = false;
        for(int i = totalNumber-1; i >= 0 ; i--){
            int x_i = n[i];
            res = subSum(n,T-x_i,totalNumber-1);
            if(res){
                return res;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] n = {4,7,10,12,15};
        System.out.println(subSum(n,19,5));
    }
}
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