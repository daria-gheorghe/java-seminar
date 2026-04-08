public class Garage
{
    private Vehicle[] fleet;    //capacitatea
    private int size;   //cate vehicule am efectiv in garaj

    public Garage(int nr)
    {
        fleet = new Vehicle[nr];
        size = 0;
    }

    public void add(Vehicle v)  //fails if full or duplicate id
    {
        if(size==fleet.length)
            throw new IllegalStateException("garage is full");
        if(findById(v.getId())!=null)
            throw new IllegalArgumentException("DUPLICATE ID");
        fleet[size++]=v;
    }

    public Vehicle findById(String id)  //returns vehicle or null
    {
        for (int i = 0; i < size; i++) {
            if (fleet[i].getId()==id)
                return fleet[i];
        }
        return null;
    }

    public void rentById(String id)
    {
        Vehicle v = findById(id);
        if (v == null)
            throw new IllegalArgumentException("Vehicle not found");
        v.rent();
    }

    public void returnById(String id, int drivenKm)
    {
        Vehicle v = findById(id);
        if (v == null)
            throw new IllegalArgumentException("Vehicle not found");
        v.returnVehicle(drivenKm);
    }
    public void printAvailable()
    {
        for (int i = 0; i < size; i++)
        {
            if (!fleet[i].isRented())
                System.out.println(fleet[i].getId());
        }
    }
    public void printNeedsService()
    {
        for (int i = 0; i < size; i++) {
            if (fleet[i].needsService())
                System.out.println(fleet[i].getId());
        }
    }
    public void printRentalEstimate(String id, int days)
    {
        Vehicle v = findById(id);
        if (v == null)
            throw new IllegalArgumentException("Vehicle not found");
        double price = v.rentalPrice(days);
        System.out.println("Price: " + price);
    }
}
