// https://programmers.co.kr/learn/courses/30/lessons/64061
// 프로그래머스 - 2020 카카오 인턴십 - 키패드 누르기
// 작성자 : 김성중
// 출처 : https://velog.io/@hadam/JS-%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%ED%82%A4%ED%8C%A8%EB%93%9C-%EB%88%84%EB%A5%B4%EA%B8%B0

// 현 손가락 위치에서 누를 자판까지의 거리를 구하는 함수
function getDistance(start, target) {
  let sum = 0;
  // 거리는 행 인덱스 차이 + 열 인덱스 차이이므로 각각 구해 더해준다.
  // 예를 들어, [1, 0]에서 [3, 3]까지의 거리는 (3-1) + (3-0) = 5이다.
  sum += Math.max(start[0], target[0]) - Math.min(start[0], target[0]);
  sum += Math.max(start[1], target[1]) - Math.min(start[1], target[1]);
  return sum;
}

function solution(numbers, hand) {
  // L, R을 이어붙이는 문자열
  let answer = "";

  // 전화 키패드를 2차원 배열화하여 각 인덱스 정보를 key를 통해 알아낼 수 있도록 객체로 선언
  const keys = {
    1: [0, 0],
    2: [0, 1],
    3: [0, 2],
    4: [1, 0],
    5: [1, 1],
    6: [1, 2],
    7: [2, 0],
    8: [2, 1],
    9: [2, 2],
    "*": [3, 0],
    0: [3, 1],
    "#": [3, 2],
  };

  // 왼손의 위치 (시작은 * 키패드부터)
  let leftHand = keys["*"];
  // 오른손의 위치 (시작은 # 키패드부터)
  let rightHand = keys["#"];

  // 눌러야 할 키패드의 갯수만큼 반복
  for (let i = 0; i < numbers.length; i++) {
    // 눌러야 할 키패드
    const target = numbers[i];
    // 왼손으로 누르는지
    let isLeft = false;
    // 눌러야 할 키패드가 1, 4, 7이면
    if (target === 1 || target === 4 || target === 7) {
      // 왼손으로 누름
      isLeft = true;
    } else if (target === 3 || target === 6 || target === 9) {
      // 눌러야 할 키패트가 3, 6, 9이면 오른손으로 누름
    } else {
      // 2, 5, 8, 0은 왼손과 오른손의 현 위치에서 누를 키패드가 가까운 손으로 누름
      // 왼손과 누를 키패드의 거리
      const leftDistance = getDistance(leftHand, keys[target]);
      // 오른손과 누를 키패드의 거리
      const rightDistance = getDistance(rightHand, keys[target]);

      // 왼손과 오른손의 거리가 같다면
      if (leftDistance === rightDistance) {
        // 왼손잡이이면 왼손으로 누르고 오른손 잡이이면 오른손으로 누름
        if (hand === "left") {
          isLeft = true;
        }
      } else if (leftDistance < rightDistance) {
        // 왼손이 더 가깝다면 왼손으로 누름
        isLeft = true;
      }
    }

    if (isLeft) {
      // 왼손으로 누른 뒤 누른 키패드의 위치로 왼손 위치 설정
      leftHand = keys[target];
      answer += "L";
    } else {
      // 오른손으로 누른 뒤 누른 키패드의 위치로 오른손 위치 설정
      rightHand = keys[target];
      answer += "R";
    }
  }

  return answer;
}
