package is.ru.honn.ruber.drivers.service.Exceptions;

/**
 * Created by Kristinn on 25.10.2014.
 */
public class ReviewExistsException extends RuntimeException
{
    public ReviewExistsException()
    {
    }

    public ReviewExistsException(String message)
    {
        super(message);
    }

    public ReviewExistsException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public ReviewExistsException(Throwable cause)
    {
        super(cause);
    }
}