package is.ru.honn.ruber.process;

import is.ru.honn.ruber.domain.Trip;

public interface TripHandler
{
    /**
     * Adds a trip to our trips
     * @param trip
     * Trip to be added
     */
     public void addTrip(Trip trip);
}
