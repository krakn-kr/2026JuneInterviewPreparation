package Q32;

import java.util.Arrays;

import java.util.List;

import java.util.Optional;


class Person {

    private String firstName;

    private String lastName;

    private int age;


    // Constructor

    public Person(String firstName, String lastName, int age) {

        this.firstName = firstName;

        this.lastName = lastName;

        this.age = age;

    }


    // Getters

    public String getFirstName() {

        return firstName;

    }


    public int getAge() {

        return age;

    }

}
public class Main {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(

                new Person("John", "Doe", 25),

                new Person("Jane", "Smith", 30),

                new Person("Alice", "Johnson", 28)

        );
        Optional<Person> oldestPerson = people.stream().max((p1, p2) -> Integer.compare(p1.getAge(), p2.getAge()));
        String firstNameofOldestPerson = oldestPerson.map(Person::getFirstName).orElse("No person found");
        System.out.println(firstNameofOldestPerson);
    }
}
