class Solution {    
    private static int[] dr = {-1, -1,  1,  1, -2, -2,  2, 2};
    private static int[] dc = { 2, -2,  2, -2, -1,  1, -1, 1};
    
    public double knightProbability(int N, int K, int r, int c) {
        if(K == 0) return 1.0;
        
        double[][][] probability = new double[N][N][K + 1];
        for(int i = 0;i < N;++i) {
            for(int j = 0;j < N;++j) {
                probability[i][j][0] = 1.0;
            }
        }
        
        for(int s = 1;s <= K;++s) {
            for(int i = 0;i < N;++i) {
                for(int j = 0;j < N;++j) {
                    probability[i][j][s] = 0;
                    for(int d = 0;d < 8;++d) {
                        int nr = i + dr[d];
                        int nc = j + dc[d];
                        if(nr >= 0 && nr < N && nc >= 0 && nc < N) {
                            probability[i][j][s] += probability[nr][nc][s - 1] / 8.0; 
                        }
                    }
                }
            }
        }
        return probability[r][c][K];
    }
}