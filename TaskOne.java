public class TaskOne {

    private final Object someThing = new Object();
    private volatile char currentSomeThing = 'A';

    public static void main(String[] args) {
        TaskOne task1 = new TaskOne();
        Thread t1 = new Thread(() -> {
            task1.printA();
        });

        Thread t2 = new Thread(() -> {
            task1.printB();
        });

        Thread t3 = new Thread(() -> {
            task1.printC();
        });

        t1.start();
        t2.start();
        t3.start();
    }

    public void printA() {
        synchronized (someThing) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (currentSomeThing != 'A') {
                        someThing.wait();
                    }
                    System.out.print("A");
                    currentSomeThing = 'B';
                    someThing.notifyAll();
                }
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void printB() {
        synchronized (someThing) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (currentSomeThing != 'B') {
                        someThing.wait();
                    }
                    System.out.print("B");
                    currentSomeThing = 'C';
                    someThing.notifyAll();
                }
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void printC() {
        synchronized (someThing) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (currentSomeThing != 'C') {
                        someThing.wait();
                    }
                    System.out.print("C");
                    currentSomeThing = 'A';
                    someThing.notifyAll();
                }
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
