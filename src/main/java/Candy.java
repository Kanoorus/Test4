public abstract class Candy{
    private double price;
    private double mass;
    private String name;
    private int id;

    public Candy(double price, double mass, String name, int id) {
        this.price = price;
        this.mass = mass;
        this.name = name;
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public double getMass() {
        return mass;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Назнавиние: "+name+" Масса: "+mass+" Цена: "+price;
    }
}
