package Utils;

public class IntegerType extends NumericType<Integer> {
   public IntegerType() {
      super("integer");
      this.value = 0;
   }

   public IntegerType(Integer x) {
      super("integer");
      this.value = x;
   }

   public IntegerType(IntegerType other) {
      super("integer");
      this.value = other.value;
   }

   //  Solves rare situations where we don't know the class that is being provided
   public IntegerType sum(Type rhs) {
      if (rhs instanceof IntegerType) { return new IntegerType(sum((IntegerType)rhs));}
      else { return new IntegerType(this.value); } //  Ex: 1 + null = 1 
   }
   
   public void set(Integer rhs) { this.value = rhs; }
   public void set(IntegerType rhs) { this.value = rhs.value; }

   public Type copyType() { return new IntegerType(this.value); }

   public IntegerType sum(Integer rhs) { return new IntegerType(value + rhs); }
   public IntegerType sub(Integer rhs) { return new IntegerType(value - rhs); }
   public IntegerType mul(Integer rhs) { return new IntegerType(value * rhs); }
   public IntegerType div(Integer rhs) { return new IntegerType(value / rhs); }
   
   public RealType sum(RealType other) { return new RealType(value + other.value); }
   public RealType sub(RealType other) { return new RealType(value - other.value); }
   public RealType mul(RealType other) { return new RealType(value * other.value); }
   public RealType div(RealType other) { return new RealType(value / other.value); }

   public IntegerType sum(IntegerType other) { return new IntegerType(sum(other.value)); }
   public IntegerType sub(IntegerType other) { return new IntegerType(sub(other.value)); }
   public IntegerType mul(IntegerType other) { return new IntegerType(mul(other.value)); }
   public IntegerType div(IntegerType other) { return new IntegerType(div(other.value)); }

   public IntegerType minus() { return new IntegerType(-this.value); }


   public Boolean equals(IntegerType other) { return this.value == other.value; }
   public Boolean notEquals(IntegerType other) { return this.value != other.value; }
   public Boolean equals(Integer other) { return this.value == other; }
   public Boolean notEquals(Integer other) { return this.value != other; }

   public Boolean higher(IntegerType other) { return this.value > other.value; }
   public Boolean lower(IntegerType other) { return this.value < other.value; }
   public Boolean higher(Integer other) { return this.value > other; }
   public Boolean lower(Integer other) { return this.value < other; }
   public Boolean higher(RealType other) { return this.value > other.value; }
   public Boolean lower(RealType other) { return this.value < other.value; }
   public Boolean higher(Double other) { return this.value > other; }
   public Boolean lower(Double other) { return this.value < other; }

   public Boolean higherEquals(IntegerType other) { return this.value >= other.value; }
   public Boolean lowerEquals(IntegerType other) { return this.value <= other.value; }
   public Boolean higherEquals(Integer other) { return this.value >= other; }
   public Boolean lowerEquals(Integer other) { return this.value <= other; }
   public Boolean higherEquals(RealType other) { return this.value >= other.value; }
   public Boolean lowerEquals(RealType other) { return this.value <= other.value; }
   public Boolean higherEquals(Double other) { return this.value >= other; }
   public Boolean lowerEquals(Double other) { return this.value <= other; }
   
   @Override
   public String toString() {
      if (value == null) {
         return "null";
      }
      return value.toString();
   }
}
