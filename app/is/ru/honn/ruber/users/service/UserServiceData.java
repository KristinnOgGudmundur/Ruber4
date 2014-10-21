package is.ru.honn.ruber.users.service;


import is.ru.honn.ruber.users.data.UserDataGateway;
import is.ru.honn.ruber.domain.User;

import java.util.Date;
import java.util.logging.Logger;

public class UserServiceData implements UserService
{

  private Logger log = Logger.getLogger(UserServiceData.class.getName());

  private UserDataGateway userDataGateway;

  public UserServiceData(UserDataGateway userDataGateway)
  {
    this.userDataGateway = userDataGateway;
  }

  @Override
  public User userSignup(String username, String firstName, String lastName, String password, String email, Date registered) throws UsernameExistsException
  {
    User user = new User(username, firstName, lastName, password, email, registered);
    int id = userDataGateway.addUser(user);
    user.setId(id);
    return user;
  }

  @Override
  public User getUser(String username) throws UserNotFoundException
  {
    User user = userDataGateway.getUserByUsername(username);
    if (user == null)
    {
      throw new UserNotFoundException("User not found: " + username);
    }
    return user;
  }

}
