package week9;

public class SingleTable {
    private int seats;
    private int height;
    private double view;

    public SingleTable(int s, int h, double v){
        seats = s;
        height = h;
        view = v;
    }

    public int getNumSeats(){
        return seats;
    }

    public int getHeight(){
        return height;
    }

    public void setViewQuality(double quality){
        view = quality;
    }

    public double getViewQuality(){
        return view;
    }
}