package designPatterns;

/*
 * builder pattern: user class
 * separates the construction of a complex object from its representation
 * allows for step-by-step creation of complex objects
 */
public class User {

    // private fields
    private final String firstName;
    private final String lastName;
    private final int age;
    private final String phone;
    private final String address;

    // private constructor to force use of builder
    private User(Builder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.age = builder.age;
        this.phone = builder.phone;
        this.address = builder.address;
    }

    // getters
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "User: " + firstName + " " + lastName + ", Age: " + age + ", Phone: " + phone + ", Address: " + address;
    }

    /*
     * static inner builder class
     */
    public static class Builder {
        // required parameters
        private final String firstName;
        private final String lastName;

        // optional parameters initialized to default values
        private int age = 0;
        private String phone = "N/A";
        private String address = "N/A";

        // constructor with required parameters
        public Builder(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        // setter-like methods returning builder for chaining
        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public Builder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public Builder address(String address) {
            this.address = address;
            return this;
        }

        // build method to return the final user object
        public User build() {
            return new User(this);
        }
    }

    // main method to test builder pattern
    public static void main(String[] args) {
        // creating user object using builder
        User user1 = new User.Builder("John", "Doe")
                .age(30)
                .phone("1234567890")
                .address("123 Main St")
                .build();

        System.out.println(user1);

        // creating another user with minimal info
        User user2 = new User.Builder("Jane", "Smith")
                .build();

        System.out.println(user2);
    }
}
