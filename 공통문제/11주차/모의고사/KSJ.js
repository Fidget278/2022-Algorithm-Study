// https://programmers.co.kr/learn/courses/30/lessons/42840
// 프로그래머스 - 완전탐색 - 모의고사
// 작성자 : 김성중

function solution(answers) {
  var answer = [];

  // 각 학생 입력 패턴 배열로
  const student1 = [1, 2, 3, 4, 5];
  const student2 = [2, 1, 2, 3, 2, 4, 2, 5];
  const student3 = [3, 3, 1, 1, 2, 2, 4, 4, 5, 5];

  // 학생별 정답 수 배열로 저장
  let count = [0, 0, 0];

  for (let i = 0; i < answers.length; i++) {
    if (answers[i] === student1[i % student1.length]) count[0]++;
    if (answers[i] === student2[i % student2.length]) count[1]++;
    if (answers[i] === student3[i % student3.length]) count[2]++;

    console.log(
      "student1 - " +
        (i % student1.length) +
        " student2 - " +
        (i % student2.length) +
        " student3 - " +
        (i % student3.length)
    );

    // student1 - 0 student2 - 0 student3 - 0
    // student1 - 1 student2 - 1 student3 - 1
    // student1 - 2 student2 - 2 student3 - 2
    // student1 - 3 student2 - 3 student3 - 3
    // student1 - 4 student2 - 4 student3 - 4
    // student1 - 0 student2 - 5 student3 - 5
    // student1 - 1 student2 - 6 student3 - 6
    // student1 - 2 student2 - 7 student3 - 7
    // student1 - 3 student2 - 0 student3 - 8
    // student1 - 4 student2 - 1 student3 - 9
    // [ 1 ]
  }

  const max = Math.max(...count);

  // count에 저장한 최대수 와 비교하여 각 학생을 i+1로 정답에 추가
  for (let i = 0; i < count.length; i++) {
    console.log(answer);
    if (max === count[i]) answer.push(i + 1);
  }

  return answer;
}

console.log(solution([1, 3, 2, 4, 2, 1, 3, 2, 4, 2]));
