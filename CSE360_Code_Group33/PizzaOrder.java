/*
 Group 33
 Mazen alzahrani 
 Waleed Altamimi 
 Saleh Alkredes 
 Rakan Al Omairi
 Faisal Alfawaz
 */

public class PizzaOrder {

    private String id;
    private double price;
    private String pizza;
    private String status;

    public PizzaOrder() {
    }
    
    public PizzaOrder(String id, double price, String pizza, String status) {
        this.id = id;
        this.price = price;
        this.pizza = pizza;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getPizza() {
        return pizza;
    }

    public void setPizza(String pizza) {
        this.pizza = pizza;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
