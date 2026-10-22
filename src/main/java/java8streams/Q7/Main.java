package java8streams.Q7;
/*
Q7. Find the employee with the highest salary from a list of employee objects ?
 */

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

class Employee{
    private String name;
    private Integer age;
    private String gender;
    private Double salary;

    public Employee(String name, Integer age, String gender, Double salary) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.salary = salary;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public Double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", salary=" + salary +
                '}';
    }
}

public class Main {
    public static void main(String[] args) {
        List<Employee> employeeList = List.of(new Employee("Ashok",29,"Male",100000.0),
                new Employee("Ashok",29,"Male",100000.0),
                new Employee("Kumar",29,"Male",100000.0),
                new Employee("Jaya",28,"Female",60000.0),
                new Employee("Lakshmi",21,"Female",300000.0),
                new Employee("Reddy",29,"Male",100000.0),
                new Employee("Bagi",28,"Female",60000.0),
                new Employee("Naidu",29,"Male",100000.0)

        );
        Optional<Employee> max = employeeList.stream().max(Comparator.comparingDouble(Employee::getSalary));
        max.ifPresent(System.out::println);

    }
}
