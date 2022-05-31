import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;

        Arrays.sort(phone_book);

        Map<Integer, String> map = new HashMap<>();
        for(int i = 0; i < phone_book.length; i++) {
            map.put(i, phone_book[i]);
        }

        for(int i = 0; i < phone_book.length-1; i++) {
            String prefix = map.get(i);
            if(map.get(i+1).startsWith(prefix)) {
                answer = false;
                break;
            }
            if(answer == false) {
                break;
            }
        }

        return answer;
    }
}
