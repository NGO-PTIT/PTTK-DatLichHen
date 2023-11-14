package DKLH;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="login", urlPatterns={"/login"})
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        login(req,resp);
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("login.jsp");
        dispatcher.forward(req, resp);
    }
    
    public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        
        String jdbcURL = "jdbc:mysql://localhost:3306/demopttk?useSSL=false";
        String jdbcUsername = "root";
        String jdbcPassword = "17032002";
        
        String SELECT_SQL = "select * from thanhvien";
        
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        int checklogin = 0;
        
        try (
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_SQL);) {
            
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String user = rs.getString("username");
                String pass = rs.getString("password");
                
                System.out.println(user);
                if(user.equals(username)==true && pass.equals(password)==true){
                    checklogin = 1;
                }
            }
            if(checklogin==1){
                response.sendRedirect("TrangchuKH.jsp");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
