package pageobjectmodel;

import java.util.List;

public class pojo {
	private String userId;
	private College college;
	private List<CollectionOfIsbns> collectionOfIsbns;
	public pojo( College college,List<CollectionOfIsbns> collectionOfIsbns,String userId) {
		this.college=college;
		this.collectionOfIsbns=collectionOfIsbns;
		this.userId=userId;
	}
   public pojo() {
	   
   }

    public College getCollege ()
    {
        return college;
    }

    public void setCollege (College college)
    {
        this.college = college;
    }

    public List<CollectionOfIsbns> getCollectionOfIsbns ()
    {
        return collectionOfIsbns;
    }

    public void setCollectionOfIsbns (List<CollectionOfIsbns> collectionOfIsbns)
    {
        this.collectionOfIsbns = collectionOfIsbns;
    }

    public String getUserId ()
    {
        return userId;
    }

    public void setUserId (String userId)
    {
        this.userId = userId;
    }
    
   

}


			
	
	
