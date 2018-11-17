<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

<body>

<main>

    <section class="section-wallet">
        <div class="container-fluid">
            <div class="row">
                <div class="col-sm-12 col-md-12 col-lg-5">
                    <div class="card">
                        <div class="card-body">
                            <h5 class="card-title">ACCOUNT BALANCE</h5>
                            <h6 class="card-subtitle mb-2 text-muted">List wallet</h6>
                            <ul id="display-resources" class="list-group list-group-flush">
                                <c:forEach items="${wallets}" var="wallet">
                                    <%--"<li class=\"list-group-item\">" +--%>
                                    <%--"<div class=\"wallet-name\">" +--%>
                                    <%--wallet.name +--%>
                                    <%--"</div>" +--%>
                                    <%--"<div class=\"wallet-balance\">" +--%>
                                    <%--wallet.balance +--%>
                                    <%--"</div>" +--%>
                                    <%--"</li>";--%>
                                    <li class="list-group-item">
                                        <div class="wallet-name">
                                            ${wallet.name}
                                        </div>
                                        <div class="wallet-balance">
                                            ${wallet.balance}
                                        </div>
                                    </li>

                                </c:forEach>

                            </ul>
                        </div>
                    </div>
                </div>
                <div class="col-sm-12 col-md-12 col-lg-7">
                    <div class="card">
                        <div class="card-body">
                            <h5 class="card-title">CREATE WALLET</h5>
                            <h6 class="card-subtitle mb-2 text-muted">Add a new wallet</h6>
                            <form id="addWalletForm" action="/api/wallet">
                                <div class="form-group">
                                         <label for="walletName"> Name</label>
                                    <input type="text" name="name" class="form-control" id="walletName" placeholder="Shopping wallet,etc" required>
                                </div>
                                <div class="form-group">
                                    <label for="walletDescription">Description</label>
                                    <input type="text" name="description" class="form-control" id="walletDescription" placeholder="Wallet for shopping,...">
                                </div>

                                <div class="form-group">
                                    <label for="initAmount">Init amount</label>
                                    <input type="text" name="balance" class="form-control" id="initAmount" placeholder="1000">
                                    <small id="initAmountHelp" class="form-text text-muted">Unit: $</small>
                                </div>
                                <div id="notification" class="alert d-none">

                                </div>
                                <button type="submit" class="btn btn-dark">Create</button>
                            </form>
                        </div>
                    </div>
                </div>

            </div>
        </div>

    </section>

</main>

</body>
</html>
