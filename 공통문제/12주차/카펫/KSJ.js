// https://programmers.co.kr/learn/courses/30/lessons/42842
// 프로그래머스 - 완전탐색 - 카펫
// 작성자 : 김성중

function solution(brown, yellow) {
  var answer = [];
  let sum = brown + yellow;

  //카펫의 최소높이는 3이기 때문에 3부터 시작
  // sum의 약수로 나눠서 나머지값이 있으면 길이 측정 안됨
  for (let h = 3; h <= brown; h++) {
    if (sum % h === 0) {
      //가로길이
      let weight = sum / h;
      console.log("weight - " + weight);

      //테두리를 제외한 길이를 구해야하기 때문에 각각 -2해준뒤 곱셈
      //결과가 yellow와 같다면 해당 높이와 길이 리턴
      console.log("yellow? - " + (h - 2) * (weight - 2));
      if ((h - 2) * (weight - 2) === yellow) {
        return [weight, h];
      }
    }
  }
  return answer;
}

solution(10, 2);
