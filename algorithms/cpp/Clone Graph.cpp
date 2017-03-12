/**
 * Definition for undirected graph.
 * struct UndirectedGraphNode {
 *     int label;
 *     vector<UndirectedGraphNode *> neighbors;
 *     UndirectedGraphNode(int x) : label(x) {};
 * };
 */
class Solution {
public:
    UndirectedGraphNode *cloneGraph(UndirectedGraphNode *node) {
        if(node == NULL) return NULL;
        unordered_map<int, UndirectedGraphNode*> node_pointer;
        
        queue<UndirectedGraphNode*> q;
        q.push(node);
        UndirectedGraphNode* head = new UndirectedGraphNode(node->label);
        node_pointer.insert(make_pair(node->label, head));
        
        while(!q.empty()) {
            UndirectedGraphNode* front = q.front();
            q.pop();
            
            for(size_t i = 0;i < front->neighbors.size();++i) {
                if(node_pointer.find(front->neighbors[i]->label) == node_pointer.end()) {
                    q.push(front->neighbors[i]);
                    UndirectedGraphNode* newNode = new UndirectedGraphNode(front->neighbors[i]->label);
                    node_pointer.insert(make_pair(front->neighbors[i]->label, newNode));
                }
                node_pointer[front->label]->neighbors.push_back(node_pointer[front->neighbors[i]->label]);
            }
        }
        
        return head;
    }
};