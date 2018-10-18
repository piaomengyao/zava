package future;

import org.junit.Ignore;
import org.junit.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @author Abel
 * @date 2018/10/18
 */
public class CompletableFutureDemoTest {

    private static final String product = "my favorite product";

    @Test
    public void getPriceCompletableFuture() {
        long start = System.nanoTime();
        Future<Double> futurePrice = CompletableFutureDemo.getPriceCompletableFuture(product);
        long invocationTime = ((System.nanoTime() - start) / 1_000_000);
        System.out.println("Invocation returned after " + invocationTime + "msecs");

        //并行执行其他任务

        try {
            double price = futurePrice.get();
            System.out.println("随机计算出的价格为:" + price);
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
        long retrievalTime = ((System.nanoTime() - start) / 1_000_000);
        System.out.println("Price returned after " + retrievalTime + "msecs");
    }

    @Test
    public void getPrice() {
        long start = System.nanoTime();
        double price = CompletableFutureDemo.getPrice(product);
        System.out.println("随机计算出的价格为:" + price);
        long retrievalTime = ((System.nanoTime() - start) / 1_000_000);
        System.out.println("Price returned after " + retrievalTime + "msecs");
    }

    @Test
    public void getPriceAsync() {
        long start = System.nanoTime();
        Future<Double> futurePrice = CompletableFutureDemo.getPriceAsync(product);
        long invocationTime = ((System.nanoTime() - start) / 1_000_000);
        System.out.println("Invocation returned after " + invocationTime + "msecs");

        //并行执行其他任务

        try {
            double price = futurePrice.get();
            System.out.println("随机计算出的价格为:" + price);
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
        long retrievalTime = ((System.nanoTime() - start) / 1_000_000);
        System.out.println("Price returned after " + retrievalTime + "msecs");
    }

    //    @Test
    @Ignore
    public void getPriceExceptionAsync() {
        long start = System.nanoTime();
        Future<Double> futurePrice = CompletableFutureDemo.getPriceExceptionAsync(product);
        long invocationTime = ((System.nanoTime() - start) / 1_000_000);
        System.out.println("Invocation returned after " + invocationTime + "msecs");

        //并行执行其他任务

        try {
            double price = futurePrice.get();
            System.out.println("随机计算出的价格为:" + price);
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
        long retrievalTime = ((System.nanoTime() - start) / 1_000_000);
        System.out.println("Price returned after " + retrievalTime + "msecs");
    }
}