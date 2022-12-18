//왼쪽 자식의 인덱스 = 부모 인덱스 * 2 + 1;
//오른쪽 자식의 인덱스 = 부모 인덱스 * 2 + 2; 

class Heap {
    constructor() {
        this.heap = [];
    }

    getLeft(index) { 
       return index * 2 + 1;
    }

    getRight(index) {
        return index * 2 + 2;
    }
    peek() {
        return this.heap[0];
    }

    swap(a, b) {
        let tmp = this.heap[a];
        this.heap[a] = this.heap[b];
        this.heap[b] = tmp;
    }

    getParentIdx(idx) {
        return idx % 2 == 0 ? Math.floor((idx) / 2) - 1 : Math.floor( (idx) / 2);
    }

    insert(data) {
        this.heap.push(data);
        let currentIdx = this.heap.length - 1;
        let parentIdx = this.getParentIdx(currentIdx);
        while (this.heap[parentIdx] > this.heap[currentIdx]) {
            this.swap(parentIdx, currentIdx);
            currentIdx = parentIdx;
            parentIdx = this.getParentIdx(currentIdx);
        }
    }
    
    delete() {
        this.heap[0] = this.heap.pop();
        let currentIndex = 0;
        let leftIndex = this.getLeft(currentIndex);
        let rightIndex = this.getRight(currentIndex);
        while ( this.heap[currentIndex] > this.heap[leftIndex] || this.heap[currentIndex] > this.heap[leftIndex]) {
            let swapIndex = this.heap[leftIndex] < this.heap[rightIndex] ? leftIndex : rightIndex;
            this.swap(currentIndex, swapIndex);
            leftIndex = this.getLeft(currentIndex);
            rightIndex = this.getRight(currentIndex);
        }
    }
}


let heap = new Heap();
heap.insert(5)
heap.insert(1)
heap.insert(2)
heap.insert(9)
heap.insert(4)
heap.insert(7)
heap.insert(6)
heap.insert(3)
heap.delete()
console.log(heap)
