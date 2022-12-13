let numbers = [1, 2, 3, 4, 5, 6, 7, 8, 9, 0] ;
let hand = 'right'

class Pos { 
    constructor(x, y) { this.x = x, this.y = y; }
}

let pad = new Map();
let currentLeft = '*';
let currentRight = '#';
pad.set('*', new Pos(0,0));
pad.set(7, new Pos(0,1));
pad.set(4, new Pos(0,2));
pad.set(1, new Pos(0,3));

pad.set('#', new Pos(2,0));
pad.set(9, new Pos(2,1));
pad.set(6, new Pos(2,2));
pad.set(3, new Pos(2,3));

pad.set(0, new Pos(1,0));
pad.set(8, new Pos(1,1));
pad.set(5, new Pos(1,2));
pad.set(2, new Pos(1,3));

let result = [];
for ( const number of numbers) { 
    if (number % 3 === 1) {
        result.push('L')
        currentLeft = number;
    } else if (number % 3 === 0 && number != 0) {
        result.push('R')
        currentRight = number;
    } else {
        let left = pad.get(currentLeft === '*' ? currentLeft : Number(currentLeft) );
        let right = pad.get(currentRight === '#' ? currentRight : Number(currentRight));
        let end = pad.get(+number);
        leftDis = Math.abs(left.x - end.x) + Math.abs(left.y - end.y);
        rigtDis = Math.abs(right.x - end.x) + Math.abs(right.y - end.y);
        if (leftDis < rigtDis) {
            result.push('L')
            currentLeft = number;
        } else if (rigtDis < leftDis) {
            result.push('R')
            currentRight = number;
        } else {
            if (hand === 'left') {
                result.push('L')
                currentLeft = number;
            } else {
                result.push('R')
                currentRight = number;
            }
        }
    }

}
console.log(result);
