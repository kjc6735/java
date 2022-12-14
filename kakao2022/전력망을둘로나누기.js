// let wires = [[1, 3], [2, 3], [3, 4], [4, 5], [4, 6], [4, 7], [7, 8], [7, 9]];
// let n = 9;
// let wires = [[1, 2], [2, 3], [3, 4]];
// let n = 4;
let wires = [[1, 2], [2, 7], [3, 7], [3, 4], [4, 5], [6, 7]];
let n = 7;

let arr = Array.from(Array(n), () => Array(n).fill(0));
for (let i = 0; i < n; i++) arr[i][i] = 1;
for (const wire of wires) {
    let [a, b] = wire;
    arr[a-1][b-1] = arr[b-1][a-1] = 1;
}
let visited = new Array(n).fill(0);
let count = 99999999999; 
for (const wire of wires) {
    let [a, b] = wire;
    arr[a - 1][b - 1] = arr[b - 1][a - 1] = 0;
    let tmp = [0]; visited[0] = true;

    while (tmp.length) {
        let top = tmp[tmp.length - 1];
        tmp.pop();
        for (let i = 0; i < n; i++) {
            if (!visited[i] && arr[top][i]) {
                tmp.push(i);
                visited[i] = true;
            }
        }
    }
    arr[a - 1][b - 1] = arr[b - 1][a - 1] = 1;
    let trueCounter = visited.filter(i => i === true).length; 
    count = Math.min(count, Math.abs(n - (2 * trueCounter)));
    visited.fill(0);
}
console.log(count);