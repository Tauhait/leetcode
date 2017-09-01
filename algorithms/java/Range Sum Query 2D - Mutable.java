public class NumMatrix {
    private class TreeNode {
        int rowU;
        int rowD;
        int colL;
        int colR;
        int sum;
        TreeNode leftUp;
        TreeNode rightUp;
        TreeNode leftDown;
        TreeNode rightDown;
        
        public TreeNode(int fRowU, int fRowD, int fColL, int fColR, int fSum, 
               TreeNode fLeftUp, TreeNode fRightUp, TreeNode fLeftDown, TreeNode fRightDown) {
               rowU = fRowU;
               rowD = fRowD;
               colL = fColL;
               colR = fColR;
               sum = fSum;
               leftUp = fLeftUp;
               rightUp = fRightUp;
               leftDown = fLeftDown;
               rightDown = fRightDown;
        }
    }
    
    private TreeNode root;
    
    private TreeNode buildTree(int[][] matrix, int rowU, int rowD, int colL, int colR) {
        if(rowU > rowD || colL > colR) {
            return null;
        }
        
        if(rowU == rowD && colL == colR) {
            return new TreeNode(rowU, rowD, colL, colR, matrix[rowU][colL], null, null, null, null);
        }
        
        int mRow = rowU + (rowD - rowU) / 2;
        int mCol = colL + (colR - colL) / 2;
        
        if(rowU == rowD) {
            TreeNode leftUp = buildTree(matrix, rowU, rowD, colL, mCol);
            TreeNode rightUp = buildTree(matrix, rowU, rowD, mCol + 1, colR);
            return new TreeNode(rowU, rowD, colL, colR, leftUp.sum + rightUp.sum, leftUp, rightUp,  null, null);
        }
        
        if(colL == colR) {
            TreeNode leftUp = buildTree(matrix, rowU, mRow, colL, colR);
            TreeNode leftDown = buildTree(matrix, mRow + 1, rowD, colL, colR);
            return new TreeNode(rowU, rowD, colL, colR, leftUp.sum + leftDown.sum, leftUp, null, leftDown, null);
        }
        
        TreeNode leftUp = buildTree(matrix, rowU, mRow, colL, mCol);
        TreeNode rightUp = buildTree(matrix, rowU, mRow, mCol + 1, colR);
        TreeNode leftDown = buildTree(matrix, mRow + 1, rowD, colL, mCol);
        TreeNode rightDown = buildTree(matrix, mRow + 1, rowD, mCol +1, colR);
        
        return new TreeNode(rowU, rowD, colL, colR, leftUp.sum + rightUp.sum + leftDown.sum + rightDown.sum, 
                   leftUp, rightUp, leftDown, rightDown);
    }
    
    public NumMatrix(int[][] matrix) {
        int m = matrix.length;
        if(m == 0) {
            root = null;
            return ;
        }
        int n = matrix[0].length;
        if(n == 0) {
            root = null;
            return;
        }
        
        if(m != 0 && n != 0) {
            root = buildTree(matrix, 0, m - 1, 0, n - 1);
        }
    }
    
    private void updateTree(int row, int col, int val, TreeNode root) {
        if(root == null) return;
        if(root.rowU == root.rowD && root.colL == root.colR) {
            if(row == root.rowU && col == root.colL) {
                root.sum = val;
            } else {
                throw new RuntimeException("the row/col is not correct");
            }
            return ;
        }
        
        if(root.rowU == root.rowD) {
            if(col <= root.leftUp.colR) {
                updateTree(row, col, val, root.leftUp);
            } else {
                updateTree(row, col, val, root.rightUp);
            }
        } else if(root.colL == root.colR) {
            if(row <= root.leftUp.rowD) {
                updateTree(row, col, val, root.leftUp);
            } else {
                updateTree(row, col, val, root.leftDown);
            }
        } else {
            if(root.leftUp != null && row <= root.leftUp.rowD && col <= root.leftUp.colR) {
                updateTree(row, col, val, root.leftUp);
            } else if(root.rightUp != null && row <= root.rightUp.rowD && col >= root.rightUp.colL) {
                updateTree(row, col, val, root.rightUp);
            } else if(root.leftDown != null && row >= root.leftDown.rowU && col <= root.leftDown.colR) {
                updateTree(row, col, val, root.leftDown);
            } else {
                updateTree(row, col, val, root.rightDown);
            }
        }
        
        int sum = 0;
        if(root.leftUp != null) {
            sum += root.leftUp.sum;
        }
        if(root.leftDown != null) {
            sum += root.leftDown.sum;
        }
        if(root.rightUp != null) {
            sum += root.rightUp.sum;
        }        
        if(root.rightDown != null) {
            sum += root.rightDown.sum;
        }
        root.sum = sum;
    }
    
    public void update(int row, int col, int val) {
        updateTree(row, col, val, root);
    }
    
    private int getSumFromTree(int row1, int row2, int col1, int col2, TreeNode root) {
        if(row1 > row2 || col1 > col2 || root == null) {
            return 0;
        }
        
        if(root == null) {
            return 0;
        }
        
        if(root.rowU == row1 && root.rowD == row2 && root.colL == col1 && root.colR == col2) {
            return root.sum;
        }
        
        int s = 0;
        if(root.leftUp != null && row1 <= root.leftUp.rowD && col1 <= root.leftUp.colR) {
            s += getSumFromTree(row1, Math.min(row2, root.leftUp.rowD), col1, Math.min(root.leftUp.colR, col2), root.leftUp);
        }
        if(root.leftDown != null && row2 >= root.leftDown.rowU && col1 <= root.leftDown.colR) {
            s += getSumFromTree(Math.max(row1, root.leftDown.rowU), row2, col1, Math.min(root.leftDown.colR, col2), root.leftDown);
        }
        if(root.rightUp != null && row1 <= root.rightUp.rowD && col2 >= root.rightUp.colL) {
            s += getSumFromTree(row1, Math.min(row2, root.rightUp.rowD), Math.max(col1, root.rightUp.colL), col2, root.rightUp);
        }
        if(root.rightDown != null && row2 >= root.rightDown.rowU && col2 >= root.rightDown.colL) {
            s += getSumFromTree(Math.max(row1, root.rightDown.rowU), row2, Math.max(col1, root.rightDown.colL), col2, root.rightDown);
        }
        
        return s;
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return getSumFromTree(row1, row2, col1, col2, root);
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * obj.update(row,col,val);
 * int param_2 = obj.sumRegion(row1,col1,row2,col2);
 */