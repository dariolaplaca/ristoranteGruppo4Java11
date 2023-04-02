import java.util.Set;


public class Seconds extends Course {
    private double weight;

    /**
     * @param name        name of the seconds
     * @param description description of the seconds
     * @param price       price of seconds
     * @param weight      weight of seconds
     */

    public Seconds(String name, String description, double weight, double calories, double price, MenuType mt, Set<AllergensEnum> allergens) {
        super(name, description, calories, price, mt, allergens);
        this.weight = weight;
        this.courseType = CourseEnum.SECONDS;
    }


    public double getWeight() {return this.weight;}
    public void setWeight(double weight) {this.weight = weight;}
}
