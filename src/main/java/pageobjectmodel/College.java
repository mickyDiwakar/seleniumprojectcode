package pageobjectmodel;

public class College
{
    private String loc;

    private String collName;
    public College(String loc,String collName) {
    	this.loc=loc;
    	this.collName=collName;
    }
    public College() {
    	
    }

    public String getLoc ()
    {
        return loc;
    }

    public void setLoc (String loc)
    {
        this.loc = loc;
    }

    public String getCollName ()
    {
        return collName;
    }

    public void setCollName (String collName)
    {
        this.collName = collName;
    }

    
}