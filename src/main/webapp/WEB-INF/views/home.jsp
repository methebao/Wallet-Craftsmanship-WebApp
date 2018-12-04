<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
  <body>
    <main>
      <section class="section-summary">
        <div class="row">
          <div class="col-sm-12 col-md-6 col-lg-4">
            <div class="card">
              <div class="card-body">
                <h5 class="card-title">ACCOUNT BALANCE</h5>
                <h6 class="card-subtitle mb-2 text-muted">List wallet</h6>
                <ul id="display-resources" class="list-group list-group-flush">
                  <c:forEach items="${wallets}" var="wallet">
                    <li class="list-group-item">
                      <a href="${wallet.id}" class="wallet-item">
                        <div class="wallet-name"> ${wallet.name} </div>
                        <div class="wallet-balance"> ${wallet.balance} </div>
                      </a>
                    </li>
                  </c:forEach>
                </ul>
              </div>
            </div>
          </div>
          <div class="col-sm-12 col-md-6 col-lg-4">
            <div class="card">
              <div class="card-body">
                <h5 class="card-title">CARDS</h5>
                <h6 class="card-subtitle mb-2 text-muted">
                  List card of ${wallet.name}
                </h6>
                <div id="display-cards-thumbnail"></div>
              </div>
            </div>
          </div>
          <div class="col-sm-12 col-md-12 col-lg-4"></div>
        </div>
      </section>
      <!-- Popup CreditCard Details -->
      <div
        class="modal fade"
        id="creditCardModal"
        tabindex="-1"
        role="dialog"
        aria-labelledby="creditCardModal"
        aria-hidden="true"
      >
        <div class="modal-dialog" role="document">
          <div class="modal-content">
            <div class="modal-header">
              <h5 class="modal-title" id="cardTitle">Card title</h5>
              <button
                type="button"
                class="close"
                data-dismiss="modal"
                aria-label="Close"
              >
                <span aria-hidden="true">&times;</span>
              </button>
            </div>
            <div class="modal-body">
              <div class="card-details">
                <form id="updateCreditCardForm">
                  <div class="form-group">
                    <label for="cardNo"> CardNo</label>
                    <input
                      type="text"
                      name="name"
                      class="form-control"
                      id="cardNo"
                      placeholder="1234 4567 7890 0123"
                      required
                    />
                  </div>
                  <div class="form-group">
                    <label for="expiredDate">Expired Date</label>
                    <input
                      type="text"
                      id="expiredDate"
                      class="datepicker-here form-control"
                      data-language="en"
                      data-min-view="months"
                      data-view="months"
                      data-date-format="mm-yy"
                      required
                    />
                  </div>

                  <div class="form-group">
                    <label for="cvv">CVV</label>
                    <input
                      type="text"
                      name="balance"
                      class="form-control"
                      id="cvv"
                      placeholder="123"
                    />
                  </div>
                  <div id="notification" class="alert d-none"></div>
                  <div class="modal-footer">
                    <button type="submit" class="btn btn-dark">Update</button>
                    <button
                      type="button"
                      class="btn btn-secondary"
                      data-dismiss="modal"
                    >
                      Close
                    </button>
                  </div>
                </form>
              </div>
            </div>
          </div>
        </div>
      </div>
    </main>
  </body>
</html>
