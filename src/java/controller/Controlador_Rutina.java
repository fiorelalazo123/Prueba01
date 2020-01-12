
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Rutina;
import model.RutinaDao;

/**
 *
 * @author ELIAS
 */
@WebServlet(name = "Controlador_Rutina", urlPatterns = {"/Controlador_Rutina"})
public class Controlador_Rutina extends HttpServlet {

  String listar="rutina_listar.jsp";
    String add="rutina_add.jsp";
    String edit="rutina_edit.jsp";
    Rutina rut= new Rutina();
    RutinaDao dao=new RutinaDao();
    int id;
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Controlador_Clientes</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Controlador_Clientes at " + request.getContextPath() + "</h1>");
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
            String desc=request.getParameter("txtdescripcion");
            String fec_i=request.getParameter("txtfecha_i");
            String fec_f=request.getParameter("txtfecha_f");
            
          
            
            rut.setId(id);
            rut.setDescripcion(desc);
            rut.setFecha_inicio(fec_i);
            rut.setFecha_fin(fec_f);
            rut.setEstado("Activo");
            
            dao.add(rut);
            acceso=listar;
        }else if(action.equalsIgnoreCase("editar")){
            request.setAttribute("idrut", request.getParameter("id"));
            acceso=edit;
        }else if(action.equalsIgnoreCase("Actualizar")){
            int id=Integer.parseInt(request.getParameter("txtid"));
            String desc=request.getParameter("txtdescripcion");
            String fec_i=request.getParameter("txtfecha_i");
            String fec_f=request.getParameter("txtfecha_f");
            
            rut.setId(id);
            rut.setDescripcion(desc);
            rut.setFecha_inicio(fec_i);
            rut.setFecha_fin(fec_f);
      
            
            dao.edit(rut);
            acceso=listar;
            
        }else if(action.equalsIgnoreCase("estado")) {
           id=Integer.parseInt(request.getParameter("id"));
       String estado=RutinaDao.getestado(id);
       if(estado.equalsIgnoreCase("Activo")){
           rut.setEstado("Desactivado");
       }else{
       rut.setEstado("Activo");
        
       }
        dao.Estado(rut,id);
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
