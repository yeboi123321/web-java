<%@ page import="java.util.List" %>
<%@ page import="es.daw.jakarta.models.Animal" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Animales</title>
</head>
<body>
    <%
        List<Animal> animales = (List<Animal>) request.getAttribute("animales");
    %>
    <h1>Lista de Animales</h1>
    <p><%= animales.size() %></p>
    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Especie</th>
            </tr>
        </thead>
        <tbody>
            <%
                for (Animal animal : animales) {
            %>
                <tr>
                    <td><%= animal.getId() %></td>
                    <td><%= animal.getEspecie() %></td>
                </tr>
            <% } %>
        </tbody>
    </table>
</body>
</html>
