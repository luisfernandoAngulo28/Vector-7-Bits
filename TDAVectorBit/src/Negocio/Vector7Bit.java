/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

/**
 *
 * @author Estudiante
 */
public class Vector7Bit { 
    int v[];
    int dim;

    public Vector7Bit(int cant){
        int Nbit = 7*cant;
        System.out.println("Nbit="+Nbit);
        int NE = Nbit/32;
        System.out.println("NE="+NE);
        if (Nbit%32!=0){
            NE++;
             System.out.println("holaa "+NE);
        }
        System.out.println("int["+NE+"]");
        v = new int[NE];
        dim = cant;
    }
    private int SacarNbit(int pos){
        return (pos-1)*7;
    }
    private int SacarNE(int pos){
        return 1;
    }
    public void Insertar(int Elemento, int pos){
        int Elemento1 = Elemento;
        int mask = (int) (Math.pow(2, 7)-1);
        int nbit = SacarNbit(pos); // 2=7 
        int NE = SacarNE(pos); // 2=0
        mask = mask <<nbit;
        mask = ~mask;
        v[NE] = v[NE]&mask;
        Elemento = Elemento<<nbit;
        v[NE] = v[NE]|Elemento;
        if(nbit+7>32){
            int mask1 = (int)(Math.pow(2, 7)-1);
            mask1 = mask1>>(32-nbit);
            mask1 = ~mask1;
            v[NE+1] = v[NE+1]& mask1;
            Elemento1 = Elemento1>>>(32-nbit);
            v[NE+1] = v[NE+1]|Elemento1;
        }
    }
    
    public static void main(String[] args) {
       Vector7Bit A=new Vector7Bit(4);
    }
}
