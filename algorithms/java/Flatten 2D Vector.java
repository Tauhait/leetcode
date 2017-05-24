public class Vector2D implements Iterator<Integer> {
    Iterator<List<Integer> > outerIt;
    Iterator<Integer> innerIt;
    public Vector2D(List<List<Integer>> vec2d) {
        outerIt = vec2d.iterator();
        if(outerIt.hasNext()) {
            innerIt = outerIt.next().iterator();
        } else {
            innerIt = null;
        }
    }

    @Override
    public Integer next() {
        return innerIt.next();
    }

    @Override
    public boolean hasNext() {
        if(innerIt == null) {
            return false;
        }
        if(innerIt.hasNext()) {
            return true;
        }
        
        while(outerIt.hasNext()) {
            innerIt = outerIt.next().iterator();
            if(innerIt.hasNext()) {
                return true;
            }
        }
        
        return false;
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */