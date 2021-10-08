package Week4;

// THIS IS WRONG :/

public class BayviewGlenPools {
    public static void main(String[] args) {
        final int l = 20; // length
        final int w = 8; // width
        final int sD = 3; // shallow depth
        final int sL = 5; // shallow length
        final int dD = 8; // deep depth
        final int t = 7; // transition length (diagonal)
        final int liner = 2; // liner cost

        final int tL = (int) Math.sqrt(Math.pow(t, 2) - Math.pow((double) (dD - sD), 2.0)); // transition length (horiz)
        final int dL = l - tL - sL; // deep length

        int volume = calcVolume(l, w, sL, sD, t, dD, tL, dL);
        int area = calcArea(l, w, sL, sD, t, dD, tL, dL);

        System.out.println((int) (volume * 0.9) + "m^3"); // 90% capacity
        System.out.println(area + "m^2"); // liner needed
        System.out.println("$" + area * liner); // liner cost
    }

    private static int calcVolume(int l, int w, int sL, int sD, int t, int dD, int tL, int dL) {
        return (sD * (sL + tL) * w) + (dD * w * dL) + (tL * (dD - sD) / 2 * w);
    }

    private static int calcArea(int l, int w, int sL, int sD, int t, int dD, int tL, int dL) {
        return (w * sD) + (w * sL) + (w * t) + (w * dD) + (w * dL) + (2 * (sD * (sL + tL) + (dD * dL) + (tL * (dD - sD) / 2)));
    }   
}