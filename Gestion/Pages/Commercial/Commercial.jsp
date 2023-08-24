<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/Gestion/assets/css/bootstrap.css">
    <title>Document</title>
</head>
<body>
    <jsp:include page="../INDEX/Action.jsp" flush="true"/>
    </div>
    <style>
        .nav-item {
            margin-right: 1%;
        }
        .nav-item li {
            list-style: square;
        }
    </style>
    <div class="container" style="margin-top: 5rem;">
        <h1>Nouveau commercial</h1>
        <form method="post" class="form-control" enctype="multipart/form-data" action="/Gestion/insertion-commercial.st">
            <label>Nom commercial</label> <input type="text" name="designation" class="form-control">
            <label>Photo</label> <input type="text" name="photo" class="form-control">
            <input type="submit" class="btn btn-primary mt-3">
        </form>
    </div>
</body>
</html>