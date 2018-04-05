class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> count = new HashMap<>();
        for(int i = 0;i < cpdomains.length;++i) {
            int s = cpdomains[i].indexOf(' ');
            if(s < 0) return Collections.emptyList();
            int c = Integer.parseInt(cpdomains[i].substring(0, s));
            String domain = cpdomains[i].substring(s + 1);
            int p = domain.indexOf('.');
            while(p >= 0) {
                count.put(domain, count.getOrDefault(domain, 0) + c);
                domain = domain.substring(p + 1);
                p = domain.indexOf('.');
            }
            count.put(domain, count.getOrDefault(domain, 0) + c);
        }
        List<String> ret = new ArrayList<>();
        for(Map.Entry<String, Integer> entry: count.entrySet()) {
            ret.add(entry.getValue() + " " + entry.getKey());
        }
        return ret;
    }
}