package is.ru.honn.ruber.drivers.service.Exceptions;

/**
 * Created by Gvendur Stefáns on 28.10.2014.
 */
public class ProductNotFoundException extends RuntimeException
{
	public ProductNotFoundException()
	{
	}

	public ProductNotFoundException(String message)
	{
		super(message);
	}

	public ProductNotFoundException(String message, Throwable cause)
	{
		super(message, cause);
	}

	public ProductNotFoundException(Throwable cause)
	{
		super(cause);
	}
}
