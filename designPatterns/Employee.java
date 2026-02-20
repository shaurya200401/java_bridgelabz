package designPatterns;

/*
 * prototype pattern: employee class
 * creates new objects by copying an existing object (cloning)
 * implements cloneable interface to support cloning
 */
public class Employee implements Cloneable {

    // private fields
    private String name;
    private String department;
    private double salary;

    // constructor
    public Employee(String name, String department, double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    // getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    // overriding clone method
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    // toggle string method for easy printing
    @Override
    public String toString() {
        return "Employee [Name=" + name + ", Dept=" + department + ", Salary=" + salary + "]";
    }

    // main method to test prototype pattern
    public static void main(String[] args) {
        try {
            // create original employee object
            Employee emp1 = new Employee("Alice", "Engineering", 75000);
            System.out.println("Original: " + emp1);

            // clone the object using clone()
            Employee emp2 = (Employee) emp1.clone();
            System.out.println("Cloned: " + emp2);

            // verify cloned object has same data
            System.out.println("Are they same object? " + (emp1 == emp2));
            System.out.println("Do they have same data? " + emp1.toString().equals(emp2.toString()));

            // modifying cloned object
            emp2.setSalary(80000);
            System.out.println("Modified Cloned: " + emp2);
            System.out.println("Original after clone modification: " + emp1);

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
