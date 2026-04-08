import java.util.Objects;

public abstract class Vehicle
{
    private String brand;
    private double speed;

    private String id;
    private int mileage;
    private boolean rented;

    public Vehicle(){};
    public Vehicle(String brand, double speed,String id)
    {
        this.brand=brand;
        this.speed=speed;
        this.id = id;
        this.mileage = 0;
        this.rented = false;
    }

    public String getBrand()
    {
        return brand;
    }
    public void setBrand(String brand)
    {
        this.brand=brand;
    }

    public double getSpeed()
    {
        return speed;
    }
    public void setSpeed(double speed)
    {
        this.speed=speed;
    }

    public String getId() { return id; }
    public int getMileage() { return mileage; }
    public boolean isRented() { return rented; }

    public abstract void move();
    public void rent()
    {
        if(rented)
            throw new IllegalStateException("vehicle already rented");
        rented=true;
    }
    public void returnVehicle(int drivenKm)
    {
        if(!rented)
            throw new IllegalStateException("vehicle is not rented");
        if(drivenKm<=0)
            throw new IllegalArgumentException("driven km must be >0");
        mileage+=drivenKm;
        rented=false;
    }
    public abstract boolean needsService();
    public abstract double rentalPrice(int days);
}

class Car extends Vehicle
{
    public int doors;

    public Car(String brand, double speed, int doors,String id)
    {
        super(brand,speed,id);
        this.doors=doors;
    }

    @Override
    public void move() {
        System.out.println("Car drives on the road");
    }

    @Override
    public boolean needsService() {
        return getMileage() >= 10000;
    }

    @Override
    public double rentalPrice(int days) {
        double x=50*days;
        if(doors>=4)
            x=x*1.10;
        return x;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        Car car = (Car) o;
        return this.getBrand() == car.getBrand();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBrand());
    }
}
class Motorcycle extends Vehicle
{
    private boolean hasSidecar;
    public Motorcycle()
    {
        super();
    }

    public Motorcycle(String brand, double speed,String id,boolean hasSidecar)
    {
        super(brand, speed,id);
        this.hasSidecar=hasSidecar;
    }

    @Override
    public void move() {
        System.out.println("Motorcycle speeds through traffic");
    }

    @Override
    public boolean needsService() {
        return getMileage() >= 6000;
    }

    @Override
    public double rentalPrice(int days) {
        double y=30*days;
        if(hasSidecar)
            y=y+15*days;
        return y;
    }
}

class Truck extends Vehicle
{
    private double loadCapacity;
    public Truck() {super();}

    public Truck(String brand, double speed,String id,double loadCapacity)
    {
        super(brand, speed,id);
        this.loadCapacity=loadCapacity;
    }

    @Override
    public void move() {
        System.out.println("Truck transports heavy cargo");
    }

    @Override
    public boolean needsService() {
        return getMileage()>=15000;
    }

    @Override
    public double rentalPrice(int days) {
        return (80+0.02*loadCapacity)*days;
    }
}