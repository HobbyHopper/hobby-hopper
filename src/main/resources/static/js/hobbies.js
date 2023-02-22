let hobbyName = "";
console.log("hobbyName (pre ajax req): " + hobbyName);

$("#add-hobby-btn").click(function (event) {

    // Stop form from submitting normally
    event.preventDefault();

    hobbyName = $("#hobby-name").val();
    console.log("hobbyName: (post ajax req): " + hobbyName);

    let token = $("meta[name='_csrf']").attr("content");
    let header = $("meta[name='_csrf_header']").attr("content");

    console.log(token);
    console.log(header);


    $(document).ajaxSend(function (e, xhr, options) {
        xhr.setRequestHeader(header, token);
    });

    $.ajax({
        type: 'POST',
        url: "/add-hobbies/create-event",
        data: {
            hobby: hobbyName
        },
        success: function (res) {
            console.log("Success: " + res);
            $("#hobbies-parent-div").load(location.href + " #hobbies-parent-div");
            // $("ul#lists li:first").fadeIn("slow");
        },
        error: function (res) {
            console.log("Error: " + res);
        }
    });

    $("#hobby-name").val("");

});