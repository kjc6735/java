class Stack {
    stack = [];
    constructor(stack = null) {
        stack && this.stack.push(stack);
    }

    push(d) {
        this.stack.push(d);
    }
    peek() {
        return this.stack ? this.stack[this.stack.length - 1] : null;
    }

    pop() {
        this.stack && this.stack.pop();
    }
    clear() {
        this.stack = [];
    }
    size() {
        return this.stack.length();
    }

    isEmpty() {
        return this.stack.length === 0;
    }
}