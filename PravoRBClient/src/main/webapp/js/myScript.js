/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$("textarea").jqte();

$(document).ready(function(){
    $(".btn-create-favorite").click(function(event) {
        event.preventDefault();
        thisa = $(this);
        $.ajax({
            url: thisa.attr("href"),
            beforeSend: function ( xhr ) {
                thisa.removeClass("btn-success");
                thisa.addClass("btn-warning");
                thisa.text("...");
            }
        }).done(function ( data ) {
            thisa.removeClass("btn-warning");
            thisa.addClass("btn-danger");
            thisa.text("- из избранного");
            var strhref = thisa.attr("href");
            thisa.attr("href",strhref.replace("action=create","action=delete"));
        });
      });
      
      $(".btn-delete-favorite").click(function(event) {
        event.preventDefault();
        thisa = $(this);
        $.ajax({
            url: thisa.attr("href"),
            beforeSend: function ( xhr ) {
                thisa.removeClass("btn-danger");
                thisa.addClass("btn-warning");
                thisa.text("...");
            }
        }).done(function ( data ) {
            thisa.removeClass("btn-warning");
            thisa.addClass("btn-success");
            thisa.text("+ в избранное");
            var strhref = thisa.attr("href");
            thisa.attr("href",strhref.replace("action=delete","action=create"));
        });
      });
    /*$(this).ajax({
        url: "http://fiddle.jshell.net/favicon.png",
        beforeSend: function ( xhr ) {
          xhr.overrideMimeType("text/plain; charset=x-user-defined");
        }
    }).done(function ( data ) {
        if( console && console.log ) {
          console.log("Sample of data:", data.slice(0, 100));
        }
    });*/
});


