
import java.util.HashMap;
import java.util.Map;

public class stanagram {

    public static void main(String[] a) {
        String s1 = "listen";
        String s2 = "niselt";
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            if (map.containsKey(s1.charAt(i))) {
                map.put(s1.charAt(i), map.get(s1.charAt(i)) + 1);
            } else {
                map.put(s1.charAt(i), 1);
            }

        }
        for (int i = 0; i < s2.length(); i++) {
            if (map.containsKey(s2.charAt(i))) {
                map.put(s2.charAt(i), map.get(s2.charAt(i)) - 1);
            } else {
                map.put(s2.charAt(i), 1);
            }

        }

        boolean isAnagram = true;
        for (char i : map.keySet()) {
            if (map.get(i) != 0) {
                isAnagram = false;
            }
        }

        if (isAnagram) {
            System.out.println("Anagram");
        } else {
            System.out.println("No anagram");
        }

    }
}
