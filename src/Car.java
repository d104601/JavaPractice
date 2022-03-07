public class Car {
    private float efficiency;
    private float fuel;

    public Car(float efficiency)
    {
        this.efficiency = efficiency;
        this.fuel = 0.0F;
    }

    public float getGas()
    {
        return this.fuel;
    }

    public void drive(float distance)
    {
        float gasUsed = distance/this.efficiency;
        if(gasUsed > this.fuel)
        {
            System.out.println("Not enough gas to drive " + distance + " miles. Drove " + this.efficiency*this.fuel + " miles.");
            this.fuel = 0.0F;
        }
        else
        {
            this.fuel -= gasUsed;
        }
    }

    public void addGas(float amount)
    {
        this.fuel += amount;
    }
}
