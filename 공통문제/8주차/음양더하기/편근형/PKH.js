function solution(absolutes, signs) {
    var answer = 0;
    signs.map((value, i) => {
        if (value == true) {
            answer += absolutes[i];
        }
        else {
            answer -= absolutes[i];
        }
    })
    return answer;
}
