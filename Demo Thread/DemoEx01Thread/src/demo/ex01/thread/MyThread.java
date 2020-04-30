package demo.ex01.thread;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Minh Tan
 */
public class MyThread extends Thread {

    @Override
    public void run() {
        for (int i = 0; i <= 9; i++) {
            System.out.println(getName() + " " + i);
            try {
                sleep(1000);
            } catch (InterruptedException e) {
            }
        }
    }
    
}
