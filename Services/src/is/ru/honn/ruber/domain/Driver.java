package is.ru.honn.ruber.domain;

/**
 * Created by Gvendur Stefáns on 21.10.2014.
 */
public class Driver {
	protected int id;
	protected String name;
	protected String car;

	//region Getters
	public int getId(){
		return id;
	}

	public String getName(){
		return name;
	}

	public String car(){
		return car;
	}
	//endregion Getters

	//region Setters
	public void setId(int id){
		this.id = id;
	}

	public void setName(String name){
		this.name = name;
	}

	public void setCar(String car){
		this.car = car;
	}
	//endregion Setters

	@Override
	public String toString(){
		return String.format("Name: %s, Car: %s", name, car);
	}
}
