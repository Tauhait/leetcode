public class Solution {
    private class Interval implements Comparable<Interval> {
        private int start;
        private int end;
        
        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
        
        public int compareTo(Interval that) {
            return this.start - that.start;
        }
    }
    
    public String addBoldTag(String s, String[] dict) {
        ArrayList<Interval> arr = new ArrayList<>();
        for(int i = 0;i < dict.length;++i) {
            String word = dict[i];
            int pos = s.indexOf(word);
            while(pos >= 0) {
                arr.add(new Interval(pos, pos + word.length() - 1));
                pos = s.indexOf(word, pos + 1);
            }
        }
        Collections.sort(arr);
        if(arr.size() == 0) {
            return s;
        }
        
        int start = arr.get(0).start;
        int end = arr.get(0).end;
        StringBuilder sb = new StringBuilder();
        if(start > 0) {
            for(int i = 0;i < start;++i) {
                sb.append(s.charAt(i));
            }
        }
        sb.append("<b>");
        for(int i = 1;i < arr.size();++i) {
            if(arr.get(i).start > end + 1) {
                for(int j = start;j <= end;++j) {
                    sb.append(s.charAt(j));
                }
                sb.append("</b>");
                for(int j = end + 1;j < arr.get(i).start;++j) {
                    sb.append(s.charAt(j));
                }
                sb.append("<b>");
                start = arr.get(i).start;
                end = arr.get(i).end;
            } else {
                end = Math.max(end, arr.get(i).end);
            }
        }
        for(int j = start;j <= end;++j) {
            sb.append(s.charAt(j));
        }
        sb.append("</b>");
        while(end < s.length() - 1) {
            sb.append(s.charAt(end + 1));
            end++;
        }
        return sb.toString();
    }
}