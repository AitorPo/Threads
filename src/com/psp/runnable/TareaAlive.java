package com.psp.runnable;

public class TareaAlive implements Runnable{
    private Thread otroHilo;

    public TareaAlive(Thread otroHilo){
        this.otroHilo = otroHilo;
    }

    @Override
    public void run() {
        while (otroHilo.isAlive()){
            System.out.println("Hago cosas mientras el otro hilo siga en ejecución");
            try {
                Thread.sleep(1000);
            }catch (InterruptedException ie){
                ie.printStackTrace();
            }
        }
        System.out.println("El otro hilo ha terminado. Yo también");
    }
}
