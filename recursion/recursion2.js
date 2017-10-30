// 1-2. recursion
var result = "";
function printChars(str) {
  if (str === "") {
    return;
  } else {
    result += str.charAt(0);
    printChars(str.substring(1));
  }
  return result;
}

var result = "";
function printCharsReverse(str) {
  if (str === "") {
    return;
  } else {
    printCharsReverse(str.substring(1));
    result += str.charAt(0);
  }
  return result;
}

var result = 0;
function makeBinary(inputNum) {
  if (inputNum < 2) {
    result = inputNum;
    return result + "";
  } else {
    makeBinary(Math.floor(inputNum / 2));
    result += inputNum % 2 + "";
  }
  return parseInt(result);
}

function sumOfArray(arr) {
  if (arr.length == 0) {
    return 0;
  } else {
    console.log(arr);
    return arr.pop() + sumOfArray(arr);
  }
}