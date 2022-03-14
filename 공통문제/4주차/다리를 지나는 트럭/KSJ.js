// https://programmers.co.kr/learn/courses/30/lessons/42583
// 프로그래머스 - 연습 - 스택/큐 - 다리를 지나는 트럭
// 작성자 : 김성중
// 시간 : O(n)

function solution(bridge_length, weight, truck_weights) {
    var answer = 0;
    let bridge = []; //스택으로 브릿지에 올라간 트럭 쌓기
    let bridge_weight = 0; //브릿지에 올라간 무게
    while (truck_weights.length > 0) {
        answer++;
        //올라간 트럭의 무게량와 허용 무게량이 같으면 bridge의 맨앞 빼서 넣기
        if (bridge.length == bridge_length) {
            bridge_weight -= bridge.shift();
        }
        //올라간 트럭 무게 + 다음 올라갈 트럭무게가 허용 무게보다 높았을때 0을 채워줌
        if (bridge_weight + truck_weights[0] > weight) {
            bridge.push(0);
            continue;
        }
        //대기트럭중 맨앞을 빼서 변수에 저장후 브릿지에 올리고 브릿지 무게에 추가
        let truck_weight = truck_weights.shift();
        bridge.push(truck_weight);
        bridge_weight += truck_weight;
    }

    // 브릿지의 올라갈수 있는 트럭수 결과에 추가
    answer += bridge_length;

    return answer;
}