// https://programmers.co.kr/learn/courses/30/lessons/12946
// 프로그래머스 - 하노이의 탑
// 작성자 : 김성중

function solution(n) {
    var answer = [];
    function hanoi(n,start,mid,end){
        if(n === 1){
            answer.push([start,end]);
            return;
        }
        hanoi(n - 1, start, end, mid);
        answer.push([start,end]);
        hanoi(n - 1, mid, start, end);
    }
    
    hanoi(n,1,2,3);
    
    return answer;
}