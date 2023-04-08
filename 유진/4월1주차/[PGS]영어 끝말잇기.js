function solution(n, words) {
  var answer = [];
  let word_list = [];
  let num = 1;
  let b_first = "";
  let b_last = words[0].split("").shift();

  for (let word of words) {
    let o_word = word;

    word = word.split("");
    let c_first = word.shift();
    let c_last = word.pop();

    if (word_list.includes(o_word) || b_last != c_first) {
      let pp = num % n == 0 ? n : num % n;
      let nth = Math.ceil(num / n);
      answer = [pp, nth];
      num = -1;
      break;
    }

    word_list.push(o_word);
    b_last = c_last;
    num++;
  }

  if (num >= words.length) {
    answer = [0, 0];
  }
  return answer;
}
