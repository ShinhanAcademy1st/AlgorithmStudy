function solution(n) {
  var answer = 0;

  for (let pp = 1; pp <= 6 * n; pp++) {
    if ((pp * 6) % n == 0) {
      answer = pp;
      break;
    }
  }
  return answer;
}
