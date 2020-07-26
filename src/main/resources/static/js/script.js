
////New Record Modal
var newModal = document.getElementById("newRecordModal");

var open = document.getElementById("newRecordBtn");

//Open Modal
$(document).ready(function() {

    $('#newRecordBtn').click(function() {
         newModal.style.display = "block";
    });

});
//Close Modal
$(document).ready(function() {

    $('#cancel').click(function() {
        newModal.style.display = "none";
    });


});
