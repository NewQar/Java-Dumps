import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ChangePasswordServlet")
public class ChangePasswordServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final String DB_URL = "jdbc:mysql://localhost:3306/Account";
    private static final String DB_USER = "username";
    private static final String DB_PASS = "password";

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String oldPassword = request.getParameter("oldpassword");
        String newPassword = request.getParameter("newpassword");
        String confirmNewPassword = request.getParameter("confirmpassword");

        if (newPassword.equals(confirmNewPassword)) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);

                PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Account WHERE username = ? AND password = ?");
                stmt.setString(1, username);
                stmt.setString(2, oldPassword);
                ResultSet rs = stmt.executeQuery();

                if (rs.next()) {
                    stmt = conn.prepareStatement("UPDATE Account SET password = ? WHERE username = ?");
                    stmt.setString(1, newPassword);
                    stmt.setString(2, username);
                    stmt.executeUpdate();
                    response.getWriter().println("Password updated successfully!");
                } else {
                    response.getWriter().println("Invalid username or password.");
                }

                conn.close();
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        } else {
            response.getWriter().println("New password and confirmed password do not match.");
        }
    }
}
