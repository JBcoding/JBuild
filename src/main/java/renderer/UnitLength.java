package renderer;

public class UnitLength {
    private double amount;
    private Unit unit;

    public UnitLength(double amount, Unit unit) {
        this.amount = amount;
        this.unit = unit;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public double getWidth(double totalWidth, double sumRemainders, double remainderPortion) {
        switch (unit) {
            case METER:
                return amount;
            case PERCENTAGE:
                return amount / 100.0 * totalWidth;
            case REM:
                return remainderPortion * amount / sumRemainders;
            default:
                return 0;
        }
    }
}
