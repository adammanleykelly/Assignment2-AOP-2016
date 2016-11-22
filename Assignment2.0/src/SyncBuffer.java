/**
 * Created by Adam Manley Kelly - R00113196 on 22/11/2016.
 */

public class SyncBuffer implements Buffer
{
    private int g;
    private boolean occupied = false;

    public synchronized void setGuessP(int gue) throws InterruptedException
    {
        while (occupied)
        {
            System.out.println("Producer tries to write.");
            //displayState("Buffer full. Producer waits.");
            wait();
        }

        g = gue;
        occupied = true;
        notifyAll();

    }

    public synchronized int getGuessP() throws InterruptedException
    {
        while (!occupied)
        {
            System.out.println("Consumer tries to read.");
            //displayState("Buffer empty. Consumer waits.");
            wait();
        }

        occupied = false;
        notifyAll();
        return g;
    }

   /* public void displayState(String operation) {
        System.out.printf("%-40s%d\t\t%b\n\n", operation, g, occupied);
    }*/
}


