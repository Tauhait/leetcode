public class Solution {
    private boolean shareCommonLetters(int i, int j, int[][] count) {
        for(int k = 0;k < 26;++k) {
            if(count[i][k] > 0 && count[j][k] > 0) {
                return true;
            }
        }
        return false;
    }
    
    public int maxProduct(String[] words) {
        int n = words.length;
        if(n < 2) {
            return 0;
        }
        Arrays.sort(words, (a, b) -> b.length() - a.length());
        
        int[][] count = new int[n][26];
        for(int i = 0;i < n;++i) {
            for(char c: words[i].toCharArray()) {
                count[i][c - 'a']++;
            }
        }
        
        int id1 = n;
        int id2 = n;
        int maxProduct = 0;
        for(int i = 0;i < n;++i) {
            if(i > id2) {
                break;
            }
            for(int j = i + 1;j < n;++j) {
                if(!shareCommonLetters(i, j, count)) {
                    int prod = words[i].length() * words[j].length();
                    if(prod > maxProduct) {
                        maxProduct = prod;
                        id1 = i;
                        id2 = j;
                        break;
                    }
                }
            }
        }
        return maxProduct;
    }
}


public class Solution {
    public int maxProduct(String[] words) {
        int n = words.length;
        if(n < 2) {
            return 0;
        }
        Arrays.sort(words, (a, b) -> b.length() - a.length());
        
        int[] count = new int[n];
        for(int i = 0;i < n;++i) {
            for(char c: words[i].toCharArray()) {
                count[i] |= 1 << (c - 'a');
            }
        }
        
        int id1 = n;
        int id2 = n;
        int maxProduct = 0;
        for(int i = 0;i < n;++i) {
            if(i > id2) {
                break;
            }
            for(int j = i + 1;j < n;++j) {
                if((count[i] & count[j]) == 0) {
                    int prod = words[i].length() * words[j].length();
                    if(prod > maxProduct) {
                        maxProduct = prod;
                        id1 = i;
                        id2 = j;
                        break;
                    }
                }
            }
        }
        return maxProduct;
    }
}