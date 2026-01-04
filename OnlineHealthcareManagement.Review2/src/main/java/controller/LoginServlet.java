
package controller;
import util.DBUtil;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.*;

public class LoginServlet extends HttpServlet {
 protected void doPost(HttpServletRequest req, HttpServletResponse res)
 throws ServletException, IOException {
  String u=req.getParameter("username");
  String p=req.getParameter("password");
  try {
   Connection c=DBUtil.getConnection();
   PreparedStatement ps=c.prepareStatement(
    "select * from users where username=? and password=?");
   ps.setString(1,u); ps.setString(2,p);
   ResultSet rs=ps.executeQuery();
   if(rs.next()){
    HttpSession s=req.getSession();
    s.setAttribute("user",u);
    res.sendRedirect("dashboard.jsp");
   } else {
    res.sendRedirect("login.jsp?error=1");
   }
  } catch(Exception e){ throw new ServletException(e); }
 }
}
