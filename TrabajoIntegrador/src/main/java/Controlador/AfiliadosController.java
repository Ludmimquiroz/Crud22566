/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletResponse;
import javax.servlet.ServletRequest;
import Modelo.Afiliados;
import java.time.LocalDate;
import Modelo.AfiliadosDAO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServlet;

public class AfiliadosController extends HttpServlet
{
    protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        AfiliadosDAO afiliadosDAO = null;
        afiliadosDAO = new AfiliadosDAO();
        RequestDispatcher dispatcher = null;
        final String accion = request.getParameter("accion");
       
        if (accion == null || accion.isEmpty()) {
            dispatcher = request.getRequestDispatcher("vistas/afiliados.jsp");
        }
        else if (accion.equals("editar")) {
            dispatcher = request.getRequestDispatcher("vistas/editar.jsp");
        }
        else if (accion.equals("actualizar")) {
            final int id = Integer.parseInt(request.getParameter("id"));
            final String nombre = request.getParameter("nombre");
            final String apellido = request.getParameter("apellido");
            final String direccion = request.getParameter("direccion");
            final String localidad = request.getParameter("localidad");
            final String nacionalidad = request.getParameter("nacionalidad");
            final LocalDate fecha = LocalDate.parse(request.getParameter("fnac"));
            final String email = request.getParameter("mail");
            final String telefono = request.getParameter("telefono");
            final Afiliados a1 = new Afiliados (id, nombre, apellido, direccion, localidad, nacionalidad, fecha, email, telefono, true);
            afiliadosDAO.ActualizarAfiliados(a1);
            dispatcher = request.getRequestDispatcher("vistas/afiliados.jsp");
        }
        else if (accion.equals("eliminar")) {
            final int id = Integer.parseInt(request.getParameter("id"));
            afiliadosDAO.eliminarAfiliado(id);
            dispatcher = request.getRequestDispatcher("vistas/afiliados.jsp");
        }
        else if (accion.equals("nuevo")) {
            dispatcher = request.getRequestDispatcher("vistas/agregar.jsp");
        }
        else if (accion.equals("insert")) {
            final String nombre2 = request.getParameter("nombre");
            final String apellido2 = request.getParameter("apellido");
            final String direccion2 = request.getParameter("direccion");
            final String localidad2 = request.getParameter("localidad");
            final String nacionalidad2 = request.getParameter("nacionalidad");
            final LocalDate fecha2 = LocalDate.parse(request.getParameter("fnac"));
            final String email2 = request.getParameter("mail");
            final String telefono2 = request.getParameter("telefono");
            final Afiliados a2 = new Afiliados(0, nombre2, apellido2, direccion2, localidad2, nacionalidad2, fecha2, email2, telefono2, true);
            afiliadosDAO.agregarAfiliado(a2);
            dispatcher = request.getRequestDispatcher("vistas/afiliados.jsp");
        }
        
        dispatcher.forward((ServletRequest)request, (ServletResponse)response);
    }
    
    protected void doPost(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
    
    public String getServletInfo() {
        return "Short description";
    }
}