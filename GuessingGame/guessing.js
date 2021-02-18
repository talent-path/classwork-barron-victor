let answer = [];


let startNumbers = function(){
    let firstNum = Math.floor(Math.random() * (10 - 1) + 1);
    answer.push(firstNum);
    let done = false;
    while(!done){
        let aNumber = Math.floor(Math.random() * (10 - 0) + 0);
        if(!answer.includes(aNumber)){
            answer.push(aNumber);
            if(answer.length === 4){
                done = true;
            }
        }
    }
    console.log(answer);
}

let submit = function(){
    let submition = document.getElementById("sub").value;
    let thisFun = num => Number(num);
    let parsedInt = Array.from(String(submition), thisFun);
    //compare the input array to random number array
    //display input numbers to html
    //display colors onto html based on comparison/in the array
    for(let i = 0; i < 4; i++){
        let divToChange = document.getElementById(i);
        if(anser[i] === parsedInt[i]){
            divToChange.style.backgroundColor = "#17F500";
        }
        else if(answer.includes(parsedInt[i])){
            divToChange.style.ba
        }
    }

}