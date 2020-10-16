/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gna;

import static java.lang.Math.sqrt;
import static java.lang.Math.log;
import static java.lang.Math.sin;
import java.util.Random;

/**
 *
 * @author Mauricio
 */
public class Distribuicoes {
    
    public double uniforme(double a,double b){
        Random random = new Random();
        return a + ((b - a)*random.nextDouble());
    }
    
    public double exponencial(double a){
        Random random = new Random();
        return -a * Math.log(random.nextDouble());
    }
    
    public double normal(double media, double variancia){
        Random random = new Random();
        double z = sqrt(-2 * log(random.nextDouble())) * sin( 2 * Math.PI * random.nextDouble());
        return media + (variancia * z);
    }
    
    public double triangular(double a,double b, double moda){
        Random random = new Random();
        double r = random.nextDouble();
        if (r < ((moda - a)/(b-a))) {
            return (a + sqrt(r * (moda - a)*(b - a)));
        }
        return (b - sqrt((1 - r)*(b - moda)*(b - a)));
    }
    
}
