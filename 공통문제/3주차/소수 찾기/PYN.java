import java.util.*;
class Solution {
    public static int solution(String numbers) {
        int answer = 0;

        ArrayList<Integer> arr = new ArrayList<Integer>();

        for(int i = 0; i < numbers.length(); ++i)
            arr.add(numbers.charAt(i) - '0');

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        String numStr = "";
        func(map, numStr, arr);

        for(Integer key : map.keySet()) {
            if(key > 1) 
                ++answer;
            for(int i = 2; i < key; ++i)
                if (key % i == 0) {
                    --answer;
                    break;
                }
        }
        return answer;
    }

    public static void func(Map<Integer, Integer> map, String numStr, ArrayList<Integer> arr){

        for(int i = 0; i < arr.size(); ++i){
            ArrayList<Integer> innerArr = ((ArrayList<Integer>)arr.clone());
            innerArr.remove(i);
            map.put(Integer.parseInt(numStr + arr.get(i)),Integer.parseInt(numStr + arr.get(i)));
            func(map, numStr + arr.get(i), innerArr);
        }
    }
}