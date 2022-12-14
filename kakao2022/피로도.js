"use strick";

let k = 80;
let dungeons = [[80, 20], [50, 40], [30, 10]];

let max_len = dungeons.length;
let dun_arr = [];
function all(arr) {
    if (arr.length === max_len) {
        dun_arr.push(arr);
        return;
    }
    for (let i = 0; i < max_len; i++){
        if (arr.includes(i)) continue;
        all(arr.concat(i));
    }
}

all([]);
// console.log(dun_arr);
let max = 0;
dun_arr.map(dun => {
    let currentK = k;
    let count = 0;
    for (let i = 0; i < dun.length; i++){
        let idx = dun[i];
        if (dungeons[idx][0] <= currentK) {
            count++;
            currentK -= dungeons[idx][1];
        } else {
            break;
        }
    }
    max = Math.max(count, max);
})
// console.log(max);