/* Продолжение задания №5.5 */
public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction(int numerator, int denominator) {
        if (denominator == 0) {
            System.out.println("Ошибка: знаменатель не может быть равен нулю");
            this.denominator = 1;
        } else {
            this.denominator = denominator;
        }
        this.numerator = numerator;
    }

    public Fraction add(Fraction other) {
        int newNumerator = this.numerator * other.denominator + other.numerator * this.denominator;
        int newDenominator = this.denominator * other.denominator;
        return new Fraction(newNumerator, newDenominator);
    }

    public Fraction subtract(int number) {
        int newNumerator = this.numerator - number * this.denominator;
        return new Fraction(newNumerator, this.denominator);
    }

    public Fraction divide(Fraction other) {
        if (other.numerator == 0) {
            System.out.println("Ошибка: деление на ноль");
            return this;
        }
        int newNumerator = this.numerator * other.denominator;
        int newDenominator = this.denominator * other.numerator;
        return new Fraction(newNumerator, newDenominator);
    }

    public Fraction multiply(Fraction other) {
        int newNumerator = this.numerator * other.numerator;
        int newDenominator = this.denominator * other.denominator;
        return new Fraction(newNumerator, newDenominator);
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }
}