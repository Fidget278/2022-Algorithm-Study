// https://programmers.co.kr/learn/courses/30/lessons/42840
// 프로그래머스 - 이분탐색 - 입국심사
// 작성자 : 김성중

function solution(n, times) {
  //검사시간이 적은 순으로 오름차순 정렬
  times.sort((a, b) => a - b);
  let left = 1; //최소 시간
  let right = n * times[times.length - 1]; //최대 n명을 다 검사했을때 시간
  console.log("right - " + right);
  let answer = right; // 최대값.
  while (left <= right) {
    let mid = Math.floor((left + right) / 2);
    console.log("mid - " + mid);
    let count = 0;
    times.forEach((value) => {
      count += Math.floor(mid / value); // 한 사람당 몇명 할 수 있는지
      console.log("mid - " + mid + " value - " + value + " count - " + count);
      if (count >= n) {
        answer = Math.min(mid, answer); // 최솟값
        console.log("answer - " + answer);
        return;
      }
    });
    // count 가 더 크면 시간을 줄이기 위해 -1 해줌, 반대로 작으면 +1 해줌;
    if (count >= n) {
      right = mid - 1;
    } else {
      left = mid + 1;
    }
  }
  return answer;
}

console.log(solution(6, [7, 10]));
