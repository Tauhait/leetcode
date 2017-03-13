public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer> > res = new ArrayList<>();
        for(int i = 1;i <= numRows;++i) {
            ArrayList<Integer> lev = new ArrayList<>(i);
            lev.add(1);
            for(int j = 1;j <= i - 2;++j) {
                lev.add(res.get(i - 2).get(j - 1) + res.get(i - 2).get(j));
            }
            if(i != 1) lev.add(1);
            
            res.add(lev);
        }
        return res;
    }
}