//Edit Modal
var editModal = document.getElementById("recordEditModal");

var openByID = document.getElementById("open");
//Open Modal
$(document).ready(function() {

    $('#myTable td').click(function() {
         editModal.style.display = "table";
    });

});
//Close Modal
$(document).ready(function() {

    $('#close').click(function() {
         modal.style.display = "none";
    });

});

//New Record Modal
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


//.ready -> waits for page to load
$('document').ready(function(){
//    $('#newRecordBtn').on('click', function(event)){
//        event.preventDefault();
//        var href = $(this)
        
        
//    });
   $('table td').on('click', function(event){
       event.preventDefault();
       // URL for EDIT /countries/findByID/?id=1
       //This is the current button
       var href = $(this).attr('href');
       $.get(href, function(country, status){
           $('#idEdit').val(country.id);
           $('#capitalEdit').val(country.capital);
           $('#codeEdit').val(country.code);
           $('#continentEdit').val(country.continent);
           $('#descriptionEdit').val(country.description);
           $('#nationalityEdit').val(country.capital);
       });
       $('#editModal').modal();
   });
    $('table #deleteButton').on('click', function(event){
       event.preventDefault();
       var href = $(this).attr('href');
       $('#confirmDeleteButton').attr('href', href);
       $('#deleteModal').modal();
   });
});
