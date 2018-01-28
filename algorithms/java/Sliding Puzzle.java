class Solution {
   	private static class Pos {
		int r;
		int c;

		public Pos(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	private static int[][] DIR = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

	private boolean solved(List<List<Integer>> board) {
		return board.get(0).get(0) == 1 && board.get(0).get(1) == 2 && board.get(0).get(2) == 3 &&
				board.get(1).get(0) == 4 && board.get(1).get(1) == 5 && board.get(1).get(2) == 0;
	}

	private List<List<Integer>> copyBoard(List<List<Integer>> board) {
		List<List<Integer>> b = new ArrayList<>();
		for (int i = 0; i < 2; ++i) {
			b.add(new ArrayList<>());
			for (int j = 0; j < 3; ++j) {
				b.get(i).add(board.get(i).get(j));
			}
		}
		return b;
	}

	private List<List<Integer>> copyBoard(int[][] board) {
		List<List<Integer>> b = new ArrayList<>();
		for (int i = 0; i < 2; ++i) {
			b.add(new ArrayList<>());
			for (int j = 0; j < 3; ++j) {
				b.get(i).add(board[i][j]);
			}
		}
		return b;
	}

	private Pos zeroPos(List<List<Integer>> board) {
		for (int i = 0; i < 2; ++i) {
			for (int j = 0; j < 3; ++j) {
				if (board.get(i).get(j) == 0) return new Pos(i, j);
			}
		}
		return new Pos(-1, -1);
	}

	private List<List<Integer>> swapBoard(List<List<Integer>> board, Pos org, Pos target) {
		List<List<Integer>> copyBoard = copyBoard(board);
		int v1 = copyBoard.get(org.r).get(org.c);
		int v2 = copyBoard.get(target.r).get(target.c);
		copyBoard.get(org.r).set(org.c, v2);
		copyBoard.get(target.r).set(target.c, v1);
		return copyBoard;
	}

	public int slidingPuzzle(int[][] board) {
		List<List<Integer>> copy = copyBoard(board);
		if (solved(copy)) return 0;
		Queue<List<List<Integer>>> q = new LinkedList<>();
		Set<List<List<Integer>>> set = new HashSet<>();
		q.add(copy);
		set.add(copy);
		int move = 0;
		while (!q.isEmpty()) {
			int s = q.size();
			move++;
			for (int i = 0; i < s; ++i) {
				List<List<Integer>> f = q.poll();
				Pos posZero = zeroPos(f);
				for (int d = 0; d < 4; ++d) {
					int r = posZero.r + DIR[d][0];
					int c = posZero.c + DIR[d][1];
					if (r >= 0 && r < 2 && c >= 0 && c < 3) {
						List<List<Integer>> newBoard = swapBoard(f, posZero, new Pos(r, c));
						if (solved(newBoard)) return move;
						if (set.contains(newBoard)) continue;
						set.add(newBoard);
						q.add(newBoard);
					}
				}
			}
		}

		return -1;
	}
}