public class Fraction {
    private int numerador;
    private int denominador;

    public Fraction(int numerador, int denominador) {
        this.numerador = numerador;
        this.denominador = denominador;

        if (denominador < 0) {
            this.numerador = -numerador;
            this.denominador = -denominador;
        }
    }

    public Fraction(int numerador) {
        this.numerador = numerador;
        this.denominador = 1;
    }

    public int getNumerador() {
        return this.numerador;
    }

    public int getDenominador() {
        return this.denominador;
    }

    public Fraction reduce() {
        int mdc = mdc(numerador, denominador);
        return new Fraction(numerador / mdc, denominador / mdc);
    }

    private int mdc(int a, int b) {
        int res = a;
        if (b != 0) {
            res = mdc(b, a % b);
        } else if (a == 0) {
            res = 1;
        }
        return res;
    }

    @Override
    public String toString() {
        if (this.denominador == 1) {
            return String.valueOf(this.numerador);
        }
        return this.numerador + "/" + this.denominador;
    }
}
