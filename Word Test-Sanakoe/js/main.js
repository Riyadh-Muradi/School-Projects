document.addEventListener("DOMContentLoaded",()=>{

var sanat =  [
    ["erikielinen sana","suomenkielinen sana"],
    ["alma", "omena"],
    ["ház", "talo"],
    ["víz", "vesi"],
    ["szék", "tuoli"],
    ["asztul","pöytä"],
    ["fiú","poika"],
    ["lány","tyttö"],
    ["vér","veri"]
]
const buttons = document.querySelectorAll(".b");   
const button1 = document.querySelector(".b1");
const button2 = document.querySelector(".b2");
const button3 = document.querySelector(".b3");
const button4 = document.querySelector(".b4");
const sanabutton = document.querySelector(".sanabutton");
const sana = document.querySelector("#sana");
var answerindex = 0;
var baitindex = 0;
const pistetxt = document.querySelector("#pistetxt");
var pisteet = 0;
var clickedindex = 0;
var wordindex = 0;
var chosenbaitindexes = [];
valittu = false;



sanabutton.addEventListener("click",()=>{
    console.log("--------------------------------------------------------------");

    for(let i = 1; i < 5; i++){
    eval('button'+i).innerHTML = "";
    eval('button'+i).classList.remove("answer");
    eval('button'+i).classList.remove("bait");
    eval('button'+i).style.backgroundColor = "#2E75DE";
    chosenbaitindexes = [];
}

    wordindex =  Math.floor(Math.random() * (sanat.length-1)) + 1
    console.log("wordindex: "+wordindex+" eli sana on "+sanat[wordindex][0]);
    sana.innerHTML = sanat[wordindex][0];
    answerindex =  Math.floor(Math.random() * 4) + 1
    console.log("vastausslotti: "+answerindex);

    eval('button' + (answerindex)).classList.add("answer");
    eval('button' + (answerindex)).innerHTML = sanat[wordindex][1];
    for(let i = 1; i < 5; i++){
        if(eval('button' + (i)).classList.contains("answer")){
            continue;    
    }
    eval('button' + (i)).classList.add("bait");
    
    while(valittu !=true)
    {
        baitindex =  Math.floor(Math.random() * (sanat.length-1)   ) + 1
        if(chosenbaitindexes.includes(baitindex) || baitindex == wordindex){
            console.log(baitindex+"on valittu jo. jatketaan...");
            continue;
        }
        else{
            eval('button' + (i)).innerHTML = sanat[baitindex][1];
            console.log("bait valittu slottiin "+i+" : " +baitindex+" eli sana on "+sanat[baitindex][1]);
            chosenbaitindexes.push(baitindex);
            valittu = true;
        }  
    }
    valittu = false;
}


});  
button1.addEventListener("click",()=>{
    console.log("button1");
    clickedindex =1;
    tarkista();
})     
button2.addEventListener("click",()=>{
    console.log("button2");
    clickedindex =2;
    tarkista();

})     
button3.addEventListener("click",()=>{
    console.log("button3");
    clickedindex =3;
    tarkista();

})     
button4.addEventListener("click",()=>{
    console.log("button4");
    clickedindex =4;
    tarkista();

})

function tarkista(){
    if(clickedindex == answerindex){
        pisteet++;
        pistetxt.innerHTML = pisteet;
        eval('button' + (answerindex)).style.backgroundColor = "#39AD48";

}
else{
    eval('button' + (clickedindex)).style.backgroundColor = "#D61A3C";
    eval('button' + (answerindex)).style.backgroundColor = "#39AD48";
}
}

});