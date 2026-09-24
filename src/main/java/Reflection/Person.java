package Reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Person {
    private String name;
    public Person(String name){
        this.name = name;
    }
    private String getName(){
        return name;
    }
}
class Test{
    public static void main(String[] args) {
        Person ashok = new Person("Ashok");
        try {
            Field name = Person.class.getDeclaredField("name");
            name.setAccessible(true);
            String retrived_name = (String) name.get(ashok);
            System.out.println(retrived_name);
            Method getName = Person.class.getDeclaredMethod("getName");
            getName.setAccessible(true);
            String retrivedNameMethod = (String) getName.invoke(ashok);
            System.out.println(retrivedNameMethod);
        } catch (NoSuchFieldException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
}
