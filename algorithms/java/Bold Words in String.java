public class Solution {
	private static class Interval implements Comparable<Interval> {
		private int s;
		private int e;

		public Interval(int s, int e) {
			this.s = s;
			this.e = e;
		}

		public int compareTo(Interval that) {
			return this.s - that.s;
		}
	}

	private void getIntervals(String word, String S, List<Interval> intervals) {
		int pos = S.indexOf(word);
		while (pos >= 0) {
			intervals.add(new Interval(pos, pos + word.length() - 1));
			pos = S.indexOf(word, pos + 1);
		}
	}

	private List<Interval> mergeIntervals(List<Interval> intervals) {
		Collections.sort(intervals);
		List<Interval> newIntervals = new ArrayList<>();
		int s = intervals.get(0).s, e = intervals.get(0).e;
		for (int i = 1; i < intervals.size(); ++i) {
			if (intervals.get(i).s > e + 1) {
				newIntervals.add(new Interval(s, e));
				s = intervals.get(i).s;
				e = intervals.get(i).e;
			} else {
				e = Math.max(e, intervals.get(i).e);
			}
		}
		newIntervals.add(new Interval(s, e));
		return newIntervals;
	}

	public String boldWords(String[] words, String S) {
		List<Interval> intervals = new ArrayList<>();
		for (int i = 0; i < words.length; ++i) {
			getIntervals(words[i], S, intervals);
		}
		if (intervals.size() == 0) return S;
		intervals = mergeIntervals(intervals);

		StringBuilder sb = new StringBuilder();
		int s = 0;
		for (int i = 0; i < intervals.size(); ++i) {
			if (intervals.get(i).s > s) {
				for (int j = s; j < intervals.get(i).s; ++j) sb.append(S.charAt(j));
            }
			s = intervals.get(i).e + 1;
			sb.append("<b>").append(S.substring(intervals.get(i).s, intervals.get(i).e + 1)).append("</b>");
		}
		if (s < S.length()) sb.append(S.substring(s));
		return sb.toString();
	}
}
