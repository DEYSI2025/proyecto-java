<%@ page import="modelo.Empleado" %>
<%
    Empleado e = (Empleado) request.getAttribute("empleado");
%>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Editar Empleado</title>
    <style>
        * { box-sizing: border-box; font-family: 'Segoe UI', Tahoma, sans-serif; }
        body {
            margin: 0; height: 100vh;
            background: linear-gradient(135deg, #1f4037, #99f2c8);
            display: flex; align-items: center; justify-content: center;
        }
        .card {
            background: #fff; width: 420px; padding: 35px;
            border-radius: 14px; box-shadow: 0 25px 45px rgba(0,0,0,.25);
        }
        h2 { margin-bottom: 25px; text-align: center; color: #1f4037; }
        .group { margin-bottom: 15px; }
        .group input, .group select {
            width: 100%; padding: 11px 14px;
            border: 1px solid #ddd; border-radius: 8px;
        }
        .btn {
            width: 100%; padding: 12px;
            border: none; border-radius: 8px;
            background: linear-gradient(135deg, #1f4037, #99f2c8);
            color: #fff; font-weight: bold;
        }
    </style>
</head>
<body>

<div class="card">
    <h2>Editar Empleado</h2>

    <form action="EmpleadoServlet" method="post">
        <input type="hidden" name="accion" value="actualizar">
        <input type="hidden" name="id" value="<%= e.getId() %>">

        <div class="group">
            <input type="text" name="nombres" value="<%= e.getNombres() %>" required>
        </div>

        <div class="group">
            <input type="text" name="apellidos" value="<%= e.getApellidos() %>" required>
        </div>

        <div class="group">
            <input type="date" name="fechaNacimiento" value="<%= e.getFechaNacimiento() %>" required>
        </div>

        <div class="group">
            <input type="email" name="correo" value="<%= e.getCorreo() %>" required>
        </div>

        <div class="group">
            <input type="text" name="cargo" value="<%= e.getCargo() %>" required>
        </div>

        <div class="group">
            <input type="number" step="0.01" name="sueldo" value="<%= e.getSueldo() %>" required>
        </div>

        <div class="group">
            <select name="estado">
                <option value="Activo" <%= "Activo".equals(e.getEstado()) ? "selected" : "" %>>Activo</option>
                <option value="Inactivo" <%= "Inactivo".equals(e.getEstado()) ? "selected" : "" %>>Inactivo</option>
            </select>
        </div>

        <button class="btn">Actualizar</button>
    </form>
</div>

</body>
</html>
