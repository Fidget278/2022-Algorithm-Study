// https://programmers.co.kr/learn/courses/30/lessons/42747
// 프로그래머스 - 연습 - 월간 코드 챌린지 시즌2 - 약수의 개수와 덧셈
// 작성자 : 김성중
// 시간 : O(n^2)

function solution(left, right) {
  var answer = 0;
  var c = 0;
  var n = new Map();

  for (var i = 0; i <= right - left; i++) {
    for (var j = 1; j <= left + i; j++) {
      if ((left + i) % j === 0) {
        c++;
      }
    }
    n.set(left + i, c);
    c = 0;
  }

  for (let [key, value] of n) {
    if (value % 2 === 0) {
      answer += key;
    } else {
      answer -= key;
    }
  }
  return answer;
}

solution(13, 17);
