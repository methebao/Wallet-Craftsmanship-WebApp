<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
  <body>
    <main>
      <section class="section-summary">
        <div class="row">
          <div class="col-sm-12 col-md-6 col-lg-5">
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
          <div class="col-sm-12 col-md-6 col-lg-7"></div>
        </div>
      </section>
    </main>
  </body>
</html>
