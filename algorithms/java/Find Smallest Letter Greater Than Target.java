class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int index = Arrays.binarySearch(letters, target);
        int ret = -1;
        if(index < 0) {
            index = -(index + 1);
            ret = index;
        } else {
            ret = index + 1;
        }
        
        while(ret < letters.length && letters[ret] == target) ret++;
        if(ret < letters.length) return letters[ret];
        return letters[0];
    }
}