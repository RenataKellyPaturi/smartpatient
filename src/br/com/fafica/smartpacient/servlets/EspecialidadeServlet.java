package br.com.fafica.smartpacient.servlets;


import br.com.fafica.smartpacient.control.EspecialidadeService;
import br.com.fafica.smartpacient.entity.impl.Especialidade;
import com.google.gson.Gson;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


/**
 * Servlet implementation class DicaServlet
 */
@WebServlet("/especialidadeServlet")
public class EspecialidadeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private EspecialidadeService especialidadeControl = new EspecialidadeService();


    /**
     * @see HttpServlet#HttpServlet()
     */
    public EspecialidadeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }




    /**
     * @see Servlet#init(ServletConfig)
     */
    public void init(ServletConfig config) throws ServletException {
        // TODO Auto-generated method stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        String action = request.getParameter("action");
        List<Especialidade> esplist;
        Especialidade esp;
        String json = null;

        switch (action) {

            case "listar":

                esplist = especialidadeControl.listAllActive();

                json = new Gson().toJson(esplist);

                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");
                response.getWriter().write(json);

                break;

            case "inativar":


                break;

            case "ativar":

                break;

            case "procurar":

                break;

        }

    }


}
