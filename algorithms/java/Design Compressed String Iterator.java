public class StringIterator {
    private char c;
    private int remender;
    private int index;
    private String compressedString;
    public StringIterator(String compressedString) {
        if(compressedString.length() == 0) {
            index = compressedString.length();
            remender = 0;
        }
        this.compressedString = compressedString;
        index = 0;
        c = compressedString.charAt(index);
        index++;
        int start = index;
        while(index < compressedString.length() && Character.isDigit(compressedString.charAt(index))) {
            index++;
        }
        remender = Integer.parseInt(compressedString.substring(start, index));
    }
    
    public char next() {
        if(remender > 0) {
            remender--;
            return c;
        }
        
        if(index == compressedString.length()) {
            return ' ';
        }
        c = compressedString.charAt(index);
        index++;
        int start = index;
        while(index < compressedString.length() && Character.isDigit(compressedString.charAt(index))) {
            index++;
        }
        remender = Integer.parseInt(compressedString.substring(start, index));
        
        remender--;
        return c;
    }
    
    public boolean hasNext() {
        if(remender > 0) {
            return true;
        }
        if(index == compressedString.length()) {
            return false;
        }
        return true;
    }
}

/**
 * Your StringIterator object will be instantiated and called as such:
 * StringIterator obj = new StringIterator(compressedString);
 * char param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */