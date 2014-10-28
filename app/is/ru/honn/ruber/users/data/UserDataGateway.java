package is.ru.honn.ruber.users.data;

import is.ru.honn.ruber.domain.User;
import is.ruframework.data.RuDataAccess;

/**
 * Gateway for ru_users database
 */
public interface UserDataGateway extends RuDataAccess
{
    /**
     * Adds user to database
     * @param user
     * The user to be added
     * @return
     * int userId
     */
    public int addUser(User user);

    /**
     * Fetches user for a give username
     * @param username
     * username of user
     * @return
     * User user
     */
    public User getUserByUsername(String username);
}