"use strick";

// let answers = [1, 2, 3, 4, 5];
let answers = [1, 3, 2, 4, 2];

let patttern1 = [1, 2, 3, 4, 5];
let patttern2 = [2, 1, 2, 3, 2, 4, 2, 5];
let patttern3 = [3, 3, 1, 1, 2, 2, 4, 4, 5, 5];

let counts = [0, 0, 0];
for (let i = 0; i < answers.length; i++){
    patttern1[i % patttern1.length] === answers[i] && counts[0]++;
    patttern2[i % patttern2.length] === answers[i] && counts[1]++;
    patttern3[i % patttern3.length] === answers[i] && counts[2]++;
}
max = Math.max(...counts);
let result = []
counts.filter((e, index) => e === max && result.push(index+1));
console.log(result);