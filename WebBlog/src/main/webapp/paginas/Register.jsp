<%-- 
    Document   : Register
    Created on : 27/11/2023, 08:38:08 PM
    Author     : HP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Registrar</title>
        <link href="../estilos/Register.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <section class="container">
            <main class="form-outer">
                <form action="#">
                    <section class="page slidepage">
                        <div class="title">Crear Cuenta</div>
                        <div class="field">
                            <div class="label">Nombre</div>
                            <input type="text">
                        </div>
                        <div class="field">
                            <div class="label">Apellido Paterno</div>
                            <input type="text">
                        </div>
                        <div class="field">
                            <div class="label">Apellido Materno</div>
                            <input type="text">
                        </div>
                        <div class="field nextBtn">
                            <button>Siguiente</button>
                        </div>
                    </section>
                    <section class="page">
                        <div class="title">información de Contacto</div>
                        <div class="field">
                            <div class="label">Correo Electrónico</div>
                            <input type="email">
                        </div>
                        <div class="field">
                            <div class="label">Número Telefónico</div>
                            <input type="tel">
                        </div>
                        <div class="field buttons">
                            <button class="prev-1 prev">Anterior</button>
                            <button class="next-1 next">Siguiente</button>
                        </div>
                    </section>
                    <section class="page">
                        <div class="field">
                            <div class="label">Estado</div>
                            <input type="text">
                        </div>
                        <div class="field">
                            <div class="label">Ciudad</div>
                            <input type="text">
                        </div>
                        <div class="field">
                            <div class="label">Municipio</div>
                            <input type="text">
                        </div>
                        <div class="field buttons">
                            <button class="prev-2 prev">Anterior</button>
                            <button class="next-2 next">Siguiente</button>
                        </div>
                    </section>
                    <section class="page">
                        <div class="title">Fecha de Cumpleaños</div>
                        <div class="field">
                            <div class="label">Fecha Nacimiento</div>
                            <input type="date">
                        </div>
                        <div class="field">
                            <div class="label">Género</div>
                            <select>
                                <option value="hombre">Hombre</option>
                                <option value="mujer">Mujer</option>
                            </select>
                        </div>
                        <div class="field buttons">
                            <button class="prev-3 prev">Anterior</button>
                            <button class="next-3 next">Siguiente</button>
                        </div>
                    </section>
                    <section class="page">
                        <div class="title">Credenciales</div>
                        <div class="field">
                            <div class="label">Nombre Usuario</div>
                            <input type="text">
                        </div>
                        <div class="field">
                            <div class="label">Contraseña</div>
                            <input type="password">
                        </div>
                        <div class="field buttons">
                            <button class="prev-4 prev">Anterior</button>
                            <button class="submit next">Registrar</button>
                        </div>
                    </section>
                </form>
            </main>

            <script src="../scripts/script.js" type="text/javascript"></script>
    </body>
</html>
