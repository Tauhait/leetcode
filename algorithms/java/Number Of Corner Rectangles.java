class Solution {    
    private int getCommonElement(List<Integer> v, List<Integer> u) {
        int i = 0, j = 0, count = 0;
        while(i < v.size() && j < u.size()) {
            if(v.get(i) == u.get(j)) {i++;j++;count++;}
            else if(v.get(i) > u.get(j)) j++;
            else i++;
        }
        return count;
    }
    
    public int countCornerRectangles(int[][] grid) {
        int m = grid.length;
        int n = m == 0 ? 0 : grid[0].length;
        if(m < 2 || n < 2) return 0;
        
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0;i < m;++i) {
            List<Integer> cols = new ArrayList<>();
            for(int j = 0;j < n;++j) {
                if(grid[i][j] == 1) cols.add(j);
            }
            list.add(cols);
        }

        int count = 0;
        for(int i = 0;i < m;++i) {
            for(int j = i + 1;j < m;++j) {
                int c = getCommonElement(list.get(i), list.get(j));
                count += c * (c - 1) / 2;
            }
        }
        return count;
    }
}