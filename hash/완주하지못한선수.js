let participant = ["leo", "kiki", "eden"];
let completion = ["eden", "kiki"];
let result = new Map();


for (let p of participant) {
    if (!result.get(p)) result.set(p, 1);
    else result.set(p, result.get(p) + 1);
}

for (let p of completion) {
    result.set(p, result.get(p) - 1);
    if(result.get(p) == 0)  result.delete(p)
}
let ans = [];
for (let [key, value] of result) {
    for (let i = 0; i < value; i++){
        ans.push(key);
    }
}
console.log(ans.toString());


