'use strick';
let places = [["POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"], ["POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"], ["PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"], ["OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"], ["PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"]];

let result = new Array(5).fill(1);
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
function c (idx,x,y,arr,bool = true){
    for(let i = 0; i < arr.length; i++){
        let xx = x + arr[i][0];
        let yy = y + arr[i][1];
        if(xx < 0 || yy  < 0 || xx >= 5 || yy >= 5 ) continue;
        if(places[idx][xx][yy] == 'X') continue;
        if(places[idx][xx][yy] == 'P'){
            result[idx] = 0;
            return ;
        }
        bool == true && c(idx, xx, yy, check2[i], false);
    }
}

for(let [index,place] of places.entries()){
    for(let i = 0 ; i < 5; i++){
        for(let k = 0; k < 5; k++){
            if(place[i][k] === 'P') c(index, i,k,check);
        }
    }
}
console.log(result);