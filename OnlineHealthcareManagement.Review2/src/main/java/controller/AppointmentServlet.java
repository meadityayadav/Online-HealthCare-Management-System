
package controller;
import util.DBUtil;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.*;

public class AppointmentServlet extends HttpServlet {
 protected void doPost(HttpServletRequest req, HttpServletResponse res)
 throws ServletException, IOException {
  try {
   Connection c=DBUtil.getConnection();
   PreparedStatement ps=c.prepareStatement(
    "insert into appointments(patient,doctor,date) values(?,?,?)");
   ps.setString(1,req.getParameter("patient"));
   ps.setString(2,req.getParameter("doctor"));
   ps.setString(3,req.getParameter("date"));
   ps.executeUpdate();
   res.sendRedirect("dashboard.jsp");
  } catch(Exception e){ throw new ServletException(e); }
 }
}
