// https://programmers.co.kr/learn/courses/30/lessons/42862
// 프로그래머스 - 연습 - 탐욕법 - 체육복
// 작성자 : 김성중
// 시간 : O(n^2)

function solution(n, lost, reserve) {
  var answer = ;
  let lostarr = []; //도난된 학생
  let count = 0;

  //정렬해야함 안하니 13,14에서 에러
  lost.sort();
  reserve.sort();

  // 여벌 학생이 도난 부분 체크후 해당부분 삭제
  for (const a of lost) {
    if (reserve.includes(a)) {
      let temp = reserve.indexOf(a);
      reserve.splice(temp, 1);
    } else {
      lostarr.push(a);
    }
  }

  // 도난된 학생 체크 후 이전 이후 체크해서 없으면 빌려주고 여별 있는 학생 삭제
  for (const a of lostarr) {
    if (reserve.includes(a - 1)) {
      let temp = reserve.indexOf(a - 1);
      reserve.splice(temp, 1);
      count += 1;
    } else if (reserve.includes(a + 1)) {
      let temp = reserve.indexOf(a + 1);
      reserve.splice(temp, 1);
      count += 1;
    }
  }

  answer -= lostarr.length - count;
  return answer;
}

solution(5, [2, 4], [1, 3, 5]);
