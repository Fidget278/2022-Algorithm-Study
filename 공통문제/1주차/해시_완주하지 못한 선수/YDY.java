package common;

import java.util.*;

class AlgorithmStudy1 {

    public String solution(String[] participant, String[] completion) {
        String answer = "";

        HashMap<String, Integer> map = new HashMap<>();

        for (String player : participant) {
            //participant의 값을 key로하여 map에 put
            //key가 없으면 1, 있으면 지금 value값에 +1
            // -> getOrDefault가 (player, 0) => player가 없으면 0을 주고 +1, 있으면 해당 player가 갖고 있는 vlaue에 +1
            map.put(player, map.getOrDefault(player, 0) + 1); //getOrDefault(key, defaultValue) : key가 있으면 해당 value를, 없으면 default값을 반환
        }

        for (String player : completion) {
            //key가 있으면 해당 key의 value를 반환, 없으면 null 반환 (근데 participant에 있는 건 completion에 있으므로 그럴 일 없는 듯)
            //해당 player의 value에서 -1 => value가 0이 될 것
            map.put(player, map.get(player) -1);
        }

        //keySet() : Map 내의 key를 Set으로 반환
        //get(key) : 해당 key와 매핑되는 value를 반환
        for (String player : map.keySet()) {
            //value가 0이 아닌 값
            if (map.get(player) != 0) {
                answer = player;
                System.out.println(answer);
                break;
            }
        }
        return answer;
    }


    public static void main(String[] args) {
        AlgorithmStudy1 algorithm = new AlgorithmStudy1();
        String[] participant = {"A", "B", "D", "C"};
        String[] completion = {"A", "C", "B"};
        algorithm.solution(participant, completion);
    }
}

