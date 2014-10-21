package is.ru.honn.ruber.process;


import is.ru.honn.ruber.domain.Trip;
import is.ru.honn.ruber.domain.TripStatus;
import is.ruframework.http.SimpleHttpRequest;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;

public class TripReader
{
  TripHandler handler;

  public TripReader()
  {
  }

  public void setHandler(TripHandler handler)
  {
    this.handler = handler;
  }

  public void read(String url) throws ProcessException
  {
    Logger log = Logger.getAnonymousLogger();
    URL feedUrl = null;
    try
    {
      feedUrl = new URL(url);
    }
    catch(MalformedURLException murlex)
    {
      String tmp = "URL is not valid.";
      throw new ProcessException(tmp, murlex);
    }

    SimpleHttpRequest jsonRequest = new SimpleHttpRequest();
    JSONParser jsonParser = new JSONParser();

    try
    {
      String jsonString = jsonRequest.sendGetRequest(url);

      JSONObject jsonRoot = (JSONObject)jsonParser.parse(jsonString);
      JSONArray jsonHistory = (JSONArray)jsonRoot.get("history");

      for(int i=0; i<jsonHistory.size(); i++)
      {
        JSONObject jsonTrip = (JSONObject)jsonHistory.get(i);
        Trip trip = new Trip();

        trip.setId(Integer.parseInt(jsonTrip.get("uuid").toString()));
        trip.setProductId(Integer.parseInt(jsonTrip.get("product_id").toString()));
        trip.setStatus(TripStatus.COMPLETED);
        trip.setDistance((Double)jsonTrip.get("distance"));
        trip.setRequestTime(Integer.parseInt(jsonTrip.get("request_time").toString()));
        trip.setStartTime(Integer.parseInt(jsonTrip.get("start_time").toString()));
        trip.setEndTime(Integer.parseInt(jsonTrip.get("end_time").toString()));

        handler.addTrip(trip);
      }
    }
    catch(Exception ex)
    {
      String tmp = "URL is not valid.";
      throw new ProcessException(tmp, ex);
    }
  }
}



