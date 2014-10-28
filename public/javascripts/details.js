/**
 * Runs when details html has been loaded
 */
$( document ).ready(function() {

    /*
        Send GET Request to 'http://localhost:9000/api/driver/name/' with the drivers name
        Response: JSON: {id}
     */

    var driverName = $('#drivername').text();
    var driver;
    $.ajax({
        async: false,
        type: 'GET',
        url: 'http://localhost:9000/api/driver/name/' + driverName
        })
        .done(function(data) {
            driver = $.parseJSON(data);
        })
        .fail(function(){
            alert("GET : http://localhost:9000/api/driver/name/" + driverName + " Failed" )
        });
    getComments(driver.id.toString());
});

/**
 * shows the add review box
 */
function show() {
    document.getElementById('hiddebutton' ).style.display = "none";
    document.getElementById('hiddeMe').style.display = "inline";
    document.getElementById('border').style.border = "solid #808080";
}

/**
 * hides the add review box and clears all form inputs
 */
function hideAndClear() {
    $ ( '#mytext' ).val ('' ) ;
    $ ( 'input[name=score]:checked', '#form' ).removeAttr("checked");
    document.getElementById('hiddebutton' ).style.display = "inline";
    document.getElementById('hiddeMe').style.display = "none";
    document.getElementById('border').style.border = "none";
}

/**
 * Adds a new review for a driver
 */
function add() {

    /*
        Check if either one of the input field are empty, they need to be both filled to continue
    */
    if($( '#mytext' ).val ( ).length === 0 || !$("input[name='score']:checked").val())
    {
        $('#formerror' ).css("display", "inline");
    }
    else
    {
        //Fetch and create variables
        //************************************************************************************
        $('#formerror' ).css("display", "none   ");
        var text = $ ( '#mytext' ).val ( ) ;
        var radio = $ ( 'input[name=score]:checked', '#form' ).val ( ) ;
        var url = $ ( "#form" ).attr ( "action" ) ;
        var user;
        var myUsername =  $('#myusername' ).text();
        var driverName = $('#drivername' ).text();
        //**************************************************************************************

        /*
            Send GET Request to 'http://localhost:9000/api/user/' with the users name
            Response: JSON: {id, username, firstName, lastName, registered}
        */

        $.ajax({
            async: false,
            type: 'GET',
            url: 'http://localhost:9000/api/user/' + myUsername
            })
            .done(function(data) {
                user = $.parseJSON(data)
            })
            .fail(function(){
                alert("GET : http://localhost:9000/api/user/" + myUsername + " Failed" )
            });

        //Create a json string for the review
        var myUserId = user.id;
        var reviewInfo = { "content": text.toString(), "score": radio.toString(), userId: myUserId.toString(), driverName: driverName.toString() }

        /*
            Send POST Request to 'http://localhost:9000/driver/rate' with the review-jsonInfo as data
            Response: JSON: {id}
        */
        $.ajax({
            type: "POST",
            url: url,
            data: JSON.stringify({ Info: reviewInfo }),
            contentType: "application/json; charset=utf-8",
            dataType: "json"
        })
            .done(function( msg ) {
                //On success we need to get updated comments
                getComments(msg.driverId.toString());
            })
            .fail(function() {
                alert("POST : http://localhost:9000/driver/rate: " + reviewInfo.toString() + " Failed" )
            });
    }
}

/**
 * Gets all reviews for a specific driver
 * @param myDriverId
 * Id of the driver
 */
function getComments(myDriverId)
{
    /*
     Send GET Request to 'http://localhost:9000/reviews/driverId' with the drivers Id
     Response: JSON: [{content, score}]
    */
    $.ajax({
        type: "GET",
        url: 'http://localhost:9000/driver/reviews/driverId',
        data: {driverId: myDriverId},
        contentType: "application/json; charset=utf-8",
        dataType: "json"
        })
        .done(function( data ) {
            //On success we need to update our html view
            updateComments(data.reviews);
            //we want to hidde and clear our review input box
            hideAndClear();
            //scroll to our added comment
            $('tr:last').get(0).scrollIntoView();
        })
        .fail(function() {
            alert("GET : http://localhost:9000/driver/reviews/driverId " + myDriverId + " Failed" )
        });
}

/**
 * Update comments table
 * @param reviews
 * our new updated comments
 */
function updateComments(reviews)
{
    //remove outdated table
    $("#mytable tbody tr" ).remove();
    //add updated comments
    $.each(reviews, function(i, obj) {
        $("#myTable").find('tbody').append($('<tr><td>' + obj.score.toString() + '</td><td>'+  obj.content.toString() + '</td></tr>'))
    });
}