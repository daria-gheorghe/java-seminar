public class Main
{
    public static void main(String[] args)
    {
        Vehicle[] vehicles =new Vehicle[4];
        vehicles[0]=new Car("BMW",200,4,"100");
        vehicles[1]=new Motorcycle("Yamaha",180,"101",false);
        vehicles[2]=new Truck("Volvo",120,"102",1000);
        vehicles[3]=new Car("Audi",220,4,"103");

        for (Vehicle v : vehicles)
        {
            v.move();
        }

        if(vehicles[0].equals(vehicles[3]))
        {
            System.out.println("they are the same");
        }
        else {
            System.out.println("they are not the same");
        }

        Garage g=new Garage(10);
        g.add(vehicles[0]);
        g.add(vehicles[1]);
        g.add(vehicles[2]);
        g.add(vehicles[3]);
        g.add(new Motorcycle("Honda",160,"104",false));
        g.add(new Truck("Volvo",150,"105",1500));

        g.rentById("100");
        g.rentById("102");

        //afisez disponibile
        System.out.println("available: ");
        g.printAvailable();

        //verific service
        System.out.println("needs service: ");
        g.printNeedsService();

        //estimare pret
        System.out.println("rental price for 3 days: ");
        g.printRentalEstimate("100",3);
    }
}
