
abstract class Animal {
	protected int leg;
	protected  Animal(int legs)
	{
		this.leg = legs;
	}
	public void walk()
	{
		System.out.println("The animal walk with " + leg + " legs");
	}
	public abstract void eat();
	

}
