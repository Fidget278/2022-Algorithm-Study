package common;

import java.util.LinkedList;
import java.util.Queue;

public class AlgorithmStudy4 {
    public static int solution3(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> q = new LinkedList<>();
        int answer = 0;
        int totalWeight = 0;
        int index = 0;

        while (true) {
            if (index == truck_weights.length) { //i 가 다리 길이와 같다 -> tw에 남은 트럭이 없다
                break;
            } else if (q.size() == bridge_length) { //트럭이 다리 끝 지점 통과
                totalWeight -= q.poll();
            } else if (totalWeight + truck_weights[index] <= weight && q.size() < bridge_length) { //무게 가능 && 대수 가능
                q.offer(truck_weights[index]);
                totalWeight += truck_weights[index];
                answer++;
                index++;
            } else { //다리 위에 트럭이 못 올라가는 경우
                q.offer(0); //길이 고려해서 0 추가
                answer++;
            }
        }

        answer += bridge_length; //마지막 트럭이 끝까지 도착하는 데 걸리는 시간 더해주기
        System.out.println("answer : " + answer);
        return answer;
    }
}
