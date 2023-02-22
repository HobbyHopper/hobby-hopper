var today = new Date();
var date = today.getFullYear() + '-' + (today.getMonth() + 1) + '-' + today.getDate();
let currentDateElementForCreateEvent = document.getElementById("current-date-create");
currentDateElementForCreateEvent.setAttribute("value", date);