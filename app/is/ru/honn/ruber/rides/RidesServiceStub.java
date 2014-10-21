package is.ru.honn.ruber.rides;


import is.ru.honn.ruber.domain.Trip;

import java.util.ArrayList;
import java.util.List;

public class RidesServiceStub implements RidesService
{
  List<Trip> theTrips = new ArrayList<Trip>();

  @Override
  public void addTrip(int userId, Trip trip)
  {
    theTrips.add(trip);
  }

  @Override
  public List<Trip> getTrip(int userId)
  {
    return theTrips;
  }
}

