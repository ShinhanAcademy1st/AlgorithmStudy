function solution(number) {
  var answer = 0;
  var count = 0;

  for (let b = 0; b < number.length; b++) {
    let temp_1 = number[b];
    for (let a = b + 1; a < number.length; a++) {
      let temp_2 = number[a];
      for (let c = a + 1; c < number.length; c++) {
        let temp_3 = number[c];
        if (temp_1 + temp_2 + temp_3 === 0) {
          answer++;
        }
      }
    }
  }

  return answer;
}
