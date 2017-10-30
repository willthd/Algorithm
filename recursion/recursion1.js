// 1 ~ n까지의 합
var sum = 0;
function addNum(n) {
  if (n <= 0) {
    return 0;
  } else {
    sum = n + addNum(n - 1);
    return sum;
  }
}

// factorial
function factorial(n) {
  if (n === 1) {
    return 1;
  } else {
    return n * factorial(n - 1);
  }
}

// x의 n승
function multiplyNTimes(n1, n2) {
  if (n2 === 0) {
    return 1;
  } else {
    return n1 * multiplyNTimes(n1, n2 - 1);
  }
}

// fibonacci
function fibonacci(n) {
  if (n < 2) {
    return n;
  } else {
    return fibonacci(n - 1) + fibonacci(n - 2);
  }
}

// Euclid(최대공약수) 1
function euclid1(p, q) {
  if (p < q) {
    var temp = 0;
    temp = p;
    p = q;
    q = temp;
  }
  if (p % q === 0) {
    return q;
  } else {
    return euclid1(q, p % q);
  }
}

// Euclid(최대공약수) 2
function euclid2(p, q) {
  if (q === 0) {
    return p;
  } else {
    return euclid2(q, p % q);
  }
}
console.log(euclid2(15, 40));