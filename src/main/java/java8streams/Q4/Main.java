package java8streams.Q4;

import java.util.stream.Collectors;

/*
Q4. Remove all the occurrences of a given character ?
 */
public class Main {
    public static void main(String[] args) {
        String str = "java interview";

        char ch = 'a';

        String result = removeCharacter(str, ch);
        System.out.println(result);
    }
    public static String removeCharacter(String str,char ch){
        if(str == null || str.isEmpty()){
            return str;
        }
        String collect = str.chars().filter(c -> c != ch)
                .mapToObj(i -> String.valueOf((char) i))
                .collect(Collectors.joining());

        return collect;
    }
}
