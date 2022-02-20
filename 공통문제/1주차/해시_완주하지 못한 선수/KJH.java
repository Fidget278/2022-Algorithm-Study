import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {

        HashMap<String, Integer> hm = new HashMap<>();
        String answer = "";
        
        for(String partPeople : participant) hm.put(partPeople, hm.getOrDefault(partPeople, 0) + 1);
        for(String compPeople : completion) hm.put(compPeople, hm.getOrDefault(compPeople, 0) - 1);
        
        for (String key : hm.keySet()){
            Integer value = hm.get(key);
            if (value == 1){
                answer = key;
            }
        }
        return answer;
    }
}