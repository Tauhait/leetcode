class RandomizedCollection {
    List<Integer> list;
    Map<Integer, Set<Integer> > map;
    
    /** Initialize your data structure here. */
    public RandomizedCollection() {
        list = new ArrayList<>();  
        map = new HashMap<>();
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        boolean notExist = false;
        if(!map.containsKey(val)) {
            map.put(val, new HashSet<>());
            notExist = true;
        }
        if(map.get(val).size() == 0) {
            notExist = true;
        }

        list.add(val);
        map.get(val).add(list.size() - 1);
        return notExist;
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if(!map.containsKey(val)) {
            return false;
        }
        if(map.get(val).size() == 0) {
            return false;
        }
        
        Integer index = map.get(val).iterator().next();
        map.get(val).remove(index);
        
        if(index == list.size() - 1) {
            list.remove(list.size() - 1);
        } else {
            Integer lastVal = list.get(list.size() - 1);
            list.set(index, lastVal);
            map.get(lastVal).remove(new Integer(list.size() - 1));
            map.get(lastVal).add(index);
            list.remove(list.size() - 1);
        } 
        return true;
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
        int size = list.size();
        if(size == 0) throw new RuntimeException("No elements");
        int index = new Random().nextInt(size);
        return list.get(index);        
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */