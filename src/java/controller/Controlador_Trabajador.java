/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Trabajador;
import model.TrabajadorDao;

/**
 *
 * @author ELIAS
 */
@WebServlet(name = "Controlador_Trabajador", urlPatterns = {"/Controlador_Trabajador"})
public class Controlador_Trabajador extends HttpServlet {

   
    String listar="trab_listar.jsp";
    String add="trab_add.jsp";
    String edit="trab_edit.jsp";
    
    
            
            
    Trabajador e=new Trabajador();
    TrabajadorDao dao=new TrabajadorDao();
    int id;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Controlador_Trabajador</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Controlador_Trabajador at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {String acceso="";
        String action=request.getParameter("accion");
        if(action.equalsIgnoreCase("listar")){
            acceso=listar;            
        }else if(action.equalsIgnoreCase("add")){
            acceso=add;
        }
        else if(action.equalsIgnoreCase("Agregar")){
            int id=Integer.parseInt(request.getParameter("txtid"));
            String nom=request.getParameter("txtnombre");
            String ape=request.getParameter("txtapellido");
            String cor=request.getParameter("txtcorreo");
            String cel=request.getParameter("txtcelular");            
            String usu=request.getParameter("txtusuario");
            String pass=request.getParameter("txtpassword");
            String carg=request.getParameter("txtcargo");
            
            e.setId(id);
            e.setNombres(nom);
            e.setApellidos(ape);
            e.setCorreo(cor);
            e.setCelular(cel);
            e.setUsuario(usu);
            e.setPassword(pass);
            e.setCargo(carg);
            e.setEstado("Activo");
           
            
            dao.add(e);
            acceso=listar;
        }
        else if(action.equalsIgnoreCase("editar")){
            request.setAttribute("idtra",request.getParameter("id"));
            acceso=edit;    
        }
        else if(action.equalsIgnoreCase("Actualizar")){
            
            id=Integer.parseInt(request.getParameter("txtid"));
            String nom=request.getParameter("txtnombre");
            String ape=request.getParameter("txtapellido");
            String cor=request.getParameter("txtcorreo");
            String cel=request.getParameter("txtcelular");            
            String usu=request.getParameter("txtusuario");
            String pass=request.getParameter("txtpassword");           
            String carg=request.getParameter("txtcargo");
            
            e.setId(id);
            e.setNombres(nom);
            e.setApellidos(ape);
            e.setCorreo(cor);
            e.setCelular(cel);
            e.setUsuario(usu);
            e.setPassword(pass);
            e.setCargo(carg);
            dao.edit(e);
            acceso=listar;
        }else if(action.equalsIgnoreCase("estado")) {
           id=Integer.parseInt(request.getParameter("id"));
       String estado=TrabajadorDao.getestado(id);
       if(estado.equalsIgnoreCase("Activo")){
           e.setEstado("Desactivado");
       }else{
       e.setEstado("Activo");
        
       }
        dao.Estado(e,id);
          acceso=listar;  
      }
        
         RequestDispatcher vista=request.getRequestDispatcher(acceso);
        vista.forward(request, response);
       
    }
    

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
