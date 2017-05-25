public class Solution {
    private int ret;
    private int[][] skip;
    private void dfs(int pre, int d, boolean[] visited, int m, int n) {
        if(d >= m && d <= n) {
            ret++;
        }
        
        if(d == n) {
            return ;
        }
        
        for(int i = 1;i <= 9;++i) {
            if(visited[i] == true) {
                continue;
            }
            if(d == 0 || skip[pre][i] == 0 || visited[skip[pre][i]] == true) {
                visited[i] = true;
                dfs(i, d + 1, visited, m, n);
                visited[i] = false;
            }
        }
    }
    
    public int numberOfPatterns(int m, int n) {
        skip = new int[10][10];
        for(int i = 0;i < 10;++i) {
            Arrays.fill(skip[i], 0);
        }
        skip[1][3] = skip[3][1] = 2;
        skip[1][7] = skip[7][1] = 4;
        skip[7][9] = skip[9][7] = 8;
        skip[9][3] = skip[3][9] = 6;
        skip[1][9] = skip[3][7] = skip[9][1] = skip[7][3] = skip[2][8] = skip[6][4] = skip[8][2] = skip[4][6] = 5;
        
        
        
        boolean[] visited = new boolean[10];
        Arrays.fill(visited, false);
        
        ret = 0;
        dfs(-1, 0, visited, m, n);
        
        return ret;
    }
}