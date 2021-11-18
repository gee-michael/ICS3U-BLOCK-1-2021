package week11;

public class Sound {
    private int[] samples = {0, 0, 0, 0, 1999, 2000, 2001, -1999, -2000, -2001};

    public int limitAmplitude(int limit){
        int count = 0;
        for (int i = 0; i < samples.length; i++) {
            if (samples[i] > limit){
                samples[i] = limit;
                count++;
            }
            if (samples[i] < -1 * limit){
                samples[i] = -1 * limit;
                count++;
            }
        }
        return count;
    }

    public void trimSilence(){
        int count = 0;
        for (int i = 0; i < samples.length; i++) while (samples[count] == 0) count++;
        int[] arr = new int[samples.length - count];
        for (int i = count; i < samples.length; i++) samples[i] = arr[i];
        samples = arr;
    }
}