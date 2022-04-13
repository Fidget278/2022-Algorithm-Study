// https://programmers.co.kr/learn/courses/30/lessons/43165?language=javascript
// 프로그래머스 - 월간 코드 챌린지 시즌3 - 없는 숫자 더하기
// 작성자 : 김성중
// 시간 : O(n^2)

function solution(numbers) {
  var answer = 0;
  var comparison = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9];

  var diff = comparison.filter((x) => !numbers.includes(x));

  for (var i of diff) {
    answer += i;
  }

  return answer;
}

// 다른사람 풀이
// 0~9 총합 45에서 reduce로 배열총합을 뺀값을 리턴
// 시간 : O(n)
function solution1(numbers) {
  return 45 - numbers.reduce((acc, cur) => cur + acc, 0);
}

console.log(solution1([0, 1, 2, 3, 4, 6, 7, 8]));
