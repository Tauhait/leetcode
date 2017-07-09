public class Solution {
    private int getXCoff(String[] equs, int sign) {
        // left sign 1, right sign -1
        int coffSum = 0;
        for(int i = 0;i < equs.length;++i) {
            if(equs[i].length() == 0) continue;
            if(equs[i].indexOf('x') >= 0) {
                String coff = equs[i].substring(0, equs[i].length() - 1);
                if(coff == "" || coff == null || coff.length() == 0) coffSum += sign * 1;
                else if(coff.equals("-")) coffSum += -1 * sign;
                else coffSum +=  sign * Integer.parseInt(coff);
            }
        }
        return coffSum;
    }

    private int getNums(String[] equs, int sign) {
        // left sign -1, right sign 1
        int coffSum = 0;
        for(int i = 0;i < equs.length;++i) {
            if(equs[i].length() == 0) continue;
            if(equs[i].indexOf('x') < 0) {
                coffSum += sign * Integer.parseInt(equs[i]);
            }
        }
        return coffSum;
    }

    public String solveEquation(String equation) {
        String equ = equation.replaceAll("-", "+-");
        int pos = equ.indexOf('=');
        if(pos < 0) return "No solution";
        
        String left = equ.substring(0, pos);
        String right = equ.substring(pos + 1);
        String[] leftNums = left.split("\\+");
        String[] rightNums = right.split("\\+");

        int xCoff = getXCoff(leftNums, 1) + getXCoff(rightNums, -1);
        int nums = getNums(leftNums, -1) + getNums(rightNums, 1);

        if(xCoff == 0 && nums == 0) return "Infinite solutions";
        if(xCoff == 0 && nums != 0) return "No solution";
        return "x=" + String.valueOf(nums/xCoff);
    }
}