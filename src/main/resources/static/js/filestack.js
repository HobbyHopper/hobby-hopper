const picker = document.getElementsByClassName("picker");


function fileStackApi() {
    for (let i = 0; i < picker.length; i++) {
        picker[i].addEventListener("click", () => {
            const client = filestack.init(FILESTACK_API_TOKEN);
            const options = {
                accept: ["image/*"],
                maxFiles: 5,
                onFileUploadFinished(file) {
                    console.log(file);
                    let element = document.createElement('input');
                    element.setAttribute("type", "hidden");
                    element.value = file.url;
                    element.setAttribute("class", "image");
                    element.setAttribute("name", "images");
                    document.getElementById("image-url").appendChild(element);
                    // let imageArr = [];
                }
            }
            client.picker(options).open();
        });
    }
}


fileStackApi();

