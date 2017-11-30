/**
 * 
 */
package employee;

import java.util.*; // Importing java.util package

// TODO: Auto-generated Javadoc
/**
 * This class is used to instantiate the Employee object which contains the employee name, 
 * employee designation, Employee salary. It also has getter and setter methods to modify and 
 * retrieve the values of the variables of the objects of this class
 * @author Praveen
 */
class Employee{

	/** The Employee Name. */
	String name;
	
	/** The Employee Designation. */
	String designation;
	
	/** The Employee Salary. */
	float salary;

	/**
	 * Constructor, Instantiates a new employee.
	 *
	 * @param name the name
	 * @param designation the designation
	 * @param salary the salary
	 */
	public Employee(String name, String designation, int salary)
	{
		this.name = name;
		this.designation = designation;
		this.salary = salary;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 * @return returns nothing
	 */
	public void setName(String name){
		this.name = name;
	}

	/**
	 * Sets the designation.
	 *
	 * @param designation the new designation
	 * @return returns nothing
	 */
	public void setDesignation(String designation){
		this.designation = designation;
	}

	/**
	 * Sets the salary.
	 *
	 * @param salary the new salary
	 * @return returns nothing
	 */
	public void setSalary(int salary){
		this.salary = salary;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName(){
		return name;
	}

	/**
	 * Gets the designation.
	 *
	 * @return the designation
	 */
	public String getDesignation(){
		return designation;
	}

	/**
	 * Gets the salary.
	 *
	 * @return the salary
	 */
	public float getSalary(){
		return salary;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString(){
		return "\nName: " + name + "\tDesignation: " + designation + "\tSalary: " + salary ;
	}
}


/**
 * The Class EmployeeComparator used to create custom comparator for sorting the TreeSet Object's 
 * members
 */
class EmployeeComparator implements Comparator<Employee>{
	
	/* (non-Javadoc)
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 * 
	 * If two employees have the same salary then it considers alphabetical orders of their names
	 * for comparison. If two employees have the same name then it consider alphabetical orders of 
	 * their designation for comparison.
	 * 
	 */
	public int compare(Employee  emp1, Employee emp2) {
		if (emp1.getSalary() != emp2.getSalary())
		{
			if( emp1.getSalary() > emp2.getSalary()){
				return 1;
			} 
			else{
				return -1;
			}
		}
		else{
			if(!emp1.getName().equalsIgnoreCase(emp2.getName()))
			{
				if (emp1.getName().compareToIgnoreCase(emp2.getName()) > 0)
				{
					return 1;
				}
				else{
					return -1;
				}				  
			}
			else{
				if(!emp1.getDesignation().equalsIgnoreCase(emp2.getDesignation()))
				{
					if (emp1.getDesignation().compareToIgnoreCase(emp2.getDesignation()) > 0)
					{
						return 1;
					}
					else{
						return -1;
					}			
				}
				else{
					return -1;
				}

			}
		}
	}
}

/**
 * This class is used to demonstrate the automatic sorting of the Tree Set elements using the custom 
 * Comparator class, i.e. EmployeeComparator, as Employee class objects are added to the Tree Set
 * @author Praveen
 */
public class EmployeeSortDemo {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {

		/* Instantiated the TreeSet object with EmployeeComparator object as parameter for custom
		comparison of the members of the TreeSet */
		TreeSet<Employee> empTreeSet = new TreeSet<Employee>(new EmployeeComparator());

		// Instantiating the Employee objects using a parameterised constructor
		Employee emp1 = new Employee("Praveen", "Developer", 20000);
		Employee emp2 = new Employee("Ramesh", "Tester", 15000);
		Employee emp3 = new Employee("Praveen", "Designer", 20000);
		Employee emp4 = new Employee("Ramesh", "Engineer", 15000);
		Employee emp5 = new Employee("Rohan", "Doctor", 15000);
		Employee emp6 = new Employee("Rakesh", "Lawyer", 25000);

		// Adding the Employee objects to the TreeSet object
		empTreeSet.add(emp1);
		empTreeSet.add(emp2);
		empTreeSet.add(emp3);
		empTreeSet.add(emp4);
		empTreeSet.add(emp5);
		empTreeSet.add(emp6);

		System.out.println("Sorted Tree Set of the Employees: \n");
		// Printing the sorted TreeSet of the Employee objects
		System.out.println(empTreeSet);


	}

}
