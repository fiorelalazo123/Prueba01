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
import model.Membresia;
import model.MembresiaDao;

/**
 *
 * @author USER
 */
@WebServlet(name = "Controlador_Membresia", urlPatterns = {"/Controlador_Membresia"})
public class Controlador_Membresia extends HttpServlet {

String listar="membresia_listar.jsp";
    String add="membresia_add.jsp";
    String edit="membresia_edit.jsp";
    Membresia mem =new Membresia();
    MembresiaDao dao=new MembresiaDao();
    int id;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Controlador_Membresia</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Controlador_Membresia at " + request.getContextPath() + "</h1>");
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
            throws ServletException, IOException {
        
        String acceso="";
        String action=request.getParameter("accion");
        if(action.equalsIgnoreCase("listar")){
            acceso= listar;
        }else if(action.equalsIgnoreCase("add")){
            acceso=add;
        }else if(action.equalsIgnoreCase("Agregar")){
            
            int id=Integer.parseInt(request.getParameter("txtid"));
            String tip=request.getParameter("txttipo");
            Double prec=Double.parseDouble(request.getParameter("txtprecio"));

            
            mem.setId(id);
            mem.setTipo(tip);
            mem.setPrecio(prec);
            mem.setEstado("Activo");

            dao.add(mem);
            acceso=listar;
        }else if(action.equalsIgnoreCase("editar")){
            request.setAttribute("idmem", request.getParameter("id"));
            acceso=edit;
        }else if(action.equalsIgnoreCase("Actualizar")){
            id=Integer.parseInt(request.getParameter("txtid"));
            String tip=request.getParameter("txttipo");
            Double prec=Double.parseDouble(request.getParameter("txtprecio"));
            
            
            mem.setId(id);
            mem.setTipo(tip);
            mem.setPrecio(prec);
            
            dao.edit(mem);
            acceso=listar;
            
        }else if(action.equalsIgnoreCase("estado")) {
           id=Integer.parseInt(request.getParameter("id"));
       String estado=MembresiaDao.getestado(id);
       if(estado.equalsIgnoreCase("Activo")){
           mem.setEstado("Desactivado");
       }else{
       mem.setEstado("Activo");
        
       }
        dao.Estado(mem,id);
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

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
