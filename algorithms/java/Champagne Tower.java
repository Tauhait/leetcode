class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] ret = new double[101][101];
        ret[0][0] = poured;
        for(int i = 1;i <= query_row;++i) {
            ret[i][0] = Math.max(0, (ret[i - 1][0] - 1) / 2.0);
            for(int j = 1;j < i;++j) {
                ret[i][j] = Math.max(0, (ret[i - 1][j - 1] - 1) / 2.0) + Math.max(0, (ret[i - 1][j] - 1) / 2.0);
            }
            ret[i][i] = Math.max(0, (ret[i - 1][i - 1] - 1) / 2.0);
        }
        return Math.min(1.0, ret[query_row][query_glass]);
    }
}