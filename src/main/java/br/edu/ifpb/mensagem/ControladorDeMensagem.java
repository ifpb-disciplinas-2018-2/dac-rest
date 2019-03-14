package br.edu.ifpb.mensagem;

import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ricardo Job
 */
@WebServlet(name = "Mensagem",urlPatterns = {"/msg"})
public class ControladorDeMensagem extends HttpServlet {

    @EJB
    private ClienteDeMensagens cliente;

    @Override
    protected void doGet(HttpServletRequest request,HttpServletResponse response)
        throws ServletException,IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Mensagem</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Mensagem at " + request.getContextPath() + "</h1>");
            String destino = request.getParameter("destinatario");
            out.println("<p>  " + this.cliente.ler(destino) + "</p>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request,HttpServletResponse response)
        throws ServletException,IOException {
        String destinatario = request.getParameter("destinatario");
        String corpo = request.getParameter("corpo");
        String resposta = cliente.enviarMensagem(destinatario,corpo);
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Mensagem</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<p>Id: " + resposta + "</p>");
            out.println("</body>");
            out.println("</html>");
        }
    }

}
