package is.ru.honn.ruber.drivers.data.ReviewData;

import is.ru.honn.ruber.domain.Review;

import java.util.List;

/**
 * Gateway for ru_reviews database
 */
public interface ReviewDataGateway{

    /**
     * Adds review to database
     * @param review
     * the review that is to be added
     * @return
     * int reviewId
     */
    public int addReview(Review review);

    /**
     * Fetches all reviews for a given driver
     * @param driverId
     * Id of the driver
     * @return
     * List<Review> reviews
     */
    public List<Review> getReviews(int driverId);
}
