class Solution {
    private static class Package implements Comparable<Package> {
		double dis;
		int numOfGas;

		public Package(double dis, int numOfGas) {
			this.dis = dis;
			this.numOfGas = numOfGas;
		}

		private double getAvg() {
			if (numOfGas == 0) return dis;
			return dis / (1 + numOfGas);
		}

		public int compareTo(Package that) {
			return (int) Math.signum(this.getAvg() - that.getAvg());
		}
	}

	public double minmaxGasDist(int[] stations, int K) {
		PriorityQueue<Package> pq = new PriorityQueue<>(Collections.reverseOrder());
		for (int i = 0; i < stations.length - 1; ++i)
			pq.add(new Package(stations[i + 1] - stations[i], 0));

		for (int i = 0; i < K; ++i) {
			Package f = pq.poll();
			f.numOfGas++;
			pq.add(f);
		}
		return pq.peek().getAvg();
	}
}