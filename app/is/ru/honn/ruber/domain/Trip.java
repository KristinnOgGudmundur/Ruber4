package is.ru.honn.ruber.domain;

public class Trip
{
  protected int id;
  protected long requestTime;
  protected int productId;
  protected TripStatus status;
  protected double distance;
  protected long startTime;
  protected long endTime;

  public Trip()
  {

  }

  public Trip(int id, long requestTime, int productId, TripStatus status, double distance, long startTime, long endTime)
  {
    this.id = id;
    this.requestTime = requestTime;
    this.productId = productId;
    this.status = status;
    this.distance = distance;
    this.startTime = startTime;
    this.endTime = endTime;
  }

  public Trip(long requestTime, int productId, TripStatus status, double distance, long startTime, long endTime)
  {
    this.requestTime = requestTime;
    this.productId = productId;
    this.status = status;
    this.distance = distance;
    this.startTime = startTime;
    this.endTime = endTime;
  }

  public int getId()
  {
    return id;
  }

  public void setId(int id)
  {
    this.id = id;
  }

  public long getRequestTime()
  {
    return requestTime;
  }

  public void setRequestTime(long requestTime)
  {
    this.requestTime = requestTime;
  }

  public int getProductId()
  {
    return productId;
  }

  public void setProductId(int productId)
  {
    this.productId = productId;
  }

  public TripStatus getStatus()
  {
    return status;
  }

  public void setStatus(TripStatus status)
  {
    this.status = status;
  }

  public double getDistance()
  {
    return distance;
  }

  public void setDistance(double distance)
  {
    this.distance = distance;
  }

  public long getStartTime()
  {
    return startTime;
  }

  public void setStartTime(long startTime)
  {
    this.startTime = startTime;
  }

  public long getEndTime()
  {
    return endTime;
  }

  public void setEndTime(long endTime)
  {
    this.endTime = endTime;
  }

  @Override
  public String toString()
  {
    return "Trip{" +
        "id=" + id +
        ", requestTime=" + requestTime +
        ", productId=" + productId +
        ", status=" + status +
        ", distance=" + distance +
        ", startTime=" + startTime +
        ", endTime=" + endTime +
        '}';
  }
}
