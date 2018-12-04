<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
  <body>
    <main>
      <section class="section-topup">
        <div class="container-fluid">
          <div class="row">
            <div class="card topup">
              <div class="card-body">
                <h5 class="card-title">TOP UP</h5>
                <h6 class="card-subtitle mb-2 text-muted">
                  Add new credit card to wallets
                </h6>
                <form id="addCardForm">
                  <div class="form-group">
                    <label for="cardNo"> CREDIT CARD NO</label>
                    <input
                      type="text"
                      name="cardNo"
                      class="form-control"
                      id="cardNo"
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
                      name="cvv"
                      class="form-control"
                      id="cvv"
                      required
                    />
                  </div>
                  <div class="form-group">
                    <label for="walletSelect">Wallet</label>
                    <select
                      id="walletSelect"
                      class="form-control"
                      id="wallets "
                    >
                      <c:forEach items="${wallets}" var="wallet">
                        <option value="${wallet.id}">${wallet.name}</option>
                      </c:forEach>
                    </select>
                  </div>
                  <div id="notification" class="alert d-none"></div>
                  <button type="submit" class="btn btn-dark">Topup</button>
                </form>
              </div>
            </div>
          </div>
        </div>
      </section>
    </main>
    <script src="https://cdn.jsdelivr.net/npm/pikaday/pikaday.js"></script>
  </body>
</html>
