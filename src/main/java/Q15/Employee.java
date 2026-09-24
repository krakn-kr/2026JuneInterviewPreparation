package Q15;

import java.util.*;

import java.util.stream.*;


class Employee {

    private int id;

    private String name;

    private int age;

    private String gender;

    private double salary;


    // Constructor

    public Employee(int id, String name, int age, String gender, double salary) {

        this.id = id;

        this.name = name;

        this.age = age;

        this.gender = gender;

        this.salary = salary;

    }


    // Getters

    public String getGender() {

        return gender;

    }


    public double getSalary() {

        return salary;

    }


    @Override

    public String toString() {

        return String.format("Employee{id=%d, name='%s', age=%d, gender='%s', salary=%.2f}", id, name, age, gender, salary);

    }

}


class Main {

    public static void main(String[] args) {

        List<Employee> employees = Arrays.asList(

                new Employee(1, "John Doe", 30, "Male", 50000),

                new Employee(2, "Jane Smith", 25, "Female", 20000),

                new Employee(3, "Mike Johnson", 40, "Male", 70000),

                new Employee(4, "Emily Davis", 35, "Female", 30000),

                new Employee(5, "Robert Brown", 50, "Male", 90000)

        );


        Map<String, Long> genderCount = employees.stream()

                .collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));


        Map<String, Double> averageSalary = employees.stream()

                .collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getSalary)));


        System.out.println("Gender Count: " + genderCount);

        System.out.println("Average Salary: " + averageSalary);

        /*
        Core java
        */
        // Setting a system property for demonstration
        System.setProperty("download.threads", "8");

// Correct usage: looks up the system property "download.threads"
        Integer threads = Integer.getInteger("download.threads");
        System.out.println(threads); // Outputs: 8

// Missing property with a default fallback value
        Integer timeout = Integer.getInteger("network.timeout", 3000);
        System.out.println(timeout); // Outputs: 3000

// Common mistake: trying to parse a raw string directly
        Integer mistaken = Integer.getInteger("123");
        System.out.println(mistaken); // Outputs: null


    }

}
