'use strick';
let places = [["POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"], ["POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"], ["PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"], ["OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"], ["PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"]];

let result = new Array(5).fill(1);
console.log(result)
let check = [
    [0,1],
    [0,-1],
    [1,0],
    [-1,0]
];
let check2 = [
   [
    [-1,0],[0,1],[1,0]
   ],
   [
    [-1,0],[0,-1],[1,0]
   ],
   [
    [1,0],[0,1],[0,-1]
   ],
   [
    [-1,0],[0,1],[0,-1]
   ]
]
function c (idx,x,y){
    if(result)
    for(let i = 0; i < 4; i++){
        let xx = x + check[i][0];
        let yy = y + check[i][1];
        if(xx < 0 || yy  < 0 || xx >= 5 || yy >= 5 ) continue;
        if(places[idx][xx][yy] == 'X') continue;
        if(places[idx][xx][yy] == 'P'){
            result[idx] = 0;
            return ;
        }
       for(k = 0; k < 3; k++){
            let xxx = xx + check2[i][k][0];
            let yyy = yy + check2[i][k][1];
            if(xxx < 0 || yyy  < 0 || xxx >= 5 || yyy>= 5 ) continue;
            if(places[idx][xxx][yyy] == 'X') continue;
            if( places[idx][xxx][yyy] =='P'){
                result[idx] = 0;
                return ;
            }
        }
    }
}

for(let [index,place] of places.entries()){
    for(let i = 0 ; i < 5; i++){
        for(let k = 0; k < 5; k++){
            if(place[i][k] === 'P') c(index, i,k);
        }
    }
    console.log(result);
}
