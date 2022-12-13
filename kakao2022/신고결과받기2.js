const id_list = ["muzi", "frodo", "apeach", "neo"];
const report = ["muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"];
const k = 2;
// const k = 3;
// const id_list = ["con", "ryan"]	
// const report = ["ryan con", "ryan con", "ryan con", "ryan con"]	

const user = new Map();
const reportSender = new Map();
const reportCount = new Map();
for (let i = 0; i < id_list.length; i++){
    user.set(i + 1, id_list[i]);
    reportSender.set(id_list[i], new Array());
    reportCount.set(id_list[i], 0);

}
for (const str of report) {
    const split = str.split(" ");
    const data = [...reportSender.get(split[0])]
    const isExist = data.includes(split[1])
    if (isExist) continue;

    reportSender.set(split[0], [...data].concat(split[1]));
    reportCount.set(split[1], reportCount.get(split[1]) + 1);
}
// console.log(reportSender);
// console.log(reportCount);

const suspended = [];
for (const [key, v] of reportCount) {
    if (v >= k) suspended.push(key);
}
let result = [];
for (const user of id_list) {
    result.push( [...reportSender.get(user)].filter((u) => suspended.includes(u)).length);
}
console.log(result)