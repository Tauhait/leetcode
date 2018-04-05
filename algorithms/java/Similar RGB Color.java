class Solution {
    private int[] parseColor(String color) {
        int r = Integer.parseInt(color.substring(1, 3), 16);
        int g = Integer.parseInt(color.substring(3, 5), 16);
        int b = Integer.parseInt(color.substring(5, 7), 16);
        return new int[]{r, g, b};
    }

    private int getDistance(int[] color, int[] dup) {
        int s = 0;
        s += (color[0] - dup[0]) * (color[0] - dup[0]);
        s += (color[1] - dup[1]) * (color[1] - dup[1]);
        s += (color[2] - dup[2]) * (color[2] - dup[2]);
        return s;
    }

    public String similarRGB(String color) {
        int[] rgb = parseColor(color);
        int[] res = new int[3];
        int minDis = Integer.MAX_VALUE;
        for (int r = 0; r < 16; ++r) {
            for (int g = 0; g < 16; ++g) {
                for (int b = 0; b < 16; ++b) {
                    int[] dup = new int[]{16 * r + r, 16 * g + g, 16 * b + b};
                    int d = getDistance(rgb, dup);
                    if (d < minDis) {
                        minDis = d;
                        res = dup;
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append('#');
        for(int i = 0;i < 3;++i) {
            if(res[i] == 0) sb.append("00");
            else sb.append(Integer.toString(res[i], 16));  
        }
        return sb.toString();
    }
}