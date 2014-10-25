package is.ru.honn.ruber.drivers.service.Exceptions;

public class DriverNotFoundException extends RuntimeException
{
    public DriverNotFoundException()
    {
    }

    public DriverNotFoundException(String message)
    {
        super(message);
    }

    public DriverNotFoundException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public DriverNotFoundException(Throwable cause)
    {
        super(cause);
    }
}