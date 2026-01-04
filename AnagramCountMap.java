import java.util.*;

public class AnagramCountMap {
    public static int countAnagrams(String txt, String pat) {
        int n = txt.length(), k = pat.length();
        if (k > n) return 0;

        Map<Character, Integer> patMap = new HashMap<>();
        Map<Character, Integer> winMap = new HashMap<>();

        // frequency of pattern
        for (char c : pat.toCharArray()) {
            patMap.put(c, patMap.getOrDefault(c, 0) + 1);
        }
        // frequency of first window
        for (int i = 0; i < k; i++) {
            char c = txt.charAt(i);
            winMap.put(c, winMap.getOrDefault(c, 0) + 1);
        }
        int ans = 0;
        if (patMap.equals(winMap)) ans++;
       
        for (int i = k; i < n; i++) {
            char addChar = txt.charAt(i);
            char removeChar = txt.charAt(i - k);

            // add new char
            winMap.put(addChar, winMap.getOrDefault(addChar, 0) + 1);

            // remove old char
            winMap.put(removeChar, winMap.get(removeChar) - 1);
            if (winMap.get(removeChar) == 0) {
                winMap.remove(removeChar);
            }

            // check equality
            if (patMap.equals(winMap)) ans++;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(countAnagrams("forxxorfxdofr", "for")); 
        }
}
