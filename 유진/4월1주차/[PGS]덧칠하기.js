[
  function solution(n, m, section) {
    var answer = 0;
    var pos = [];

    for (let i = 1; i <= n; i++) {
      if (i == section[0]) {
        pos[i] = 0;
        section.shift();
      } else {
        pos[i] = 1;
      }
    }

    let pp = 0;
    let count = 0;

    while (pos.includes(0)) {
      if (pos[pp] == 0) {
        for (let a = pp; a < m + pp; a++) {
          pos[a] = 1;
        }
        count++;
      }
      pp++;
    }

    answer = count;
    return answer;
  }
];
