package is.ru.honn.ruber.process;

import is.ru.honn.ruber.domain.Trip;
import is.ru.honn.ruber.rides.RidesService;
import is.ruframework.process.RuAbstractProcess;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class TripImportProcess extends RuAbstractProcess implements TripHandler
{
  RidesService ridesService;
  TripReader reader = new TripReader();
  Logger log = Logger.getAnonymousLogger();

  @Override
  public void beforeProcess()
  {
    ApplicationContext appCtx = new FileSystemXmlApplicationContext("RidesService.xml");
    ridesService = (RidesService)appCtx.getBean("RidesService");
    reader.setHandler(this);
  }

  @Override
  public void startProcess()
  {
    List<Trip> trips = new ArrayList();
    try
    {
      reader.read(getProcessContext().getImportURL());
    }
    catch (ProcessException e)
    {
      String message = "Error reading importfile";
      log.severe(message);
      System.exit(0);
    }
  }

  @Override
  public void afterProcess()
  {
    List<Trip> trips = ridesService.getTrip(1);
    for(Trip trip : trips)
    {
      System.out.println(trip);
    }
  }

  @Override
  public void addTrip(Trip trip)
  {
    ridesService.addTrip(1, trip);
  }
}
