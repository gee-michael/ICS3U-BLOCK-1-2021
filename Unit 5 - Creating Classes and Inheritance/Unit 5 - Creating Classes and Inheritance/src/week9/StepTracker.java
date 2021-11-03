package week9;

public class StepTracker {
    int days = 0;
    int maxDays = 0;
    int steps = 0;
    int max;

    public StepTracker(int num) {
        max = num;
    }

    public void addDailySteps(int steps){
        this.steps += steps;
        days++;
        if (steps > max) maxDays++;
    }

    public int activeDays() {
        return maxDays;
    }

    public double averageSteps() {
        if (days == 0) return 0.0;
        return steps / days;
    }
}
