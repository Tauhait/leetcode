public class RandomizedSet {
    private ArrayList<Integer> arr = new ArrayList<>();
    private HashMap<Integer, Integer> map = new HashMap<>();
    
    /** Initialize your data structure here. */
    public RandomizedSet() {
        map.clear();
        arr.clear();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(map.containsKey(val)) return false;
        
        arr.add(val);
        map.put(val, arr.size() - 1);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!map.containsKey(val)) return false;
        
        int index = map.get(val);
        if(index == arr.size() - 1) {
            map.remove(val);
            arr.remove(arr.size() - 1);
        } else {
            map.remove(val);
            int last = arr.get(arr.size() - 1);
            arr.set(index, last);
            map.put(last, index);
            arr.remove(arr.size() - 1);
        }
        
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        Random rand = new Random();
        int r = rand.nextInt(arr.size());
        return arr.get(r);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */