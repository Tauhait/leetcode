class Solution {
    private double Afirst;
    private double ABsame;

    private Map<String, Double> mapA = new HashMap<>();
    private Map<String, Double> mapAB = new HashMap<>();

    private static int SERVE[][] = {{100, 0}, {75, 25}, {50, 50}, {25, 75}};

    private String key(int A, int B) {
        return A + "-" + B;
    }

    private double[]  dfs(int A, int B, double p) {
        if (A == 0 && B != 0) {
            Afirst += p;
            return new double[]{p, 0};
        }
        if (A == 0 && B == 0) {
            ABsame += p;
            return new double[]{0, p};
        }
        if (B == 0) return new double[]{0, 0};

        if(mapA.containsKey(key(A, B)) && mapAB.containsKey(key(A, B))) {
            Afirst += mapA.get(key(A, B));
            ABsame += mapAB.get(key(A, B));
            return new double[]{mapA.get(key(A, B)), mapAB.get(key(A, B))};
        }
        double[] pro = new double[2];
        for (int i = 0; i < 4; ++i) {
            double[] r = dfs(Math.max(0, A - SERVE[i][0]), Math.max(0, B - SERVE[i][1]), p * 0.25);
            pro[0] += r[0];
            pro[1] += r[1];
        }
        mapA.put(key(A, B), pro[0]);
        mapAB.put(key(A, B), pro[1]);
        return pro;
    }

    public double soupServings(int N) {
        Afirst = 0.0;
        ABsame = 0.0;
        if(N > 4000) return 1.0;
        dfs(N, N, 1.0);
        return Afirst + ABsame / 2.0;
    }
}
