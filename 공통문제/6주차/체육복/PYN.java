import java.util.*;
import java.lang.Math;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;
        Map<Integer, Integer> map = new HashMap<>();
        
        Arrays.sort(reserve);
        Arrays.sort(lost);
        
        for(int i : reserve) {
           map.put(i, i);
        }
        
        for(int i = 0; i < lost.length; ++i) {
            if(map.get(lost[i]) != null) {
                map.remove(lost[i]);
                ++answer;
                lost[i] = -100;
            }
        }
        
        for(int i = 0; i < lost.length && !map.isEmpty(); ++i) {
            
            if(map.get(lost[i] - 1) != null) {
                map.remove(lost[i] - 1);
                ++answer;
                continue;
            }

            if(map.get(lost[i] + 1) != null) {
                map.remove(lost[i] + 1);
                ++answer;
            }
        }
        return answer;
    }
}