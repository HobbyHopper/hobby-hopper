const img = document.getElementById("image");

img.addEventListener("click", ()=>{
    const client = filestack.init(FILESTACK_API_TOKEN);
    const options =  {
        accept: ["image/*"],
        onFileUploadFinished(file){
            console.log(file.url);
            // document.getElementById("image").src= file.url;
            document.getElementById("image").value=file.url;
        }
    }
    client.picker(options).open();
})