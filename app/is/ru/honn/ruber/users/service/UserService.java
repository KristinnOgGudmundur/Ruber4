package is.ru.honn.ruber.users.service;

import is.ru.honn.ruber.domain.User;
import is.ru.honn.ruber.users.service.Exceptions.UserNotFoundException;
import is.ru.honn.ruber.users.service.Exceptions.UsernameExistsException;

import java.util.Date;

public interface UserService
{
	public User userSignup(	String username, String firstName, String lastName,
							String password, String email, Date registered)
							throws UsernameExistsException;

	public User getUser(String username) throws UserNotFoundException;

}
