<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
  <body>
    <main>
      <section class="section-bill-payments">
        <div class="row">
          <div class="col-sm-12 col-md-6 col-lg-5">
            <div class="card">
              <div class="card-body">
                <h5 class="card-title">BILL PAYMENTS</h5>
                <h6 class="card-subtitle mb-2 text-muted">Types Of Bill</h6>
                <ul id="display-resources" class="list-group list-group-flush">
                  <li class="list-group-item">
                    <a href="#" class="bill-item" onclick="selectBill(1)">
                      <div class="bill-name">
                        <span class="type-of-bill">Types: </span> Electricity
                      </div>
                    </a>
                  </li>
                  <li class="list-group-item">
                    <a href="#" class="bill-item" onclick="selectBill(2)">
                      <div class="bill-name">
                        <span class="type-of-bill">Types: </span> Mobi phone
                      </div>
                    </a>
                  </li>
                  <li class="list-group-item">
                    <a href="#" class="bill-item" onclick="selectBill(3)">
                      <div class="bill-name">
                        <span class="type-of-bill">Types: </span> Water
                      </div>
                    </a>
                  </li>
                  <li class="list-group-item">
                    <a href="#" class="bill-item" onclick="selectBill(4)">
                      <div class="bill-name">
                        <span class="type-of-bill">Types: </span> Caple
                      </div>
                    </a>
                  </li>
                </ul>
              </div>
            </div>
          </div>
          <div class="col-sm-12 col-md-6 col-lg-7">
            <div class="card">
              <div class="card-body">
                <h5 class="card-title">PAYMENT</h5>
                <h6 class="card-subtitle mb-2 text-muted">
                  Your card will charged based on initAmount value.
                </h6>
                <div class="bill-title">
                  <span class="type-of-bill">Types: </span>
                  <span id="billName">Electricity</span>
                </div>

                <form id="addPaymentForm" action="">
                  <div class="form-group">
                    <label for="consumerNo"> ConsumerNo</label>
                    <input
                      type="text"
                      name="consumerNo"
                      class="form-control"
                      id="consumerNo"
                      required
                    />
                  </div>
                  <div class="form-group">
                    <label for="billNo">Bill No</label>
                    <input
                      type="text"
                      name="billNo"
                      class="form-control"
                      id="billNo"
                    />
                  </div>
                  <div class="form-group">
                    <label for="walletSelect">Select Wallet</label>
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
                  <div class="form-group">
                    <label for="initAmount">Init amount</label>
                    <input
                      type="text"
                      name="balance"
                      class="form-control"
                      id="initAmount"
                      placeholder="1000"
                    />
                    <small id="initAmountHelp" class="form-text text-muted"
                      >Unit: $</small
                    >
                  </div>
                  <div id="notification" class="alert d-none"></div>
                  <button type="submit" class="btn btn-dark">Payment</button>
                </form>
                <!--
                  <ul id="display-resources" class="list-group list-group-flush">

                  </ul>
                -->
              </div>
            </div>
          </div>
        </div>
      </section>
    </main>
  </body>
</html>
