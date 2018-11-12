$(document).ready(function() {

    // GET Wallet List Onload
    $("#retrieve-resources").ready(function() {
        var displayResources = $("#display-resources");

        displayResources.text("Loading data from JSON source...");

        getWallets()
    });

    // POST Create a wallet
    $("#addWalletForm").submit(function(e) {

        var dataWalletInputs = {};
        dataWalletInputs.name = $("#walletName").val();
        dataWalletInputs.description = $("#walletDescription").val();
        dataWalletInputs.balance = $("#initAmount").val();


        var form = $(this);
        var url = "http://localhost:8080" + form.attr('action');

        $.post({

            url: url,
            contentType: "application/json; charset=utf-8",
            datatype: 'json',
            data: JSON.stringify(dataWalletInputs), // serializes the form's elements.
            success: function(data)
            {
                getWallets(); // Reload wallets

            }
        });

        e.preventDefault(); // avoid to execute the actual submit of the form.
    });

    

    function getWallets() {
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
    }
});