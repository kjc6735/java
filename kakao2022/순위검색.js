// let info = ["java backend junior pizza 150", "python frontend senior chicken 210", "python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80", "python backend senior chicken 50"];
// let query = ["java and backend and junior and pizza 100", "python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250", "- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150"];
// let a = new Map();
// let b = new Map();
// let c = new Map();
// let d = new Map();

// a.set('cpp', 1);
// a.set('java', 2);
// a.set('python', 3);

// b.set('backend', 1);
// b.set('frontend', 2);

// c.set('chicken', 1);
// c.set('pizza', 2);


// let custom_info = info.map(m => m.split(' '));
let info = ["java backend junior pizza 150", "python frontend senior chicken 210", "python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80", "python backend senior chicken 50"];
let query = ["java and backend and junior and pizza 100", "python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250", "- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150"];
let a = new Map();
a.set('-', '');
a.set('cpp', 'a');
a.set('java', 'b');
a.set('python', 'c');

a.set('junior', 'd');
a.set('senior', 'e');

a.set('backend', 'f');
a.set('frontend', 'g');

a.set('chicken', 'h');
a.set('pizza', 'i');

info = info.map(m => m.split(' '));
let custom_info = [];
for (let i = 0; i < info.length; i++){
    custom_info.push(
        [
        (a.get(info[i][0])+
        a.get(info[i][1]) +
        a.get(info[i][2]) +
        a.get(info[i][3])),
        Number(info[i][4])
        ]
    )
}
let custom_query = query.map(m => (m.split(" ").filter(k => k !== 'and'))).map((q) => {
    return [a.get(q[0]) +
        a.get(q[1]) +
        a.get(q[2]) +
        a.get(q[3]),
    Number(q[4])
    ]
});
let result = custom_query.map((q, index) => {
    return custom_info.filter((i) => 
        (q[0].length == 0|| [...q[0]].filter(f => i[0].includes(f)).length == q[0].length )
         &&
         q[1] <= i[1]
        ).length
})
console.log(result)
