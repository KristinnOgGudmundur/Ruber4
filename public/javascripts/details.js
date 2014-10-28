$( document ).ready(function() {
    var drivername = $('#drivername').text();
    var driver;
    $.ajax({
        async: false,
        type: 'GET',
        url: 'http://localhost:9000/api/driver/name/' + drivername,
        success: function(data) {
            driver = $.parseJSON(data);
        }
    });
    getComments(driver.id.toString());
});

function show() {
    document.getElementById('hiddebutton' ).style.display = "none";
    document.getElementById('hiddeMe').style.display = "inline";
    document.getElementById('border').style.border = "solid #808080";
}

function hideAndClear() {
    $ ( '#mytext' ).val ('' ) ;
    $ ( 'input[name=score]:checked', '#form' ).removeAttr("checked");
    document.getElementById('hiddebutton' ).style.display = "inline";
    document.getElementById('hiddeMe').style.display = "none";
    document.getElementById('border').style.border = "none";
}

function add() {

    if($( '#mytext' ).val ( ).length === 0 || !$("input[name='score']:checked").val())
    {
        $('#formerror' ).css("display", "inline");
    }
    else
    {
        $('#formerror' ).css("display", "none   ");
        var text = $ ( '#mytext' ).val ( ) ;
        var radio = $ ( 'input[name=score]:checked', '#form' ).val ( ) ;
        var url = $ ( "#form" ).attr ( "action" ) ;
        var user;
        var myusername =  $('#myusername' ).text();
        var drivername = $('#drivername' ).text();

        //Getting the userId for the user
        $.ajax({
            async: false,
            type: 'GET',
            url: 'http://localhost:9000/api/user/' + myusername,
            success: function(data) {
                user = $.parseJSON(data)
            }
        });
        var userid = user.id;
        var reviewinfo = { "content": text.toString(), "score": radio.toString(), userId: userid.toString(), driverName: drivername.toString() }

        //Posting the review
        $.ajax({
            type: "POST",
            url: url,
            data: JSON.stringify({ Info: reviewinfo }),
            contentType: "application/json; charset=utf-8",
            dataType: "json"
        })
            .done(function( msg ) {
                getComments(msg.driverId.toString());
            })
            .fail(function( msg ) {
            })
            .always(function() {
            });
    }
}

function getComments(myDriverId)
{
    $.ajax({
        type: "GET",
        url: 'http://localhost:9000/driver/reviews/driverId',
        data: {driverId: myDriverId},
        contentType: "application/json; charset=utf-8",
        dataType: "json"
    })
        .done(function( data ) {
            updateComments(data.reviews);
            hideAndClear();
            $('tr:last').get(0).scrollIntoView();
        })
        .fail(function( data ) {
        })
        .always(function() {
        });
}

function updateComments(reviews)
{
    $("#mytable tr" ).remove();
    $.each(reviews, function(i, obj) {
        $("#myTable").find('tbody').append($('<tr><td>' + obj.score.toString() + '</td><td>'+  obj.content.toString() + '</td></tr>'))
    });
}