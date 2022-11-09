package dam2.dii.p11.model;

public class Usuario {
  private String name;
  private String password;
  private int trysLeft;

  public Usuario() {
    this("", "");
  }

  public Usuario(String name, String password) {
    this(name, password, 3);
  }

  public Usuario(String name, String password, int trysLeft) {
    this.name = name;
    this.password = password;
    this.trysLeft = trysLeft;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public int getTrysLeft() {
    return trysLeft;
  }

  public void setTrysLeft(int trysLeft) {
    this.trysLeft = trysLeft;
  }
}
