public class LogSystem {
    TreeMap<String, Integer> map = new TreeMap<>();
    
    public LogSystem() {
    }
    
    public void put(int id, String timestamp) {
        map.put(timestamp, id);
    }
    
    private String[] getDateTime(String timestamp) {
        String[] time = timestamp.split(":");
        if(time.length != 6) {
            throw new IllegalArgumentException();
        }
        return time;
    }
    
    private String formatTime(String[] dateTime, String gra, boolean isStart) {
        String[] start = new String[]{"2000", "00", "00", "00", "00", "00"};
        String[] end = new String[]{"2017", "12", "31", "23", "59", "59"};
        int len = 0;
        if(gra.equals("Year")) {
            len = 1;
        } else if(gra.equals("Month")) {
            len = 2;
        } else if(gra.equals("Day")) {
            len = 3;
        } else if(gra.equals("Hour")) {
            len = 4;
        } else if(gra.equals("Minute")) {
            len = 5;
        } else if(gra.equals("Second")) {
            len = 6; 
        }
        
        String time = "";
        for(int i = 0;i < len;++i) {
            time += dateTime[i];
            time += ":";
        }
        if(isStart) {
            for(int i = len;i < 6;++i) {
                time += start[i];
                time += ":";
            }
        } else {
            for(int i = len;i < 6;++i) {
                time += end[i];
                time += ":";
            }
        }
        return time.substring(0, time.length() - 1);
    }
    
    public List<Integer> retrieve(String s, String e, String gra) {
        String[] sDateTime = getDateTime(s);
        String[] eDateTime = getDateTime(e);
        String start = formatTime(sDateTime, gra, true);
        String end = formatTime(eDateTime, gra, false);
        Map<String, Integer> subMap = map.subMap(start, true, end, true);
        
        return new ArrayList<Integer>(subMap.values());    
    }
}

/**
 * Your LogSystem object will be instantiated and called as such:
 * LogSystem obj = new LogSystem();
 * obj.put(id,timestamp);
 * List<Integer> param_2 = obj.retrieve(s,e,gra);
 */