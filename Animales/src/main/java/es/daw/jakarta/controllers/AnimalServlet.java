package es.daw.jakarta.controllers;

import es.daw.jakarta.models.*;
import es.daw.jakarta.DAO.*;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.*;
import java.util.List;

@WebServlet("/animales")
public class AnimalServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        AnimalDAO dao = new AnimalDAO();
        List<Animal> animales;
        try {
            animales = dao.obtenerAnimales();
            request.setAttribute("animales", animales);  // Pasar la lista al JSP
            RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
            dispatcher.forward(request, response);
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}