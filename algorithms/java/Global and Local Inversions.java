class Solution {
	private int localInversions(int[] A) {
		int count = 0;
		for (int i = 0; i < A.length - 1; ++i) {
			if (A[i] > A[i + 1]) count++;
		}
		return count;
	}

	private int globalCount;

	private void swap(int[] B, int i, int j) {
		int t = B[i];
		B[i] = B[j];
		B[j] = t;
	}

	private void mergeSort(int[] B, int l, int h) { // not include h
		if (h - l <= 1) return;
		if (h - l == 2) {
			if (B[l] > B[l + 1]) {
				globalCount++;
				swap(B, l, l + 1);
			}
			return;
		}

		int m = l + (h - l) / 2;
		mergeSort(B, l, m);
		mergeSort(B, m, h);

		// merge
		int i = l, j = m, right = 0, k = 0;
		int[] C = new int[h - l];
		while (i < m && j < h) {
			if (B[i] < B[j]) {
				globalCount += right;
				C[k] = B[i];
				k++;
				i++;
			} else { // no equal
				C[k] = B[j];
				k++;
				j++;
				right++;
			}
		}
		while (i < m) {
			globalCount += right;
			C[k++] = B[i++];
		}
		while (j < h) C[k++] = B[j++];
		k = 0;
		for (int p = l; p < h; ++p) B[p] = C[k++];
	}

	private void globalInversions(int[] A) {
		int[] B = Arrays.copyOf(A, A.length);
		globalCount = 0;
		mergeSort(B, 0, B.length);
	}

	public boolean isIdealPermutation(int[] A) {
		globalInversions(A);
		int local = localInversions(A);
		if (local == globalCount) return true;
		return false;
	}
}