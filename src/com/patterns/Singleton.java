package com.patterns;

import java.io.Serializable;

public class Singleton implements Serializable {

    private static Singleton instance = null;

    private Singleton() {
        //private constructor of singleton
    }

    /**
     * Returns a singleton instance using lazy initialization method
     * @return Singleton
     */
    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

    // implement readResolve method
    protected Object readResolve() { return instance; }

    /**
     *
     * @return
     * @throws CloneNotSupportedException
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("Clone is not supported for singleton");
    }
}
