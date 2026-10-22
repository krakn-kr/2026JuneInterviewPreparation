package java9To21.java16;

public record Person(String name, int age) {
}
class Main{
    public static void main(String[] args) {
        Person person = new Person("Ashok",28);
        System.out.println(person.name()+" "+person.age());
        System.out.println(person);
    }
}
