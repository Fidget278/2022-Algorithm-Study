// https://www.acmicpc.net/problem/1377
// 백준 - 버블소트
// 작성자 : 김성중

// 속도 초과
// const fs = require("fs");
// const [N, ...A] = fs.readFileSync("test.txt").toString().trim().split("\n"); ///dev/stdin

// let changed = false;
// for (var i = 1; i <= N + 1; i++) {
//   changed = false;
//   console.log(i);
//   let temp;
//   for (var j = 1; j <= N - i; j++) {
//     if (A[j] > A[j + 1]) {
//       changed = true;
//       temp = A[j];
//       A[j] = A[j + 1];
//       A[j + 1] = temp;
//     }
//   }
//   if (changed == false) {
//     console.log(i);
//     break;
//   }
// }

const readline = require("readline");

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout,
});

const input = [];
let count = 0;
rl.on("line", (line) => {
    if (!count) {
        count = Number(line);
    } else {
        input.push(Number(line));
        if (input.length === count) {
            rl.close();
        }
    }
}).on("close", () => {
    const numbers = input
        .map((el, i) => {
            return {
                value: el,
                index: i,
            };
        })
        .sort((a, b) => a.value - b.value);

    let maxValue = 0;
    for (let i = 0; i < count; i++) {
        maxValue = Math.max(maxValue, numbers[i].index - i);
    }

    console.log(maxValue + 1);
});

// function sol(input) {
//     const N = +input[0];
//     const A = input.slice(1).map((elem, idx) => ({ num: +elem, idx }));

//     A.sort((a, b) => a.num - b.num);

//     let cnt = 0;
//     for (let i = 0; i < N; i++) {
//       if (A[i].idx - i > cnt) cnt = A[i].idx - i;
//     }

//     return cnt + 1;
//   }

//   const input = [];
//   require('readline')
//     .createInterface(process.stdin, process.stdout)
//     .on('line', (line) => {
//       input.push(line);
//     })
//     .on('close', () => {
//       console.log(sol(input));
//       process.exit();
//     });
