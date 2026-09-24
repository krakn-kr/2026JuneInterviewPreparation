package Q45;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
        var map = Map.of(

                "Python", 95,

                "JavaScript", 89,

                "C++", 92,

                "TypeScript", 85,

                "Swift", 80

        );
        Map<String, Integer> newMap = map.entrySet().stream().sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,(e1,e2)->e1, LinkedHashMap::new));
        newMap.forEach((k,v)-> System.out.println(k+"="+v));
    }
}
