package thread;

/**
 * 继承Thread实现多线程
 *
 * @author Abel
 * @date 2018/12/23
 */
public class MyThread extends Thread{
    @Override
    public void run() {
     System.out.println("输出一段话");
    }
}