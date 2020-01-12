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
import model.Horario;
import model.HorarioDao;

/**
 *
 * @author ELIAS
 */
@WebServlet(name = "Controlador_Horario", urlPatterns = {"/Controlador_Horario"})
public class Controlador_Horario extends HttpServlet {

String listar="hor_listar.jsp";
    String add="hor_add.jsp";
    String edit="hor_edit.jsp";
    Horario h =new Horario();
    HorarioDao dao=new HorarioDao();
    int id;
    
        
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Controlador_Horario</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Controlador_Horario at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

  
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
            String dia=request.getParameter("txtfecha");
            int hor=Integer.parseInt(request.getParameter("txthora"));
            
            
            h.setId(id);
            h.setDia(dia);
            h.setHoras(hor);
            h.setEstado("Activo");
            dao.add(h);
            acceso=listar;
        }else if(action.equalsIgnoreCase("editar")){
            request.setAttribute("idhor", request.getParameter("id"));
            acceso=edit;
        }else if(action.equalsIgnoreCase("Actualizar")){
            id=Integer.parseInt(request.getParameter("txtid"));
            String dia=request.getParameter("txtfecha");
            int hor=Integer.parseInt(request.getParameter("txthora"));
            
            h.setId(id);
            h.setDia(dia);
            h.setHoras(hor);
            
            dao.edit(h);
            acceso=listar;
        }else if(action.equalsIgnoreCase("estado")) {
           id=Integer.parseInt(request.getParameter("id"));
       String estado=HorarioDao.getestado(id);
       if(estado.equalsIgnoreCase("Activo")){
           h.setEstado("Desactivado");
       }else{
       h.setEstado("Activo");
        
       }
        dao.Estado(h,id);
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
