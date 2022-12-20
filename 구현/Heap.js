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
        // this.heap.push(data);
        // let currentIdx = this.heap.length - 1;
        // let parentIdx = this.getParentIdx(currentIdx);
        // while (this.heap[parentIdx] > this.heap[currentIdx]) {
        //     this.swap(parentIdx, currentIdx);
        //     currentIdx = parentIdx;
        //     parentIdx = this.getParentIdx(currentIdx);
        // }
        let currentIndex = this.heap.length - 1;

    // current요소가 상위요소보다 클 때까지 돌린다.
    // 현재 요소 (가장마지막, 밑에있던 요소) 와 부모 요소의 값을 비교 한다. 
    // 현재요소가 크면 위로 올려야하기 때문에 swap()을 쓴다.
        while (
            this.heap[this.getParentIdx(currentIndex)] && this.heap[currentIndex] > this.heap[this.getParentIdx(currentIndex)]
        ) {
        this.swap(currentIndex, this.getParentIdx(currentIndex));

        // currentIndex를 비교했던 부모요소로 재할당시킨다.
        currentIndex = this.getParentIdx(currentIndex);
        }
    }
    
    delete() {
        this.heap[0] = this.heap.pop();
        let currentIndex = 0;
        let leftIndex = this.getLeft(currentIndex);
        let rightIndex = this.getRight(currentIndex);
        while (this.heap[leftIndex] !== undefined) {
            let swapIndex = this.leftIndex;
            if (this.heap[rightIndex] !== undefined && this.heap[this.rightIndex] > this.heap[leftIndex]) {
                swapIndex = this.rightIndex;
            }
            if (this.heap[currentIndex] < this.data[swapIndex]) {
                this.swap(currentIndex, swapIndex);
                currentIndex = swapIndex;
                leftIndex = this.getLeft(currentIndex);
                rightIndex = this.getRight(currentIndex);
            } else return;
        }
    }
}

let heap = new Heap();
let arr = [-1, 5, 5, 2, 8, 6, 0, 0, 2, -1, , -1];
for (let a of arr) {
    heap.insert(a);
    console.log(a);
}

console.log(heap)
