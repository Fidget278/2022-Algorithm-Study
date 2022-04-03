package common;
//https://programmers.co.kr/learn/courses/30/lessons/42862
import java.util.HashMap;
import java.util.Map;

public class AlgorithmStudy6 {
    public static int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        Map<Integer, String> map = new HashMap<>();

        //key : 체육복 도난당한 학생들
        if (lost != null) {
            for (int i = 0; i < lost.length; i++) {
                map.put(lost[i], "lost");
            }
        }

        //key : 체육복 여벌 있는 학생들
        if (reserve != null) {
            for (int i = 0; i < reserve.length; i++) {
                //근데 map에 key가 이미 있으면 도난당한 학생 -> 체육복 하나만 있는 것 -> value : "one"
                if (map.get(reserve[i]) != null) {
                    map.put(reserve[i], "one");
                } else {
                    map.put(reserve[i], "reserve");
                }
            }
            answer = reserve.length;
        }

        //key : 체육복 한 벌만 있었고 도난도 안 당한 학생들
        if (n != 0) {
            for (int i = 1; i <= n; i++) {
                if (map.get(i) == null) {
                    map.put(i, "one");
                    answer++;
                }
            }
        }

        for (int i = 1; i <= map.size(); i++) {
            if (i == map.size()) {
                break;
            }
            //체육복 여벌 있는 학생 앞 혹은 뒤로 도난당한 학생이 있는 경우
            if ((map.get(i).equals("lost") && map.get(i + 1).equals("reserve"))
                    || (map.get(i).equals("reserve") && map.get(i + 1).equals("lost"))) {
                map.put(i, "one");
                map.put(i + 1, "one");
                answer++;
            }
        }

        return answer;
    }
}
