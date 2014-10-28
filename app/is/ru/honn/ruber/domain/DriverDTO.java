package is.ru.honn.ruber.domain;

public class DriverDTO {
	protected int id;
	protected String name;
	protected String car;

	public DriverDTO(int id, String name, String car)
	{
		this.id = id;
		this.name = name;
		this.car = car;
	}

	//region Getters
	public int getId(){
		return id;
	}

	public String getName(){
		return name;
	}

	public String getCar(){
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