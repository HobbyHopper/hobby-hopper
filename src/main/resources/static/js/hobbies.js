let hobbyName = "";
$("#add-hobby-btn").click(function (event) {
    event.preventDefault();

    hobbyName = $("#hobby-name").val();
    console.log("hobbyName: (post ajax req): " + hobbyName);

    let token = $("meta[name='_csrf']").attr("content");
    let header = $("meta[name='_csrf_header']").attr("content");

    $(document).ajaxSend(function (e, xhr, options) {
        xhr.setRequestHeader(header, token);
    });

    $.ajax({
        type: 'POST',
        url: "/add-hobbies",
        data: {
            hobby: hobbyName
        },
        success: function (res) {
            $("#hobbies-parent-div").load(location.href + " #hobbies-parent-div");
        },
        error: function (res) {
            console.log("Error: " + res);
        }
    });

    $("#hobby-name").val("");
});