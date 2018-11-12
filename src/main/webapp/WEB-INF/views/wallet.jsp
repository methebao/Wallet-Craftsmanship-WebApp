<!DOCTYPE html>
<html>

<body>

<main>
    <section class="section-wallet">
        <div class="row">
            <div class="col-sm-12 col-md-12 col-lg-5">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">Account Balance</h5>
                        <h6 class="card-subtitle mb-2 text-muted">List wallet</h6>
                        <ul class="list-group list-group-flush">
                            <li class="list-group-item">
                                <div class="wallet-name">
                                    Wallet 1
                                </div>
                                <div class="wallet-balance">
                                    500$
                                </div>
                            </li>
                            <li class="list-group-item">
                                <div class="wallet-name">
                                    Wallet 2
                                </div>
                                <div class="wallet-balance">
                                    1500$
                                </div>
                            </li>
                            <li class="list-group-item"><div class="wallet-name">
                                Wallet 3
                            </div>
                                <div class="wallet-balance">
                                    5000$
                                </div>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
            <div class="col-sm-12 col-md-12 col-lg-7">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">Create Wallet</h5>
                        <h6 class="card-subtitle mb-2 text-muted">Add a new wallet</h6>
                        <form>
                            <div class="form-group">
                                <label for="walletName"> Name</label>
                                <input type="text" class="form-control" id="walletName" placeholder="Shopping wallet,etc">
                            </div>
                            <div class="form-group">
                                <label for="walletDescription">Description</label>
                                <input type="text" class="form-control" id="walletDescription" placeholder="Wallet for shopping,...">
                            </div>
                            <div class="form-group">
                                <label for="walletDate">Date</label>
                                <input type="text" class="form-control" id="walletDate" placeholder="23/09/1997">
                            </div>
                            <div class="form-group">
                                <label for="initAmount">Init amount</label>
                                <input type="text" class="form-control" id="initAmount" placeholder="1000">
                                <small id="initAmountHelp" class="form-text text-muted">Unit: $</small>
                            </div>
                            <button type="submit" class="btn btn-dark">Create</button>
                        </form>
                    </div>
                </div>
            </div>

        </div>
    </section>

</main>

</body>
</html>
