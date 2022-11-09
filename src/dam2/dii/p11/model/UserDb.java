package dam2.dii.p11.model;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public final class UserDb {
  private static UserDb instance;
  private HashMap<String, Usuario> userList;

  public UserDb() {
    this.userList = new HashMap<String, Usuario>();
    this.initDb();
  }

  public static UserDb getInstance() {
    if (instance == null) {
      instance = new UserDb();
    }
    return instance;
  }

  public Usuario addNewUser(Usuario user) {
    Usuario newUser = deepCopyUser(user);
    return userList.put(newUser.getName(), newUser) != null ? newUser : new Usuario();
  }

  public Usuario getUserByName(Usuario user) {
    Usuario foundUser = userList.get(user.getName());
    return foundUser != null ? deepCopyUser(foundUser) : new Usuario();
  }

  public HashMap<String, Usuario> getAllUsers() {
    Map<String, Usuario> usersMap = userList.entrySet().stream()
        .collect(Collectors.toMap(e -> e.getKey(), e -> deepCopyUser(e.getValue())));
    return (HashMap<String, Usuario>) usersMap;
  }

  public Usuario updateUser(Usuario user) {
    userList.put(user.getName(), deepCopyUser(user));
    Usuario updatedUser = userList.get(user.getName());
    return updatedUser != null ? updatedUser : new Usuario();
  }

  public boolean deleteUser(Usuario user) {
    return userList.remove(user.getName()) != null;
  }

  private Usuario deepCopyUser(Usuario user) {
    return new Usuario(user.getName(), user.getPassword(), user.getTrysLeft());
  }

  public void initDb() {
    userList.put("admin", new Usuario("admin", "admin", 3));
    userList.put("betty", new Usuario("betty", "bbbb", 0));
    userList.put("charlie", new Usuario("charlie", "cccc", 1));
    userList.put("diane", new Usuario("diane", "dddd", 3));
    userList.put("eddie", new Usuario("eddie", "eeee", 0));
    userList.put("felicia", new Usuario("felicia", "ffff", 0));
  }
}
