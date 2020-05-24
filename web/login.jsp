<%-- 
    Document   : login
    Created on : 23-may-2020, 22:26:23
    Author     : Raúl Mansilla
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="es-ES">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <link rel="stylesheet" href="css/style.css" type="text/css">
    <title>Tusoftware Fac - Iniciar Sesi&oacute;n</title>
  </head>
  <body class="bg-dark">
    <div class="container-fluid row bg-dark">
        <div id="login-card" class="card px-0 mt-5 col-4 offset-4">
            <img src="img/logo.png" class="card-img-top img-fluid" alt="...">
            <div class="card-body">
              <h5 class="card-title">Iniciar sesi&oacute;n</h5>
              <form action="Controller?op=login" method="POST">
                <div class="form-group">
                  <input type="number" class="form-control" id="nif" name="nif" placeholder="NIF" aria-describedby="emailHelp">
                  <small id="emailHelp" class="form-text text-muted">Introduce tu DNI sin la letra</small>
                </div>
                <div class="form-group">
                  <input type="password" class="form-control" placeholder="Contrase&ntilde;a" id="pass" name="pass">
                </div>
                <div class="form-group form-check">
                </div>
                <button type="submit" class="btn btn-primary">Acceder</button>
              </form>
            </div>
            <div class="card-footer text-muted">
                &copy; 2020, Ra&uacute;l Mansilla Cruz - S2DAM
              </div>
        </div>
    </div>

    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
  </body>
</html>
