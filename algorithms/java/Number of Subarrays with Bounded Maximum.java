class Solution {
    private int numOfConsectiveSubarray(int len) {
		return len * (len + 1) / 2;
	}
	private int numSubarrayBoundedMax(List<Integer> list, int L) {
		int s = -1;
		int e = -1;
		int neg = 0;
		for (int i = 0; i < list.size(); ++i) {
			if (list.get(i) < L) {
				if (s == -1) {
					s = i;
					e = i;
				} else {
					e = i;
				}
			} else {
				if (s != -1) {
					neg += numOfConsectiveSubarray(e - s + 1);
					s = -1;
					e = -1;
				}
			}
		}
		if(s != -1) neg += numOfConsectiveSubarray(e - s + 1);
		return numOfConsectiveSubarray(list.size()) - neg;
	}

	public int numSubarrayBoundedMax(int[] A, int L, int R) {
		List<List<Integer>> list = new ArrayList<>();
		List arr = new ArrayList<>();
		for (int i = 0; i < A.length; ++i) {
			if (A[i] <= R) arr.add(A[i]);
			else {
				if (arr.size() > 0) {
					list.add(arr);
					arr = new ArrayList<>();
				}
			}
		}
		if (arr.size() > 0) {
			list.add(arr);
			arr = new ArrayList<>();
		}
		int count = 0;
		for (int i = 0; i < list.size(); ++i) {
			count += numSubarrayBoundedMax(list.get(i), L);
		}
		return count;
	}
}