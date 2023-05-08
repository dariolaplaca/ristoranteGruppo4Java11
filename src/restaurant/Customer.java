package restaurant;

import course.Course;
import enumProject.MenuTypeEnum;

import java.util.ArrayList;
import java.util.List;

/**
 * Customer class is the class that represents a customer of the restaurant.
 */
public class Customer {
    private static Integer idCounter = 0;
    private Integer id;
    private String name;
    private MenuTypeEnum menuTypeEnum;
    private String mail;
    private String password;
    private List<Course> orderedCourses;
    private Double billToPay;

    public Customer(String name, MenuTypeEnum menuTypeEnum, String mail, String password) {
        this.id = ++idCounter;
        this.name = name;
        this.menuTypeEnum = menuTypeEnum;
        this.mail = mail;
        this.password = password;
        this.orderedCourses = new ArrayList<>();
        this.billToPay = 0.0;
    }

    // GETTER & SETTE
    public int getId() {return this.id;}
    public void setId(int id) {this.id = id;}

    public String getName() {return this.name;}
    public void setName(String name) {this.name = name;}

    public MenuTypeEnum getMenuType() {return this.menuTypeEnum;}
    public void setMenuType(MenuTypeEnum menuTypeEnum) {this.menuTypeEnum = menuTypeEnum;}

    public String getMail() {return this.mail;}
    public void setMail(String mail) {this.mail = mail;}

    public String getPassword() {return this.password;}
    public void setPassword(String password) {this.password = password;}

    public List<Course> getOrderedCourses() {return this.orderedCourses;}

    public void setOrderedCourses(List<Course> orderedCourses) {
        this.orderedCourses = orderedCourses;
    }

    public Double getBillToPay() {return billToPay;}
    public void setBillToPay(Double billToPay) {this.billToPay = billToPay;}

    /**
     * Adds a course to the ordered course of a customer
     *
     * @param c is the course to add
     */
    public void addOrderedCourse(Course c) {
        orderedCourses.add(c);
    }

    public void addAllOrderedCourse(List<Course> c) {
        orderedCourses.addAll(c);
    }


    public double calculateBill(List<Course> orderedCourses) {
        for (Course course : orderedCourses) {
            billToPay += course.getPrice();
        }
        return Math.floor(billToPay);
    }

    /**
     * That method apply a discount
     *
     * @param discount
     * @return
     */
    public double calculateBill(List<Course> orderedCourses, double discount) {
        for (Course course : orderedCourses) {
            billToPay += course.getPrice();
        }
        return Math.floor((billToPay / 100) * (100 - discount));
    }

    /**
     * It's a method to retrieve all the ordered courses names
     *
     * @return all the names of the ordered courses as a String
     */
    public String OrderedCourseToString() {
        StringBuilder sb = new StringBuilder();
        for (Course c : orderedCourses) {
            sb.append(c.getName()).append(" - ");
        }
        return sb.substring(0, sb.toString().length() - 3);
    }


    /**
     * that method print the info of customer
     */
    public void printInfo() {
        System.out.println(this.name + " " + this.menuTypeEnum + " menu\n" + this.mail);
    }
}
