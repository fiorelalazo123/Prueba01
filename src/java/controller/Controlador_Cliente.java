
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Cliente;
import model.ClienteDao;

/**
 *
 * @author ELIAS
 */
@WebServlet(name = "Controlador_Cliente", urlPatterns = {"/Controlador_Cliente"})
public class Controlador_Cliente extends HttpServlet {

  String listar="client_listar.jsp";
    String add="client_add.jsp";
    String edit="client_edit.jsp";
    Cliente cli= new Cliente();
    ClienteDao dao=new ClienteDao();
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
            String nom=request.getParameter("txtnombre");
            String ape=request.getParameter("txtapellido");
            String cor=request.getParameter("txtcorreo");
            String cel=request.getParameter("txtcel");
            String dni=request.getParameter("txtdni");
            String edad=request.getParameter("txtedad");
            
            cli.setId(id);
            cli.setNombre(nom);
            cli.setApellido(ape);
            cli.setCorreo(cor);
            cli.setCelular(cel);
            cli.setDni(dni);
            cli.setEdad(edad);
            cli.setEstado("Activo");
            dao.add(cli);
            acceso=listar;
        }else if(action.equalsIgnoreCase("editar")){
            request.setAttribute("idcli", request.getParameter("id"));
            acceso=edit;
        }else if(action.equalsIgnoreCase("Actualizar")){
            id=Integer.parseInt(request.getParameter("txtid"));
            String nom=request.getParameter("txtnombre");
            String ape=request.getParameter("txtapellido");
            String cor=request.getParameter("txtcorreo");
            String cel=request.getParameter("txtcel");
            String dni=request.getParameter("txtdni");
            String edad=request.getParameter("txtedad");
            
            cli.setId(id);
            cli.setNombre(nom);
            cli.setApellido(ape);
            cli.setCorreo(cor);
            cli.setCelular(cel);
            cli.setDni(dni);
            cli.setEdad(edad);
            
            dao.edit(cli);
            acceso=listar;
            
        }else if(action.equalsIgnoreCase("estado")) {
           id=Integer.parseInt(request.getParameter("id"));
       String estado=ClienteDao.getestado(id);
       if(estado.equalsIgnoreCase("Activo")){
           cli.setEstado("Desactivado");
       }else{
       cli.setEstado("Activo");
        
       }
        dao.Estado(cli,id);
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
