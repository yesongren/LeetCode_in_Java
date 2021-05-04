package leetcode601_650;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yesongren on 2021/5/4
 * 690. Employee Importance
 */
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
}

public class EmployeeImportance {
    private Map<Integer, Employee> map = new HashMap<>();

    public int getImportance(List<Employee> employees, int id) {
        for (Employee employee : employees) {
            map.put(employee.id, employee);
        }
        return helper(id);
    }

    public int helper(int id) {
        Employee e = map.get(id);
        int total = e.importance;
        List<Integer> sub = e.subordinates;
        for (int subId : sub) {
            total += helper(subId);
        }
        return total;
    }
}
