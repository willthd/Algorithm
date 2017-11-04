// 매개변수의 명시화
// 순차 탐색
var arr = [4, 20, 30, -3, 5, 0, 0, 9, 40];
function search(arr, begin, end, target) {
  if (begin > end) {
    return -1;
  } else if(arr[begin] === target) {
    return begin;
  } else {
    return search(arr, begin + 1, end, target);
  }
}

// 최대값 찾기
function findMax(arr, begin, end) {
  if (begin === end) {
    return arr[begin];
  } else {
    return Math.max(arr[begin], findMax(arr, begin + 1, end));
  }
}

// binarySearch, javaVersion
function binarySearch(String[] arr, begin, end, target) {
  if (begin > end) {
    return - 1;
  } else {
    var middle = (begin + end) / 2;
    var comparison = target.compareTo(arr[middle]);
    if (comparison === 0) {
      return middle;
    } else if (comparison < 0) {
      return binarySearch(arr, begin, middle - 1, target);
    } else {
      return binarySearch(arr, middle + 1, end, target);
    }
  }
}
