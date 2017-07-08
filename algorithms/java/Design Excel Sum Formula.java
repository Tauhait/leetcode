public class Excel {
    private int numRows;
    private int numCols;
    private Cell[][] excel;
    
    private class Cell {
        public Cell() {
            value = 0;
            sumFormula = null;
        }
        
        private int value;
        private String[] sumFormula;
        
        private int[] getPosition(String pos) {
            int rIndex = Integer.parseInt(pos.substring(1))- 1;
            int cIndex = pos.charAt(0) - 'A';
            checkIndexRange(rIndex, cIndex);
            return new int[]{rIndex, cIndex};
        }   
        
        public int getValue() {
            if(sumFormula == null) {
                return value;
            }
            
            int sum = 0;
            for(int i = 0;i < sumFormula.length;++i) {
                if(sumFormula[i].indexOf(":") < 0) {
                    int[] index = getPosition(sumFormula[i]);
                    sum += excel[index[0]][index[1]].getValue();
                } else {
                    String[] positions = sumFormula[i].split(":");
                    int[] indexTopLeft = getPosition(positions[0]);
                    int[] indexBottomRight = getPosition(positions[1]);
                    for(int r = indexTopLeft[0];r <= indexBottomRight[0];++r) {
                        for(int c = indexTopLeft[1];c <= indexBottomRight[1];++c) {
                            checkIndexRange(r, c);
                            sum += excel[r][c].getValue();
                        }
                    }
                }
            }
            return sum;            
        }
    }
       
    public Excel(int H, char W) {
        numRows = H;
        numCols = W - 'A' + 1;
        excel = new Cell[numRows][numCols];
        for(int i = 0;i < numRows;++i) {
            for(int j = 0;j < numCols;++j) {
                excel[i][j] = new Cell();
            }
        }
    }
    
    private void checkIndexRange(int rIndex, int cIndex) {
        if(rIndex < 0 || rIndex >= numRows || cIndex < 0 || cIndex >= numCols) {
            throw new IllegalArgumentException();
        }
    }
    
    public void set(int r, char c, int v) {
        int rIndex = r - 1;
        int cIndex = c - 'A';
        checkIndexRange(rIndex, cIndex);
        if(excel[rIndex][cIndex].sumFormula != null) {
            excel[rIndex][cIndex].sumFormula = null;
        }
        excel[rIndex][cIndex].value = v;        
    }
    
    public int get(int r, char c) {
        int rIndex = r - 1;
        int cIndex = c - 'A';
        checkIndexRange(rIndex, cIndex);
        return excel[rIndex][cIndex].getValue();
    }
    
    public int sum(int r, char c, String[] strs) {
        int rIndex = r - 1;
        int cIndex = c - 'A';
        checkIndexRange(rIndex, cIndex);
        excel[rIndex][cIndex].sumFormula = strs;
        return excel[rIndex][cIndex].getValue();
    }
}

/**
 * Your Excel object will be instantiated and called as such:
 * Excel obj = new Excel(H, W);
 * obj.set(r,c,v);
 * int param_2 = obj.get(r,c);
 * int param_3 = obj.sum(r,c,strs);
 */