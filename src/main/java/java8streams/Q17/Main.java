package java8streams.Q17;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

/*
Q17. Find the first name of the oldest person in a list of Person objects ?
 */
class Person{
    private String name;
    private Integer age;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }
}
public class Main {
    public static void main(String[] args) {
        List<Person> list = Arrays.asList(new Person("Raja", 55),
                new Person("Ashok", 29),
                new Person("Mukesh", 19));
        Optional<Person> max = list.stream().max((p1,p2)->Integer.compare(p1.getAge(), p2.getAge()));
        max.ifPresent(person -> System.out.println(person.getName()));
    }
}
