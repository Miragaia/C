package Utils;

public abstract class Type {

   protected final String name;

   protected Type(String name) {
      assert name != null;
      this.name = name;
   }

   public String name() { return name; }
   public IntegerType length() { return new IntegerType(0); }
   public Type copyType() { return null; }

   //  Number of characters if this value was transformed into a string 
   // (very usefull for calculating RealType size because of the trailing numbers
   // after the .)
   //  Ex: 213.73 will return 6
   public int representationSize() { return 0; }

   //  See if type is the same as another
   public boolean conformsTo(Type other) {
      return name.equals(other.name());
   }

   //  Simple calculations, to be overwriten by the individual classes

   public Type sum(Double rhs) { return null; }
   public Type sub(Double rhs) { return null; }
   public Type mul(Double rhs) { return null; }
   public Type div(Double rhs) { return null; }

   public Type sum(Integer rhs) { return null; }
   public Type sub(Integer rhs) { return null; }
   public Type mul(Integer rhs) { return null; }
   public Type div(Integer rhs) { return null; }

   public Type sum(String rhs) { return null; }
   public Type sub(String rhs) { return null; }
   public Type mul(String rhs) { return null; }
   public Type div(String rhs) { return null; }

   public Type sum(Type other) { return null; }
   public Type sub(Type other) { return null; }
   public Type mul(Type other) { return null; }
   public Type div(Type other) { return null; }

   
   public Boolean equals(Type other) { return false; }
   public Boolean notEquals(Type other) { return false; }

   //  See if the object is numeric or not
   abstract public boolean isNumeric();
   
   @Override
   public String toString() {
      return "null";
   }
}
