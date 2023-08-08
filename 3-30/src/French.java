
public class French implements Language{
    @Override
    public String getAuthor(){
        return author + " Stathis and Daniel";
    }
    @Override
    public String getHello(){
        return "Bonjour";
    }
    @Override
	public String getBye(){
        return "Au revoir";
    }
    @Override
	public String getThankYou(){
        return "Merci";
    }
}
