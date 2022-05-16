// https://www.acmicpc.net/problem/2220
// 백준 - K번째 수
// 작성자 : 김성중
//출처 - https://medium.com/jongah-tech-blog/%ED%9E%99-%EC%A0%95%EB%A0%AC-2ec5197d0c2e

const heapSort2 = () => {
  // const fs = require('fs');
  // const input = fs.readFileSync('dev/stdin').toString().split('').map((n) => parseInt(n));
  const input = "6".split("").map((n) => parseInt(n));

  const heap = [0, 1];

  const swap = (a, b, heap) => {
    [heap[a], heap[b]] = [heap[b], heap[a]];
  };

  for (let num = 2; num <= input[0]; num++) {
    heap.push(num);
    swap(num, num - 1, heap);

    if (heap.length > 2) {
      let curIdx = num - 1;
      while (curIdx != 1) {
        swap(curIdx, Math.floor(curIdx / 2), heap);
        curIdx = Math.floor(curIdx / 2);
      }
    }
  }

  console.log(heap.slice(1).join(" "));
  console.log(heap.slice(1).join(" ") === "6 5 3 2 4 1");
};

heapSort2();
