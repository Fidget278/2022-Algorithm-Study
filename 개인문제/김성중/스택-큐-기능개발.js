// https://programmers.co.kr/learn/courses/30/lessons/42586
// 프로그래머스 - 고득점스킬 스택/큐 - 기능개발
// 작성자 : 김성중

function solution(progresses, speeds) {
    let answer = [0];
    let days = progresses.map((progress, index) => Math.ceil((100 - progress) / speeds[index]));
    let maxDay = days[0];

    for(let i = 0, j = 0; i< days.length; i++){
        if(days[i] <= maxDay) {
            answer[j] += 1;
        } else {
            maxDay = days[i];
            answer[++j] = 1;
        }
    }

    return answer;
}