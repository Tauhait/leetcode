class Solution {
    public int magicalString(int n) {
        int[] arr = new int[Math.max(6, n + 1)];
        arr[0] = 1;
        arr[1] = 2;arr[2] = 2;
        arr[3] = 1;arr[4] = 1;
        int i = 3;
        int j = 5;
        while(j < n) {
            if(arr[i] == 1) {
                if(arr[j - 1] == 1) arr[j] = 2;
                else arr[j] = 1;
                i++;j++;
            } else { // arr[i] == 2
                if(arr[j - 1] == 1) {arr[j] = 2;arr[j + 1] = 2;}
                else {arr[j] = 1;arr[j + 1] = 1;}
                i++;
                j += 2;
            }
        }
        
        int num1 = 0;
        for(int k = 0;k < n;++k) {
            if(arr[k] == 1) num1++;
        }
        return num1;
    }
}