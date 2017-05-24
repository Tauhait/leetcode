// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {
    LinkedList<Integer> list = new LinkedList<>();
    Iterator<Integer> iterator;
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    this.iterator = iterator;
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
	    if(iterator.hasNext()) {
	        list.add(iterator.next());
	    }
	    
	    if(!list.isEmpty()) {
	        return list.peek();
	    }
	    
	    return null;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    if(iterator.hasNext()) {
	        list.add(iterator.next());
	    }
	    if(!list.isEmpty()) {
	        return list.poll();
	    }
	    
	    return null;
	}

	@Override
	public boolean hasNext() {
	    if(list.size() > 0 || iterator.hasNext()) {
	        return true;    
	    }
	    
	    return false;
	}
}