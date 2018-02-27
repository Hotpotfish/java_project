
public class Fish extends Animal  implements Pet
{
	String name;
	public Fish()
	{
		super(0);
		this.name = "";
	}
	public String getName()
	{
		return this.name;
		
	}
	public void setName(String name)
	{
		
	}
	public void play()
	{
		System.out.println("Fish can play");
	}
	public void eat()
	{
		System.out.println("Fish can play");
	}
	public void walk()
	{
		System.out.println("Fish can't walk and don't have legs. ");
	}
	
	
	
}