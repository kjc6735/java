"use strict";

let sizes = [[60, 50], [30, 70], [60, 30], [80, 40]];
let width = 0, height = 0;
for (let i = 0; i < sizes; i++) {
    width = sizes[i][0] > sizes[i][1] ? Math.max([width, sizes[i][0]]) : Math.max([width, sizes[i][1]]);
    height = sizes[i][0] < sizes[i][1] ? Math.max([width, sizes[i][0]]) : Math.max([width, sizes[i][1]]);
}

console.log(width, height)