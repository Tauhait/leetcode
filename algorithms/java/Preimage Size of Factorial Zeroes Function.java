class Solution {
	private int numOfTailingZero(int num) {
		int count = 0;
		while (num != 0) {
			count += num / 5;
			num /= 5;
		}
		return count;
	}

	private int lowerBound(int K) {
		int l = 0, h = 1000000000;
		while (l < h) {
			int m = (l + h) / 2;
			int c = numOfTailingZero(m);
			if (c > K) h = m - 1;
            else if(c < K) l = m + 1;
            else if(c == K) h = m;
		}
        if(l > h || numOfTailingZero(l) != K) return -1;
		return l;
	}

	private int upperBound(int K) {
		int l = 0, h = 1000000000;
		while (l < h) {
			int m = (l + h + 1) / 2;
			int c = numOfTailingZero(m);
			if (c > K) h = m - 1;
            else if(c < K) l = m + 1;
            else if(c == K) l = m;
		}
        if(l > h || numOfTailingZero(l) != K) return -1;
		return l;
	}

	public int preimageSizeFZF(int K) {
        int upper = upperBound(K);
        int lower = lowerBound(K);
        if(upper == -1 || lower == -1) return 0;
		return upper - lower + 1;
	}
}