package is.ru.honn.ruber.rides;

import is.ru.honn.ruber.domain.Trip;
import java.util.List;

/**
 * Dedicated service for rides
 */
public interface RidesService
{
    /**
     * Adds a trip to our trips
     * @param userId
     * Id of user
     * @param trip
     * Trip to be added
     */
    public void addTrip(int userId, Trip trip);

    /**
     * Fetches all trips for a given user
     * @param userId
     * Id of user
     * @return
     * List<Trip> trips
     */
    public List<Trip> getTrip(int userId);
}
