/**
 * Created by Adam Manley Kelly - R00113196  on 22/11/2016.
 * https://github.com/adammanley-kelly/Assignment2-AOP-2016
 * Based off of FIG26_18-19 from class notes
 */

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test
{
    public static void main( String[] args )
    {
        ExecutorService app = Executors.newCachedThreadPool();

        Buffer sharedLocation = new SyncBuffer();

        System.out.print("Operation\n");
        System.out.println("---------");

        app.execute( new Producer( sharedLocation ) );
        app.execute( new Consumer( sharedLocation ) );

        app.shutdown();
    }
}


