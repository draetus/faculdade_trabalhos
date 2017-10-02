/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univali.kob.poo1.aula06;

import java.util.Comparator;

/**
 *
 * @author Mauricio
 */
public class ContactableNameComparator implements Comparator<Contactable> {
    
    @Override
    public int compare(Contactable c1, Contactable c2)
    {
        System.out.println(c1.getName() + " Comparing to: " + c2.getName());
        return c1.getName().compareTo(c2.getName());
    }
}
