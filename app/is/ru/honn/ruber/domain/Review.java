package is.ru.honn.ruber.domain;

/**
 * Created by Gvendur Stefáns on 21.10.2014.
 */
public class Review {
	protected int id;
	protected int userId;
	protected int driverId;
	protected String content;
	protected int score;

    public Review()
    {

    }

    public Review(int id, int userId, int driverId, String content, int score)
    {
        this.id = id;
        this.userId = userId;
        this.driverId = driverId;
        this.content = content;
        this.score = score;
    }

    public Review(int userId, int driverId, String content, int score)
    {
        this.userId = userId;
        this.driverId = driverId;
        this.content = content;
        this.score = score;
    }

	//region Getters
	public int getId(){
		return id;
	}

	public int getUserId(){
		return userId;
	}

	public int getDriverId(){
		return driverId;
	}

	public String getContent(){
		return content;
	}

	public int getScore(){
		return score;
	}
	//endregion Getters

	//region Setters
	public void setId(int id){
		this.id = id;
	}

	public void setUserId(int userId){
		this.id = userId;
	}

	public void setDriverId(int driverId){
		this.driverId = driverId;
	}

	public void setContent(String content){
		this.content = content;
	}

	public void setScore(int score){
		this.score = score;
	}
	//endregion Setters

	@Override
	public String toString(){
		return String.format("User: %s, Driver: %s, Score: %s, Content: %s", userId, driverId, score, content);
	}
}
