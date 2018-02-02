class Solution {
    public int repeatedStringMatch(String A, String B) {
        int n = B.length() / A.length() + 2;
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i < n;++i)
            sb.append(A);
        
        int index = sb.toString().indexOf(B);
        if(index < 0) return -1;
        int end = index + B.length();
        return (int) Math.ceil(end / (double) A.length());
    }
}