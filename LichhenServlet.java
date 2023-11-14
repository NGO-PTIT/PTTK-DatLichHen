package DKLH;

import java.io.IOException;

import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/")
public class LichhenServlet extends HttpServlet {
    private LichhenDAO lichhenDAO;
    
    public void init(){
       lichhenDAO = new LichhenDAO();
   }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getServletPath();
        
        try {
            switch (action){
                case "/new":
                    showNewForm(req, resp);
                    break;
                case "/insert":
                    insertLH(req, resp);
                    break;
                case "/edit":
                    showEditForm(req, resp);
                    break;
                case "/update":
                    updateLH(req, resp);
                    break;
                case "/list":
                    listLH(req, resp);
                    break;
                default:
                    trangchuKH(req, resp);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }
    
    public void trangchuKH(HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
        RequestDispatcher dispatcher = request.getRequestDispatcher("TrangchuKH.jsp");
        dispatcher.forward(request, response);
    }
        
    public void listLH(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException, ServletException {
        List < Lichhen > listLH = lichhenDAO.selectAllLH();
        request.setAttribute("listLH", listLH);
        RequestDispatcher dispatcher = request.getRequestDispatcher("danhsachlichhen.jsp");
        dispatcher.forward(request, response);
    } 
        
    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("lichhen-form.jsp");
        dispatcher.forward(request, response);
    }
    
    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, ServletException, IOException {
        String STT = request.getParameter("id");
        Integer id = Integer.valueOf(STT);
        Lichhen existingLH = lichhenDAO.selectLH(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("lichhen-form.jsp");
        request.setAttribute("lh", existingLH);
        dispatcher.forward(request, response);

    }  
    
    public void insertLH(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException {
        String date = request.getParameter("ngay");
        String time = request.getParameter("gio");
        String name = request.getParameter("tenKH");
        String email = request.getParameter("email");
        String phone = request.getParameter("dienthoai");
        String note = request.getParameter("ghichu");
        
        List < Lichhen > listLH = lichhenDAO.selectAllLH();
        Integer id = listLH.size() + 1;

        Lichhen appointment = new Lichhen(id, date, time, name, email, phone, note);
        
        lichhenDAO.insertAppointment(appointment);
        response.sendRedirect("datthanhcong.jsp");
    }
    
    private void updateLH(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException {
        
        String date = request.getParameter("ngay");
        String time = request.getParameter("gio");
        String name = request.getParameter("tenKH");
        String email = request.getParameter("email");
        String phone = request.getParameter("dienthoai");
        String note = request.getParameter("ghichu");
        
        Lichhen newappointment = new Lichhen(1, date, time, name, email, phone, note);

        lichhenDAO.updateLH(newappointment);
        response.sendRedirect("/PTTK1/list");
    }

}

