// https://leetcode.com/problems/number-of-operations-to-make-network-connected/
// LeetCode - 1319. Number of Operations to Make Network Connected
// 작성자 : 김성중

const makeConnected = (n, connections) => {
  const adjacency = Array.from({ length: n }, () => []);
  const visited = new Set();
  let disconnected = 0;

  // 모든 자식 노드를 순회하고 방문한 것으로 표시
  const traverse = (parent) => {
    visited.add(parent); // 방문에 추가

    for (const child of adjacency[parent]) {
      if (visited.has(child)) continue; // 이미 방문한 노드 스킵

      traverse(child);
    }
  };

  // 유효하지 않는 간선의 수 !== n - 1
  if (connections.length < n - 1) return -1;

  // 인접 리스트 생성
  for (const [u, v] of connections) {
    adjacency[u].push(v);
    adjacency[v].push(u);
  }

  for (let i = 0; i < n; i++) {
    if (visited.has(i)) continue; // 방문한 노드

    disconnected++;
    traverse(i);
  }

  // 간선이 두 노드를 연결하기 때문에 -1
  return disconnected - 1;
};
