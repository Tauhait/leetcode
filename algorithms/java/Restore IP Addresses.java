class Solution {
    private boolean validIPSection(String section) {
        if(section == null || section.length() == 0) return false;
        if(section.length() > 3) return false;
        
        if(section.charAt(0) == '0') {
            if(section.length() > 1) return false;
            return true;
        }
        
        int ip = Integer.parseInt(section);
        if(ip < 0 || ip > 255) return false;
        return true;     
    }
    
    private void dfs(int start, int index, String s, String[] cur, List<String> IPs) {
        if(start == s.length() && index == 4) {
            for(int i = 0;i < 4;++i) {
                if(!validIPSection(cur[i])) return ;
            }
            StringBuilder ip = new StringBuilder(cur[0]);
            for(int i = 1;i < 4;++i) {
                ip.append(".").append(cur[i]);
            }
            IPs.add(ip.toString());
            return ;
        }
        
        if(start >= s.length()) return ;
        if(index == 4) return ;
        
        cur[index] = s.substring(start, Math.min(start + 1, s.length()));
        dfs(start + 1, index + 1, s, cur, IPs);
        
        cur[index] = s.substring(start, Math.min(start + 2, s.length()));
        dfs(start + 2, index + 1, s, cur, IPs);
        
        cur[index] = s.substring(start, Math.min(start + 3, s.length()));
        dfs(start + 3, index + 1, s, cur, IPs);
    }
    
    public List<String> restoreIpAddresses(String s) {
        List<String> IPs = new ArrayList<>();
        if(s.length() > 12) return IPs;
        
        dfs(0, 0, s, new String[4], IPs);
        return IPs;
    }
}