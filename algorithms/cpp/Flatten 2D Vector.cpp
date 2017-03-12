class Vector2D {
public:
    Vector2D(vector<vector<int> >& vec2d) : data(vec2d) {
        c_i = 0;
        c_j = 0;
        cur = 0;
        total = 0;
        for(size_t i = 0;i < vec2d.size();++i) {
            total += vec2d[i].size();
        }
    }

    int next() {
        while(c_j == data[c_i].size()) {
            c_i++;
            c_j = 0;
        }
        int val = data[c_i][c_j];
        cur++;
        c_j++;
        
        return val;
    }

    bool hasNext() {
        return cur < total;
    }
    
    const vector<vector<int> >& data;
    int cur;
    int c_i;
    int c_j;
    int total;
};

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i(vec2d);
 * while (i.hasNext()) cout << i.next();
 */