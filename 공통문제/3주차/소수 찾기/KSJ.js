// https://programmers.co.kr/learn/courses/30/lessons/42839
// 프로그래머스 - 연습 - 완전탐색 소수찾기
// 작성자 : 김성중
// O(√N);
function solution(numbers) {
    let answer = new Set(); //배열로 객체 생성

    getAllCombination([...numbers], '');  // [...]배열 자체를 전달
    
    function getAllCombination(arr, str) {
        if(arr.length) {
            for(let i=0; i <arr.length; i++) {
                let tmp = [...arr];
                tmp.splice(i,1); // i 위치 해당숫자 삭제
                getAllCombination(tmp, str + arr[i]); // 반복할수록 남은 숫자와 합쳐서 다시 전달
            }
        }
        if(str > 0) answer.add(Number(str)); // 소수인 문자열을 숫자로 바꿔 answer에 추가
    }

    return [...answer].filter(v => { //조건을 만족하는 배열을 거름
        for(let i=2; i<=Math.sqrt(v); i++) { //제곱근 함수로 큰수를 줄인다
            if(parseInt(v) % i == 0) return false; //0으로 나누어 떨어지면 소수가 아니다.
        }
        
        return ![0, 1].includes(parseInt(v)); // v에 0,1이 포함되어 있으면 true이지만 ! 로 있으면 false 처리 후 소수인 숫자들을 answer에 추가
    }).length; // 총 소수의 개수 리턴
}