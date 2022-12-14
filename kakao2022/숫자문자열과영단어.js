let s = "one4seveneight";

const word = new Map();
const words = ["zero", 'one', 'two', 'three', 'four', 'five', 'six', 'seven', 'eight', 'nine'];
for (let i = 0; i < words.length; i++) word.set(words[i], i);
for (const w of words) {
    s = s.replaceAll(w, word.get(w));
}
