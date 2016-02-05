/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex1;

import javax.swing.JFileChooser;

/**
 *
 * @author David
 */
public class Tester {
    
    public static void main(String[] args) throws InterruptedException {
        
        System.out.println("Avilable Processors: " + Runtime.getRuntime().availableProcessors());
        
        Biteme b1 = new Biteme("https://fronter.com/cphbusiness/design_images/images.php/Classic/login/fronter_big-logo.png");
        Biteme b2 = new Biteme("https://fronter.com/cphbusiness/design_images/images.php/Classic/login/folder-image-transp.png");
        Biteme b3 = new Biteme("https://fronter.com/volY12-cache/cache/img/design_images/Classic/other_images/button_bg.png");
        
        Thread t1 = new Thread(b1);
        Thread t2 = new Thread(b2);
        Thread t3 = new Thread(b3);
        
        long start = System.nanoTime();
        
        t1.start();
        t2.start();
        t3.start();
        
        
//        t1.run();
//        t2.run();
//        t3.run();
        
        t1.join();
        t2.join();
        t3.join();
        
        int tot = b1.getSum() + b2.getSum() + b3.getSum();
        
        System.out.println("Total Sum: " + tot);
        long end = System.nanoTime();
        System.out.println("Time Sequental: " + (end-start));
        
        
        
    }
    
}
