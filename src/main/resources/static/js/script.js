
////New Record Modal
var newModal = document.getElementById("newRecordModal");

var open = document.getElementById("newRecordBtn");

var editModal = document.getElementById("recordEditModal");

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

$(document).ready(function(){
    $("#close").click(function(){
        editModal.style.display = "none";
    });
    
    $("table #editButton").click(function(){
            editModal.style.display = "flex";
            
                 event.preventDefault();
       // URL for EDIT /findByID/?id=1
       //Current Button (edit)
       var href = $(this).attr('href');
        $.get(href, function(records, status){
           $('#idEdit').val(records.id);
           $('#artistEdit').val(records.artist);
           $('#albumEdit').val(records.album);
           $('#catNumEdit').val(records.catalog_number);
           $('#formatEdit').val(records.format);
           $('#cover_conditionEdit').val(records.cover_condition);
           $('#record_conditionEdit').val(records.record_condition);
           $('#pressingEdit').val(records.pressing);
           $('#remarksEdit').val(records.remarks);
           $('#yearEdit').val(records.year);
           $('#onDiscogsEdit').val(records.on_discogs);
           $('#discogsLinkEdit').val(records.discogs_link);
       });
        jQuery('#recordEditModal').modal();
       $('#recordEditModal').modal();
            
    });   
});  

