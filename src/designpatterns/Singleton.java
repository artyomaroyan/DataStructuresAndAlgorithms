package designpatterns;

/**
 * Author: Artyom Aroyan
 * Date: 05.09.25
 * Time: 23:09:09
 */
public final class Singleton {
    private Singleton() {
    }

    // this is implementation of singleton lazy initialization
    // this is not thread safe
    private static class LazyInitializedSingleton {
        private static LazyInitializedSingleton instance;

        private LazyInitializedSingleton() {
        }

        public static LazyInitializedSingleton getInstance() {
            if (instance == null) {
                instance = new LazyInitializedSingleton();
            }
            return instance;
        }
    }

    // this is implementation of thread safe singleton initialization.
    // this is thread safe but slower.
    private static class ThreadSafeSingleton {
        private static ThreadSafeSingleton instance;

        private ThreadSafeSingleton() {
        }

        public static synchronized ThreadSafeSingleton getInstance() {
            if (instance == null) {
                instance = new ThreadSafeSingleton();
            }
            return instance;
        }
    }

    // this is double-checked locking singleton initialization.
    // this is thread safe and faster than only thread safe version.
    private static class DoubleCheckedLockingSingleton {
        private static DoubleCheckedLockingSingleton instance;

        private DoubleCheckedLockingSingleton() {
        }

        public static DoubleCheckedLockingSingleton getInstance() {
            if (instance == null) {
                synchronized (DoubleCheckedLockingSingleton.class) {
                    if (instance == null) {
                        instance = new DoubleCheckedLockingSingleton();
                    }
                }
            }
            return instance;
        }
    }

    // this is best practice thread safe, lazy initialize and no synchronized overhead.
    private static class BillPughSingleton {
        private BillPughSingleton() {
        }

        private static class SingletonHelper {
            private static final BillPughSingleton INSTANCE = new BillPughSingleton();
        }

        public static BillPughSingleton getInstance() {
            return SingletonHelper.INSTANCE;
        }
    }
}