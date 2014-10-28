package is.ru.honn.ruber.drivers.data.ReviewData;

import is.ru.honn.ruber.domain.Review;

import java.util.List;

/**
 * Created by Kristinn on 25.10.2014.
 */
public interface ReviewDataGateway{
        public int addReview(Review driver);
        public List<Review> getReviews(int driverId);
}
