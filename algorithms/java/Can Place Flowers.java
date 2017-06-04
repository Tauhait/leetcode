public class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if(n == 0) {
            return true;
        }
        
        int i = 0;
        int j = 0;
        while(i < flowerbed.length && j < n) {
            if(flowerbed[i] == 1) {
                i +=  2;
            } else {
                if(i + 1 < flowerbed.length && flowerbed[i + 1] == 0) {
                    j++;
                    i += 2;
                } else if(i + 1 == flowerbed.length) {
                    j++;
                    i++;
                } else {
                    i++;
                }
            }
        }
        
        if(j == n) {
            return true;
        }
        return false;
    }
}