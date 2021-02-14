
package lista1;
import java.util.Random;
public class Lista1 {

   
    public static void main(String[] args) 
    {
        
        //Ordenada
        ArvoreBinaria []arvore_ordenada =new ArvoreBinaria[9];
        for(int i=0;i<9;i++)
        {
            arvore_ordenada[i]=new ArvoreBinaria();
        }
        for(int i=0;i<9;i++)
        {
            int tamanho=1000*(i+1);
            Item []itens= new Item[tamanho];
            for(int j=0;j<tamanho;j++)
           {
               itens[j]=new Item(j+1);
               arvore_ordenada[i].insere(itens[j]);
           }
        }
        System.out.println("");
        System.out.println("ARVORE ORDENADA:");
        for(int k=0;k<9;k++)
        {
           Item num = new Item((1001)*(k+1));
           long n=System.nanoTime();
           arvore_ordenada[k].pesquisa(num);
           long n2=System.nanoTime()-n;
           System.out.println("Arvore " + (k+1) + " = " + arvore_ordenada[k].getComparacoes()+" comparacoes, Tempo = "+n2+" nanosegundos");
        }
        //Aleatoria
        ArvoreBinaria []arvore_aleatoria =new ArvoreBinaria[9];
        Random gerador= new Random();
        for(int i=0;i<9;i++)
        {
            arvore_aleatoria[i]=new ArvoreBinaria();
        }
        for(int i=0;i<9;i++)
        {
            int tamanho=1000*(i+1);
            Item []itens= new Item[tamanho];
            //System.out.println("Arvore "+(i+1));
            for(int j=0;j<tamanho;j++)
            {
                itens[j]=new Item(gerador.nextInt(tamanho));
                //verifica se o numero aleatorio gerado ja tem na arvore
                while(arvore_aleatoria[i].pesquisa(itens[j])==true)
                {
                    itens[j]=new Item(gerador.nextInt(tamanho));
                }
                arvore_aleatoria[i].insere(itens[j]);
            }
        }
        System.out.println("");
        System.out.println("ARVORE ALEATORIA:");
        for(int k=0;k<9;k++)
        {
           //Item num = new Item(1001*(k+1));
           Item num = new Item(15000);
           long n=System.nanoTime();
           arvore_aleatoria[k].pesquisa(num);
           long n2=System.nanoTime()-n;
           System.out.println("Arvore " + (k+1) + " = " + arvore_aleatoria[k].getComparacoes()+" comparacoes, Tempo = "+n2+" nanosegundos");
        }
        
    }
    
}
