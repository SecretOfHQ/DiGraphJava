/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Generate_DiGraph_List;

import com.sun.org.apache.bcel.internal.generic.AALOAD;
import java.util.*;

/**
 *
 * @author HOoD
 */
public class Generate_DiGraph_List {
    
    private int v; // number of vertices
    private int i;
    private final double d = 0.85;
    ArrayList<Integer> count;
    ArrayList<Double> rank;
    ArrayList<ArrayList<Integer>> adjacencyList; // Array work Like Linked List ,for each item of this list has Linked List
    //Like this ( "1 == > 1,2,3,4" , "2 ==> 1 ,2 " , "3 ==> 1,2,6,7,8" , And so on)
    
    private ArrayList<Integer> temp = new ArrayList<>();//(temp Linked List contain all vertices number except
    //same number of current vertex and remove lucky vertices " no Dublicate Edges " ☺ )

    
    public Generate_DiGraph_List(int v, int i) {
        this.v = v;
        this.i = i;
        
        count = new ArrayList<>();
        rank = new ArrayList<Double>();
        
        Create_AdjLis();// 
        Create_Data();
        
        print();
    }
    
    private void Create_AdjLis(){
        adjacencyList = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < v; i++)
        {
            adjacencyList.add(new ArrayList<Integer>());
            count.add(0);
            double x = 1/v;
            rank.add(x);
        }
        
    }
    
    private void rank_calculate(){
        
        
        for(int k = 0; k < v ; k++)
        {                            
            rank.set(k, rank.get(k)+((1-d)/v));
        }
        
        for(int k = 0; k < v ; k++)
        {            
            for (int j = 1; j < i; j++) {                                
                rank.set(k, rank.get(k) + (d*(rank.get(k)/count.get(k))));
            }
        }
        
    }
    
    
    private void Create_Data() {
        
        for(int i = 0; i < v ; i++)
        {
            Create_temp_List(i);
            
            int edges = Generate_Random_Num(v-1);
            
            for (int j = 0; j < edges; j++) {                
                Select_v(i);
            }
        }
        rank_calculate();
    }
    
    
    private void Select_v(int i) {
        int r = Generate_Random_Num(temp.size());
        adjacencyList.get(i).add(temp.get(r));
        count.set((temp.get(r)), (count.get(temp.get(r))) + 1);
        temp.remove(r);
    }
    
    private void Create_temp_List(int k){
        temp.clear();
        for(int i = 0 ; i < v; i++){
            if(k == i)
                continue;
            temp.add(i);
        }

                    
    }

    
    private int Generate_Random_Num(int x){
        Random rand = new Random();        
        return rand.nextInt(x);
    }

    private void print() {
        for(int i = 0 ; i < v; i++)
        {
            System.out.println((i+1) + " :-");
            for(int k = 0; k < adjacencyList.get(i).size() ; k++)
            {
                System.out.print(" ==> " + (adjacencyList.get(i).get(k) + 1));
            }
            System.out.println("\nrank of " + (i+1) + " = " + rank.get(i));
            System.out.println();
        }
    }
    
    
}
