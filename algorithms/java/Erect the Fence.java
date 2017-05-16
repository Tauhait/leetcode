/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    private class PointsComparator implements Comparator<Point> {
        private Point org;
        public PointsComparator(int x, int y) {
            org = new Point(x, y);
        }
        
        public int compare(Point a, Point b) {
            int c = crossProduct(org, a, b);
            if(c > 0) return -1;
            else if(c < 0) return 1;
            else {
                int disa = (org.x - a.x) * (org.x - a.x) + (org.y - a.y) * (org.y - a.y);
                int disb = (org.x - b.x) * (org.x - b.x) + (org.y - b.y) * (org.y - b.y);
                return disa - disb;
            }
        }
    }
    
    private int crossProduct(Point org, Point a, Point b) {
        return (a.x - org.x) * (b.y - org.y) - (b.x - org.x) * (a.y - org.y);
    }
    
    public List<Point> outerTrees(Point[] points) {
        int n = points.length;
        List<Point> ret = new ArrayList<>();
        if(n <= 3) {
            for(int i = 0;i < n;++i) {
                ret.add(points[i]);
            }
            return ret;
        }
        int minXY = 0;
        for(int i = 1;i < n;++i) {
            if(points[i].y < points[minXY].y) {
                minXY = i;
            } else if(points[i].y == points[minXY].y && points[i].x < points[minXY].x) {
                minXY = i;
            }
        }
        
        if(minXY != 0) {
            Point t = points[0];
            points[0] = points[minXY];
            points[minXY] = t;
        }
        
        Arrays.sort(points, 1, n, new PointsComparator(points[0].x, points[0].y));
        
        ////////
        // this part is to avoid complexity for the points with the largest angel to points[0]
        //https://leetcode.com/problems/erect-the-fence/#/solutions
        int idx = n - 2;
        while(idx >= 0 && crossProduct(points[0], points[n - 1], points[idx]) == 0) {
            idx--;
        }
        int i = idx + 1;
        int j = n - 1;
        while(i < j) {
            Point t = points[i];
            points[i] = points[j];
            points[j] = t;
            i++;
            j--;
        }
        //////////
        
        ret.add(points[0]);
        ret.add(points[1]);
        i = 2;
        while(i < n) {
            while(ret.size() >= 2) {
                int c = crossProduct(ret.get(ret.size() - 2), ret.get(ret.size() - 1), points[i]);
                if(c >= 0) {
                    break;
                } else {
                    ret.remove(ret.size() - 1);
                }
            }
            ret.add(points[i]);
            i++;
        }
        
        return ret;
    }
}