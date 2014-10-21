package is.ru.honn.ruber.rides;

import is.ru.honn.ruber.domain.Trip;
import java.util.List;

public interface RidesService
{
  public void addTrip(int userId, Trip trip);
  public List<Trip> getTrip(int userId);
}
