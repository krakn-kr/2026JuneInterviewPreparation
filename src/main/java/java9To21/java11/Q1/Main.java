package java9To21.java11.Q1;
/*
Q13. What are some new string methods introduced in Java 11
 */
public class Main {
    public static void main(String[] args) {
        String str = """
                
                aa
                """;

        System.out.println(str.isBlank());
        System.out.println(str);
        str = str.strip();
        System.out.println(str);
        str = str.repeat(3);
        System.out.println(str);
        str.stripLeading();
        str.stripTrailing();


    }
}
