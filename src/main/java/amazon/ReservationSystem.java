package amazon;

import java.util.*;

public class ReservationSystem {

    public static int solve(String s, int n) {
        int res = 0;

        String[] strs = s.split(" ");
        Map<Integer, Set<Character>> rowSeatMap = new HashMap<>();

        for(int i=1;i<=n;i++) {
            rowSeatMap.put(i, new HashSet<>());
        }
        for(String str : strs) {
            rowSeatMap.get(Integer.parseInt(str.substring(0, str.length() - 1))).add(str.charAt(str.length() - 1));
        }
        for(Map.Entry<Integer, Set<Character>> entry : rowSeatMap.entrySet()) {
            Set<Character> set = entry.getValue();
            if(!set.contains('B') && !set.contains('C') && !set.contains('D') && !set.contains('E')) {
                res++;
                set.addAll(Arrays.asList('B', 'C', 'D', 'E'));
            }
            if(!set.contains('D') && !set.contains('E') && !set.contains('F') && !set.contains('G')) {
                res++;
                set.addAll(Arrays.asList('D', 'E', 'F', 'G'));
            }
            if(!set.contains('F') && !set.contains('G') && !set.contains('H') && !set.contains('J')) {
                res++;
                set.addAll(Arrays.asList('F', 'G', 'H', 'J'));
            }
        }
        return res;
    }
}
