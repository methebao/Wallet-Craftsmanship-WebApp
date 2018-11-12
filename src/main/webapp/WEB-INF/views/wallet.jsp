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
                        <ul id="display-resources" class="list-group list-group-flush">


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
