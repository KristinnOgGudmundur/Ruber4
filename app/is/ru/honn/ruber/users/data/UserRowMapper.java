package is.ru.honn.ruber.users.data;

import is.ru.honn.ruber.domain.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<User>
{
  public User mapRow(ResultSet rs, int rowNum) throws SQLException
  {
    return  new User(rs.getInt(1),      // id
                     rs.getString(2),   // username
                     rs.getString(3),   // firstname
                     rs.getString(4),   // lastname
                     rs.getString(5),   // password
                     rs.getString(6),   // email
                     rs.getDate(7)      // registered
        );
  }
}
