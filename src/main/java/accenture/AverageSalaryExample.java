package accenture;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


class Employee {
    private String name;
    private String department;
    private double salary;

    public Employee(String name, String department, double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }
}

class AverageSalaryExample1 {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", "HR", 50000),
                new Employee("Bob", "HR", 60000),
                new Employee("Charlie", "Engineering", 80000),
                new Employee("David", "Engineering", 90000),
                new Employee("Eve", "Marketing", 70000)
        );

        // Calculate average salary by department
        Map<String, Double> averageSalaryByDept = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getSalary)
                ));

        // Print the result
        averageSalaryByDept.forEach((department, avgSalary) ->
                System.out.println(department + " : " + avgSalary)
        );
    }
}