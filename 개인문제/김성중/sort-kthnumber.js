// https://programmers.co.kr/learn/courses/30/lessons/42748#
// 프로그래머스 - 고득점스킬 정렬-k번째 수
// 작성자 : 김성중

function solution(array, commands) {
    var answer = [];
    let arraySlice = [];
    commands.forEach(key =>{
        arraySlice = array.slice(key[0]-1,key[1]);
        
        arraySlice.sort((a, b) => a - b); // sort 오름차순으로 하기. a,b 형식으로 안하면 중간에 에러

        answer.push(arraySlice[key[2]-1]);

    })

    return answer;
}
