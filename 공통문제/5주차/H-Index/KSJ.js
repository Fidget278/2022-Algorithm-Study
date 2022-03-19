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
    // console.log(
    //     "i : " + i + ", answers : " + answers + ", citations[i] : " + citations[i]
    //   );
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
console.log(5);
solution([47, 42, 32, 28, 24, 22, 17, 15, 10, 10, 8]);
console.log(6);
solution([3, 0, 6, 1, 5]);

// 1
// i : 0, answers : 1, citations[i] : 6
// i : 1, answers : 2, citations[i] : 5
// i : 2, answers : 3, citations[i] : 3
// i : 3, answers : 3, citations[i] : 1
// i : 4, answers : 3, citations[i] : 0
// 2
// i : 0, answers : 1, citations[i] : 100
// i : 1, answers : 2, citations[i] : 10
// 3
// i : 0, answers : 1, citations[i] : 6
// i : 1, answers : 2, citations[i] : 6
// i : 2, answers : 3, citations[i] : 6
// i : 3, answers : 4, citations[i] : 6
// i : 4, answers : 5, citations[i] : 6
// i : 5, answers : 6, citations[i] : 6
// 4
// i : 0, answers : 1, citations[i] : 2
// i : 1, answers : 2, citations[i] : 2
// i : 2, answers : 2, citations[i] : 2
// 5
// i : 0, answers : 1, citations[i] : 47
// i : 1, answers : 2, citations[i] : 42
// i : 2, answers : 3, citations[i] : 32
// i : 3, answers : 4, citations[i] : 28
// i : 4, answers : 5, citations[i] : 24
// i : 5, answers : 6, citations[i] : 22
// i : 6, answers : 7, citations[i] : 17
// i : 7, answers : 8, citations[i] : 15
// i : 8, answers : 9, citations[i] : 10
// i : 9, answers : 10, citations[i] : 10
// i : 10, answers : 10, citations[i] : 8
// 6
// i : 0, answers : 1, citations[i] : 6
// i : 1, answers : 2, citations[i] : 5
// i : 2, answers : 3, citations[i] : 3
// i : 3, answers : 3, citations[i] : 1
// i : 4, answers : 3, citations[i] : 0
