
import java.util.*;


public class test {
    public long maxWeight(int[] pizzas) {
        int n = pizzas.length / 4;

        Arrays.sort(pizzas);

        int step = 0;
        int weight = 0;
        int len = pizzas.length;

        int odd_count = 0;
        int even_count = 0;
        for (int i = 1; i <= n; i++) {
            if(i % 2 != 0){
                odd_count++;
            }else{
                even_count++;
            }
        }
        while (odd_count > 0) {
            step++;
            weight+=pizzas[len-step];
            odd_count--;
        }

        while (even_count > 0) {
            step+=2;
            weight+=pizzas[len-step];
            even_count--;
        }


        return weight;

        // 最大值 次最大值 次次最大值 次次次最大值 次次次次最大值
        //[1, 2, 2, 2, 2, 3, 3, 3, 4, 4, 5, 5]

    }

    public static void main(String[] args) {
        int[] pizzas = {5,2,2,4,3,3,1,3,2,5,4,2};

        new test().maxWeight(pizzas);
    }

}

