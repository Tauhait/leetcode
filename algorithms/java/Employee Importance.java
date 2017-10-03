/*
// Employee info
class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
};
*/
class Solution {
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>();
        for(Employee employee: employees)
            map.put(employee.id, employee);
        
        int importance = 0;
        Queue<Employee> q = new LinkedList<>();
        q.add(map.get(id));
        while(!q.isEmpty()) {
            Employee front = q.poll();
            importance += front.importance;
            for(Integer sub: front.subordinates) {
                q.add(map.get(sub));
            }
        }
        return importance;
    }
}