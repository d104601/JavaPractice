public class Rational {
    private int numerator;
    private int denominator;

    public Rational(int num, int den)
    {
        if(den != 0)
        {
            this.numerator = num/getGcd(num, den);
            this.denominator = den/getGcd(num, den);
        }
        else
        {
            System.out.println("Invalid Denominator");
        }
    }

    private int getGcd(int num, int den)
    {
        if(num == 0)
            return den;
        return getGcd(den%num, num);
    }

    public int getNum()
    {
        return this.numerator;
    }

    public int getDen()
    {
        return this.denominator;
    }

    public Rational addition(Rational r1)
    {
        int num;
        int den;
        if(this.denominator == r1.getDen())
        {
            num = this.numerator + r1.getNum();
            den = this.denominator;
        }
        else
        {
            num = (this.numerator * r1.getDen()) + (r1.getNum() * this.denominator);
            den = this.denominator * r1.getDen();
        }
        return new Rational(num, den);
    }

    public Rational subtraction(Rational r1)
    {
        int num;
        int den;
        if(this.denominator == r1.getDen())
        {
            num = this.numerator - r1.getNum();
            den = this.denominator;
        }
        else
        {
            num = (this.numerator * r1.getDen()) - (r1.getNum() * this.denominator);
            den = this.denominator * r1.getDen();
        }
        return new Rational(num, den);
    }

    public Rational multiplication(Rational r1)
    {
        int num = this.numerator * r1.getNum();
        int den = this.denominator * r1.getDen();
        return new Rational(num, den);
    }

    public Rational division(Rational r1)
    {
        int num = this.numerator * r1.getDen();
        int den = this.denominator * r1.getNum();
        return new Rational(num, den);
    }
}
