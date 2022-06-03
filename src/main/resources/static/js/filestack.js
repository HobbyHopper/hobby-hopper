const img = document.getElementById("image");

function fileStackApi(domValue){
    domValue.addEventListener("click", ()=>{
        const client = filestack.init(FILESTACK_API_TOKEN);
        const options =  {
            accept: ["image/*"],
            onFileUploadFinished(file){
                console.log(file.url);
                // document.getElementById("image").src= file.url;
                domValue.value=file.url;
            }
        }
        client.picker(options).open();
    });
}

function fileLoop(){
    for(let i = 1; i <= 5; i++){
         fileStackApi(document.getElementById("event-image-" + i));
    }
}

fileStackApi(img);

fileLoop();



