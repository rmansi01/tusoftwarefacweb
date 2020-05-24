<%-- 
    Document   : home
    Created on : 23-may-2020, 23:21:52
    Author     : Raúl Mansilla
--%>

<%@page import="model.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<% Usuario usuario = (Usuario) session.getAttribute("usuario");%>
<html lang="es-ES">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.1.1/css/all.css" integrity="sha384-O8whS3fhG2OnA5Kas0Y9l3cfpmYjapjI0E4theH4iuMD+pLhbf6JI0jIMfYcK3yZ" crossorigin="anonymous">
    <link rel="stylesheet" href="css/style.css" type="text/css">
    <title>Tusoftware Fac - P&aacute;gina principal</title>
  </head>
  <body class="bg-dark">
    <nav id="main-nav" class="navbar navbar-expand-lg navbar-dark bg-dark">
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
      
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <span style="color: #fff;"> Hola, <%= usuario.getNombre() %></span>
          <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
              <a class="nav-link" href="#"> <i class="fas fa-home    "></i></a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#"><i class="fas fa-cog"></i></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="Controller?op=logout" tabindex="-1" aria-disabled="true"><i class="fa fa-key"></i></a>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                  <i class="fas fa-file-invoice-dollar"></i> Facturas
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                  <a class="dropdown-item" href="#">Facturas de compra</a>
                  <a class="dropdown-item" href="#">Facturas de venta</a>
                </div>
              </li>
            <li class="nav-item dropdown">
              <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
               <i class="fa fa-shopping-cart" aria-hidden="true"></i> Articulos
              </a>
              <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                <a class="dropdown-item" href="#"> <i class="fa fa-plus-circle" aria-hidden="true"></i> Nuevo articulo r&aacute;pido</a>
                <a class="dropdown-item" href="#"> <i class="fa fa-eye" aria-hidden="true"></i> Ver articulos</a>
              </div>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                  <i class="fas fa-users"></i> Clientes
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                  <a class="dropdown-item" href="#"> <i class="fa fa-plus-circle" aria-hidden="true"></i> Nuevo cliente</a>
                  <a class="dropdown-item" href="#"> <i class="fa fa-eye" aria-hidden="true"></i> Ver clientes</a>
                </div>
              </li>
              <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                 <i class="fas fa-address-book"></i> Proveedores
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                  <a class="dropdown-item" href="#"> <i class="fa fa-plus-circle" aria-hidden="true"></i> Nuevo articulo r&aacute;pido</a>
                  <a class="dropdown-item" href="#"> <i class="fa fa-eye" aria-hidden="true"></i> Ver articulos</a>
                </div>
              </li>
            
          </ul>
          <form class="form-inline my-2 my-lg-0">
            <select class="form-control mx-1">
                <option>Clientes</option>
                <option>Articulos</option>
                <option>Proveedores</option>
                <option>Empleados</option>
            </select>
            <input class="form-control mr-sm-2" type="search" placeholder="Buscar..." aria-label="Search">
            <button class="btn btn-primary my-2 my-sm-0" type="submit"><i class="fa fa-search" aria-hidden="true"></i></button>
          </form>
        </div>
      </nav>
      <div class="row my-2 mx-2 row-cols-1 row-cols-md-4">
        <div class="col mb-4">
          <div class="card">
            <img src="img/clientes.png" height="150px" alt="...">
            <div class="card-body">
              <h5 class="card-title">Nuevo cliente</h5>
            </div>
          </div>
        </div>
        <div class="col mb-4">
          <div class="card">
            <img src="img/proveedores.jpg" height="150px" alt="...">
            <div class="card-body">
              <h5 class="card-title">Nuevo proveedor</h5>
            </div>
          </div>
        </div>
        <div class="col mb-4">
          <div class="card">
            <img src="img/articulos.jpg" height="150px" alt="...">
            <div class="card-body">
              <h5 class="card-title">Nuevo articulo r&aacute;pido</h5>
            </div>
          </div>
        </div>
        <div class="col mb-4">
          <div class="card">
            <img src="img/facturas.jpg" height="150px" alt="...">
            <div class="card-body">
              <h5 class="card-title">Nueva factura de venta</h5>
            </div>
          </div>
        </div>
        <div class="col mb-4">
            <div class="card">
              <img src="img/clientes.png" height="150px" alt="...">
              <div class="card-body">
                <h5 class="card-title">Empleados</h5>
              </div>
            </div>
          </div>
          <div class="col mb-4">
            <div class="card">
              <img src="img/clientes.png" height="150px" alt="...">
              <div class="card-body">
                <h5 class="card-title">Clientes</h5>
              </div>
            </div>
          </div>
          <div class="col mb-4">
            <div class="card">
              <img src="img/proveedores.jpg" height="150px" class="card-img-top" alt="...">
              <div class="card-body">
                <h5 class="card-title">Proveedores</h5>
              </div>
            </div>
          </div>
          <div class="col mb-4">
            <div class="card">
              <img src="img/articulos.jpg" class="card-img-top" height="150px" alt="...">
              <div class="card-body">
                <h5 class="card-title">Articulos</h5>
              </div>
            </div>
          </div>
          <div class="col mb-4">
            <div class="card">
              <img src="img/facturas.jpg" height="150px" class="card-img-top" alt="...">
              <div class="card-body">
                <h5 class="card-title">Facturas de compra</h5>
              </div>
            </div>
          </div>
          <div class="col mb-4">
            <div class="card">
              <img src="img/facturas.jpg" height="150px" class="card-img-top" alt="...">
              <div class="card-body">
                <h5 class="card-title">Facturas de venta</h5>
              </div>
            </div>
          </div>
          <div class="col mb-4">
            <div class="card">
              <img src="img/albaranes.jpg" height="150px" class="card-img-top" alt="...">
              <div class="card-body">
                <h5 class="card-title">Albaranes</h5>
              </div>
            </div>
          </div>
          <div class="col mb-4">
            <div class="card">
              <img src="img/settings.png" height="150px" class="card-img-top" alt="...">
              <div class="card-body">
                <h5 class="card-title">Configuraci&oacute;n</h5>
              </div>
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
