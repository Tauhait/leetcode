public class Solution {
    private static class Interval {
        private int start;
        private int end;
        
        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
        
        public void setStart(int start) {
            this.start = start;
        }
        
        public void setEnd(int end) {
            this.end = end;
        }
        
        public int getStart() {
            return start;
        }
        
        public int getEnd() {
            return end;
        }
    }
    
    public boolean isPossible(int[] nums) {
        if(nums.length < 3) return false;
        
        List<Interval> list = new LinkedList<>();
        
        list.add(new Interval(nums[0], nums[0]));
        for(int i = 1;i < nums.length;++i) {
            int num = nums[i];
            Iterator<Interval> it = list.iterator();
            while(it.hasNext()) {
                Interval interval = it.next();
                if(num > interval.getEnd() + 1) {
                    if(interval.getEnd() - interval.getStart() + 1 < 3) return false;
                    it.remove();
                }
            }
            Interval temp = null;
            int len = Integer.MAX_VALUE;
            for(int j = 0;j < list.size();++j) {
                if(list.get(j).getEnd() + 1 == num) {
                    if(list.get(j).getEnd() - list.get(j).getStart() + 1 < len) {
                        temp = list.get(j);
                        len = list.get(j).getEnd() - list.get(j).getStart() + 1;
                    }
                }
            }
            if(temp == null) {
                list.add(new Interval(num, num));
            } else {
                temp.setEnd(num);
            }
        }
        for(Interval interval: list) {
            if(interval.getEnd() - interval.getStart() + 1  < 3) return false;  
        }
        return true;
    }
}