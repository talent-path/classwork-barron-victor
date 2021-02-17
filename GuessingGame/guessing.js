let answer = [];


let startNumbers = function(){
    let firstNum = Math.floor(Math.random() * (10 - 0) + 0);
    answer.push(firstNum);
    let done = true;
    while(!done){
        let aNumber = Math.floor(Math.random() * (10 - 0) + 0);
        if(!answer.includes(aNumber)){
            answer.push(aNumber);
            if(answer.length === 4){
                done = false;
            }
        }
    }

}

let submit = function(){
    let submition = document.getElementById("sub");
    let splitNum = submition.toString

}