// https://programmers.co.kr/learn/courses/30/lessons/43165?language=javascript
// 프로그래머스 - 깊이/너비 우선 탐색(DFS/BFS) - 타겟 넘버
// 작성자 : 김성중
// 시간 : O(n^2)

function solution(numbers, target) {
  var answer = 0;

  function dfs(index, sum) {
    // 마지막 index에 도착하고 target하고 동일하면 횟수 ++
    if (index === numbers.length) {
      if (sum === target) {
        answer++;
      }
      return;
    }
    dfs(index + 1, sum + numbers[index]);
    dfs(index + 1, sum - numbers[index]);
  }

  dfs(0, 0);

  return answer;
}

console.log(solution([1, 1, 1, 1, 1], 3));
