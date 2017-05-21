public class Solution {
    private class Point implements Comparable<Point> {
        int x;
        int y;
        
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
        
        public int compareTo(Point that) {
            if(this.x == that.x) {
                return this.y - that.y;
            }
            return this.x - that.x;
        }
    }
    
    private int dis(Point a, Point b) {
        return (a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y);
    }
    
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        Point[] p = new Point[4];
        p[0] = new Point(p1[0], p1[1]);
        p[1] = new Point(p2[0], p2[1]);
        p[2] = new Point(p3[0], p3[1]);
        p[3] = new Point(p4[0], p4[1]);
        Arrays.sort(p);
        int[][] D = new int[4][4];
        for(int i = 0;i < 4;++i) {
            for(int j = 0;j < 4;++j) {
                D[i][j] = dis(p[i], p[j]);
            }
        }
        if(D[0][1] == 0 || D[0][3] == 0) {
            return false;
        }
        if(D[0][1] != D[1][3] || D[0][1] != D[3][2] || D[0][1] != D[2][0]) {
            return false;
        }
        if(D[0][3] != D[1][2]) return false;
        
        if(D[0][1] + D[1][3] != D[0][3]) return false;
        return true;
    }
}