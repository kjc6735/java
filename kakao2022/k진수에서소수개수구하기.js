let n = 437674;
const k = 3;

let str = '';

const data = n.toString(k);
console.log(data);
const split = data.split(0);
console.log(split)
const result = split.map((number) => {
    if (number < 2) return false; // 자연수가 아닌 경우

    for (let i = 2; i <= Math.floor(Math.sqrt(number)); i++) {
        if (number % i === 0) {
            return false;
        }
    }

    return true;
}).filter((a) => a === true).length;

