const numbers = [1, 11, 2, 3, 4, 44, 5];
console.log(
  numbers.sort(function (a, b) {
    // if (a > b) return 1;
    // if (a === b) return 0;
    // if (a < b) return -1;
    //비교함수를 이용해서 오름차순 정렬

    return a - b;
  })
);
console.log(numbers.sort((a, b) => a - b));

const chars = ["a", "z", "f", "c", "b"];
console.log(chars.sort((a, b) => a - b));
