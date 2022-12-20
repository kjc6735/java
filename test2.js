// let games = [[66000, 0, 50], [16000, 2, 10], [84500, 3, 20], [5500, 2, 75]];
let games = [[100, 0, 50], [1000, 0, 50], [10000, 0, 50]]	
// let games = [[100, 2, 50], [100, 2, 50], [1000, 4, 50], [1000, 4, 50], [1000, 4, 50]]; 
// let games = [[100, 0, 50], [100, 0, 50], [100, 0, 50], [10000, 3, 50]];


let games2 = new Array(1000).fill(0)
let lastPrices = new Array(1000).fill(0);
let idx = [];
let result = 0;
games.map((g) => {
    let price = g[0] - (g[0] / (100 / g[2]));
    if (games2[g[1]] == 0) {
        games2[g[1]] = price;
        lastPrices[g[1]] = [price, g[0]];
    }
    else if (price < lastPrices[g[1]][0]) {
        
        games2[g[1]] -= lastPrices[g[1]][0];
        games2[g[1]] += price;
        result += lastPrices[g[1]][1];
        lastPrices[g[1]] = [price, g[0]];
    } else {
        result += g[0];
    }
})
games2.map((d) => result += d);

