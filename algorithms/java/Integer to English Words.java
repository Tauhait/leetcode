public class Solution {
    private final static int[] metric = new int[]{1000000000, 1000000, 1000, 1};
    private final static String[] metricName = new String[]{" Billion", " Million", " Thousand", ""};

    private final static Map<Integer, String> nums = new HashMap<>();
    static {
        nums.put(0, "Zero");
        nums.put(1, "One");     nums.put(11, "Eleven");
        nums.put(2, "Two");     nums.put(12, "Twelve");
        nums.put(3, "Three");   nums.put(13, "Thirteen");
        nums.put(4, "Four");    nums.put(14, "Fourteen");
        nums.put(5, "Five");    nums.put(15, "Fifteen");
        nums.put(6, "Six");     nums.put(16, "Sixteen");
        nums.put(7, "Seven");   nums.put(17, "Seventeen");
        nums.put(8, "Eight");   nums.put(18, "Eighteen");
        nums.put(9, "Nine");    nums.put(19, "Nineteen");
        nums.put(10, "Ten");    nums.put(20, "Twenty");

        nums.put(30, "Thirty");
        nums.put(40, "Forty");
        nums.put(50, "Fifty");
        nums.put(60, "Sixty");
        nums.put(70, "Seventy");
        nums.put(80, "Eighty");
        nums.put(90, "Ninety");
    }
    
    public String numberLessThan1000(int num) {
        StringBuilder sb = new StringBuilder();
        if(num >= 100) {
            sb.append(nums.get(num / 100));
            sb.append(" Hundred");
        }
        num %= 100;
        if(num == 0) return sb.toString();
        
        if(num <= 20) {
            if(sb.length() > 0) sb.append(" ");
            sb.append(nums.get(num));
        } else { 
            if(sb.length() > 0) sb.append(" ");
            sb.append(nums.get(num - num % 10));
            if(num % 10 != 0) {
                if(sb.length() > 0) sb.append(" ");
                sb.append(nums.get(num % 10));    
            }
        }
        return sb.toString();
    }
    
    public String numberToWords(int num) {
        if(num <= 20) return nums.get(num);
                
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i < 4;++i) {
            int n = (num / metric[i]) % 1000;
            if(n == 0) continue;
            if(sb.length() > 0) sb.append(" ");
            sb.append(numberLessThan1000(n));
            sb.append(metricName[i]);
        }
        return sb.toString();            
    }
}


////////
public class Solution {
    private final static String[] LESS_THAN_20 = new String[]{
        "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
        "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private final static String[] TENS = new String[]{
        "", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private final static String[] THOUSANDS = new String[]{"", "Thousand", "Million", "Billion"};
      
    public String getNum(int num) {
        if(num < 20) return LESS_THAN_20[num];
        if(num >= 100) return (LESS_THAN_20[num / 100] + " Hundred " + getNum(num % 100)).trim();
        else return (TENS[num / 10] + " " + LESS_THAN_20[num % 10]).trim();
    }
    
    public String numberToWords(int num) {
        if(num == 0) return "Zero";
                
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i < 4 && num != 0;++i) {
            int n = num % 1000;
            num /= 1000;
            if(n != 0)
                sb.insert(0, " " + getNum(n) + " " + THOUSANDS[i]);
        }
        return sb.toString().trim();            
    }
}