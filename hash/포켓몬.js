let nums = [3, 1, 2, 3];
let max = nums.length / 2;
let result = new Map();

for (let n of nums) { 
    if (!result.get(n)) result.set(n, 1);
    else result.set(n, result.get(n) + 1);
}

let ans = result.size > max ? max : result.size 