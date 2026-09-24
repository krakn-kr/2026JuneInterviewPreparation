package Q43;

import java.util.Arrays;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import java.util.stream.Collectors;


class Employee {

    private int id;

    private String name;

    private double salary;


    public Employee(int id, String name, double salary) {

        this.id = id;

        this.name = name;

        this.salary = salary;

    }


    public int getId() {

        return id;

    }


    public String getName() {

        return name;

    }


    public double getSalary() {

        return salary;

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

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(

                new Employee(1, "Alice", 70000),

                new Employee(2, "Bob", 85000),

                new Employee(3, "Charlie", 60000),

                new Employee(4, "David", 95000),

                new Employee(5, "Eve", 120000)

        );
        List<Employee> list = employees.stream().sorted((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()))
                .limit(3).toList();
        System.out.println(list);
    }
}
