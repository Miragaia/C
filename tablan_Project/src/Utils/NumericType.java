package Utils;

// Não usar diretamente.
// Prefira as classes IntegerType e RealType!

public abstract class NumericType<T extends Number> extends Type {
    protected T value;
 
    protected NumericType(String name) {
       super(name);
    }

    public T get() { return value; }
    public void set(T x) { value = x; }
    public void set(NumericType<T> other) { value = other.value; }

    abstract public NumericType<T> sum(T rhs);
    abstract public NumericType<T> sub(T rhs);
    abstract public NumericType<T> mul(T rhs);
    abstract public NumericType<T> div(T rhs);

    public T sum(NumericType<T> other) { return sum(other.value).get(); }
    public T sub(NumericType<T> other) { return sub(other.value).get(); }
    public T mul(NumericType<T> other) { return mul(other.value).get(); }
    public T div(NumericType<T> other) { return div(other.value).get(); }

    public Boolean equals(T rhs) { return value == rhs; }
    public Boolean notEquals(T rhs) { return !equals(rhs); }

    public Boolean equals(NumericType<T> other) { return equals(other.value); }
    public Boolean notEquals(NumericType<T> other) { return notEquals(other.value); }
 
    public Integer toInt() { return value.intValue(); }
    public Double toReal() { return value.doubleValue(); }

    public boolean isNumeric() { return true; }
    public boolean conformsTo(NumericType<?> other) { return true; }
    public int representationSize() { return value.toString().length(); }

    public String toString() {
        return value.toString();
    }
}