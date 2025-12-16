<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Nuevo Empleado</title>
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
            outline: none; transition: .3s;
        }
        .group input:focus, .group select:focus {
            border-color: #1f4037;
            box-shadow: 0 0 0 2px rgba(31,64,55,.15);
        }
        .btn {
            width: 100%; padding: 12px;
            border: none; border-radius: 8px;
            background: linear-gradient(135deg, #1f4037, #99f2c8);
            color: #fff; font-weight: bold; cursor: pointer;
        }
        .btn:hover { opacity: .9; }
    </style>
</head>
<body>

<div class="card">
    <h2>Nuevo Empleado</h2>

    <form action="EmpleadoServlet" method="post">
        <input type="hidden" name="accion" value="guardar">

        <div class="group">
            <input type="text" name="nombres" placeholder="Nombres" required>
        </div>

        <div class="group">
            <input type="text" name="apellidos" placeholder="Apellidos" required>
        </div>

        <div class="group">
            <input type="date" name="fechaNacimiento" required>
        </div>

        <div class="group">
            <input type="email" name="correo" placeholder="Correo" required>
        </div>

        <div class="group">
            <input type="text" name="cargo" placeholder="Cargo" required>
        </div>

        <div class="group">
            <input type="number" step="0.01" name="sueldo" placeholder="Sueldo" required>
        </div>

        <div class="group">
            <select name="estado" required>
                <option value="">Seleccione estado</option>
                <option value="Activo">Activo</option>
                <option value="Inactivo">Inactivo</option>
            </select>
        </div>

        <button class="btn">Guardar Empleado</button>
    </form>
</div>

</body>
</html>
