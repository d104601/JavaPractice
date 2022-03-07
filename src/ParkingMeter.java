public class ParkingMeter {
    private float maxTime;
    private float rate;
    private float time;

    public ParkingMeter(float maxTime, float rate)
    {
        this.maxTime = maxTime;
        this.rate = rate;
        this.time = 0;
    }

    public float getMaxTime()
    {
        return maxTime;
    }

    public float getRate()
    {
        return rate;
    }

    public float getTime()
    {
        return time;
    }

    public void insert(int n)
    {
        this.time += this.rate * n;
        if(this.time > this.maxTime)
            this.time = this.maxTime;
    }

    public void check()
    {
        System.out.println("Remaining time : " + this.time);
    }
}
