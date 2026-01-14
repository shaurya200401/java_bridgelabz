package Method.lvl3;
public class collinear {
    public static void main(String[] args) {
        double x1 = 2, y1 = 4;
        double x2 = 4, y2 = 6;
        double x3 = 6, y3 = 8;

        double slopeAB = (y2 - y1) / (x2 - x1);
        double slopeBC = (y3 - y2) / (x3 - x2);
        double slopeAC = (y3 - y1) / (x3 - x1);

        boolean isCollinearBySlope = (slopeAB == slopeBC) && (slopeBC == slopeAC);

        double area = 0.5 * (x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2));
        boolean isCollinearByArea = (area == 0);

        System.out.println("Collinear (Slope Method): " + isCollinearBySlope);
        System.out.println("Collinear (Area Method): " + isCollinearByArea);
    }
}