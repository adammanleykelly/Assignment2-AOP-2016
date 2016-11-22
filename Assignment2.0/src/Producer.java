/**
 * Created by Adam Manley Kelly - R00113196 on 20/11/2016.
 */
import java.util.Random;

public class Producer implements Runnable
{
    private final static Random rand = new Random();
    private final Buffer sharedLocation;

    public Producer(Buffer shared) {
        sharedLocation = shared;
    }

    public void run() {
        int guess;

        for (int count = 1; count <= 5; count++) {
            try {
                Thread.sleep(rand.nextInt(3000));
                guess = rand.nextInt((10 - 1) + 1) + 1;
                sharedLocation.setGuessP(guess);
                System.out.println("\nProducer produces guess of:\t\t" + guess);
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }
        }

        System.out.println("\nProducer done producing\nTerminating Producer");
    }
}