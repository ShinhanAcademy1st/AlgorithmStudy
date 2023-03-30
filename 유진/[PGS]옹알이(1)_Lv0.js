function solution(babbling) {
  var check = ["aya", "ye", "woo", "ma"];
  count = 0;
  for (let a of babbling) {
    var r = false;
    for (let b of check) {
      if (a.indexOf(b) >= 0) {
        a = a.replace(a.slice(a.indexOf(b), a.indexOf(b) + b.length), "-");
        console.log(a);

        if (a.replaceAll("-", "") == 0) {
          r = true;
          console.log(a + " <-");

          break;
        }
      } else {
        r = false;
      }
    }
    if (r) {
      count++;
    }
  }
  var answer = count;
  return answer;
}
