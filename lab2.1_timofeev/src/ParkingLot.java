public class ParkingLot {
    private int totalSpaces;
    private int occupiedSpaces;
    private double hourlyRate;

    public ParkingLot(int totalSpaces, double hourlyRate) {
        this.totalSpaces = totalSpaces;
        this.hourlyRate = hourlyRate;
        this.occupiedSpaces = 0;
    }

    public boolean parkCar() {
        if (occupiedSpaces < totalSpaces) {
            occupiedSpaces++;
            return true;
        }
        return false;
    }

    public boolean leaveCar() {
        if (occupiedSpaces > 0) {
            occupiedSpaces--;
            return true;
        }
        return false;
    }

    public double calculatePayment(int hours) {
        return hours * hourlyRate;
    }

    public int getAvailableSpaces() { return totalSpaces - occupiedSpaces; }
}