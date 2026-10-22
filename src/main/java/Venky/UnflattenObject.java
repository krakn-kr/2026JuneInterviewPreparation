package Venky;

import java.util.HashMap;
import java.util.Map;

public class UnflattenObject {

    @SuppressWarnings("unchecked")
    public static Map<String, Object> unflatten(Map<String, Object> flatMap) {
        Map<String, Object> result = new HashMap<>();

        for (Map.Entry<String, Object> entry : flatMap.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();

            // Split by dot (needs escaping in regex)
            String[] parts = key.split("\\.");
            Map<String, Object> current = result;

            for (int i = 0; i < parts.length; i++) {
                String part = parts[i];

                // If it's the last part of the key, put the value
                if (i == parts.length - 1) {
                    current.put(part, value);
                } else {
                    // Create a new nested map if it doesn't exist, then traverse into it
                    current.computeIfAbsent(part, k -> new HashMap<String, Object>());
                    current = (Map<String, Object>) current.get(part);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Map<String, Object> input = new HashMap<>();
        input.put("a", 2);
        input.put("b.d", 4);
        input.put("b.f.e", 7);

        Map<String, Object> output = unflatten(input);
        System.out.println(output);
    }
}
