public class Solution {
    private List<String> getAbbreviation(String target, int bits) {
        List<String> abbreviation = new ArrayList<>();
        int count = 0;
        for(int i = 0;i < target.length();++i) {
            if((bits & (1 << i)) != 0) {
                if(count != 0) {
                    abbreviation.add(String.valueOf(count));
                    count = 0;
                }
                abbreviation.add(target.substring(i, i + 1));
            } else {
                count++;
            }
        }
        if(count != 0) {
            abbreviation.add(String.valueOf(count));
        }
        return abbreviation;
    }
    
    private boolean overlap(List<String> abbreviation, String word) {
        int j = 0;
        for(int i = 0;i < abbreviation.size();++i) {
            String str = abbreviation.get(i);
            if(Character.isLetter(str.charAt(0))) {
                if(str.charAt(0) != word.charAt(j)) {
                    return false;
                }   
                j++;
            } else {
                int count = Integer.parseInt(str);
                j = j + count;
            }
        }
        return true;
    }
    
    public String minAbbreviation(String target, String[] dictionary) {
        int m = target.length();
        int n = dictionary.length;
        if(n == 0) {
            return String.valueOf(m);
        }
        String ret = "";
        int minLen = Integer.MAX_VALUE;
        for(int i = 0;i < (1 << m);++i) {
            List<String> abbreviation = getAbbreviation(target, i);
            boolean valid = true;
            for(int j = 0;j < n;++j) {
                if(dictionary[j].length() != target.length()) {
                    continue;
                }
                if(overlap(abbreviation, dictionary[j])) {
                    valid = false;
                    break;
                }    
            }
            if(valid) {
                if(abbreviation.size() < minLen) {
                    StringBuilder sb = new StringBuilder();
                    for(int j = 0;j < abbreviation.size();++j) {
                        sb.append(abbreviation.get(j));
                    }
                    minLen = abbreviation.size();
                    ret = sb.toString();
                }
            }
        }
        return ret;
    }
}