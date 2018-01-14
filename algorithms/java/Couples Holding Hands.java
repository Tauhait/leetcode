public class Solution {
	private boolean validSeat(List<Integer> row, int i) {
		if (row.get(i).intValue() % 2 == 0) {
			if (!row.get(i + 1).equals(row.get(i) + 1)) return false;
		} else {
			if (!row.get(i + 1).equals(row.get(i) - 1)) return false;
		}
		return true;
	}

	private boolean validSeats(List<Integer> row) {
		for (int i = 0; i < row.size(); i += 2) {
			if (!validSeat(row, i)) return false;
		}
		return true;
	}

	private int getValidIndex(List<Integer> row, int i) {
		int num = -1;
		if (row.get(i).intValue() % 2 == 0) num = row.get(i) + 1;
		else num = row.get(i) - 1;
		for (int j = i + 2; j < row.size(); ++j) {
			if (row.get(j).equals(num)) return j;
		}
		return -1;
	}

	public int minSwapsCouples(int[] row) {
		if (row.length == 0) return 0;

		Queue<List<Integer>> q = new LinkedList<>();
		Set<List<Integer>> v = new HashSet<>();
		List<Integer> start = new ArrayList<>();
		for (int i = 0; i < row.length; ++i) start.add(row[i]);
		if (validSeats(start)) return 0;
		q.add(start);
		v.add(start);
		int lev = 0;
		while (!q.isEmpty()) {
			int s = q.size();
			lev++;
			for (int i = 0; i < s; ++i) {
				List<Integer> f = q.poll();
				int first = -1;
				for (int j = 0; j < f.size(); j += 2) {
					if (!validSeat(f, j)) {first = j;break;}
				}
				if (first != -1) {
					int index = getValidIndex(f, first);
					if (index != -1) {
						List<Integer> list = new ArrayList<>();
						for (int p = first + 2; p < index; ++p) list.add(f.get(p));
						list.add(f.get(first + 1));
						for (int p = index + 1; p < f.size(); ++p) list.add(f.get(p));
						if (validSeats(list)) return lev;
						if (!v.contains(list)) {
							q.add(list);
							v.add(list);
						}
					}
				}
			}
		}
		return row.length;
	}
}
