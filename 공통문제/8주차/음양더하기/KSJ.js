// https://programmers.co.kr/learn/courses/30/lessons/76501
// 프로그래머스 - 월간 코드 챌린지 시즌2 - 음양 더하기
// 작성자 : 김성중
// 시간 : O(log n)

function solution(absolutes, signs) {
  var answer = 0;

  for (var i = 0; i < absolutes.length; i++) {
    if (signs[i] === true) {
      answer += absolutes[i];
    } else {
      answer -= absolutes[i];
    }
  }

  return answer;
}
