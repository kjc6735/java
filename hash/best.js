let genres = ["classic", "pop", "classic", "classic", "pop"]
let plays = [500, 600, 150, 800, 2500]

let map = new Map();

for (let [index, value] of genres.entries()) {
    if (!map.get(value)) map.set(value, [plays[index] , new Map().set(index, plays[index])]);
    else map.set(value, [map.get(value)[0] + plays[index], map.get(value)[1].set(index, plays[index])]);
}
let sorted = Array.from(map);
sorted.sort((a, b) => b[1][0] - a[1][0])
console.log(sorted)
let first = [ ...sorted[0][1][1].entries() ].sort((a,b) => b[1] - a[1])
let second = [ ...sorted[1][1][1].entries() ].sort((a,b) => b[1] - a[1])

let result = [first[0][0], first[1][0], second[0][0], second[1][0]]
