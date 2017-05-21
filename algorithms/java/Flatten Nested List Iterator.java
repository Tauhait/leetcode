/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
    Stack<Iterator<NestedInteger> > stack = new Stack<>();
    Integer nextValue;
    
    public NestedIterator(List<NestedInteger> nestedList) {
        if(!nestedList.isEmpty()) {
            stack.push(nestedList.iterator());
        }
    }

    @Override
    public Integer next() {
        return nextValue;
    }

    @Override
    public boolean hasNext() {
        nextValue = null;
        while(!stack.empty()) {
            // get top element
            Iterator<NestedInteger> top = stack.peek();
            NestedInteger e = top.next();
            if(!top.hasNext()) {
                stack.pop();
            }
            
            if(e.isInteger()) {
                nextValue = e.getInteger();
                break;
            } else {
                List<NestedInteger> list = e.getList();
                if(!list.isEmpty()) {
                    stack.push(list.iterator());
                }
            }
        }
        
        return nextValue != null;
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */