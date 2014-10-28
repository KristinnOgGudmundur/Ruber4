package is.ru.honn.ruber.domain;

/**
 * Created by Gvendur Stefáns on 21.10.2014.
 */
public class Driver {
	protected int id;
	protected String name;
	protected int productId;

    public Driver(int id, String name, int productId)
    {
        this.id = id;
        this.name = name;
        this.productId = productId;
    }

	//region Getters
	public int getId(){
		return id;
	}

	public String getName(){
		return name;
	}

	public int getProductId(){
		return productId;
	}
	//endregion Getters

	//region Setters
	public void setId(int id){
		this.id = id;
	}

	public void setName(String name){
		this.name = name;
	}

	public void setProductId(int productId){
		this.productId = productId;
	}
	//endregion Setters

	@Override
	public String toString(){
		return String.format("Name: %s, ProductId: %s", name, productId);
	}
}
