package is.ru.honn.ruber.drivers.data.ReviewData;

import is.ru.honn.ruber.domain.Review;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * RowMapper for ru_reviews database
 */
public class ReviewRowMapper implements RowMapper<Review>{

    public Review mapRow(ResultSet rs, int rowNum) throws SQLException
    {
        Review review = new Review(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getString(4),rs.getInt(5));

        return review;
    }
}
