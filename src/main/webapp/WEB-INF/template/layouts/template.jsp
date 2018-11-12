<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<html>
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>Wallet App Craftmanship project</title>
    <link
            href="webjars/bootstrap/4.1.3/css/bootstrap.min.css"
            rel="stylesheet"
    />
    <link
            href="css/main.css"
            rel="stylesheet"
    />
</head>

<body>
    <tiles:insertAttribute name="header" />
    <tiles:insertAttribute name="body" />
    <tiles:insertAttribute name="footer" />

    <script src="webjars/bootstrap/4.1.3/js/bootstrap.min.js"></script>
    <script src="webjars/jquery/3.1.1/jquery.min.js"></script>
    <script src="js/main.js"></script>
</body>
</html>