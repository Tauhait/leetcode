class Solution {
    private int[] getCount(String word) {
        int[] count = new int[26];
        for(char c: word.toCharArray()) {
            if(Character.isLetter(c)) {
                char lc = Character.toLowerCase(c);
                count[(int)(lc - 'a')]++;
            }
        }
        return count;
    }
    
    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] count = getCount(licensePlate);
        
        int ansLen = Integer.MAX_VALUE;
        int ansIndex = -1;
        for(int i = 0;i < words.length;++i) {
           int[] letterCount = getCount(words[i]);
            boolean containAll = true;
            for(int j = 0;j < 26;++j) {
                if(letterCount[j] < count[j]) {
                    containAll = false;
                    break;
                }
            }
            if(containAll && words[i].length() < ansLen) {
                ansLen = words[i].length();
                ansIndex = i;
            }
        }
        return words[ansIndex];
    }
}