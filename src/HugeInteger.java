public class HugeInteger {
    private int sign;
    private int[] integers;
    private int digits;

    public HugeInteger()
    {
        this.sign = 0;
    }

    public HugeInteger(String integer)
    {
        if(integer.length() <= 0)
            throw new IllegalArgumentException("length must be greater than zero");
        parse(integer);
    }

    public void parse(String str)
    {
        if(str.charAt(0) == '-')
        {
            this.integers = new int[str.length()-1];
            this.sign = 1;
            for(int i = 1; i < str.length(); i++)
            {
                this.integers[i-1] = str.charAt(i) -'0';
            }
        }
        else
        {
            this.integers = new int[str.length()];
            this.sign = 0;
            for(int i = 0; i < str.length(); i++)
            {
                this.integers[i] = str.charAt(i) -'0';
            }
        }

        this.digits = this.integers.length;
    }

    public String toString()
    {
        StringBuilder output = new StringBuilder();

        if(this.sign == 1)
            output.append("-");

        for (int integer : this.integers) {
            output.append(integer);
        }

        return output.toString();
    }

    public HugeInteger add(HugeInteger a)
    {
        HugeInteger result = new HugeInteger();

        int largerLength = Math.max(this.digits, a.digits);
        int[] tempInt1 = new int[largerLength];
        int[] tempInt2 = new int[largerLength];

        for(int i = 1; i <= this.digits; i++)
            tempInt1[largerLength - i] = this.integers[this.digits - i];

        for(int i = 1; i <= a.digits; i++)
            tempInt2[largerLength - i] = a.integers[a.digits - i];

        if(this.sign == a.sign)
        {
            result.integers = new int[largerLength];
            result.digits = largerLength;
            result.sign = this.sign;

            for(int i = 0; i < result.digits; i++)
                result.integers[i] = tempInt1[i] + tempInt2[i];

            for(int i = result.digits - 1; i >= 1; i--)
            {
                if(result.integers[i] >= 10)
                {
                    result.integers[i] -= 10;
                    result.integers[i-1] += 1;
                }
            }
        }
        else
        {
            int[] tempInt3 = new int[largerLength];

            int temp1 = this.sign;
            int temp2 = a.sign;

            this.sign = 0;
            a.sign = 0;

            if(this.isEqualTo(a))
            {
                result.integers = new int[1];
                result.digits = 1;
                result.sign = 0;
            }
            else if(this.isGreaterThan(a))
            {
                result.sign = temp1;
                for(int i = 0; i < tempInt3.length; i++)
                    tempInt3[i] = tempInt1[i] - tempInt2[i];
            }
            else if(this.isLessThan(a))
            {
                result.sign = temp2;
                for(int i = 0; i < tempInt3.length; i++)
                    tempInt3[i] = tempInt2[i] - tempInt1[i];
            }
            this.sign = temp1;
            a.sign = temp2;

            for(int i = 0; i < tempInt3.length; i++)
            {
                if(tempInt3[i] != 0)
                {
                    result.digits = tempInt3.length - i;
                    result.integers = new int[result.digits];
                    for(int j = i; j < tempInt3.length; j++)
                        result.integers[j - i] = tempInt3[j];
                    break;
                }
            }

            for(int i = result.digits - 1; i >= 1; i--)
            {
                if(result.integers[i] < 0)
                {
                    result.integers[i] += 10;
                    result.integers[i-1] -= 1;
                }
            }
        }

        return result;
    }

    public HugeInteger subtract(HugeInteger a)
    {
        HugeInteger result = new HugeInteger();
        int largerLength = Math.max(this.digits, a.digits);
        int[] tempInt1 = new int[largerLength];
        int[] tempInt2 = new int[largerLength];

        for(int i = 1; i <= this.digits; i++)
            tempInt1[largerLength - i] = this.integers[this.digits - i];

        for(int i = 1; i <= a.digits; i++)
            tempInt2[largerLength - i] = a.integers[a.digits - i];

        if(this.sign == a.sign)
        {
            int[] tempInt3 = new int[largerLength];

            int temp1 = this.sign;
            int temp2 = a.sign;

            this.sign = 0;
            a.sign = 0;

            if(this.isEqualTo(a))
            {
                result.integers = new int[1];
                result.digits = 1;
                result.sign = 0;
            }
            else if(this.isGreaterThan(a))
            {
                result.sign = temp1;
                for(int i = 0; i < tempInt3.length; i++)
                    tempInt3[i] = tempInt1[i] - tempInt2[i];
            }
            else if(this.isLessThan(a))
            {
                result.sign = temp2;
                for(int i = 0; i < tempInt3.length; i++)
                    tempInt3[i] = tempInt2[i] - tempInt1[i];
            }
            this.sign = temp1;
            a.sign = temp2;

            for(int i = 0; i < tempInt3.length; i++)
            {
                if(tempInt3[i] != 0)
                {
                    result.digits = tempInt3.length - i;
                    result.integers = new int[result.digits];
                    for(int j = i; j < tempInt3.length; j++)
                        result.integers[j - i] = tempInt3[j];
                    break;
                }
            }

            for(int i = result.digits - 1; i >= 1; i--)
            {
                if(result.integers[i] < 0)
                {
                    result.integers[i] += 10;
                    result.integers[i-1] -= 1;
                }
            }
        }
        else
        {
            result.integers = new int[largerLength];
            result.digits = largerLength;
            result.sign = this.sign;

            for(int i = 0; i < result.digits; i++)
                result.integers[i] = tempInt1[i] + tempInt2[i];

            for(int i = result.digits - 1; i >= 1; i--)
            {
                if(result.integers[i] >= 10)
                {
                    result.integers[i] -= 10;
                    result.integers[i-1] += 1;
                }
            }
        }
        return result;
    }

    public boolean isEqualTo(HugeInteger a)
    {
        if(this.sign != a.sign)
            return false;
        if(this.digits != a.digits)
            return false;

        for(int i = 0; i<this.digits; i++)
        {
            if(this.integers[i] != a.integers[i])
                return false;
        }

        return true;
    }

    public boolean isNotEqualTo(HugeInteger a)
    {
        if(this.sign != a.sign)
            return true;
        if(this.digits != a.digits)
            return true;

        for(int i = 0; i<this.digits; i++)
        {
            if(this.integers[i] != a.integers[i])
                return true;
        }
        return false;
    }

    public boolean isGreaterThan(HugeInteger a)
    {
        if(this.sign != a.sign)
        {
            return this.sign == 0;
        }
        if(this.digits != a.digits)
        {
            if(this.sign == 0)
                return this.digits > a.digits;
            else
                return this.digits < a.digits;
        }
        for(int i = 0; i<this.integers.length; i++)
        {
            if(this.integers[i] > a.integers[i])
                return true;
            if(this.integers[i] < a.integers[i])
                return false;
        }
        return false;
    }

    public boolean isLessThan(HugeInteger a)
    {
        if(this.sign != a.sign)
        {
            return this.sign == 1;
        }
        if(this.digits != a.digits)
        {
            if(this.sign == 1)
                return this.digits > a.digits;
            else
                return this.digits < a.digits;
        }
        for(int i = 0; i<this.integers.length; i++)
        {
            if(this.integers[i] < a.integers[i])
                return true;
            if(this.integers[i] > a.integers[i])
                return false;
        }
        return false;
    }

    public boolean isGreaterThanOrEqualTo(HugeInteger a)
    {
        if(this.sign != a.sign)
        {
            return this.sign == 0;
        }
        if(this.digits != a.digits)
        {
            if(this.sign == 0)
                return this.digits > a.digits;
            else
                return this.digits < a.digits;
        }
        for(int i = 0; i<this.digits; i++)
        {
            if(this.integers[i] > a.integers[i])
                return true;
            if(this.integers[i] < a.integers[i])
                return false;
        }
        return true;
    }

    public boolean isLessThanOrEqualTo(HugeInteger a)
    {
        if(this.sign != a.sign)
        {
            return this.sign == 1;
        }
        if(this.digits != a.digits)
        {
            if(this.sign == 1)
                return this.digits > a.digits;
            else
                return this.digits < a.digits;
        }
        for(int i = 0; i<this.digits; i++)
        {
            if(this.integers[i] < a.integers[i])
                return true;
            if(this.integers[i] > a.integers[i])
                return false;
        }
        return true;
    }
}
