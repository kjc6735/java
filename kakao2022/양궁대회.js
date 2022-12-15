
'use strick';

class Queue {
    constructor() {
        this.queue = []
    }

    enqueue(d) {
        this.queue.push(d);
    }
    
    dequeue() {
        this.queue.shift();
    }

    poll() {
        if (this.queue.length == 0) return null;
        let data = this.queue[0];
        this.queue.shift();
        return data;
    }
    peek() {
        return this.queue ? this.queue[0] : null;
    }
    
    clear() {
        this.queue = [];
    }
    size() {
        return this.queue.length;
    }
    isEmpty() {
        return this.queue.length === 0;
    }
}


let n = 5;
let info = [2, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0].reverse();
let lyan = Array.from(info.length).fill(0);
let p_sccore = 0;
info.map((s, idx) => s != 0 ? p_sccore += (idx * s) : null);
const dfs = (arr, rest,index) => {
    if (rest == 0 || index == info.length) {
        return;
    }
    for (let i = index; i < info.length; i++){
        for (k = 0; k <= rest; k++){
            arr[i] = k;
            dfs(arr, rest - k, index+1);
        }
    }
}
dfs(Array.from(info.length).fill(0), n, 0);