// https://programmers.co.kr/learn/courses/30/lessons/42747
// 프로그래머스 - 연습 - 배열 - H-Index
// 작성자 : 김성중
// 시간 : O(n^2)

function solution(citations) {
  let answers = 0;

  citations.sort((a, b) => b - a);

  for (let i = 0; i < citations.length; i++) {
    if (i < citations[i]) {
      answers++;
    }
  }

  return answers;
}

console.log(1);
solution([3, 0, 6, 1, 5]);
console.log(2);
solution([10, 100]);
console.log(3);
solution([6, 6, 6, 6, 6, 6]);
console.log(4);
solution([2, 2, 2]);

// 1
// h : 1, length : 4
// h : 2, length : 3
// h : 3, length : 3
// h : 4, length : 2
// 2
// h : 1, length : 2
// h : 2, length : 2
// h : 3, length : 2
// 3
// h : 1, length : 6
// h : 2, length : 6
// h : 3, length : 6
// h : 4, length : 6
// h : 5, length : 6
// h : 6, length : 6
// h : 7, length : 0
// 4
// h : 1, length : 3
// h : 2, length : 3
// h : 3, length : 0
