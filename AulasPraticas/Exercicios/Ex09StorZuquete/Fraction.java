public class Fraction {
	public Integer numerator = null;
	public Integer denominator = null;

	public Fraction(Integer nNum, Integer dNum) {
		this.numerator = nNum;
		this.denominator = dNum;
	}


   	public static Integer gcd(Integer a, Integer b) {
        	return b == 0 ? a : gcd(b, a % b);
	}

	public Fraction reduce() { 
		Integer greatestCommonDeno = gcd(this.numerator, this.denominator);
		this.numerator /= greatestCommonDeno;
		this.denominator /= greatestCommonDeno;
		return this;
	}

	public Fraction mul(Fraction b) {
		this.numerator *= b.numerator;
		this.denominator *= b.denominator;
		return this;
	}


        public Fraction div(Fraction b) {
                this.numerator *= b.denominator;
                this.denominator *= b.numerator;
                return this;
        }

        public Fraction sum(Fraction b) {
                this.numerator = this.numerator * b.denominator + b.numerator * this.denominator;
                this.denominator *= b.denominator;
                return this;
        }

        public Fraction sub(Fraction b) {
                this.numerator = this.numerator * b.denominator - b.numerator * this.denominator;
                this.denominator *= b.denominator;
                return this;
        }

        public Fraction power(Fraction b) {
                this.numerator = (int) Math.pow(this.numerator, b.numerator/b.denominator);
                this.denominator = (int) Math.pow(this.denominator, b.numerator/b.denominator);;
                return this;
        }

        public Fraction minus() {
                this.numerator = this.numerator * -1;
                return this;
        }

		public String print() {
			System.out.println(this.numerator + "/" + this.denominator);
			return null;
		}


	@Override
	public String toString() {
		return Integer.toString(numerator) + "/" + Integer.toString(denominator);
	}
}
