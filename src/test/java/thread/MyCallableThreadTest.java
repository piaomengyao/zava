package thread;

import org.junit.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @author Abel
 * @date 2018/12/23
 */
public class MyCallableThreadTest {
    @Test
    public void myCallableThreadTest() {
        MyCallableThread ct = new MyCallableThread();
        FutureTask<Integer> f = new FutureTask<>(ct);

        Thread t = new Thread(f);
        t.start();

        try {
            Integer out = f.get(1, TimeUnit.MILLISECONDS);
            System.out.println(out);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            e.printStackTrace();
        }

    }
}