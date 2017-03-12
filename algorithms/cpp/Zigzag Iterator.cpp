class ZigzagIterator {
public:
    vector<int>::iterator s1;
    vector<int>::iterator s2;
    
    vector<int>::iterator e1;
    vector<int>::iterator e2;
    
    int cur;
    
    ZigzagIterator(vector<int>& v1, vector<int>& v2) {
        s1 = v1.begin();
        e1 = v1.end();
        
        s2 = v2.begin();
        e2 = v2.end();
        
        cur = 0;
    }

    int next() {
         int ret = 0;
        if(s1 != e1 && s2 != e2) {
            if(cur % 2 == 0) {
                ret = *s1;
                s1++;
                cur++;
                return ret;
            } else {
                ret = *s2;
                s2++;
                cur++;
                return ret;
            }
        } else if(s1 != e1) {
             ret = * s1;
             s1++;
             cur++;
             return ret;
        } else {
            ret = *s2;
            s2++;
            cur++;
            return ret;
        }
    }

    bool hasNext() {
        return s1 != e1 || s2 != e2;
    }
};

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i(v1, v2);
 * while (i.hasNext()) cout << i.next();
 */