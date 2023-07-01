package Utils;

public class TextType extends Type {
   String value;
   
   public TextType() {
      super("text");
   }

   public TextType(String value) {
      super("text");
      this.value = value;
   }

   public String get() { return value; }
   public TextType copyType() { return new TextType(this.value); }
   public void set(String s) { value = s; }
   public void set(TextType s) { value = s.value; }

   public int representationSize() { return value.length(); }

   public TextType sum(String rhs) { return new TextType(this.value + rhs); }

   //  Can't use just one sum(Type) as every type's get return a diferent class of object
   public TextType sum(TextType other) { return new TextType(this.value + other.get()); }
   public TextType sum(IntegerType other) { return new TextType(this.value + other.get()); }
   public TextType sum(RealType other) { return new TextType(this.value + other.get()); }

   public boolean isNumeric() { return false; }
   public IntegerType length() { return new IntegerType(value.length()); }

   @Override
   public String toString() {
      if (value == null || value == "") {
         return "null";
      }
      return value;
   }

   public Boolean equals(TextType other) { return this.value == other.value; }
   public Boolean notEquals(TextType other) { return this.value != other.value; }
   public Boolean equals(String other) { return this.value == other; }
   public Boolean notEquals(String other) { return this.value != other; }
}
