    
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Ejercicio;
import model.EjercicioDao;

@WebServlet(name = "Controlador_Ejercicios", urlPatterns = {"/Controlador_Ejercicios"})
public class Controlador_Ejercicios extends HttpServlet {
    String listar="ejercicio_listar.jsp";
    String add="ejercicio_add.jsp";
    String edit="ejercicio_edit.jsp";
    Ejercicio ej=new Ejercicio();
    EjercicioDao dao= new EjercicioDao();
    int id;
    
 
    

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Controlador_Ejercicios</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Controlador_Ejercicios at " + request.getContextPath() + "</h1>");
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
            String nom=request.getParameter("txtnombre");
            String musc=request.getParameter("txtmusculo");
            
            
            ej.setId(id);
            ej.setNombre(nom);
            ej.setMusculo(musc);
            ej.setEstado("Activo");
            dao.add(ej);
            acceso=listar;
        }else if(action.equalsIgnoreCase("editar")){
            request.setAttribute("idejer", request.getParameter("id"));
            acceso=edit;
        }else if(action.equalsIgnoreCase("Actualizar")){
             id=Integer.parseInt(request.getParameter("txtid"));
            String nom=request.getParameter("txtnombre");
            String musc=request.getParameter("txtmusculo");
            
            
            ej.setId(id);
            ej.setNombre(nom);
            ej.setMusculo(musc);
            
            dao.edit(ej);
            acceso=listar;
        }else if(action.equalsIgnoreCase("estado")) {
           id=Integer.parseInt(request.getParameter("id"));
       String estado=EjercicioDao.getestado(id);
       if(estado.equalsIgnoreCase("Activo")){
           ej.setEstado("Desactivado");
       }else{
       ej.setEstado("Activo");
        
       }
        dao.Estado(ej,id);
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
