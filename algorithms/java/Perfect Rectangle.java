public class Solution {
    private String encodePoint(int x, int y) {
        return String.valueOf(x) + "_" + String.valueOf(y);
    }
        
    public boolean isRectangleCover(int[][] rectangles) {
        int m = rectangles.length;
        if(m == 0) {
            return true;
        }
        
        Set<String> set = new HashSet<>();
        int totalArea = 0;
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;
        for(int i = 0;i < m;++i) {
            int x1 = rectangles[i][0];
            int y1 = rectangles[i][1];
            int x2 = rectangles[i][2];
            int y2 = rectangles[i][3];
            minX = Math.min(minX, Math.min(x1, x2));
            minY = Math.min(minY, Math.min(y1, y2));
            maxX = Math.max(maxX, Math.max(x1, x2));
            maxY = Math.max(maxY, Math.max(y1, y2));
            
            // four pionts
            String p1 = encodePoint(x1, y1);
            String p2 = encodePoint(x1, y2);
            String p3 = encodePoint(x2, y1);
            String p4 = encodePoint(x2, y2);
            if(set.contains(p1)) {
                set.remove(p1);
            } else {
                set.add(p1);
            }
            if(set.contains(p2)) {
                set.remove(p2);
            } else {
                set.add(p2);
            }
            if(set.contains(p3)) {
                set.remove(p3);
            } else {
                set.add(p3);
            }
            if(set.contains(p4)) {
                set.remove(p4);
            } else {
                set.add(p4);
            }
            totalArea += (x2 - x1) * (y2 - y1);
        }
        
        if(totalArea != (maxX - minX) * (maxY - minY)) {
            return false;
        }
        if(set.size() != 4) {
            return false;
        }
        
        if(!set.contains(encodePoint(minX, minY))) {
            return false;
        }
        if(!set.contains(encodePoint(minX, maxY))) {
            return false;
        }
        if(!set.contains(encodePoint(maxX, minY))) {
            return false;
        }
        if(!set.contains(encodePoint(maxX, maxY))) {
            return false;
        }
        return true;
    }
}