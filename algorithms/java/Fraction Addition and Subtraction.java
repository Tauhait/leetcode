public class Solution {
	private class Fraction {
		int a;
		int b;
		int sign;
		public Fraction(int a, int b, int sign) {
			this.a = a;
			this.b = b;
			this.sign = sign;
		}
	}

	private int gcd(int a, int b) {
		if (a < b) {
			return gcd(b, a);
		}
		if (b == 0) {
			return a;
		}
		return gcd(b, a % b);
	}

	private int lcm(int a, int b) {
		return a * b / gcd(a, b);
	}

	private int lcm(ArrayList<Fraction> list) {
		int lcmDenominator = list.get(0).b;
		for (int i = 1; i < list.size(); ++i) {
			lcmDenominator = lcm(lcmDenominator, list.get(i).b);
		}
		return lcmDenominator;
	}

	public String fractionAddition(String expression) {
		if (expression.length() == 0) {
			return "0/1";
		}
		ArrayList<Fraction> list = new ArrayList<>();
		String[] adds = expression.split("\\+");
		for (int i = 0; i < adds.length; ++i) {
			String s = adds[i];
			int firstSign = 1;
			if (s.charAt(0) == '-') {
				firstSign = -1;
			}
			String[] sub = s.split("-");
			for (int j = 0; j < sub.length; ++j) {
				int pos = sub[j].indexOf('/');
				if (pos < 0)
					continue;
				int a = Integer.parseInt(sub[j].substring(0, pos));
				int b = Integer.parseInt(sub[j].substring(pos + 1));
				int sign = -1;
				if (j == 0) {
					sign = firstSign;
				}
				list.add(new Fraction(a, b, sign));
			}
		}
		
		int lcmDenominator = lcm(list);
		for(int i = 0;i < list.size();++i) {
			Fraction f = list.get(i);
			if(f.b != lcmDenominator) {
				f.a = f.a * (lcmDenominator / f.b);
				f.b = lcmDenominator;
			}
		}
		
		Fraction ret = new Fraction(0, lcmDenominator, 1);
		for(int i = 0;i < list.size();++i) {
			Fraction f = list.get(i);
			if(f.sign == 1) {
			    ret.a += f.a;
			} else {
			    ret.a -= f.a;
			}
		}
		if(ret.a < 0) {
			ret.a = -ret.a;
			ret.sign = -1;
		}
		int g = gcd(ret.a, ret.b);
		
		ret.a = ret.a / g;
		ret.b = ret.b / g;
		StringBuilder sb = new StringBuilder();
		if(ret.sign == -1) {
			sb.append('-');
		}
		sb.append(ret.a);
		sb.append('/');
		sb.append(ret.b);
		return sb.toString();
	}
}