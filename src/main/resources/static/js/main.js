$(document).ready(function() {


    function getWalletsTemplate(wallet, template) {
        var output = "";
        switch (template) {
            case "list" : output =
                "<li class=\"list-group-item\">" +
                "<div class=\"wallet-name\">" +
                wallet.name +
                "</div>" +
                "<div class=\"wallet-balance\">" +
                wallet.balance +
                "</div>" +
                "</li>";
                break;
            case "dropdown":
                output =
                    "<option>" +
                    wallet.name +
                    "</option>" ;
                break;
            default: break;
        }

        return output
    }
    function getWallets(template) {
        var displayResources = $("#display-resources");

        displayResources.text("Loading data from JSON source...");

        $.ajax({
            type: "GET",
            url: "http://localhost:8080/api/wallets/",
            success: function(result) {
                console.log(result);
                var output = "";
                for (var i in result) {
                    output += getWalletsTemplate(result[i], template)
                }

                displayResources.html(output);
            },
            error: function(e) {
                console.log(e);
                pushNotification(false, e.responseText);

            }
        });

    }
    function fetch() {
        var pathname = window.location.pathname;
        if (pathname === "/wallet") {
            getWallets("list")
        } else if (pathname === "/topup") {
            getWallets("dropdown")
        }

    }


    // fetch();


    function pushNotification(success, message) {
        $("#notification").removeClass('d-none');
        if (success === true) {
            $("#notification").text(message);
            $("#notification").addClass('alert-success');
            $("#notification").removeClass('alert-danger');
        } else {
            $("#notification").text("Opps! You got error: " + message);
            $("#notification").addClass('alert-danger');
            $("#notification").removeClass('alert-success');
        }
    }
    function addWalletAJAX(wallet) {
        var displayResources = $("#display-resources");
        displayResources.append(getWalletsTemplate(wallet, "list"))
    }

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
                console.log(data);
                addWalletAJAX(dataWalletInputs); // Add wallet to wallets list view
                pushNotification(true, "Successfully created a new Wallet!!");

            },
            error: function(e) {
                console.log(e);
                pushNotification(false, e.responseText);

            }
        });

        e.preventDefault(); // avoid to execute the actual submit of the form.
    });




});