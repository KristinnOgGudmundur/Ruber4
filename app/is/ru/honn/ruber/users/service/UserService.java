package is.ru.honn.ruber.users.service;

import is.ru.honn.ruber.domain.User;
import is.ru.honn.ruber.users.service.Exceptions.UserNotFoundException;
import is.ru.honn.ruber.users.service.Exceptions.UsernameExistsException;

import java.util.Date;

/**
 * dedicated service for users
 */
public interface UserService
{
    /**
     * Creates a new user in our database
     * @param username
     * username of user
     * @param firstName
     * first name of user
     * @param lastName
     * last name of user
     * @param password
     * password that the user picked
     * @param email
     * email of user
     * @param registered
     * the date for when the user was created
     * @return
     * User createdUser
     * @throws UsernameExistsException
     * Username is already taken
     */
	public User userSignup(	String username, String firstName, String lastName,
							String password, String email, Date registered)
							throws UsernameExistsException;

    /**
     * Fetches a user from database
     * @param username
     * username of user
     * @return
     * User user
     * @throws UserNotFoundException
     * No user found
     */
	public User getUser(String username) throws UserNotFoundException;

}
