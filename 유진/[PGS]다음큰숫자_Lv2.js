function solution(n) {
  var answer = 0;
  var dex = n.toString(2);
  var dex_array = dex.split("");

  function count(dex_array) {
    var cnt = 0;
    for (var c of dex_array) {
      if (c == 1) {
        cnt++;
      }
    }
    return cnt;
  }

  var ch = count(dex_array);
  for (let d = n + 1; ; d++) {
    if (count(d.toString(2)) == ch) {
      answer = d;
      break;
    }
  }
  return answer;
}
