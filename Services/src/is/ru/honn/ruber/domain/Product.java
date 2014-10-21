package is.ru.honn.ruber.domain;

public class Product
{
  protected int id;
  protected String description;
  protected String display_name;
  protected int capacity;
  protected String image;

  public int getId()
  {
    return id;
  }

  public void setId(int id)
  {
    this.id = id;
  }

  public String getDescription()
  {
    return description;
  }

  public void setDescription(String description)
  {
    this.description = description;
  }

  public String getDisplay_name()
  {
    return display_name;
  }

  public void setDisplay_name(String display_name)
  {
    this.display_name = display_name;
  }

  public int getCapacity()
  {
    return capacity;
  }

  public void setCapacity(int capacity)
  {
    this.capacity = capacity;
  }

  public String getImage()
  {
    return image;
  }

  public void setImage(String image)
  {
    this.image = image;
  }

  @Override
  public String toString()
  {
    return "Product{" +
        "product_id='" + id + '\'' +
        ", description='" + description + '\'' +
        ", display_name='" + display_name + '\'' +
        ", capacity=" + capacity +
        ", image='" + image + '\'' +
        '}';
  }
}
