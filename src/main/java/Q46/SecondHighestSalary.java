package Q46;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class SecondHighestSalary {
    public static void main(String[] args) {
        List<Employee> lstEmp = Arrays.asList(

                new Employee(1, "Alice", 90000),

                new Employee(2, "Bob", 120000),

                new Employee(3, "Charlie", 85000),

                new Employee(4, "David", 120000),

                new Employee(5, "Eve", 95000)

        );


        // Find the second highest salary using sorted and skip
        Optional<Employee> first = lstEmp.stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .skip(1)
                .findFirst();
        first.ifPresent(System.out::println);
    }
}
class Employee {

    private int id;

    private String name;

    private double salary;


    public Employee(int id, String name, double salary) {

        this.id = id;

        this.name = name;

        this.salary = salary;

    }


    public double getSalary() {

        return salary;

    }


    public String getName() {

        return name;

    }


    @Override

    public String toString() {

        return "Employee{" +

                "id=" + id +

                ", name='" + name + '\'' +

                ", salary=" + salary +

                '}';

    }

}
