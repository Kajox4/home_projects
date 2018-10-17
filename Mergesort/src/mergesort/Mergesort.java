/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mergesort;

/**
 *
 * @author kajte
 */
public class Mergesort {
    
    public static int[] merge( int tab[]){
        int dl = tab.length;
        if(dl == 1)
            return tab;
        else if(dl==2){
            if(tab[0] < tab[1]){
                return tab;
            }
            else{
                int pom = tab[0];
                tab[0] = tab[1];
                tab[1] = pom;
                return tab;
            }
        }
        else{
            if (dl%2 == 0){
                int ppol[] = new int[dl/2];
                int dpol[] = new int[dl/2];
                for(int i = 0; i < dl/2; i++){
                    ppol[i] = tab[i];
                }
                for(int i = dl/2; i < dl; i++){
                    dpol[i-dl/2] = tab[i];
                }
                int [] got1 = merge(ppol);
                int [] got2 = merge(dpol);
                int pit = 0, dit = 0, git = 0;
                while(pit < got1.length || dit < got2.length){
                    if(pit<got1.length){
                        if(dit == got2.length || got1[pit] < got2[dit] || got1[pit] == got2[dit]){
                            tab[git] = got1[pit];
                            git++;
                            pit++;
                        }
                        else{
                        tab[git] = got2[dit];
                        dit++;
                        git++;
                        }
                    }
                    else{
                        tab[git] = got2[dit];
                        dit++;
                        git++;
                    }
                }
            }
            else{
                int ppol[] = new int[(dl-1)/2];
                int dpol[] = new int[(dl+1)/2];
                for(int i = 0; i < (dl-1)/2; i++){
                    ppol[i] = tab[i];
                }
                for(int i = (dl-1)/2; i < dl; i++){
                    dpol[i-(dl-1)/2] = tab[i];
                }
                int [] got1 = merge(ppol);
                int [] got2 = merge(dpol);
                int pit = 0, dit = 0, git = 0;
                while(pit < got1.length || dit < got2.length){
                    if(pit<got1.length){
                        if(dit == got2.length || got1[pit] < got2[dit] || got1[pit] == got2[dit]){
                            tab[git] = got1[pit];
                            git++;
                            pit++;
                        }
                        else{
                        tab[git] = got2[dit];
                        dit++;
                        git++;
                        }
                    }
                    else{
                        tab[git] = got2[dit];
                        dit++;
                        git++;
                    }
                }
            }
        }
        return tab;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int tab[] = {98,45,3,24,6,78,3,-12,66,90,456,32,1,0,-678,-21};
        for(int i = 0; i < tab.length; i++)
            System.out.println(tab[i]);
        
        System.out.println("Posortowane:");
        tab = merge(tab);
        for(int i = 0; i < tab.length; i++)
            System.out.println(tab[i]);
        
    }
    
}
