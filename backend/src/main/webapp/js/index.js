var apiPath = "/_ah/api/myPhoneBookApi/v1/";

$(document).ready(function() {
});

function sendInPhoneBook(btn) {
    var form = $(btn).parent(); //get parent div
    var firstname = form.find('input[name="firstname"]');
    var lastname = form.find('input[name="lastname"]');
    var address = form.find('input[name="address"]');
    var number = form.find('input[name="number"]');
    var myPhoneBookDiv = form.parent().find('.phone');

    if (!firstname) return;

    $.ajax({
        url: apiPath + "myPhoneBook",
        method: "POST",
        dataType: 'json',
        contentType: "application/json",
        data: JSON.stringify({
            firstname: firstname.val(),
            lastname: lastname.val(),
            address: address.val(),
            number: number.val()
        }),
        success: function(myPhoneBookResponse) {
            console.log(myPhoneBookDiv);
            myPhoneBookDiv.html(
                '<p>firstname: ' + myPhoneBookResponse.firstname + '</p>' +
                '<p>lastname: ' + myPhoneBookResponse.lastname + '</p>' +
                '<p>address: ' + myPhoneBookResponse.address + '</p>' +
                '<p>number: ' + myPhoneBookResponse.number + '</p>' +
                '<p>ID: ' + myPhoneBookResponse.id + '</p>'
            );
        },
        error: function(err) {
            myPhoneBookDiv.html('<p>Sorry, an error occurred...</p>');
        }
    });
}