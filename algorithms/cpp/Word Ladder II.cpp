class Solution {
public:
    vector<vector<string> > ret;
    
    void get_path(const int& id, const vector<pair<string, int> >& q, const string& endWord) {
        vector<string> res;
        res.push_back(endWord);
        int i = id;
        while(i != -1) {
            res.push_back(q[i].first);
            i = q[i].second;
        }
        reverse(res.begin(), res.end());
        ret.push_back(res);
    }
    
    vector<vector<string> > findLadders(string beginWord, string endWord, unordered_set<string> &wordList) {
        if(beginWord == endWord) {
            vector<string> res;
            res.push_back(beginWord);
            res.push_back(endWord);
            ret.push_back(res);
            return ret;
        }
        
        int wl = beginWord.size();
        
        unordered_map<string, vector<string> > edges;
        for(unordered_set<string>::iterator it = wordList.begin();it != wordList.end();++it) {
            string str = *it;
            string org = *it;
            for(int i = 0;i < wl;++i) {
                for(char c = 'a';c <= 'z';++c) {
                    if(c != str[i]) {
                        str[i] = c;
                        if(wordList.find(str) != wordList.end()) {
                            edges[org].push_back(str);
                        }
                        str[i] = org[i];
                    }
                }
            }
        }
        
        unordered_map<string, int> visited;
        vector<pair<string, int> > q;
        q.push_back(make_pair(beginWord, -1));
        visited[beginWord] =  0;
        int start = 0, end = 0;
        int stop = 0;
        int lev = 0;
        while(!q.empty()) {
            if(stop == 1 || start > end) break;
            lev++;
            for(int i = start;i <= end;++i) {
                string str = q[i].first;
                vector<string>& edge = edges[str];
                for(int j = 0;j < edge.size();++j) {
                    if(edge[j] == endWord){
                        stop = 1;
                        get_path(i, q, endWord);
                    }
                    if(visited.find(edge[j]) == visited.end() || visited[edge[j]] == lev) {
                        visited[edge[j]] = lev;
                        q.push_back(make_pair(edge[j], i));
                    }
                }
            }
            start = end + 1;
            end = q.size() - 1;
        }
        
        return ret;
    }
};