class MedianFinder {
 public:
  priority_queue<int, vector<int>, std::less<int> > small_elements;
  priority_queue<int, vector<int>, std::greater<int> > large_elements;

  // Adds a number into the data structure.
  void addNum(int num) {
    small_elements.push(num);
    if (!large_elements.empty()
        && small_elements.top() > large_elements.top()) {
      large_elements.push(small_elements.top());
      small_elements.pop();
    }

    while (small_elements.size() > large_elements.size() + 1) {
      large_elements.push(small_elements.top());
      small_elements.pop();
    }

    while (small_elements.size() + 1 < large_elements.size()) {
      small_elements.push(large_elements.top());
      large_elements.pop();
    }
  }

  // Returns the median of current data stream
  double findMedian() {
    if (small_elements.size() == large_elements.size()) {
      if (small_elements.size() == 0) {
        return 0.0;
      }

      return (small_elements.top() + large_elements.top()) / 2.0;
    } else if (small_elements.size() > large_elements.size()) {
      return small_elements.top();
    } else {
      return large_elements.top();
    }
  }
};

// Your MedianFinder object will be instantiated and called as such:
// MedianFinder mf;
// mf.addNum(1);
// mf.findMedian();