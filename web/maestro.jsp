<%-- 
    Document   : maestro
    Created on : 24-may-2020, 16:34:09
    Author     : Raúl Mansilla
--%>

<%@page import="model.FraVenta"%>
<%@page import="model.FraCompra"%>
<%@page import="model.Proveedor"%>
<%@page import="model.Cliente"%>
<%@page import="java.util.List"%>
<%@page import="model.Articulo"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="es-ES">
    
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
              integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.1.1/css/all.css"
              integrity="sha384-O8whS3fhG2OnA5Kas0Y9l3cfpmYjapjI0E4theH4iuMD+pLhbf6JI0jIMfYcK3yZ" crossorigin="anonymous">
        <link rel="stylesheet" href="css/style.css" type="text/css">
        <title>Tusoftware Fac - P&aacute;gina principal</title>
    </head>

    <body class="bg-dark">
        <% String getting = (String) session.getAttribute("getting");
         List<Articulo> articulos = (List<Articulo>) session.getAttribute("articulos");
         List<Cliente> clientes = (List<Cliente>) session.getAttribute("clientes");
         List<Proveedor> proveedores = (List<Proveedor>) session.getAttribute("proveedores");
         List<FraCompra> fracs = (List<FraCompra>) session.getAttribute("fracs");
         List<FraVenta> fravs = (List<FraVenta>) session.getAttribute("fravs");
        %>
        <nav id="main-nav" class="navbar navbar-expand-lg navbar-dark bg-dark">
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                    aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item active">
                        <a class="nav-link" href="#"> <i class="fas fa-home    "></i></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#"><i class="fas fa-cog"></i></a>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button"
                           data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <i class="fas fa-file-invoice-dollar"></i> Facturas
                        </a>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <a class="dropdown-item" href="#">Facturas de compra</a>
                            <a class="dropdown-item" href="#">Facturas de venta</a>
                        </div>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button"
                           data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <i class="fa fa-shopping-cart" aria-hidden="true"></i> Articulos
                        </a>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <a class="dropdown-item" href="#"> <i class="fa fa-plus-circle" aria-hidden="true"></i> Nuevo
                                articulo r&aacute;pido</a>
                            <a class="dropdown-item" href="#"> <i class="fa fa-eye" aria-hidden="true"></i> Ver
                                articulos</a>
                        </div>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button"
                           data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <i class="fas fa-users"></i> Clientes
                        </a>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <a class="dropdown-item" href="#"> <i class="fa fa-plus-circle" aria-hidden="true"></i> Nuevo
                                cliente</a>
                            <a class="dropdown-item" href="#"> <i class="fa fa-eye" aria-hidden="true"></i> Ver clientes</a>
                        </div>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button"
                           data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <i class="fas fa-address-book"></i> Proveedores
                        </a>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <a class="dropdown-item" href="#"> <i class="fa fa-plus-circle" aria-hidden="true"></i> Nuevo
                                articulo r&aacute;pido</a>
                            <a class="dropdown-item" href="#"> <i class="fa fa-eye" aria-hidden="true"></i> Ver
                                articulos</a>
                        </div>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Disabled</a>
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
                    <button class="btn btn-primary my-2 my-sm-0" type="submit"><i class="fa fa-search"
                                                                                  aria-hidden="true"></i></button>
                </form>
            </div>
        </nav>
        <% if (getting == "Articles") { %>
        <div id="filtroarticulo" class="card my-2 p-2 mx-5">
            <h5>B&uacute;squeda de art&iacute;culos</h5>
            <form action="Controller?op=filterart" class="form-inline" method="POST">
                <input type="text" class="form-control m-1" name="ref" id="ref" placeholder="Referencia">
                <input type="text" class="form-control m-1" name="nombre" id="nombre" placeholder="Nombre">
                <input type="text" class="form-control m-1" name="desc" id="desc" placeholder="Descripci&oacute;n larga">
                <input type="number" class="form-control m-1" name="pvp" id="pvp" placeholder="Precio"><select
                    class="form-control m-1" name="order" id="order">
                    <option selected="selected" value="*">Marca</option>
                    <option value="">Ejemplo</option>
                </select>
                <select class="form-control ml-auto" name="order" id="order">
                    <option selected="selected" value="alpha">Alfab&eacute;ticamente (A-Z)</option>
                    <option value="alparev">Alfab&eacute;ticamente a la inversa (Z-A)</option>
                    <option value="pvpasc">Por precio ascendente</option>
                    <option value="pvpdesc">Por precio descendente</option>
                </select>
                <button type="submit" class="btn-primary btn ml-auto" name="ref" id="ref">Filtrar</button>
            </form>
        </div>
        <%} else if (getting == "cli") {%>
        <div id="filtrocliente" class="card my-2 p-2 mx-5">
            <h5>B&uacute;squeda de clientes</h5>
            <form action="Controller?op=filtercli" class="form-inline" method="POST">
                <input type="text" class="form-control m-1" name="nif" id="nif" placeholder="NIF-CIF">
                <input type="text" class="form-control m-1" name="nombre" id="nombre" placeholder="Nombre">
                <input type="text" class="form-control m-1" name="ape1" id="ape1" placeholder="Apellido 1">
                <input type="text" class="form-control m-1" name="ape2" id="ape2" placeholder="Apellido 2">
                <input type="email" class="form-control m-1" name="mail" id="mail" placeholder="E-mail" />
                <input type="tel" class="form-control m-1" name="phone" id="phone" placeholder="Tel&eacute;fono" />

                <button type="submit" class="btn-primary btn ml-auto" name="ref" id="ref">Filtrar</button>
            </form>
        </div>
        <%} else if (getting == "prov") {%>
        <div id="filtroprov" class="card my-2 p-2 mx-5">
            <h5>B&uacute;squeda de proveedores</h5>
            <form action="Controller?op=filterprov" class="form-inline" method="POST">
                <input type="text" class="form-control m-1" name="cif" id="cif" placeholder="CIF">
                <input type="text" class="form-control m-1" name="nombre" id="nombre" placeholder="Nombre">
                <input type="url" class="form-control m-1" name="web" id="web" placeholder="Sitio web">
                <input type="email" class="form-control m-1" name="mail" id="mail" placeholder="E-mail" />


                <button type="submit" class="btn-primary btn ml-auto" name="ref" id="ref">Filtrar</button>
            </form>
        </div>
        <%} else if (getting == "frac") { %>
        <div id="filtrofrac" class="card my-2 p-2 mx-5">
            <h5>B&uacute;squeda de facturas de compra</h5>
            <form action="Controller?op=filterfrac" class="form-inline" method="POST">
                <input type="number" class="form-control m-1" name="numb" id="numb" placeholder="N&uacute;mero de factura">
                <input type="text" class="form-control m-1" name="prov" id="prov" placeholder="Proveedor">
                <input type="date" class="form-control m-1" name="date" id="date" placeholder="Fecha">
                <input type="number" class="form-control m-1" name="imp" id="imp" placeholder="Importe" />


                <button type="submit" class="btn-primary btn ml-auto" name="ref" id="ref">Filtrar</button>
            </form>
        </div>
        <%} else if (getting == "frav") { %>
        <div id="filtrofrav" class="card my-2 p-2 mx-5">
            <h5>B&uacute;squeda de facturas de venta</h5>
            <form action="Controller?op=filterfrav" class="form-inline" method="POST">
                <input type="number" class="form-control m-1" name="numb" id="numb" placeholder="N&uacute;mero de factura">
                <input type="text" class="form-control m-1" name="cli" id="cli" placeholder="Cliente">
                <input type="date" class="form-control m-1" name="date" id="date" placeholder="Fecha">
                <input type="number" class="form-control m-1" name="imp" id="imp" placeholder="Importe" />

                <button type="submit" class="btn-primary btn ml-auto" name="ref" id="ref">Filtrar</button>
            </form>
        </div>
        <% } %>

        <div class="card p-2 mx-5">
            <% if (getting == "Articles") { %>
            <a href="Controller?op=newArt" class="btn btn-primary">A&ntilde;adir nuevo</a>
            <table id="tableart" class="table table-responsive-md table-striped table-dark">
                <thead>
                    <tr>
                        <th scope="col">Id</th>
                        <th scope="col">Ref.</th>
                        <th scope="col">Nombre</th>
                        <th scope="col">Desc. larga</th>
                        <th scope="col">PVP (&euro;)</th>
                        <th scope="col">Cantidad</th>
                        <th scope="col">Marca</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                    if (articulos != null) {
                        for (Articulo articulo : articulos) {%>
                    <tr>
                        <th scope="row"><%=articulo.getId()%></th>
                        <td><%= articulo.getRef()%></td>
                        <td><%=articulo.getNombre()%></td>
                        <td><%
                            if (articulo.getDescripcionLarga().length() > 60){
                                articulo.getDescripcionLarga().substring(0, 59); %>...
                            <% } else{
                            articulo.getDescripcionLarga();
                                }%></td>
                        <td><%= articulo.getPvp()%></td>
                        <td><%= articulo.getStock()%></td>
                        <td><%= articulo.getCMarca()%></td>
                        <td><a class="btn btn-primary" href="Controller?op=getArticuloId&id=<%=articulo.getId()%>">Ver</a></td>
                    </tr>
                    <%}
                    }%>
                </tbody>
            </table>
            <%} else if (getting == "cli") {%>
               <a href="Controller?op=newCli" class="btn btn-primary">A&ntilde;adir nuevo</a>
            <table id="tablecli" class="table table-responsive-md table-striped table-dark">
                <thead>
                    <tr>
                        <th scope="col">NIF / CIF</th>
                        <th scope="col">Nombre</th>
                        <th scope="col">Apellido 1</th>
                        <th scope="col">Apellido 2</th>
                        <th scope="col">Direcci&oacute;n</th>
                        <th scope="col">E-mail</th>
                        <th scope="col">Tel&eacute;fono</th>
                    </tr>
                </thead>
                <tbody>
                    <%if (proveedores != null){
                        for (Cliente cliente : clientes){%>
                    <tr>
                        <th scope="row"><%=cliente.getNifcif() %></th>
                        <td><%=cliente.getNombre()%></td>
                        <td><%=cliente.getApe1() %></td>
                        <td><%=cliente.getApe2() %></td>
                        <td><%=cliente.getDir() %></td>
                        <td><%=cliente.getMail()%></td>
                        <td><%=cliente.getTelefono() %></td>
                        <td><a class="btn btn-primary" href="Controller?op=seecli&nif=<%=cliente.getNifcif() %>">Ver</a></td>
                    </tr>
                    <%}
                    }%>
                </tbody>
            </table>
            <%} else if (getting == "prov") {%>
            <a href="Controller?op=newProv" class="btn btn-primary">A&ntilde;adir nuevo</a>
            <table id="tableprov" class="table table-responsive-md table-striped table-dark">
                <thead>
                    <tr>
                        <th scope="col">C&oacute;digo</th>
                        <th scope="col">Nombre</th>
                        <th scope="col">URL</th>
                        <th scope="col">Direcci&oacute;n</th>
                        <th scope="col">Tel&eacute;fono</th>
                        <th scope="col">E-mail</th>
                    </tr>
                </thead>
                <tbody>
                    <%if (proveedores != null){
                        for (Proveedor proveedor : proveedores){ %>
                    <tr>
                        <th scope="row"><%=proveedor.getCProveedor() %></th>
                        <td><%=proveedor.getNombre() %></td>
                        <td><a href="<%=proveedor.getWeb() %>" target="_blank">Ver sitio web</a></td>
                        <td><%=proveedor.getDir() %></td>
                        <td><%=proveedor.getTelefono() %></td>
                        <td><%=proveedor.getMail() %></td>
                        <td><a class="btn btn-primary" href="Controller?op=seeprov&id=<%=proveedor.getCProveedor() %>">Ver</a></td>
                    </tr>
                    <%}
                       }%>
                </tbody>
            </table>
            <%} else if (getting == "frav" || getting == "frac") {
                if (getting == "frav"){%>
                <a href="Controller?op=newFrav" class="btn btn-primary">A&ntilde;adir nueva</a> <%
                    } else { %>
                    <a href="Controller?op=newFrac" class="btn btn-primary">A&ntilde;adir nueva</a>
            <%}%>
            
            <table id="tablefra" class="table table-responsive-md table-striped table-dark">
                <thead>
                    <tr>
                        <th scope="col">Nº de factura</th>
                        <th scope="col">
                            <%if (getting == "frav"){
                                %>NIF / CIF
                           <% } else {%>
                           C_Proveedor
                           <%}%>
                        </th>
                        <th scope="col">Fecha</th>
                        <th scope="col">Importe (&euro;)</th>
                    </tr>
                </thead>
                <tbody>
                   <% if (getting == "frav" && fravs != null){
                       for (FraVenta frav : fravs){ %>
                    <tr>
                        <th scope="row"><%= frav.getCFrav() %></th>
                        <td><%=frav.getNifcif() %></td>
                        <td><%=frav.getFecha() %></td>
                        <td><%=frav.getTotal() %></td>
                        <td><a class="btn btn-primary" href="Controller?op=seefrav&id=<%=frav.getCFrav() %>">Ver</a></td>
                    </tr>
                    <%}
                       }else {
                            <%if (fracs != null){
                        for (FraCompra frac : fracs){%>
                     <tr>
                        <th scope="row"><%= frac.getCFrac() %></th>
                        <td><%=frac.getCProveedor() %></td>
                        <td><%=frac.getFecha() %></td>
                        <td><%=frac.getTotal() %></td>
                        <td><a class="btn btn-primary" href="Controller?op=seefrav&id=<%=frac.getCFrac() %>">Ver</a></td>
                    </tr>
                    <%}}
                    }   %>
                </tbody>
            </table>
            <%}%>
        </div>


        <!-- Optional JavaScript -->
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
                integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
        crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
                integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
        crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
                integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
        crossorigin="anonymous"></script>
    </body>

</html>
