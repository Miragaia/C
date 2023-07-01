class Program {
	public static void main(String args[]) {
		Fraction x;
		Fraction y;

		(new Fraction(1, 4)).print();
		(new Fraction(3, 1)).print();
		x = (new Fraction(3, 4));
		x.print();
		(new Fraction(1, 4)).sub((new Fraction(1, 4))).print();
		x.reduce();
		x = (new Fraction(1, 6)).power((new Fraction(2, 3)));
		y = (new Fraction(13, 7));
		x = x.div(y);
		x = y.sum(x);
		x = x.sum((new Fraction(146, 91)));
		x.print();
		x.reduce();
		x.print();

	}
}