class Solution {
	private boolean valid(int num) {
		int org = num;
		if (num == 0) return false;

		StringBuilder sb = new StringBuilder();
		while (num != 0) {
			int x = num % 10;
			num /= 10;
			if (x == 0 || x == 1 || x == 8) sb.append(x);
			else if (x == 2) sb.append(5);
			else if (x == 5) sb.append(2);
			else if (x == 6) sb.append(9);
			else if (x == 9) sb.append(6);
			else return false;
		}
		int num2 = Integer.parseInt(sb.reverse().toString());
		return org != num2;
	}

	public int rotatedDigits(int N) {
		int count = 0;
		for (int i = 1; i <= N; ++i) {
			if(valid(i)) count++;
		}
		return count;
	}


}