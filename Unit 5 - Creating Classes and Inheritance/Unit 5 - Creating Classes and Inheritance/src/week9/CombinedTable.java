package week9;

public class CombinedTable {
    private SingleTable t1;
    private SingleTable t2;

    public CombinedTable(SingleTable a, SingleTable b){
        t1 = a;
        t2 = b;
    }

    public boolean canSeat(int seats){
        if (t1.getNumSeats() + t2.getNumSeats() - 2 >= seats) return true;
        return false;
    }

    public double getDesirability(){
        if (t1.getHeight() == t2.getHeight()) return (t1.getViewQuality() + t2.getViewQuality()) / 2;
        return (t1.getViewQuality() + t2.getViewQuality()) / 2 - 10;
    }
}
