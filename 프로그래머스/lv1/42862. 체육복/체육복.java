import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        Set<Integer> setLost = Arrays.stream(lost)
                                    .boxed()
                                    .collect(Collectors.toSet());

        Set<Integer> setReserve = Arrays.stream(reserve)
                                    .boxed()
                                    .collect(Collectors.toSet());

        Set<Integer> newLost = new HashSet<>(setLost);
        newLost.removeAll(setReserve);

        Set<Integer> newReserve = new HashSet<>(setReserve);
        newReserve.removeAll(setLost);

        List<Integer> list = new ArrayList<>(newLost);
        Collections.sort(list);

        for (int lostStudent : list) {
            if (newReserve.contains(lostStudent - 1)) {
                newReserve.remove(lostStudent - 1);
            }
            else if (newReserve.contains(lostStudent + 1)) {
                newReserve.remove(lostStudent + 1);
            }
            else {
                n--;
            }
        }
        
        return n;
    }
}
