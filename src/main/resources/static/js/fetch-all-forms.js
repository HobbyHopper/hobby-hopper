(() => {
    'use strict'

    // Fetch all the forms we want to apply custom Bootstrap validation styles to
    const forms = document.querySelectorAll('.needs-validation')

    //Check that categories and expertise have required values
    let category = $("#categories").val();
    let expertise = $("#expertise").val();
    if (category == 0) {
        $("#categories").val(null);
    }
    if (expertise == 0) {
        $("#expertise").val(null);
    }


    // Loop over them and prevent submission
    Array.from(forms).forEach(form => {
        form.addEventListener('submit', event => {

            if (!form.checkValidity()) {
                event.preventDefault()
                event.stopPropagation()
            }

            form.classList.add('was-validated')
        }, false)
    })
})()