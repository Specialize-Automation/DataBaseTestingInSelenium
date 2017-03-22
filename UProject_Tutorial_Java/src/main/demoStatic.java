package main;

public class demoStatic 
{
	public static void main(String [] args)
	{
		/* To call static method, directly call it via Class name, no need to create or instantiate a object
		 * of the class. Here we are directly calling ClassName.Mehtodname for static and it will be applicable
		 * for all class variable. Static mehtods directly belongs to class.
		 * Static variable declared here as, ClassName.variable = 20;
		 * and it will keep value 20 always, so in next method it will print 20.
		*/
		Aditya.j=20;
		Aditya.checkStaticMehtod();   
		
		
		/* To call non static method, we need to first create an object of the class, then we can use that class object
		 * to call the class methods, for every method in the class, one class object will be enough to create 
		 * separate copy of it. 
		 * Calling non-static variable as ClassObject.variable = 30, and in non static method it'll print 30
		 */
		Aditya adi = new Aditya();
		adi.i=30;
		adi.checkMethod();
	}

}
class Aditya
{
	int i = 10;
	static int j = 10;
	public void checkMethod()    //this is a normal method , can call static variable inside this mehtod.
	{
		System.out.println("Java !!! This is Normal Method");
		System.out.println("The value of Non-static variable of i :"+i);
		System.out.println("The value of Static variable of i :"+j);
		
	}
	public static void checkStaticMehtod()   //this is a staic method as tagged with static keyword,can't call non Static variable here.
	{
		System.out.println("Java !!! This is Static method");
		System.out.println("The value of Static variable of j :"+j);
	}
}
