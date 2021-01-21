package com.psp.runnable;

public class TareaPrincipal implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i <10; i ++){
            System.out.println("Soy la TareaPrincipal");
            try {
                Thread.sleep(1000);
            }catch (InterruptedException ie){
                ie.printStackTrace();
            }
        }
    }
}
