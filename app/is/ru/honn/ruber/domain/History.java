package is.ru.honn.ruber.domain;

import java.util.ArrayList;
import java.util.List;

public class History
{
  protected int offset;
  protected int limit;
  protected int count;
  protected List<Trip> history = new ArrayList<Trip>();

  public History(int offset, int limit, int count)
  {
    this.offset = offset;
    this.limit = limit;
    this.count = count;
  }

  public History(int offset, int limit, int count, List<Trip> history)
  {
    this.offset = offset;
    this.limit = limit;
    this.count = count;
    this.history = history;
  }

  public History()
  {

  }

  public int getOffset()
  {
    return offset;
  }

  public void setOffset(int offset)
  {
    this.offset = offset;
  }

  public int getLimit()
  {
    return limit;
  }

  public void setLimit(int limit)
  {
    this.limit = limit;
  }

  public int getCount()
  {
    return count;
  }

  public void setCount(int count)
  {
    this.count = count;
  }

  public void addTrip(Trip trip)
  {
    history.add(trip);
  }

  public List<Trip> getTrips()
  {
    return history;
  }
}

