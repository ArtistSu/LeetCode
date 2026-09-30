package JavaCook;

/**
 * @author ArtistS
 * @tag DFS Graph
 * @prb
 * @TimeComplexity
 * @SpaceComplexity
 */
public class Java_547{
    public int findCircleNum_google_l5(int[][] isConnected) {
        // Need to consider isConnected.length == 0, isConnected[0].length == 0
        if (isConnected == null || isConnected.length == 0 || isConnected[0].length == 0) return 0;

        final int totalProvince = isConnected[0].length; //n
        boolean[] visited = new boolean[totalProvince];
        int res = 0;
        for(int i = 0; i < totalProvince; i++){
            if(!visited[i]){
                dfs(isConnected,i,visited,totalProvince);
                res++;
            }
        }
        return res;
    }

    private void dfs(int[][] isConnected,int province,boolean[] visited,int totalProvince){
        visited[province] = true;
        for(int i = 0; i < totalProvince;i++){
            if(isConnected[province][i] == 1 && !visited[i]){
                dfs(isConnected,i,visited,totalProvince);
            }
        }
    }
}