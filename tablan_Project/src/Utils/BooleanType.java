package Utils;

public class BooleanType extends Type {
   Boolean value;
   
   public BooleanType() {
      super("boolean");
   }

   public BooleanType(Boolean value) {
      super("text");
      this.value = value;
   }

   public Boolean get() { return value; }
   public BooleanType copyType() { return new BooleanType(this.value); }
   public void set(Boolean s) { value = s; }
   public void set(BooleanType s) { value = s.value; }

   public int representationSize() { return this.value ? 4 : 5; }

   public boolean isNumeric() { return false; }

   @Override
   public String toString() {
      if (value == null) {
         return "null";
      }
      return value ? "true" : "false";
   }

   public Boolean equals(BooleanType other) { return this.value == other.value; }
   public Boolean notEquals(BooleanType other) { return this.value != other.value; }
   public Boolean equals(Boolean other) { return this.value == other; }
   public Boolean notEquals(Boolean other) { return this.value != other; }
}
