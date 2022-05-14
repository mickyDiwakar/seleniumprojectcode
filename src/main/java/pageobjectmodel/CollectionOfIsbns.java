package pageobjectmodel;


	public class CollectionOfIsbns
	{
	    private String isbn;

	    private String name;
	    

	    public CollectionOfIsbns(String isbn, String name) {
			
			this.isbn = isbn;
			this.name = name;
		}
	    public CollectionOfIsbns() {
	    	
	    }

		public String getIsbn ()
	    {
	        return isbn;
	    }

	    public void setIsbn (String isbn)
	    {
	        this.isbn = isbn;
	    }

	    public String getName ()
	    {
	        return name;
	    }

	    public void setName (String name)
	    {
	        this.name = name;
	    }

	  
	}


