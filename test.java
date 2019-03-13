import java.util.*;

class synqueue {
    private int front = 0, rear = 0;
    final static int MaxSize = 6;
    private char b[] = new char[MaxSize];

    synchronized void enqueue(char c) {
        if ((rear + 1) % MaxSize == front) {
            try {
                this.wait();
            } catch (InterruptedException e) {
            }
            this.notify();
        }
        rear = (rear + 1) % MaxSize;
        b[rear] = c;
    }

    synchronized char outqueue() {
        if (front == rear) {
            try {
                this.wait();
            } catch (InterruptedException e) {
            }
            this.notify();
        }
        front = (front + 1) % MaxSize;
        return b[front];
    }

}

class producer implements Runnable {
    synqueue sq;

    producer(synqueue sq1) {
        sq = sq1;
    }

    public void run() {
        char c;
        for (int i = 0; i < 20; i++) {
            c = (char) (Math.random() * 26 + 'A');
            sq.enqueue(c);
            System.out.println("producer" + c);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
            }
        }
    }
}

class consumer implements Runnable {
    synqueue sq;

    consumer(synqueue sq1) {
        sq = sq1;
    }

    public void run() {
        char c;
        for (int i = 0; i < 20; i++) {
            c = sq.outqueue();
            System.out.println("consumer" + c);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
            }
        }
    }
}

public class test {

    public static void main(String[] args) {
        synqueue sq = new synqueue();
        producer p1 = new producer(sq);
        consumer c1 = new consumer(sq);
        Thread t1 = new Thread(p1);
        Thread t2 = new Thread(c1);
        t1.start();
        t2.start();
    }


}
