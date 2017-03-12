class WordDistance {
 public:
 unordered_map<string, vector<int> > string_ids;

  WordDistance(vector<string>& words) {
    for (size_t i = 0; i < words.size(); ++i) {
        string_ids[words[i]].push_back(i);
    }
  }

  int shortest(string word1, string word2) {
      vector<int>& ids1 = string_ids[word1];
      vector<int>& ids2 = string_ids[word2];
      
      int dis = INT_MAX;
      int j = 0;
      for(int i = 0;i < ids1.size();++i) {
          int cur_dis = INT_MAX;
          for(;j < ids2.size();++j) {
              if(cur_dis > abs(ids2[j] - ids1[i])) cur_dis = abs(ids2[j] - ids1[i]);
              else break;
          }
          dis = min(cur_dis, dis);
          j--;
      }
      
      return dis;
  }
};