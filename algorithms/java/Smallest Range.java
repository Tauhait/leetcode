public class Solution {
    HashMap<Integer, Set<Integer> > map = new HashMap<>();
    List<Integer> allNumbers = new ArrayList<>();
    
    private boolean canBeDeleted(int value, int[] containIDCounts) {
        for(Integer id: map.get(value)) {
            if(containIDCounts[id] == 1) {
                return false;
            }
        }
        return true;
    }
    
    public int[] smallestRange(List<List<Integer>> nums) {
        int maxValue = Integer.MIN_VALUE;
        int minValue = Integer.MAX_VALUE;
        Set<Integer> allNumbersSet = new HashSet<>();
        for(int i = 0;i < nums.size();++i) {
            if(nums.get(i) == null || nums.get(i).size() == 0) {
                throw new IllegalArgumentException();
            }
            for(int j = 0;j < nums.get(i).size();++j) {
                Integer num = nums.get(i).get(j);
                maxValue = Math.max(maxValue, num);
                minValue = Math.min(minValue, num);
                map.putIfAbsent(num, new HashSet<>());
                map.get(num).add(i);
               allNumbersSet.add(num);
            }
        }
        for(Integer num: allNumbersSet) {
            allNumbers.add(num);
        }
        Collections.sort(allNumbers);
        
        int[] ans = new int[2];
        ans[0] = minValue;
        ans[1] = maxValue;
        
        int startIndex = 0;
        int curIndex = 0;
        int n = nums.size();
        int containIDs = 0;
        int[] containIDCounts = new int[n];
        Arrays.fill(containIDCounts, 0);
        while(curIndex < allNumbers.size()) {
            int cur = allNumbers.get(curIndex);
            for(Integer id: map.get(cur)) {
                containIDCounts[id]++;
                if(containIDCounts[id] == 1) {
                    containIDs++;
                }
            }
            
            if(containIDs == n) {
                while(startIndex < curIndex && canBeDeleted(allNumbers.get(startIndex), containIDCounts)) {
                    for(Integer id: map.get(allNumbers.get(startIndex))) {
                        containIDCounts[id]--;
                    }
                    startIndex++;
                }
                if(cur - allNumbers.get(startIndex) + 1 < ans[1] - ans[0] + 1) {
                    ans[0] = allNumbers.get(startIndex);
                    ans[1] = cur;
                }
                for(Integer id: map.get(allNumbers.get(startIndex))) {
                    containIDCounts[id]--;
                    if(containIDCounts[id] == 0) {
                        containIDs--;
                    }
                }
                startIndex++;
            }
            curIndex++;
        }
        return ans;
    }
}

