/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafotad;

import java.util.ArrayList;

/**
 *
 * @author Mauricio
 */
public class Apontador {
    
    private ArrayList<Vertice> v = new ArrayList<>();
    private float valor;
    
    public Apontador(ArrayList<Vertice> v, float valor){
        this.v = v;
        this.valor = valor;
    }
    
    public ArrayList<Vertice> getVertices ()
    {
        return v;
    }
    
    public float getValor()
    {
        return valor;
    }
    
    public void addVertice (Vertice v)
    {
        this.v.add(v);
    }
    
    public void setValor(float valor)
    {
        this.valor = valor;
    }
    
}
