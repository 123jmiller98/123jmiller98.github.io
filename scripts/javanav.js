// JavaScript source code


let startUrl = "JavaSubPages/index.html"; 
let newurl;


useSrc();

function useSrc() {
    document.getElementById("javaembed").src = startUrl;
}

function setUrl(url) {
    localStorage.setItem('url', url);
}

function updateDiv() {

    globalUrl = localStorage.getItem('url');
    if (globalUrl == null) {
        newurl = startUrl;
    } else {
        newurl = globalUrl;
    }
    
    document.getElementById("javaembed").src = newurl;
    document.getElementById("javaembed").innerHTML.reload;

    localStorage.setItem('url', startUrl);
}


