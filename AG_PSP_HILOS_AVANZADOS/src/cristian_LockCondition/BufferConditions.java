package LockCondition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BufferConditions {
    private Object[] buf;
    private int in = 0, out = 0, count = 0, size;
    Lock lock = new ReentrantLock();
    Condition noLleno = lock.newCondition();
    Condition noVacio = lock.newCondition();

    public BufferConditions(int size) {
        this.size = size;
        buf = new Object[size];
    }

    public void put(Object obj) throws InterruptedException {

        lock.lock();
        try {
            while (count == buf.length)
                noLleno.await();
            buf[in] = obj;
            count++;
            in = (in + 1) % size;
            noVacio.signal();
        } finally {
            lock.unlock();
        }
    }

    public Object get() throws InterruptedException {
        Object obj=null;
//        while (lock.tryLock()) {
//            System.out.println("intento coger................");
            lock.lock();
            try {
                while (count == 0)
                    noVacio.await();
                 obj = buf[out];
                buf[out] = null;
                count--;
                out = (out + 1) % size;
                noLleno.signal();
            } finally {
                lock.unlock();
            }

//        }
                return (obj);
    }
}