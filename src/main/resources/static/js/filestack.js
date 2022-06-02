const img = document.getElementById("image");
const eventImg1 = document.getElementById("event-image-1");
const eventImg2 = document.getElementById("event-image-2");
const eventImg3 = document.getElementById("event-image-3");
const eventImg4 = document.getElementById("event-image-4");
const eventImg5 = document.getElementById("event-image-5");

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

fileStackApi(img);
fileStackApi(eventImg1);
fileStackApi(eventImg2);
fileStackApi(eventImg3);
fileStackApi(eventImg4);
fileStackApi(eventImg5);



