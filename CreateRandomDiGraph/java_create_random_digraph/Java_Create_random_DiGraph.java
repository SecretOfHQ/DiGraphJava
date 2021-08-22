/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_create_random_digraph;


import Generate_DiGraph_List.*;
import java.util.*;

/**
 *
 * @author HOoD
 */
public class Java_Create_random_DiGraph {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter number of VerTiCeS :-");
        int v = sc.nextInt();
        System.out.println();
        
        System.out.println("Enter number of rank iteration :-");
        int i = sc.nextInt();
        System.out.println();
        
        Generate_DiGraph_List g1 = new Generate_DiGraph_List(v,i);
    }

}
