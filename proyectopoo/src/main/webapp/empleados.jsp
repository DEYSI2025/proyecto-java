<%@ page import="java.util.List" %>
<%@ page import="modelo.Empleado" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Empleados</title>

    <style>
        body {
            font-family: Arial, sans-serif;
            padding: 20px;
        }

        h2 {
            margin-bottom: 10px;
        }

        .top-bar {
            display: flex;
            justify-content: space-between;
            margin-bottom: 15px;
        }

        input[type="text"] {
            padding: 6px;
            width: 250px;
        }

        button {
            padding: 6px 10px;
            cursor: pointer;
        }

        .card {
            border: 1px solid #ccc;
            padding: 10px;
            margin-bottom: 10px;
        }

        .actions button {
            margin-right: 5px;
        }
    </style>
    <style>
.btn-editar {
    display: inline-block;
    padding: 6px 12px;
    background: #1f4037;
    color: white;
    text-decoration: none;
    border-radius: 6px;
    font-size: 13px;
    font-weight: bold;
    transition: 0.3s;
}

.btn-editar:hover {
    background: #145a32;
}
</style>
<style>
.btn-delete {
    display: inline-block;
    padding: 6px 12px;
    background: #c0392b;
    color: white;
    text-decoration: none;
    border-radius: 6px;
    font-size: 13px;
    font-weight: bold;
    margin-left: 5px;
    transition: 0.3s;
}

.btn-delete:hover {
    background: #922b21;
}
</style>
<style>
.btn-pdf{
    padding:10px 15px;
    background:#dc3545;
    color:white;
    text-decoration:none;
    border-radius:6px;
    font-weight:bold;
    margin-left:10px;
}
.btn-pdf:hover{ opacity:.9; }
</style>   
</head>
<body>

<h2>LISTA DE EMPLEADOS </h2>

<div class="top-bar">
    <input type="text" id="buscar" placeholder="Buscar empleado..." onkeyup="filtrar()">
    <a href="empleado_nuevo.jsp" style="
    display:inline-block;
    margin-bottom:15px;
    padding:10px 15px;
    background:#1f4037;
    color:white;
    text-decoration:none;
    border-radius:6px;
	">
	    + Nuevo Empleado
	</a>
	
	<a href="EmpleadoServlet?accion=pdf" class="btn-pdf">
   Exportar PDF
	</a>
</div>

<div id="lista">
<%
    List<Empleado> lista = (List<Empleado>) request.getAttribute("lista");
    if (lista != null) {
        for (Empleado e : lista) {
%>
    <div class="card empleado">
        <b class="nombre"><%= e.getNombres() %> <%= e.getApellidos() %></b><br>
        Fecha nac: <%= e.getFechaNacimiento() %><br>
        Correo: <%= e.getCorreo() %><br>
        Cargo: <%= e.getCargo() %><br>
        Sueldo: S/ <%= e.getSueldo() %><br>
        Estado: <%= e.getEstado() %><br><br>

        <div class="actions">
            <a href="EmpleadoServlet?accion=editar&id=<%= e.getId() %>" class="btn-editar">
			    Editar
			</a>
			<a href="EmpleadoServlet?accion=eliminar&id=<%= e.getId() %>"
			   class="btn-delete"
			   onclick="eliminar(<%= e.getId() %>)">
			   Eliminar
			</a>
			
            
        </div>
    </div>
<%
        }
    }
%>
</div>

<script>
function filtrar() {
    let texto = document.getElementById("buscar").value.toLowerCase();
    let empleados = document.getElementsByClassName("empleado");

    for (let e of empleados) {
        let nombre = e.querySelector(".nombre").innerText.toLowerCase();
        e.style.display = nombre.includes(texto) ? "block" : "none";
    }
}

function nuevoEmpleado() {
    window.location.href = "EmpleadoServlet?accion=nuevo";
}

function editar(id) {
    window.location.href = "EmpleadoServlet?accion=editar&id=" + id;
}

function eliminar(id) {
    if (confirm("¿Eliminar empleado?")) {
        window.location.href = "EmpleadoServlet?accion=eliminar&id=" + id;
    }
}
</script>

</body>
</html>
