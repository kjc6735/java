// let word = "AAAAE";

// let a = ['A', 'E', 'I', 'O', 'U'];


let a = ['a', 'b', 'c'];


function solv(word, length) {
    if (word.length === length) return word;

    for (let i = 0; i < a.length; i++) {
        solv(word.concat(a[i], length + 1));
    }
}