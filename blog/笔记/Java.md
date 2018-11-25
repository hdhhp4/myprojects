# 多线程

## 线程创建

- Thread
- Runnable

**CODE**

```java
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class TicketSell {

	public static class TicketRunnable implements Runnable {
		private AtomicInteger num = new AtomicInteger(5);

		@Override
		public void run() {
			for (int i = 0; i < 10; i++) {
				if (num.get() > 0) {
					TicketSell.sleep(TimeUnit.SECONDS, 2);
					System.out.println(Thread.currentThread().getName() + " ticket left " + num.getAndDecrement());
				}
			}

		}
	}

	public static class TicketThread extends Thread {
		private AtomicInteger num = new AtomicInteger(5);
		
		private String name;

		public TicketThread(String name) {
			super();
			this.name = name;
		}

		public TicketThread() {
			super();
		}

		@Override
		public void run() {
			for (int i = 0; i < 10; i++) {
				if (num.get() > 0) {
					TicketSell.sleep(TimeUnit.SECONDS, 2);
					System.out.println(Thread.currentThread().getName() + " ticket left " + num.getAndDecrement());
				}
			}

		}
	}

	public static void sleep(TimeUnit unit, long num) {
		try {
			unit.sleep(num);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		TicketRunnable ts = new TicketRunnable();
		Thread t = new Thread(ts, "ts");
		Thread t1 = new Thread(ts, "ts1");
		Thread t2 = new Thread(ts, "ts2");
		
		Thread tt = new TicketThread("tt");
		Thread tt1 = new TicketThread("tt1");
		Thread tt2 = new TicketThread("tt2");
		
		tt.start();
		tt1.start();
		tt2.start();

		t.start();
		t1.start();
		t2.start();
	}

}

```

## 中断

**`interrupt()`**

```java
import java.util.concurrent.TimeUnit;

public class SleepInterrupt extends Object implements Runnable {

	@Override
	public void run() {
		try {
			System.out.println("in run() - about to sleep for 20 seconds");
			Util.sleep1(TimeUnit.SECONDS, 20L);
			System.out.println("in run() - wake up");
		} catch (InterruptedException e) {
			System.out.println("in run() - interrupted while sleeping");
			return;
		}
		System.out.println("in run() - leaving normally");
	}
	
	public static void main(String[] args) {
		SleepInterrupt si = new SleepInterrupt();
		Thread t = new Thread(si);
		t.start();
		 
		Util.sleep(TimeUnit.SECONDS, 2L);
		
		System.out.println("in main() - interrupting other thread");
		t.interrupt();
		System.out.println("in main() - leaving");		
	}

}
```

- 待决中断

  *在调用`sleep()`等可中断方法前调用了`interrupt()`方法，当调用可中断方法时立即抛出异常*

```java
import java.util.concurrent.TimeUnit;

public class PendingInterrupt {

	public static void main(String[] args) {
//		if (args.length > 0) {
			Thread.currentThread().interrupt();
//		}
		long startTime = System.currentTimeMillis();

		try {
			Util.sleep1(TimeUnit.SECONDS, 2L);
			System.out.println("was not interrupted");
		} catch (InterruptedException e) {
			System.out.println("was interrupted");
		}
		System.out.println("elapsedTime=" + (System.currentTimeMillis() - startTime));
	}

}
```

*这种模式下，`main`线程中断它自身。除了将中断标志（它是`Thread`的内部标志）设置为`true`外，没有其他任何影响。线程被中断了，但`main`线程仍然运行，`main`线程继续监视实时时钟，并进入`try`块，一旦调用`sleep()`方法，它就会注意到待决中断的存在，并抛出`InterruptException`。于是执行跳转到`catch`块，并打印出线程被中断的信息。最后，计算并打印出时间差。*

**`interrupted()`**

*可以在`Thread`对象上调用`isInterrupted()`方法来检查任何线程的中断状态。这里需要注意：线程一旦被中断，`isInterrupted()`方法便会返回`true`，而一旦`sleep()`方法抛出异常，它将清空中断标志，此时`isInterrupted()`方法将返回`false`。*