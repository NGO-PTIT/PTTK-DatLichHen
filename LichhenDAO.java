package DKLH;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LichhenDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/demopttk?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "17032002";
    
    private static final String INSERT_lichhen_SQL = "INSERT INTO lich_hen" + "  (id, ngay, gio, ten, email, dienthoai, ghichu) VALUES " + " (?, ?, ?, ?, ?, ?, ?);";
    private static final String SELECT_lichhen_SQL = "select ngay, gio, ten, email, dienthoai, ghichu from lich_hen where id = ?";
    private static final String SELECT_ALL_lichhen_SQL = "select * from lich_hen";
    private static final String UPDATE_lichhen_SQL = "update lich_hen set ngay =?, gio=?, ten=?, email=?, dienthoai=?, ghichu=?  where id = ?;";
    
    public LichhenDAO(){}
    
    protected  Connection getConnection(){
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }
    
    public void insertAppointment(Lichhen appointment) throws SQLException {

        try (Connection connection = getConnection(); 
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_lichhen_SQL)) {
            
            preparedStatement.setInt(1, appointment.getId());
            preparedStatement.setString(2, appointment.getNgay());
            preparedStatement.setString(3, appointment.getGio());
            preparedStatement.setString(4, appointment.getTenKH());
            preparedStatement.setString(5, appointment.getEmail());
            preparedStatement.setString(6, appointment.getDienthoai());
            preparedStatement.setString(7, appointment.getGhichu());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public Lichhen selectLH(Integer ID) {
        Lichhen lh = null;
        try (Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_lichhen_SQL);) {
            preparedStatement.setInt(1, ID);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                
                String ngay = rs.getString("ngay");
                String gio= rs.getString("gio");
                String tenKH = rs.getString("ten");
                String email = rs.getString("email");
                String dienthoai = rs.getString("dienthoai");
                String ghichu = rs.getString("ghichu");

                lh = new Lichhen(ID, ngay, gio, tenKH, email, dienthoai, ghichu);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lh;
    }
    
    public List < Lichhen > selectAllLH() {

        List < Lichhen > lhlist = new ArrayList < > ();
        
        try (Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_lichhen_SQL);) {
            
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Integer id = rs.getInt("id");
                String ngay = rs.getString("ngay");
                String gio= rs.getString("gio");
                String tenKH = rs.getString("ten");
                String email = rs.getString("email");
                String dienthoai = rs.getString("dienthoai");
                String ghichu = rs.getString("ghichu");
                
                lhlist.add(new Lichhen(id, ngay, gio, tenKH, email, dienthoai, ghichu));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lhlist;
    }
    
    public boolean updateLH(Lichhen lh) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection(); 
                PreparedStatement statement = connection.prepareStatement(UPDATE_lichhen_SQL)){

            statement.setString(1, lh.getNgay());
            statement.setString(2, lh.getGio());
            statement.setString(3, lh.getTenKH());
            statement.setString(4, lh.getEmail());
            statement.setString(5, lh.getDienthoai());
            statement.setString(6, lh.getGhichu());
            statement.setInt(7, lh.getId());

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }
    


}
