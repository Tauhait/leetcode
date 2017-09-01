class Solution {
    public String fractionToDecimal(int numeratorI, int denominatorI) {
        if(denominatorI == 0) throw new IllegalArgumentException();
        if(numeratorI == 0) return "0";
        int signum = Integer.signum(numeratorI) * Integer.signum(denominatorI);
        long numerator = (long) numeratorI;
        long denominator = (long) denominatorI;
        if(numerator < 0) numerator = -numerator;
        if(denominator < 0) denominator = -denominator;
        
        long intPart = 0;
        if(numerator >= denominator) intPart = numerator / denominator;
        long reminder = numerator % denominator;
        if(reminder == 0) {
            StringBuilder sb = new StringBuilder();
            if(signum < 0) sb.append("-");
            sb.append(intPart);
            return sb.toString();
        }
        
        Map<Long, Integer> map = new HashMap<>();
        map.put(reminder, 0);
        List<Long> list = new ArrayList<>();
        int index = -1;
        while(reminder != 0) {
            reminder *= 10;
            list.add(reminder / denominator);
            reminder %= denominator;
            if(reminder == 0) break;
            if(map.containsKey(reminder)) {
                index = map.get(reminder);
                break;
            }
            map.put(reminder, list.size());
        }
        
        if(reminder == 0) {
            StringBuilder sb = new StringBuilder();
            if(signum < 0) sb.append("-");
            sb.append(intPart);
            sb.append(".");
            for(Long i: list) {
                sb.append(i);
            }
            return sb.toString();
        }
       
        StringBuilder sb = new StringBuilder();
        if(signum < 0) sb.append("-");
        sb.append(intPart);
        sb.append(".");
        for(int i = 0;i < index;++i) sb.append(list.get(i));
        sb.append("(");
        for(int i = index;i < list.size();++i) sb.append(list.get(i));
        sb.append(")");
        return sb.toString();
    }
}