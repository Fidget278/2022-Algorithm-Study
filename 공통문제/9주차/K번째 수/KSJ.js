// https://www.acmicpc.net/problem/11004
// 백준 - K번째 수
// 작성자 : 김성중
// 시간 : O(n)

const fs = require("fs");
let input = fs.readFileSync("/dev/stdin").toString().split("\n");

let n = input[0].split(" ");
let array = input[1].split(" ").map((item) => +item);
array.sort((f, s) => {
  return f - s;
});

console.log(array[n[1] - 1]);
