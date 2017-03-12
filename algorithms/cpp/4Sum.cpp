class Solution {
 public:
  vector<vector<int> > fourSum(vector<int>& nums, int target) {
    set<vector<int> > ret;
    vector<vector<int> > retV;
    if (nums.size() < 4)
      return retV;

    sort(nums.begin(), nums.end());
    unordered_map<int, vector<pair<int, int> > > sum_pairs;
    for (int i = 0; i < nums.size(); ++i) {
      //if (i != 0 && nums[i] == nums[i - 1])
       // continue;//
      for (int j = i + 1; j < nums.size(); ++j) {
        //if (j != i + 1 && nums[j] == nums[j - 1])
         // continue;
        sum_pairs[nums[i] + nums[j]].push_back(make_pair(i, j));
      }
    }
    //cout << "here" << endl;
    for (unordered_map<int, vector<pair<int, int> > >::iterator it = sum_pairs
        .begin(); it != sum_pairs.end(); ++it) {
      //cout << it->first << " ";
      for (size_t i = 0; i < it->second.size(); ++i) {
       // cout << "(" << it->second[i].first << ", " << it->second[i].second << "|| "
            //<< nums[it->second[i].first] << " " << nums[it->second[i].second]
            //<< ")";
      }
     // cout << endl;
    }

    for (unordered_map<int, vector<pair<int, int> > >::iterator it = sum_pairs
        .begin(); it != sum_pairs.end(); ++it) {
     // cout << it->first << endl;

      if (sum_pairs.find(target - it->first) == sum_pairs.end())
        continue;

      if (it->first == target - it->first) {
        for (size_t i = 0; i < it->second.size(); ++i) {
          for (size_t j = i + 1; j < it->second.size(); ++j) {
            if(it->second[i].second >= it->second[j].first) continue;
            vector<int> res(4, 0);
            res[0] = nums[it->second[i].first];
            res[1] = nums[it->second[i].second];
            res[2] = nums[it->second[j].first];
            res[3] = nums[it->second[j].second];
            sort(res.begin(), res.end());
            ret.insert(res);
          }
        }
      } else if(it->first < target - it->first) {
        for (size_t i = 0; i < it->second.size(); ++i) {
          for (size_t j = 0; j < sum_pairs[target - it->first].size(); ++j) {
            if(it->second[i].second >= sum_pairs[target - it->first][j].first) continue;
            vector<int> res(4, 0);
            res[0] = nums[it->second[i].first];
            res[1] = nums[it->second[i].second];
            res[2] = nums[sum_pairs[target - it->first][j].first];
            res[3] = nums[sum_pairs[target - it->first][j].second];
            sort(res.begin(), res.end());
            ret.insert(res);
          }
        }
      }
    }

    for(set<vector<int> >::iterator it = ret.begin();it != ret.end();++it) {
      retV.push_back(*it);
    }

    return retV;
  }
};
