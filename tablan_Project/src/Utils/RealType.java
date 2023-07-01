package Utils;

public class RealType extends NumericType<Double> {
   public RealType() {
      super("real");
      this.value = 0.0;
   }

   public RealType(Double x) {
      super("real");
      this.value = x;
   }

   public RealType(String text) {
      super("real");
      this.value = Double.parseDouble(text);
   }

   public RealType(RealType other) {
      super("real");
      this.value = other.value;
   }

   public RealType(IntegerType other) {
      super("real");
      this.value = Double.valueOf(other.value);
   }

   //  Solves rare situations where we don't know the class that is being provided
   public RealType sum(Type rhs) {
      if (rhs instanceof RealType) { return new RealType(sum(((RealType)rhs).value)); }
      else if (rhs instanceof IntegerType) { return new RealType(sum(Double.valueOf(((IntegerType)rhs).value)));}
      else { return new RealType(this.value); } //  Ex: 1 + null = 1 
   }
   
   public void set(Double rhs) { this.value = rhs; }
   public void set(RealType rhs) { this.value = rhs.value; }
   public void set(Integer rhs) { this.value = Double.valueOf(rhs); }
   public void set(IntegerType rhs) { this.value = Double.valueOf(rhs.value); }

   public RealType copyType() { return new RealType(this.value); }

   public RealType sum(Double rhs) { return new RealType(value + rhs); }
   public RealType sub(Double rhs) { return new RealType(value - rhs); }
   public RealType mul(Double rhs) { return new RealType(value * rhs); }
   public RealType div(Double rhs) { return new RealType(value / rhs); }

   public RealType sum(Integer rhs) { return new RealType(value + rhs); }
   public RealType sub(Integer rhs) { return new RealType(value - rhs); }
   public RealType mul(Integer rhs) { return new RealType(value * rhs); }
   public RealType div(Integer rhs) { return new RealType(value / rhs); }

   public RealType sum(IntegerType other) { return new RealType(sum(other.value)); }
   public RealType sub(IntegerType other) { return new RealType(sub(other.value)); }
   public RealType mul(IntegerType other) { return new RealType(mul(other.value)); }
   public RealType div(IntegerType other) { return new RealType(div(other.value)); }

   public RealType sum(RealType other) { return new RealType(sum(other.value)); }
   public RealType sub(RealType other) { return new RealType(sub(other.value)); }
   public RealType mul(RealType other) { return new RealType(mul(other.value)); }
   public RealType div(RealType other) { return new RealType(div(other.value)); }

   public RealType minus() { return new RealType(-value); }

   public Boolean equals(RealType other) { return this.value == other.value; }
   public Boolean notEquals(RealType other) { return this.value != other.value; }
   public Boolean equals(Double other) { return this.value == other; }
   public Boolean notEquals(Double other) { return this.value != other; }

   public Boolean higher(RealType other) { return this.value > other.value; }
   public Boolean lower(RealType other) { return this.value < other.value; }
   public Boolean higher(Double other) { return this.value > other; }
   public Boolean lower(Double other) { return this.value < other; }
   public Boolean higher(IntegerType other) { return this.value > other.value; }
   public Boolean lower(IntegerType other) { return this.value < other.value; }
   public Boolean higher(Integer other) { return this.value > other; }
   public Boolean lower(Integer other) { return this.value < other; }

   public Boolean higherEquals(RealType other) { return this.value >= other.value; }
   public Boolean lowerEquals(RealType other) { return this.value <= other.value; }
   public Boolean higherEquals(Double other) { return this.value >= other; }
   public Boolean lowerEquals(Double other) { return this.value <= other; }
   public Boolean higherEquals(IntegerType other) { return this.value >= other.value; }
   public Boolean lowerEquals(IntegerType other) { return this.value <= other.value; }
   public Boolean higherEquals(Integer other) { return this.value >= other; }
   public Boolean lowerEquals(Integer other) { return this.value <= other; }

   @Override
   public String toString() {
      if (value == null) {
         return "null";
      }
      return value.toString();
   }
}
