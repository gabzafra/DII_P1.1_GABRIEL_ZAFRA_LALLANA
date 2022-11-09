package dam2.dii.p11;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dam2.dii.p11.model.UserDb;
import dam2.dii.p11.model.Usuario;

@WebServlet({"/users"})
public class Users extends HttpServlet {
  private static final long serialVersionUID = 1L;
  private static final UserDb DB_USERS = UserDb.getInstance();



  public Users() {
    super();
  }


  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    Usuario user = new Usuario(request.getParameter("user"), request.getParameter("pass"));

    String passConfirmation = request.getParameter("pass2");

    if (!user.getPassword().equals(passConfirmation)) {
      // Passwords don't match
      request.setAttribute("error", "Las claves introducidas no coinciden.");
      request.setAttribute("name", user.getName());
      request.getRequestDispatcher("index.jsp").forward(request, response);
    } else {
      // Peticion a la Bd
      Usuario foundUser = DB_USERS.getUserByName(user);
      if (foundUser.getName().length() > 0) {
        if (foundUser.getTrysLeft() > 0) {
          if (!user.getPassword().equals(foundUser.getPassword())) {
            // Autentication fails
            foundUser.setTrysLeft(foundUser.getTrysLeft() - 1);
            foundUser = DB_USERS.updateUser(foundUser);
            request.setAttribute("error", "La clave introducida no es válida. Le quedan "
                + foundUser.getTrysLeft() + " intentos.");
            request.setAttribute("name", user.getName());
            request.getRequestDispatcher("index.jsp").forward(request, response);
          } else {
            // Autentication OK
            if (foundUser.getName().equals("admin")) {
              // Admin user
              request.setAttribute("users", DB_USERS.getAllUsers());
              request.getRequestDispatcher("admin.jsp").forward(request, response);
            } else {
              // Normal user
              request.setAttribute("name", foundUser.getName());
              request.getRequestDispatcher("saludo.jsp").forward(request, response);
            }
          }
        } else {
          // User is blocked
          request.setAttribute("error",
              "El usuario " + user.getName() + " esta bloqueado. Contacte con un administrador.");
          request.setAttribute("name", user.getName());
          request.getRequestDispatcher("index.jsp").forward(request, response);
        }
      } else {
        // Username don't match
        request.setAttribute("error", "El usuario introducido no existe.");
        request.setAttribute("name", user.getName());
        request.getRequestDispatcher("index.jsp").forward(request, response);
      }
    }
  }
}
