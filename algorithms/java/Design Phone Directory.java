public class PhoneDirectory {
    LinkedList<Integer> list = new LinkedList<>();
    HashMap<Integer, Boolean> map = new HashMap<>();
    
    /** Initialize your data structure here
        @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
    public PhoneDirectory(int maxNumbers) {
        for(int i = 0;i < maxNumbers;++i) {
            list.addLast(i);
            map.put(i, true);
        }
    }
    
    /** Provide a number which is not assigned to anyone.
        @return - Return an available number. Return -1 if none is available. */
    public int get() {
        if(list.size() == 0) return -1;
        
        Integer num = list.pollFirst();
        map.put(num, false);
        
        return num;
    }
    
    /** Check if a number is available or not. */
    public boolean check(int number) {
        return map.get(number); 
    }
    
    /** Recycle or release a number. */
    public void release(int number) {
        if(map.get(number) == true) return ;
        
        map.put(number, true);
        list.addLast(number);
    }
}

/**
 * Your PhoneDirectory object will be instantiated and called as such:
 * PhoneDirectory obj = new PhoneDirectory(maxNumbers);
 * int param_1 = obj.get();
 * boolean param_2 = obj.check(number);
 * obj.release(number);
 */