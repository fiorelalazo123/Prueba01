package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import model.Ejercicio;
import model.EjercicioDao;
import model.Horario;
import model.HorarioDao;
import java.util.List;
import java.util.Iterator;
import model.Trabajador;
import model.Trabajador;
import model.Trabajador;
import model.TrabajadorDao;

public final class ejercicio_005flistar_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<html lang=\"es\">\n");
      out.write("<head>\n");
      out.write("    <title>Inicio</title>\n");
      out.write("    <meta charset=\"UTF-8\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("    <link rel=\"Shortcut Icon\" type=\"image/x-icon\" href=\"assets/icons/book.ico\" />\n");
      out.write("    <script src=\"js/sweet-alert.min.js\"></script>\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/sweet-alert.css\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/material-design-iconic-font.min.css\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/normalize.css\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/bootstrap.min.css\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/jquery.mCustomScrollbar.css\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/style.css\">\n");
      out.write("    <script src=\"//ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js\"></script>\n");
      out.write("    <script>window.jQuery || document.write('<script src=\"js/jquery-1.11.2.min.js\"><\\/script>')</script>\n");
      out.write("    <script src=\"js/modernizr.js\"></script>\n");
      out.write("    <script src=\"js/bootstrap.min.js\"></script>\n");
      out.write("    <script src=\"js/jquery.mCustomScrollbar.concat.min.js\"></script>\n");
      out.write("    <script src=\"js/main.js\"></script>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    <div class=\"navbar-lateral full-reset\">\n");
      out.write("        <div class=\"visible-xs font-movile-menu mobile-menu-button\"></div>\n");
      out.write("        <div class=\"full-reset container-menu-movile custom-scroll-containers\">\n");
      out.write("            <div class=\"logo full-reset all-tittles\">\n");
      out.write("                <i class=\"visible-xs zmdi zmdi-close pull-left mobile-menu-button\" style=\"line-height: 55px; cursor: pointer; padding: 0 10px; margin-left: 7px;\"></i> \n");
      out.write("                sistema administrativo\n");
      out.write("            </div>\n");
      out.write("            <div class=\"full-reset\" style=\"background-color:#2B3D51; padding: 10px 0; color:#fff;\">\n");
      out.write("                <figure>\n");
      out.write("                    <img src=\"assets/img/picture1464269584591.png\" alt=\"Biblioteca\" class=\"img-responsive center-box\" style=\"width:85%;\">\n");
      out.write("                </figure>\n");
      out.write("  \n");
      out.write("            </div>\n");
      out.write("            <div class=\"full-reset nav-lateral-list-menu\">\n");
      out.write("                <ul class=\"list-unstyled\">\n");
      out.write("                    <li><a href=\"Principal.jsp\"><i class=\"zmdi zmdi-home zmdi-hc-fw\"></i>&nbsp;&nbsp; Inicio</a></li>\n");
      out.write("                    <li>\n");
      out.write("                        <div class=\"dropdown-menu-button\"><i class=\"zmdi zmdi-case zmdi-hc-fw\"></i>&nbsp;&nbsp; Mantenimientos <i class=\"zmdi zmdi-chevron-down pull-right zmdi-hc-fw\"></i></div>\n");
      out.write("                        <ul class=\"list-unstyled\">\n");
      out.write("                          <li><a href=\"client_listar.jsp\"><i class=\"zmdi zmdi-balance zmdi-hc-fw\"></i>&nbsp;&nbsp; Cliente</a></li>\n");
      out.write("                            <li><a href=\"trab_listar.jsp\"><i class=\"zmdi zmdi-balance zmdi-hc-fw\"></i>&nbsp;&nbsp; Empleados</a></li>\n");
      out.write("                            <li><a href=\"equipos_listar.jsp\"><i class=\"zmdi zmdi-truck zmdi-hc-fw\"></i>&nbsp;&nbsp; Equipos </a></li>\n");
      out.write("                            <li><a href=\"ejercicio_listar.jsp\"><i class=\"zmdi zmdi-bookmark-outline zmdi-hc-fw\"></i>&nbsp;&nbsp; Rutina</a></li>\n");
      out.write("                            <li><a href=\"hor_listar.jsp\"><i class=\"zmdi zmdi-assignment-account zmdi-hc-fw\"></i>&nbsp;&nbsp; Horario</a></li>\n");
      out.write("                       </ul>\n");
      out.write("                    </li>\n");
      out.write("                    <li>\n");
      out.write("                        <div class=\"dropdown-menu-button\"><i class=\"zmdi zmdi-account-add zmdi-hc-fw\"></i>&nbsp;&nbsp; Registro de Trabajadores <i class=\"zmdi zmdi-chevron-down pull-right zmdi-hc-fw\"></i></div>\n");
      out.write("                        <ul class=\"list-unstyled\">\n");
      out.write("                            <li><a href=\"admin.html\"><i class=\"zmdi zmdi-face zmdi-hc-fw\"></i>&nbsp;&nbsp; Nuevo administrador</a></li>\n");
      out.write("                            <li><a href=\"teacher.html\"><i class=\"zmdi zmdi-male-alt zmdi-hc-fw\"></i>&nbsp;&nbsp; Nuevo entrenador</a></li>\n");
      out.write("                            <li><a href=\"student.html\"><i class=\"zmdi zmdi-accounts zmdi-hc-fw\"></i>&nbsp;&nbsp; Nuevo recepcionista</a></li>\n");
      out.write("                            <li><a href=\"personal.html\"><i class=\"zmdi zmdi-male-female zmdi-hc-fw\"></i>&nbsp;&nbsp; Nuevo almacenero</a></li>\n");
      out.write("                        </ul>\n");
      out.write("                    </li>\n");
      out.write("                    <li>\n");
      out.write("                        <div class=\"dropdown-menu-button\"><i class=\"zmdi zmdi-assignment-o zmdi-hc-fw\"></i>&nbsp;&nbsp; Inscripción <i class=\"zmdi zmdi-chevron-down pull-right zmdi-hc-fw\"></i></div>\n");
      out.write("                        <ul class=\"list-unstyled\">\n");
      out.write("                            <li><a href=\"book.html\"><i class=\"zmdi zmdi-book zmdi-hc-fw\"></i>&nbsp;&nbsp; Nuevo</a></li>\n");
      out.write("                            <li><a href=\"catalog.html\"><i class=\"zmdi zmdi-bookmark-outline zmdi-hc-fw\"></i>&nbsp;&nbsp; Catálogo</a></li>\n");
      out.write("                        </ul>\n");
      out.write("                    </li>\n");
      out.write("                    <li>\n");
      out.write("                        <div class=\"dropdown-menu-button\"><i class=\"zmdi zmdi-alarm zmdi-hc-fw\"></i>&nbsp;&nbsp; Préstamos y reservaciones <i class=\"zmdi zmdi-chevron-down pull-right zmdi-hc-fw\"></i></div>\n");
      out.write("                        <ul class=\"list-unstyled\">\n");
      out.write("                            <li><a href=\"loan.html\"><i class=\"zmdi zmdi-calendar zmdi-hc-fw\"></i>&nbsp;&nbsp; Todos los préstamos</a></li>\n");
      out.write("                            <li>\n");
      out.write("                                <a href=\"loanpending.html\"><i class=\"zmdi zmdi-time-restore zmdi-hc-fw\"></i>&nbsp;&nbsp; Devoluciones pendientes <span class=\"label label-danger pull-right label-mhover\">7</span></a>\n");
      out.write("                            </li>\n");
      out.write("                            <li>\n");
      out.write("                                <a href=\"loanreservation.html\"><i class=\"zmdi zmdi-timer zmdi-hc-fw\"></i>&nbsp;&nbsp; Reservaciones <span class=\"label label-danger pull-right label-mhover\">7</span></a>\n");
      out.write("                            </li>\n");
      out.write("                        </ul>\n");
      out.write("                    </li>\n");
      out.write("                    <li><a href=\"report.html\"><i class=\"zmdi zmdi-trending-up zmdi-hc-fw\"></i>&nbsp;&nbsp; Reportes y estadísticas</a></li>\n");
      out.write("                    <li><a href=\"advancesettings.html\"><i class=\"zmdi zmdi-wrench zmdi-hc-fw\"></i>&nbsp;&nbsp; Configuraciones avanzadas</a></li>\n");
      out.write("                </ul>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("    <div class=\"content-page-container full-reset custom-scroll-containers\">\n");
      out.write("        <nav class=\"navbar-user-top full-reset\">\n");
      out.write("            <ul class=\"list-unstyled full-reset\">\n");
      out.write("                <figure>\n");
      out.write("                   <img src=\"assets/img/user01.png\" alt=\"user-picture\" class=\"img-responsive img-circle center-box\">\n");
      out.write("                </figure>\n");
      out.write("                <li style=\"color:#fff; cursor:default;\">\n");
      out.write("                    <span class=\"all-tittles\">Elias Gonzales</span>\n");
      out.write("                </li>\n");
      out.write("                <li  class=\"tooltips-general exit-system-button\" data-href=\"index.html\" data-placement=\"bottom\" title=\"Salir del sistema\">\n");
      out.write("                    <i class=\"zmdi zmdi-power\"></i>\n");
      out.write("                </li>\n");
      out.write("                <li  class=\"tooltips-general search-book-button\" data-href=\"searchbook.html\" data-placement=\"bottom\" title=\"Buscar libro\">\n");
      out.write("                    <i class=\"zmdi zmdi-search\"></i>\n");
      out.write("                </li>\n");
      out.write("                <li  class=\"tooltips-general btn-help\" data-placement=\"bottom\" title=\"Ayuda\">\n");
      out.write("                    <i class=\"zmdi zmdi-help-outline zmdi-hc-fw\"></i>\n");
      out.write("                </li>\n");
      out.write("                <li class=\"mobile-menu-button visible-xs\" style=\"float: left !important;\">\n");
      out.write("                    <i class=\"zmdi zmdi-menu\"></i>\n");
      out.write("                </li>\n");
      out.write("            </ul>\n");
      out.write("        </nav>\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <div class=\"page-header\">\n");
      out.write("              <h1 class=\"all-tittles\">Listado - Horario</h1>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        \n");
      out.write("        \n");
      out.write("        \n");
      out.write("         <div class=\"container\">            \n");
      out.write("            <a class=\"btn btn-success\" href=\"Controlador_Horario?accion=add\">Agregar Horario</a>\n");
      out.write("            <div style=\"padding-left: 800px\">                  \n");
      out.write("                <input type=\"text\" class=\"form-control\" value=\"Buscar\"/>                            \n");
      out.write("            </div>\n");
      out.write("        </div>  \n");
      out.write("              \n");
      out.write("        <br><div class=\"container\">               \n");
      out.write("            <!--<a  class=\"btn btn-success\" href=\"Agregar.jsp\">Nuevo Registro</a> Esto es Cuando se Crea un nuevo Archivo Agregar.jsp -->         \n");
      out.write("             <table class=\"table table-bordered\"  id=\"tablaDatos\">\n");
      out.write("                    <thead>\n");
      out.write("                        <tr>\n");
      out.write("                            <th class=\"text-center\">Id</th>\n");
      out.write("                            <th class=\"text-center\">Nombre</th>\n");
      out.write("                            <th class=\"text-center\">Musculo</th>\n");
      out.write("                            <th class=\"text-center\">Estado</th>    \n");
      out.write("                            <th class=\"text-center\">Acciones</th>\n");
      out.write("                        </tr>\n");
      out.write("                    </thead>\n");
      out.write("                    ");

                    EjercicioDao dao=new EjercicioDao();
                    List<Ejercicio>list=dao.listar();
                    Iterator<Ejercicio>iter=list.iterator();
                    Ejercicio ej=null;
                    while(iter.hasNext()){
                        ej=iter.next();
                    
                
      out.write("\n");
      out.write("                    \n");
      out.write("                    \n");
      out.write("                    \n");
      out.write("                    <tbody>\n");
      out.write("                      \n");
      out.write("                        <tr>\n");
      out.write("                            <td class=\"text-center\">");
      out.print( ej.getId());
      out.write("</td>\n");
      out.write("                            <td class=\"text-center\">");
      out.print( ej.getNombre());
      out.write("</td>\n");
      out.write("                            <td class=\"text-center\">");
      out.print( ej.getMusculo());
      out.write("</td>\n");
      out.write("                            ");
 String Estado=EjercicioDao.getestado(ej.getId());
                                                         if(Estado.equalsIgnoreCase("Activo")){ 
      out.write("\n");
      out.write("                                                             \n");
      out.write("                                                              <td class=\"text-center text-success\"><markactivo>");
      out.print(Estado );
      out.write("</markactivo></td>   \n");
      out.write("                                                          ");
   }else{ 
      out.write("\n");
      out.write("                                                                \n");
      out.write("                                                                 <td class=\"text-center text-danger\"><markdesactivado>");
      out.print( Estado );
      out.write("</markdesactivado></td>    \n");
      out.write("                                                        ");
     }
                                                        
      out.write(" \n");
      out.write("                            <td class=\"text-center\">\n");
      out.write("                                \n");
      out.write("                                <!-- <input type=\"hidden\" value=\"<//%= rs.getInt(\"Id_Usuario\")%>\" id=\"Editar\"/>\n");
      out.write("                                <input type=\"submit\" class=\"btn btn-warning\" data-toggle=\"modal\" data-target=\"#myModal1\" value=\"Editar\"/>  -->\n");
      out.write("                                <a href=\"Controlador_Ejercicios?accion=editar&id=");
      out.print(ej.getId());
      out.write("\" class=\"btn btn-primary\">Editar</a>\n");
      out.write("                                <a href=\"Controlador_Ejercicios?accion=estado&id=");
      out.print(ej.getId());
      out.write("\" class=\"btn btn-danger\">Delete</a>\n");
      out.write("                            </td>\n");
      out.write("                        </tr>\n");
      out.write("                        ");
}
      out.write("\n");
      out.write("                                        </tbody>\n");
      out.write("\n");
      out.write("                </table>\n");
      out.write("            </div>\n");
      out.write("                   \n");
      out.write("                            </div>\n");
      out.write("                   \n");
      out.write("                            \n");
      out.write("                                               \n");
      out.write("</body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
