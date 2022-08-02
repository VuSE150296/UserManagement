/*
 Asing* To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import sample.utils.DBUtils;

/**
 *
 * @author Vu Dang
 */
public class UserDAO {

    private static final String LOGIN = "SELECT userID FROM tblUsers WHERE userID=? AND password=?";

    public String checkLogin(String userID, String password) throws SQLException {
        String fullName = "";
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            String sql = "SELECT fullName"
                    + " FROM tblUsers"
                    + " WHERE userID='" + userID + "'AND password='" + password + "'";
            ptm = conn.prepareStatement(sql);
            rs = ptm.executeQuery();
            if (rs.next()) {
                fullName = rs.getString("fullName");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return fullName;
    }

    public List<UserDTO> getListUser(String search) throws SQLException {
        List<UserDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "SELECT userID, fullName, roleID"
                        + " FROM tblUsers"
                        + " WHERE fullName LIKE ?";
                ptm = conn.prepareStatement(sql);
                ptm.setString(1, "%" + search + "%");
                rs = ptm.executeQuery();
                while (rs.next()) {
                    String userID = rs.getString("userID");
                    String fullName = rs.getString("fullName");
                    String roleID = rs.getString("roleID");
                    String password = "***";
                    list.add(new UserDTO(userID, fullName, roleID, password));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return list;
    }
}
