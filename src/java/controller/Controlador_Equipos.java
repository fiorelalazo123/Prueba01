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
import model.Equipos;
import model.EquiposDao;

/**
 *
 * @author ELIAS
 */
@WebServlet(name = "Controlador_Equipos", urlPatterns = {"/Controlador_Equipos"})
public class Controlador_Equipos extends HttpServlet {

     String listar="equipos_listar.jsp";
    String add="equipos_add.jsp";
    String edit="equipos_edit.jsp";
    Equipos e=new Equipos();
    EquiposDao dao=new EquiposDao();
    
    String act = listar;
    
    
    int id;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Controlador_Equipos</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Controlador_Equipos at " + request.getContextPath() + "</h1>");
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
            acceso=listar;            
        }else if(action.equalsIgnoreCase("add")){
            acceso=add;
        }
        else if(action.equalsIgnoreCase("Agregar")){
            int id=Integer.parseInt(request.getParameter("txtid"));
            String nom=request.getParameter("txtnombre");
            int can=Integer.parseInt(request.getParameter("txtcantidad"));
            String desc=request.getParameter("txtdescripcion");
            
            
            e.setId(id);
            e.setNombre(nom);
            e.setCantidad(can);
            e.setDescripcion(desc);
            e.setEstado("Activo");
            dao.add(e);
            acceso=listar;
        }
        else if(action.equalsIgnoreCase("editar")){
            request.setAttribute("idequi",request.getParameter("id"));
            acceso=edit;    
        }
        else if(action.equalsIgnoreCase("Actualizar")){
            
            id=Integer.parseInt(request.getParameter("txtid"));
            String nom=request.getParameter("txtnombre");
            int can=Integer.parseInt(request.getParameter("txtcantidad"));
            String desc=request.getParameter("txtdescripcion");
            
            
            e.setId(id);
            e.setNombre(nom);
            e.setCantidad(can);
            e.setDescripcion(desc);
           
            dao.edit(e);
            acceso=listar;
        }else if(action.equalsIgnoreCase("estado")) {
           id=Integer.parseInt(request.getParameter("id"));
       String estado=EquiposDao.getestado(id);
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

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
