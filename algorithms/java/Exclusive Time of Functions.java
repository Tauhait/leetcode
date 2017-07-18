import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class Solution {
	private int[] times;

	private class Node {
		int id;
		int time;
		boolean isStart;
        int reduceTime;

		public Node(int id, int time, boolean isStart) {
			this.id = id;
			this.time = time;
			this.isStart = isStart;
            reduceTime = 0;
		}
	}

	private Node getNode(String log) {
		String[] eles = log.split(":");
		int id = Integer.parseInt(eles[0]);
		boolean isStart = eles[1].equals("start");
		int time = Integer.parseInt(eles[2]);
		return new Node(id, time, isStart);
	}

	public int[] exclusiveTime(int n, List<String> logs) {
		times = new int[n];
		Arrays.fill(times, 0);

		ArrayList<Node> list = new ArrayList<>();
		for (int i = 0; i < logs.size(); ++i) {
			Node node = getNode(logs.get(i));

			if (node.isStart) {
				list.add(node);
			} else {
				if (list.size() == 0) {
					throw new IllegalArgumentException("NO1");
				}
				Node top = list.get(list.size() - 1);
				if (top.id != node.id) {
					throw new IllegalArgumentException("NO2");
				}
				int time = node.time - top.time + 1 - top.reduceTime;
				times[node.id] += time;
                list.remove(list.size() - 1);
				
				for (int j = 0;j < list.size();++j) {
					list.get(j).reduceTime += time;
				}
			}
		}
		return times;
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		int[] a = s.exclusiveTime(2, Arrays.asList("0:start:0",
				"1:start:2",
				"1:end:5",
				"0:end:6"));
		for(int i = 0;i < a.length;++i) {
			System.out.println(a[i]);
		}

	}
}
