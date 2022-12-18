class Queue {
    queue = [];
    constructor(queue = null) {
        queue && this.queue.push(queue);
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

 class Node{
    constructor(node) {
        this.node = node;
    }
}

 class LinedList {
    constructor() {

    }
}
