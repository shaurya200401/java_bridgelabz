package java8Features;

/*
 * POJO class representing a Person with name, age, and salary attributes.
 * This class is used in sorting and filtering examples.
 */
public class Person {
    private String name;
    private int age;
    private double salary;

    // Constructor to initialize Person object
    public Person(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Getter for age
    public int getAge() {
        return age;
    }

    // Getter for salary
    public double getSalary() {
        return salary;
    }

    // Overriding toString method to print Person details clearly
    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + ", salary=" + salary + "}";
    }
}
