package designPatterns;

/*
 * factory method pattern: shape factory
 * creates objects without exposing the instantiation logic to the client
 * refers to the newly created object through a common interface
 */
interface Shape {
    void draw();
}

// concrete class implementing shape interface
class Circle implements Shape {
    // override draw method
    @Override
    public void draw() {
        System.out.println("Drawing Circle");
    }
}

// concrete class implementing shape interface
class Rectangle implements Shape {
    // override draw method
    @Override
    public void draw() {
        System.out.println("Drawing Rectangle");
    }
}

/*
 * factory class to generate object of concrete class based on given information
 */
public class ShapeFactory {

    // use getShape method to get object of type shape
    public static Shape getShape(String shapeType) {
        if (shapeType == null) {
            return null;
        }
        if (shapeType.equalsIgnoreCase("CIRCLE")) {
            return new Circle();
        } else if (shapeType.equalsIgnoreCase("RECTANGLE")) {
            return new Rectangle();
        }
        return null;
    }

    // main method to test factory method pattern
    public static void main(String[] args) {
        // get an object of circle and call its draw method
        Shape shape1 = ShapeFactory.getShape("CIRCLE");
        if (shape1 != null) {
            shape1.draw();
        }

        // get an object of rectangle and call its draw method
        Shape shape2 = ShapeFactory.getShape("RECTANGLE");
        if (shape2 != null) {
            shape2.draw();
        }
    }
}
