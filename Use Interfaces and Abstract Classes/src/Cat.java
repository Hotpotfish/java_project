
public class Cat extends Animal  implements Pet
{
	String name;
	public Cat(String name)
	{
		super(4);
		this.name = name;
		
	}
	public Cat()
	{
		super(4);
		this.name = "";
	}
	public String getName()
	{
		return this.name;
		
	}
	public void setName(String name)
	{
		this.name = name;
		
	}
	public void play()
	{
		System.out.println("Cat can play");
		
	}
	public void eat()
	{
		
	}
	
	
}