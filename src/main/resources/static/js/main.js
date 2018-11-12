$(document).ready(function() {
    $("#retrieve-resources").ready(function() {
        var displayResources = $("#display-resources");

        displayResources.text("Loading data from JSON source...");

        $.ajax({
            type: "GET",
            url: "http://localhost:8080/api/wallets/",
            success: function(result) {
                console.log(result);
                var output = "";
                for (var i in result) {
                    output +=
                        "<li class=\"list-group-item\">" +
                        "<div class=\"wallet-name\">" +
                        result[i].name +
                        "</div>" +
                        "<div class=\"wallet-balance\">" +
                        result[i].balance +
                        "</div>" +
                        "</li>";
                }

                displayResources.html(output);
            }
        });
    });
});