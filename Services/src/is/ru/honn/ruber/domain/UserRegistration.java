package is.ru.honn.ruber.domain;

import java.util.Date;

public class UserRegistration extends User
{
  protected String repeatPassword;

  public UserRegistration()
  {
  }

  public UserRegistration(int id, String username, String firstName, String lastName, String password, String email, Date registered, String repeatPassword)
  {
    super(id, username, firstName, lastName, password, email, registered);
    this.repeatPassword = repeatPassword;
  }

  public UserRegistration(String username, String firstname, String lastname, String password, String email, Date registered, String repeatPassword)
  {
    super(username, firstname, lastname, password, email, registered);
    this.repeatPassword = repeatPassword;
  }

  public String getRepeatPassword()
  {
    return repeatPassword;
  }

  public void setRepeatPassword(String repeatPassword)
  {
    this.repeatPassword = repeatPassword;
  }
}
