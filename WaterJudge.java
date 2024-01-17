package AIML;

import java.util.*;  

class WaterJugProblemExample1{  
  
    public static void main(String sap[]){  
    
        Scanner scan = new Scanner(System.in);  
  
        System.out.print("Enter value for Tank1, i.e., odd capacity of small tank: ");  
        int tank1 = scan.nextInt();  
  
        System.out.print("\nEnter value for Tank2, i.e., odd capacity of large tank: ");  
        int tank2 = scan.nextInt();  
          
        scan.close();  
  
    
        int count = tank1 + tank2;  
  
      
        int jug1[] = new int[count];  
        int jug2[] = new int[count];  
  
        int j = 0;  
  
        jug1[j] = tank1;  
        jug2[j] = 0;  
        j++;  
  
       
        jug1[j] = 0;  
        jug2[j] = tank1;  
        j++;  
  
        while(j < count){  
              if(jug1[ j - 1 ] > 0){  
                 
                   jug1[j] = jug1[ j - 1 ];  
                   jug2[j] = 0;  
              } else{  
               
                   jug1[j] = tank1;  
                   jug2[j] = jug2[ j - 1 ];  
              }  
              j++;  
      
              if(jug2[ j - 1 ] > 0){  
              
                   if(jug1[ j - 1 ] + jug2[ j - 1 ] < tank2){  
                    
                         jug2[j] = jug1[ j - 1 ] + jug2[ j - 1 ];  
                         jug1[j] = 0;  
                   } else{  
                       int temp = jug2[ j - 1 ];  
                       temp = tank2 - temp;  
                       jug2[j] = temp + jug2[ j - 1 ];  
       
                       jug1[j] = jug1[ j - 1 ] - temp;  
                   }  
              }  
              else{  
                  
                   jug2[j] = jug1[ j - 1 ];  
                   jug1[j] = 0;   
             }  
             j++;  
        }  
      
        for(j = 0; j<count; j++){  
            System.out.print("\nJug1: " + jug1[j] + "\tJug2: " + jug2[j]);  
        }  
        System.out.println();  
    }  
}  