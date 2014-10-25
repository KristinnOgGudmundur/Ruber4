package is.ru.honn.ruber.drivers.service.Exceptions;

public class ReviewNotFoundException extends RuntimeException
{
    public ReviewNotFoundException()
    {
    }

    public ReviewNotFoundException(String message)
    {
        super(message);
    }

    public ReviewNotFoundException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public ReviewNotFoundException(Throwable cause)
    {
        super(cause);
    }
}