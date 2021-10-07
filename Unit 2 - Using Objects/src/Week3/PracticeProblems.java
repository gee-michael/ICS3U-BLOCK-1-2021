package Week3;

public class PracticeProblems {
    public static void main(String[] args){
        questionA(); // random # from 1 - 100
        questionB(); // win % of 1927 NYY
    }

    public static void questionA(){
        int num = (int)(Math.random()*100) + 1;
        System.out.println(num);
    }

    public static void questionB(){
        int games = 110 + 44;
        double num = (int) (110.0 / games * 1000) / 1000.0;
        System.out.println(num);
    }
}
