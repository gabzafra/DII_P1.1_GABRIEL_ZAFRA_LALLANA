package dam2.dii.p11;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dam2.dii.p11.model.UserDb;
import dam2.dii.p11.model.Usuario;

@WebServlet("/admin")
public class Admins extends HttpServlet {
  private static final long serialVersionUID = 1L;
  private static final UserDb DB_USERS = UserDb.getInstance();

  public Admins() {
    super();
  }

  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String userName = request.getParameter("user");
    if (userName != null) {
      Usuario user = DB_USERS.getUserByName(new Usuario(userName, ""));
      user.setTrysLeft(3);
      DB_USERS.updateUser(user);
      request.setAttribute("users", DB_USERS.getAllUsers());
      request.getRequestDispatcher("admin.jsp").forward(request, response);
    }
  }
}
