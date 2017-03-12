class LRUCache {
 private:
  unordered_map<int, list<pair<int, int> >::iterator> hash_table;
  list<pair<int, int> > cache;
  size_t capacity;

 public:
  LRUCache(int capacity) {
    this->capacity = capacity;
    cache.clear();
    hash_table.clear();
  }

  int get(int key) {
    unordered_map<int, list<pair<int, int> >::iterator>::iterator it =
        hash_table.find(key);
    if (it == hash_table.end()) {
      return -1;
    }

    int val = it->second->second;
    cache.erase(it->second);
    cache.push_front(make_pair(key, val));
    it->second = cache.begin();  // update the iterator

    return val;
  }

  void set(int key, int value) {
    unordered_map<int, list<pair<int, int> >::iterator>::iterator it =
        hash_table.find(key);
    if (it != hash_table.end()) {  // the key is in the cache
      cache.erase(it->second);
      cache.push_front(make_pair(key, value));
      it->second = cache.begin();
    } else {  // the key is not in the cache
      if (cache.size() < capacity) {
        cache.push_front(make_pair(key, value));
        hash_table.insert(make_pair(key, cache.begin()));
      } else {
        pair<int, int> last = cache.back();
        cache.pop_back();

        // the the last element in the hash table
        unordered_map<int, list<pair<int, int> >::iterator>::iterator it =
            hash_table.find(last.first);
        hash_table.erase(it);

        cache.push_front(make_pair(key, value));
        hash_table.insert(make_pair(key, cache.begin()));
      }
    }
  }
};