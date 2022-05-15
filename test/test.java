class Vertex{
    String name;
}

public class test {
    public static void main(String[] args) {
        int[] A = new int[6];
        for (int i = 0; i <A.length ; i++) {
            A[i] = i;
        }
        System.out.println(new test().calculateFN(5, A));
    }

    public int calculateFN(int n, int[] A){
        if(n == 0) return 0;
        if(n == 1) return 1;
        // use to record F(i, j)
        int[][] fn = new int[n+1][n+1];
        for(int i = 0; i < n +1; i++){
            // initialise F(i,i) ...
            fn[i][i] = 0;
            // initialise F(i, i+1)
            if(i+1 <= n){
                fn[i][i+1] = 1;
            }
        }
        int tag = 2;
        while(tag <= n){
            int i = 0;
            for(int j = tag; j <= n; j++){
                if(A[i] == A[j]){
                    fn[i++][j] = fn[i+1][j-1] + 1;
                }else{
                    fn[i++][j] = Math.max(fn[i+1][j],fn[i][j-1]);
                }
            }
            tag++;
        }

//        for(int i = 0; i < fn.length;i++){
//            for (int j = 0; j < fn.length;j++){
//                System.out.print(fn[i][j] + " ");
//            }
//            System.out.println();
//        }
        return fn[0][n];
    }
}