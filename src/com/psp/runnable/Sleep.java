package com.psp.runnable;

public class Sleep implements Runnable {
    @Override
    public void run() {
        for(int i = 0; i< 10; i ++){
            System.out.println(i + " Soy un hilo y esto es lo que hago");
            try {//el hilo duemre durante los millis que indiquemos. Tras esos millis vuelve a iterar
                Thread.sleep(2000);
            }catch (InterruptedException ie){
                ie.printStackTrace();
            }
        }

    }
}
