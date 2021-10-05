package week5;

import java.util.Scanner;

public class CrossCountry {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        makeRunner(in);
        //makeRunner(in);
        //makeRunner(in);
        in.close();
    } 

    private static void makeRunner(Scanner in) {
        String firstName, lastName;
        String mileOne, mileTwo, finish;
        String splitTwo, splitThree;

        System.out.print("Please enter your first name: ");
        firstName = in.nextLine();
        System.out.print("Please enter your last name: ");
        lastName = in.nextLine();
        System.out.print("Hello, " + firstName + " " + lastName + ". Please enter your mile 1 time: ");
        mileOne = in.nextLine();
        System.out.print("Please enter your mile 2 time: ");
        mileTwo = in.nextLine();
        System.out.print("Please enter your finishing time: ");
        finish = in.nextLine();

        splitTwo = reTime(subtractTime(mileTwo, mileOne));
        splitThree = reTime(subtractTime(finish, mileTwo));
        displayInfo(firstName, lastName, mileOne, splitTwo, splitThree, finish);
    }

    private static String reTime(String subtractTime) {
        int mins = (int) (Double.parseDouble(subtractTime)) / 60;
        int secs = (int) (Double.parseDouble(subtractTime)) - (60 * mins);
        String mils = ("" + Double.parseDouble(subtractTime));
        int index = mils.indexOf(".");
        int newMils = (int) (Double.parseDouble(mils.substring(index + 1)) * 10);
        String fixSecs = "";
        if (secs == 0){
            fixSecs = "0";
        }
        return "" + mins + ":" + secs + fixSecs + "." + newMils;
    }

    private static void displayInfo(String firstName, String lastName, String mileOne, String splitTwo, String splitThree, String finish) {
        System.out.println("Name: " + firstName + " " + lastName);
        System.out.println("Mile 1 time: " + mileOne);
        System.out.println("Split 2 time: " + splitTwo);
        System.out.println("Split 3 time: " + splitThree);
        System.out.println("Finishing time: " + finish);
    }

    private static String subtractTime(String mileTwo, String mileOne) {
        double time2Secs = convert(mileTwo);
        double time1Secs = convert(mileOne);
        return "" + getDifference(time2Secs, time1Secs);
    }

    private static double getDifference(double time2Secs, double time1Secs) {
        return time2Secs - time1Secs;
    }

    private static double convert(String time) {
        int stop = time.indexOf(":");
        String min = time.substring(0, stop);
        String sec = time.substring(stop + 1);
        return Math.round(((Integer.parseInt(min) * 60 + Double.parseDouble(sec)) * 100.0)) / 100.0;
    }
}