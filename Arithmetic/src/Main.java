

import java.lang.reflect.Array;

/**
 * @author SuJiexi
 * @PackageName:Arithmetic
 * @ClassName:Main
 * @Decription:
 * @date 2019/5/129:31
 */
public class Main {
    public static void main(String[] args) {
        InserationSort inserationSort = new InserationSort();
        int[] arr = new int[]{31,41,59,26,41,58};
        for (int i = 0; i < 6; i++) {
            int[] result = inserationSort.implement2(arr);
            System.out.println(result[i]);
        }


    }
}