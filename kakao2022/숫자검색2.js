let a = new Map();
a.set('-', 0);
a.set('cpp', 1);
a.set('java', 2);
a.set('python', 3);

a.set('junior', 4);
a.set('senior', 5);

a.set('backend', 6);
a.set('frontend', 7);

a.set('chicken', 8);
a.set('pizza', 9);

let range = [0, 99999]

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
    let tmp = 
    // return [a.get(q[0]) +
    //     a.get(q[1]) +
    //     a.get(q[2]) +
    //     a.get(q[3]),
    // Number(q[4])
    // ]
});
