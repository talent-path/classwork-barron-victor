if(0=false){
    console.log('javascript is weird')
}
function toggleAllElements(){
    let elementToToggle = document.getElementById('toggletext');

    if(elementToToggle.style.display === 'none'){
        elementToToggle.style.display = 'block';
    }
}