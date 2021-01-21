package com.psp;

import com.psp.runnable.*;
import com.psp.thread.Tarea;

/*
Tres formas dintistas de implementar hilos/threads
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {
         //hiloThread();
         //hiloRunnable();
         //hiloRunnable();
        //sincronizacionJoinI();
        sincronizacionJoinII();
        //threadSleep();
        //threadAlive();


    }
    public static void hiloThread(){
        /**
         * Hilos heredando de la clase Thread.
         * NombreDeLaClase extends Thread
         */
        Tarea tarea = new Tarea();
        tarea.start();

        System.out.println("Soy el hilo principial");
        System.out.println("Fin del hilo principal");
    }

    public static void hiloRunnable(){
        /**
         * Hilos heredando de una segunda clase random implementando interface Runnable
         * NombreDeLaClase extends NombreDeLaSegundaClase implements Runnable
         */
        TareaRunnable tareaRunnable = new TareaRunnable();
        Thread thread = new Thread(tareaRunnable);
        thread.start();

        System.out.println("Soy el hilo principial");
        System.out.println("Fin del hilo principal");
    }

    public static void hiloAnoniumo(){
        /**
         * Hilos a partir de una clase anónima (new Runnable());
         */
        Thread hilo = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i< 10; i ++){
                    System.out.println("Soy un hilo");
                }
            }
        });

        hilo.start();

        System.out.println("Soy el hilo principial");
        System.out.println("Fin del hilo principal");

    }

    public static void sincronizacionJoinI(){
        /**
         * Sincronización de hilos mediante join()
         */
        Thread hilo1 = new Thread(new Tarea());
        Thread hilo2 = new Thread(new Tarea());

        hilo1.start();
        hilo2.start();

        try {
            hilo1.join();
            hilo2.join();
        }catch (InterruptedException ie){
            ie.printStackTrace();
        }

        System.out.println("Fin de la ejecución de los dos hilos");
    }

    public static void sincronizacionJoinII(){
        Hilo1 hilo1 = new Hilo1();
        Hilo2 hilo2 = new Hilo2();

        hilo1.start();/*
        try {
            hilo1.join();
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
*/
        hilo2.start();/*
        try {
            hilo2.join();
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
*/
        System.out.println("Fin de la ejecución de los dos hilos");

    }

    public static void threadSleep(){
        Sleep sleep = new Sleep();
        sleep.run();
    }


    public static void threadAlive(){
        TareaPrincipal tareaPrincipal = new TareaPrincipal();
        Thread hiloPrincipal = new Thread(tareaPrincipal);

        TareaAlive tareaAlive = new TareaAlive(hiloPrincipal);
        Thread hiloAlive = new Thread(tareaAlive);

        hiloPrincipal.start();
        hiloAlive.start();

        System.out.println("Se han terminado los dos hilos?");
    }
}
