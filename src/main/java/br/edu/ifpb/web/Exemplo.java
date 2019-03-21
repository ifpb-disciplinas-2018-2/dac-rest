package br.edu.ifpb.web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ricardo Job
 */
@WebServlet(name = "Exemplo",urlPatterns = {"/exemplo"})
public class Exemplo extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request,HttpServletResponse response)
        throws ServletException,IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Exemplo</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Exemplo at " + request.getContextPath() + "</h1>");
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
    protected void doGet(HttpServletRequest request,HttpServletResponse response)
        throws ServletException,IOException {
        processRequest(request,response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request,HttpServletResponse response)
        throws ServletException,IOException {
        response.setContentType("application/json;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("{\n"
                + "            \"nome\": \"Job\",\n"
                + "            \"idade\":30\n"
                + "        \n"
                + "        }");
        }

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

//        String uri = "http://localhost:8080/dac-webservice/api/produtos";
//        Client client = ClientBuilder.newClient();
        //register(new VendaAuthorization("admin", "mesmacoisa"));
//        WebTarget root = client.target(uri); // root
//        this.mensagem = root.request().get(String.class);
//        JsonObject get = root.request().get(JsonObject.class);
//        JsonReader reader = Json.createReader(
//            new StringReader(mensagem)
//        );
//        JsonArray array = reader.readArray();
//        //System.out.println("array = " + array);
//        Jsonb create = JsonbBuilder.create();
//        List<Produto> collect = array.stream()
//                .map(obj->create.fromJson(obj.toString(), Produto.class))
//                .collect(Collectors.toList());
//        collect.forEach(System.out::println);