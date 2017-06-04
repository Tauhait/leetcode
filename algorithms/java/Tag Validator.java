public class Solution {
	private String replaceCDATA(String code) {
		String str = code;
		while (true) {
			int pos1 = str.indexOf("<![CDATA[");
			if (pos1 < 0) {
				return str;
			}
			int pos2 = str.indexOf("]]>", pos1);
			if (pos2 < 0) {
				return str;
			}

			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < pos1; ++i) {
				sb.append(str.charAt(i));
			}
			sb.append("**");
			for (int i = pos2 + 3; i < str.length(); ++i) {
				sb.append(str.charAt(i));
			}
			str = sb.toString();
		}
	}

	private boolean isValideTag(String tag) {
		if (tag.length() < 1 || tag.length() > 9) {
			return false;
		}
		for (char c : tag.toCharArray()) {
			if (!Character.isLetter(c))
				return false;
			if (!Character.isUpperCase(c))
				return false;
		}
		return true;
	}
    
    Stack<String> stack = new Stack<>();
	public boolean isValidHelper(String code) {
		int i = 0;
		while (i < code.length()) {
			if (code.charAt(i) == '<') {
			    if(i + 1 >= code.length()) {
			        return false;
			    }
			    boolean isStartTag = true;
			    int startTagPos = i + 1;
			    if(code.charAt(i + 1) == '/') {
			        startTagPos = i + 2;
			        isStartTag = false;
			    }
			    int endTagPos = code.indexOf('>', startTagPos);
			    if(endTagPos < 0) {
			        return false;
			    }
			    String tagName = code.substring(startTagPos, endTagPos);
			    if(!isValideTag(tagName)) {
			        return false;
			    }
			    
			    if(isStartTag) {
			        stack.push(tagName);
			    } else {
			        if(stack.empty()) {
			            return false;
			        }
			        String top = stack.pop();
			        if(!top.equals(tagName)) {
			            return false;
			        }
			    }
			    i = endTagPos + 1;
			} else {
			    i++;
			}
		}
		
		return stack.empty();
	}

	public boolean isValid(String code) {
		code = replaceCDATA(code);
		if (code.length() < 2) {
			return false;
		}
		if (code.charAt(0) != '<' || code.charAt(code.length() - 1) != '>') {
			return false;
		}
		int firstTagStart = code.indexOf('<');
		int firstTagEnd = code.indexOf('>');
		int lastTagStart = code.lastIndexOf('<');
		int lastTagEnd = code.lastIndexOf('>');
		if(firstTagStart < 0 || firstTagEnd < 0 || lastTagStart < 0 || lastTagEnd < 0) {
		    return false;
		}
		if(firstTagEnd == lastTagEnd || firstTagStart == lastTagStart) {
		    return false;
		}
		
		if(lastTagStart + 1 == code.length() || code.charAt(lastTagStart + 1) != '/') {
		    return false;
		}
		String firstTag = code.substring(firstTagStart + 1, firstTagEnd);
		String lastTag = code.substring(lastTagStart + 2, lastTagEnd);
		if(!isValideTag(firstTag) || !isValideTag(lastTag) || !firstTag.equals(lastTag)) {
		    return false;
		}
		code = code.substring(firstTagEnd + 1, lastTagStart);
		return isValidHelper(code);
	}
}