package ro.ase.cts.seminar5.factory;

public class TechProduct implements Product{
	String productName;
	String manufacturor;
	String displayType;
	String model;
	float price;
	private TechProduct()
	{
		
	}
	public TechProduct(String productName)
	{
		
	}
	@Override
	public String getDescription() {
		return "generic";
	}
}
