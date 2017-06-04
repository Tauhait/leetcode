public class Solution {
    private class File {
        String path;
        String name;
        String content;
        
        public File(String path, String name, String content) {
            this.path = path;
            this.name = name;
            this.content = content;
        }
    }
    HashMap<String, ArrayList<File> > map = new HashMap<>();
    
    private String getFileFullPath(String path, String name) {
        if(path.length() > 0) {
            if(path.charAt(path.length() - 1) == '/') {
                return path + name;
            } else {
                return path + "/" + name;
            }
        }
        return "/" + name;
    }
    
    public List<List<String>> findDuplicate(String[] paths) {
        for(String dir: paths) {
            String[] files = dir.split(" ");
            if(files.length == 0) {
                continue;
            }
            
            String path = files[0];
            for(int i = 1;i < files.length;++i) {
                int pos1 = files[i].indexOf("(");
                int pos2 = files[i].indexOf(")");
                String name = files[i].substring(0, pos1);
                String content = files[i].substring(pos1 + 1, pos2);
                File file = new File(path, name, content);
                if(!map.containsKey(content)) {
                    map.put(content, new ArrayList<>());
                }
                map.get(content).add(file);
            }
        }
        List<List<String> > ret = new ArrayList<>();
        for(Map.Entry<String, ArrayList<File> > entry: map.entrySet()) {
            if(entry.getValue().size() < 2) continue;
            List<String> duplicate = new ArrayList<>();
            for(File file: entry.getValue()) {
                duplicate.add(getFileFullPath(file.path, file.name));   
            }
            ret.add(duplicate);
        }
        
        return ret;
    }
}