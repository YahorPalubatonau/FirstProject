package dataBase;

import java.sql.*;

public class DataBase {
    private String result;

    public String createQuery(String query, int id) {
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/data_for_mail_ru?serverTimezone=UTC", "root", "Шыффс96Ыщдуы13");
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(query)) {
            if (rs.next()) {
                result = rs.getString(id);
            }
        } catch (SQLException ex) {
            System.out.println("Connection failed");
            ex.printStackTrace();
        }
        return result;
    }
}