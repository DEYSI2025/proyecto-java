<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Login | Sistema</title>
    <style>
        * {
            box-sizing: border-box;
            font-family: 'Segoe UI', Tahoma, sans-serif;
        }

        body {
            margin: 0;
            height: 100vh;
            background: linear-gradient(135deg, #1d2671, #c33764);
            display: flex;
            align-items: center;
            justify-content: center;
        }

        .login-card {
            background: #ffffff;
            width: 360px;
            padding: 40px;
            border-radius: 12px;
            box-shadow: 0 20px 40px rgba(0,0,0,0.25);
        }

        .login-card h2 {
            margin: 0 0 25px;
            text-align: center;
            color: #1d2671;
            letter-spacing: 1px;
        }

        .form-group {
            margin-bottom: 18px;
        }

        .form-group input {
            width: 100%;
            padding: 12px 14px;
            border: 1px solid #ddd;
            border-radius: 8px;
            font-size: 14px;
            outline: none;
            transition: 0.3s;
        }

        .form-group input:focus {
            border-color: #1d2671;
            box-shadow: 0 0 0 2px rgba(29,38,113,0.15);
        }

        .btn-login {
            width: 100%;
            padding: 12px;
            border: none;
            border-radius: 8px;
            background: linear-gradient(135deg, #1d2671, #c33764);
            color: white;
            font-size: 15px;
            font-weight: bold;
            cursor: pointer;
            transition: 0.3s;
        }

        .btn-login:hover {
            opacity: 0.9;
            transform: translateY(-1px);
        }

        .footer-text {
            margin-top: 20px;
            text-align: center;
            font-size: 12px;
            color: #888;
        }
    </style>
</head>
<body>

    <div class="login-card">
        <h2>Iniciar Sesión</h2>

        <form action="LoginServlet" method="post">
            <div class="form-group">
                <input type="text" name="usuario" placeholder="Usuario" required>
            </div>

            <div class="form-group">
                <input type="password" name="password" placeholder="Contraseña" required>
            </div>

            <button type="submit" class="btn-login">Ingresar</button>
        </form>

        <div class="footer-text">
            Sistema de Gestión · 2025
        </div>
    </div>

</body>
</html>
