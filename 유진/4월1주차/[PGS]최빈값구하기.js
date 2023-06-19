function solution(array) {
  var answer = 0;
  let num_list = {};
  let count = {};

  for (let ss of array) {
    num_list[ss] = 0;
  } // 초기화

  for (let ss of array) {
    num_list[ss] += 1;
  } // 값나온곳에 +1

  let arr = Object.values(num_list); // 값만 배열로!
  let max = Math.max(...arr); // 최대값

  let index = arr.indexOf(max); //최대값의 인덱스

  arr.splice(index, 1); // 중복처리를 위해 최대값 삭제

  let key = Object.keys(num_list);

  if (arr.includes(max)) {
    answer = -1;
  } else {
    answer = Math.floor(key.find((k) => num_list[k] == max));
  }

  return answer;
}
