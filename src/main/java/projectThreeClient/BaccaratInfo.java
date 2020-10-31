package projectThreeClient;

import java.io.Serializable;

public class BaccaratInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public int bidAmount;

	public String bidOnPerson;
	
	
	public BaccaratInfo(String bidOnPerson,int bidAmount)
	{
		this.bidOnPerson = bidOnPerson;
		this.bidAmount = bidAmount;
	}

}
