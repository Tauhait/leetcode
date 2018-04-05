class Solution {
    private static String[] code = {".-","-...","-.-.","-..",".","..-.","--.","....","..",
                                    ".---","-.-",".-..","--","-.","---",".--.","--.-",".-.",
                                    "...","-","..-","...-",".--","-..-","-.--","--.."};
    private String encode(String word) {
        StringBuilder sb = new StringBuilder(); 
        for(char c: word.toCharArray()) {
            sb.append(code[c - 'a']);
        }
        return sb.toString();
    }
    
    public int uniqueMorseRepresentations(String[] words) {
        Set<String> transform = new HashSet<>();
        for(int i = 0;i < words.length;++i) {
            transform.add(encode(words[i]));   
        }
        return transform.size();
    }
}