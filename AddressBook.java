import javax.swing.*;
import java.util.*;

class Person
{
	public String fname;
	public String lname;
	public String address;
	public String city;
	public String state;
	public String pinCode;
	public String mobile;

	public Person(String fname, String lname, String address, String city, String state, String pinCode, String mobile)
	{
		this.fname = fname;
		this.lname = lname;
		this.address = address;
		this.city = city;
		this.state = state;
		this.pinCode = pinCode;
		this.mobile = mobile;
	}

	public void print()
	{
		JOptionPane.showMessageDialog(null, "First name : " +fname+ " Last name : " +lname+ " Address is : " +address+ " City : "+city+" State : "+state+" PinCode :" +pinCode+" Mobile number : "+mobile);
	}
}

public class AddressBook
{
	private ArrayList<Person> person;

	public AddressBook() {
		person = new ArrayList<Person>();
	}

	public void addPerson() {
		String fname = JOptionPane.showInputDialog("Enter first name : ");
		String lname = JOptionPane.showInputDialog("Enter last name : ");
		String address = JOptionPane.showInputDialog("Enter the address : ");
		String city = JOptionPane.showInputDialog("Enter the city name : ");
		String state = JOptionPane.showInputDialog("Enter state : ");
		String pinCode = JOptionPane.showInputDialog("Enter pin code : ");
		String mobile = JOptionPane.showInputDialog("Enter Mobile number : ");

		Person p = new Person(fname, lname, address, city, state, pinCode, mobile);

		person.add(p);
	}

	public void search(String mobile)
	{
		for (int i=0;i<person.size();i++)
		{
			Person p =(Person)person.get(i);
			if(mobile.equals(p.mobile))
			{
				p.print();
			}
		}
	}

	public void remove(String mobile)
	{
		for (int i=0;i<person.size();i++)
		{
			Person p = (Person)person.get(i);
			if (mobile.equals(p.mobile))
			{
				person.remove(i);
			}
		}
	}

	public void show()
	{
		for (int i=0;i<person.size();i++)
		{
			Person p =(Person)person.get(i);
			p.print();
		}
	}

	public static void main (String args[])
	{
		System.out.println("Welcome to the address book program.");
		AddressBook add = new AddressBook();
		int options;
		String choice;

		while(true)
		{
			choice = JOptionPane.showInputDialog(" Enter 1 to add new entry \n Enter 2 to Search\n Enter 3 to remove an entry\n Enter 4 to view all Entries \n Enter 5 to exit");
			options = Integer.parseInt(choice);
			switch(options)
			{
			 case 1:
				add.addPerson();
			 	break;
			 case 2:
				choice = JOptionPane.showInputDialog("Enter the mobile number.");
				add.search(choice);
				break;
			 case 3:
				choice = JOptionPane.showInputDialog("Enter the mobile number.");
				add.remove(choice);
				break;
			 case 4:
				add.show();
				break;
			 default:
				System.exit(0);
			}
		}
	}
}
