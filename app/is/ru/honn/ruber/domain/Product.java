package is.ru.honn.ruber.domain;

public class Product
{
  protected int id;
  protected String product_name;
  protected String car_name;

  public Product(int id, String product_name, String car_name){
	  this.id = id;
	  this.product_name = product_name;
	  this.car_name = car_name;
  }

  public int getId()
  {
    return id;
  }

  public void setId(int id)
  {
    this.id = id;
  }

  public String getProduct_name()
  {
    return product_name;
  }

  public void setProduct_name(String product_name)
  {
    this.product_name = product_name;
  }

  public String getCar_name()
  {
    return car_name;
  }

  public void setCar_name(String car_name)
  {
    this.car_name = car_name;
  }

  @Override
  public String toString()
  {
    return "Product{" +
        "id='" + id + '\'' +
        ", product_name='" + product_name + '\'' +
        ", car_name='" + car_name + '\'' +
        '}';
  }
}
