$(document).ready(function() {
  function getWalletsTemplate(wallet, template) {
    var output = "";
    switch (template) {
      case "list":
        output =
          '<li class="list-group-item">' +
          '<div class="wallet-name">' +
          wallet.name +
          "</div>" +
          '<div class="wallet-balance">' +
          wallet.balance +
          "</div>" +
          "</li>";
        break;
      case "dropdown":
        output = "<option>" + wallet.name + "</option>";
        break;
      default:
        break;
    }

    return output;
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
          output += getWalletsTemplate(result[i], template);
        }

        displayResources.html(output);
      },
      error: function(e) {
        console.log(e);
        pushNotification(false, e.responseText);
      }
    });
  }

  function pushNotification(success, message) {
    $("#notification").removeClass("d-none");
    if (success === true) {
      $("#notification").text(message);
      $("#notification").addClass("alert-success");
      $("#notification").removeClass("alert-danger");
    } else {
      $("#notification").text("Opps! You got error: " + message);
      $("#notification").addClass("alert-danger");
      $("#notification").removeClass("alert-success");
    }
  }
  function addWalletAJAX(wallet) {
    var displayResources = $("#display-resources");
    displayResources.append(getWalletsTemplate(wallet, "list"));
  }

  // POST Create a wallet
  $("#addWalletForm").submit(function(e) {
    e.preventDefault();
    var dataWalletInputs = {};
    dataWalletInputs.name = $("#walletName").val();
    dataWalletInputs.description = $("#walletDescription").val();
    dataWalletInputs.balance = $("#initAmount").val();

    var form = $(this);
    var url = "http://localhost:8080" + form.attr("action");

    $.post({
      url: url,
      contentType: "application/json; charset=utf-8",
      datatype: "json",
      data: JSON.stringify(dataWalletInputs), // serializes the form's elements.
      success: function(data) {
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
  // POST Create a credit card
  $("#addCardForm").submit(function(e) {
    var dataCardInputs = {};
    dataCardInputs.cardNo = $("#cardNo").val();
    dataCardInputs.expiredDate = $(".datepicker-here")
      .datepicker("selectedDates")
      .val();
    dataCardInputs.cvv = $("#cvv").val();

    dataCardInputs.balance = $("#initAmount").val();
    debugger;
    var selectedWalletId = $("#walletSelect option:selected").val();
    var addCardToWalletEndpoint =
      "/wallets/" + selectedWalletId + "/credit-card";

    var url = "http://localhost:8080/api" + addCardToWalletEndpoint;
    debugger;
    $.post({
      url: url,
      contentType: "application/json; charset=utf-8",
      datatype: "json",
      data: JSON.stringify(dataCardInputs), // serializes the form's elements.
      success: function(data) {
        console.log(data);
        pushNotification(true, "Successfully added a new CreditCard to Wallet");
      },
      error: function(e) {
        console.log(e);
        pushNotification(false, e.responseText);
      }
    });

    e.preventDefault(); // avoid to execute the actual submit of the form.
  });

  // Wallet selector
  // Select wallet to switch credit card data
  function getCardThumbnails(card, walletId) {
    var cardThumbnailURL = "imgs/credit-card.png";
    output =
      '<a href="wallet/' +
      walletId +
      "/card/" +
      card.id +
      '"' +
      ' class="credit-card-link-' +
      card.id +
      '"><img src=' +
      cardThumbnailURL +
      ' class="credit-card-thumbnail"></a>';
    return output;
  }
  function addLinkToCreditCardThumbnail(cardId) {
    $(".credit-card-link-" + cardId).click(function(e) {
      e.preventDefault();

      var url = e.currentTarget.toString();
      var cardId = url.substring(url.lastIndexOf("/") + 1);
      var walletId = url.substring(url.indexOf("/") + 1, url.indexOf("/") + 2);
      $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/creditcards/" + cardId,
        success: function(result) {
          console.log(result);
          passDataToCreditCardPopup(result);
          $("#creditCardModal").modal("show");
        },
        error: function(e) {
          console.log(e);
          pushNotification(false, e.responseText);
        }
      });
    });
  }
  $(".wallet-item").click(function(e) {
    e.preventDefault();
    var walletId = $(this).attr("href");
    getCreditcardsByWalletId(
      walletId,
      function(data) {
        var output = "";
        var displayCardsThumbnail = $("#display-cards-thumbnail");

        if ($.isEmptyObject(data)) {
          output += '<div class="alert alert-light">No cards available.</div>';
          displayCardsThumbnail.html(output);
        }
        data.forEach(element => {
          output += getCardThumbnails(element, walletId);
        });
        displayCardsThumbnail.html(output);
        data.forEach(element => {
          addLinkToCreditCardThumbnail(element.id);
        });
      },
      function(errorMessage) {
        pushNotification(false, errorMessage);
      }
    );
  });
  // Get creditcards by wallet id
  function getCreditcardsByWalletId(walletId, result, gotError) {
    $.ajax({
      type: "GET",
      url: "http://localhost:8080/api/wallets/" + walletId + "/credit-cards",
      success: function(data) {
        result(data);
      },
      error: function(e) {
        gotError(e.responseText);
      }
    });
  }
  // Pass data to creditcard popup
  function passDataToCreditCardPopup(card) {
    $("#cardTitle").html("Card : " + card.id);
    $("#cardNo").val(card.cardNo);
    $("#expiredDate").val(card.expiredDate);
    $("#cvv").val(card.cvv);
    $("#initAmount").val(card.balance);
  }

  // PUT Update credit card
  $("#updateCreditCardForm").submit(function(e) {
    e.preventDefault();
    var url = $(".credit-card-link").attr("href");

    var walletId = url.substring(url.indexOf("/") + 1, url.indexOf("/") + 2);

    var cardId = url.substring(url.lastIndexOf("/") + 1);

    var dataCreditCardInputs = {};
    dataCreditCardInputs.cardNo = $("#cardNo").val();
    dataCreditCardInputs.expiredDate = $("#expiredDate").val();
    dataCreditCardInputs.cvv = $("#cvv").val();
    dataCreditCardInputs.balance = $("#initAmount").val();

    var form = $(this);
    var url =
      "http://localhost:8080/api" +
      "/wallets/" +
      walletId +
      "/credit-cards/" +
      cardId;

    $.ajax({
      type: "PUT",
      url: url,
      contentType: "application/json; charset=utf-8",
      datatype: "json",
      data: JSON.stringify(dataCreditCardInputs), // serializes the form's elements.
      success: function(data) {
        console.log(data);
        debugger;
        pushNotification(true, "Successfully updated new CreditCard!!");
      },
      error: function(e) {
        console.log(e);
        pushNotification(false, e.responseText);
      }
    });

    e.preventDefault(); // avoid to execute the actual submit of the form.
  });
  // Select BILL Types

  window.selectBill = function(billId) {
    var billData = {
      electricityBill: {
        id: 1,
        title: "Electricity"
      },
      mobiPhoneBill: {
        id: 2,
        title: "Mobi Phone"
      },
      waterBill: {
        id: 3,
        title: "Water"
      },
      capleBill: {
        id: 4,
        title: "Caple"
      }
    };
    switch (billId) {
      case billData.electricityBill.id:
        $("#billName").html(billData.electricityBill.title);
        addPayment(billData.electricityBill.title);
        break;

      case billData.mobiPhoneBill.id:
        $("#billName").html(billData.mobiPhoneBill.title);
        addPayment(billData.electricityBill.title);

        break;

      case billData.waterBill.id:
        $("#billName").html(billData.waterBill.title);
        addPayment(billData.electricityBill.title);

        break;

      case billData.capleBill.id:
        $("#billName").html(billData.capleBill.title);
        addPayment(billData.electricityBill.title);

        break;
      default:
        break;
    }
  };
  function addPayment(billTypeTitle) {
    $("#addPaymentForm").submit(function(e) {
      e.preventDefault();
      var dataPaymentInputs = {};
      dataPaymentInputs.name = billTypeTitle;
      dataPaymentInputs.consumerNo = $("#consumerNo").val();
      dataPaymentInputs.billNo = $("#billNo").val();
      dataPaymentInputs.initAmount = $("#initAmount").val();
      var selectedWalletId = $("#walletSelect option:selected").val();
      var url =
        "http://localhost:8080/api" +
        "/wallets/" +
        selectedWalletId +
        "/bill-payment";
      debugger;
      $.post({
        url: url,
        contentType: "application/json; charset=utf-8",
        datatype: "json",
        data: JSON.stringify(dataPaymentInputs), // serializes the form's elements.
        success: function(data) {
          console.log(data);
          pushNotification(
            true,
            "Successfully charged " +
              data.initAmount +
              "for " +
              data.name +
              " bill"
          );
        },
        error: function(e) {
          console.log(e);
          pushNotification(false, e.responseText);
        }
      });

      e.preventDefault(); // avoid to execute the actual submit of the form.
    });
  }
  //Add payment form event listenner for initial stage.
  addPayment("Electricity");
});
