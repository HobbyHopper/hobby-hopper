const img = document.getElementsByClassName("image");
const picker = document.getElementsByClassName("picker");


function fileStackApi(){
    for (let j=0; j < img.length; j++) {
        for (let i = 0; i < picker.length; i++) {
            picker[i].addEventListener("click", () => {
                const client = filestack.init(FILESTACK_API_TOKEN);
                const options = {
                    accept: ["image/*"],
                    maxFiles: 5,
                    maxSize: 500 * 500,
                    onFileUploadFinished(file) {
                        img[j].value = file.url;
                    }
                }
                client.picker(options).open();
            });
        }
    }
}



fileStackApi();

