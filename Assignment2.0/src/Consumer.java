/**
 * Created by Adam Manley Kelly - R00113196  on 20/11/2016.
 */
import java.util.Random;

public class Consumer implements Runnable
{
    private final static Random rand = new Random();
    private final Buffer sharedLocation;

    public Consumer( Buffer shared )
    {
        sharedLocation = shared;
    }

    public void run()
    {
        int guessP;
        int correct=0;
        int incorrect=0;

        for ( int count = 1; count <= 5; count++ )
        {
            try
            {
                Thread.sleep( rand.nextInt( 3000 ) );
                guessP = sharedLocation.getGuessP();
                int guessC = rand.nextInt((10 -1) + 1) + 1;
                if(guessP  == guessC)
                {
                    correct++;
                }
                if(guessP != guessC)
                {incorrect++;}
                System.out.println("\nConsumer Guesses:\t\t\t\t"+guessC);
            }
            catch ( InterruptedException exception )
            {
                exception.printStackTrace();
            }
        }
        System.out.println("\nConsumer guessed Correct: "+ correct+"\nConsumer Guessed Incorrect: "+ incorrect+ "\nTerminating Consumer" );
    }
}
