package is.ru.honn.ruber.drivers.data.ReviewData;

import is.ru.honn.ruber.domain.Review;
import is.ru.honn.ruber.drivers.service.Exceptions.ReviewExistsException;
import is.ru.honn.ruber.drivers.service.Exceptions.ReviewNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import is.ruframework.data.RuData;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReviewData extends RuData implements ReviewDataGateway {

    private String reviewTableName = "ru_reviews";

    @Override
    public int addReview(Review review) throws ReviewExistsException
    {
        SimpleJdbcInsert insert =
                new SimpleJdbcInsert(getDataSource())
                        .withTableName(reviewTableName)
                        .usingGeneratedKeyColumns("id");

        Map<String, Object> parameters = new HashMap<String, Object>(6);
        parameters.put("userId", review.getUserId());
        parameters.put("driverId", review.getDriverId());
        parameters.put("content", review.getContent());
        parameters.put("score", review.getScore());

        int returnKey;

        try
        {
            returnKey = insert.executeAndReturnKey(parameters).intValue();
        }
        catch(DataIntegrityViolationException divex)
        {
            throw new ReviewExistsException("Review " + review.getId() + " already exits", divex);
        }

        review.setId(returnKey);
        return returnKey;
    }

    @Override
    public List<Review> getReviews(int driverId) throws ReviewNotFoundException{

        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());

        List<Review> reviews;
        try
        {
            reviews = jdbcTemplate.query(
                    "select * from " + reviewTableName + " where driverId = '" + driverId + "'", new ReviewRowMapper());
        }
        catch (EmptyResultDataAccessException erdaex)
        {
            throw new ReviewNotFoundException("No reviews found");
        }
        return reviews;
    }
}
