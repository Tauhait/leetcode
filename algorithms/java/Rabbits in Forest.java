class Solution {
    public int numRabbits(int[] answers) {
        Arrays.sort(answers);
        int count = 0, ret = 0;
        for(int i = 0;i < answers.length;++i) {
            if(count == 0 || answers[i] == answers[i - 1]) count++;
            else {
                int num = answers[i - 1];
                ret += (num + 1) * Math.ceil(count /(double) (num + 1));
                count = 1;
            }
        }
        int num = answers[answers.length - 1];
        ret += (num + 1) * Math.ceil(count / (double)(num + 1));
        return ret;
    }
}