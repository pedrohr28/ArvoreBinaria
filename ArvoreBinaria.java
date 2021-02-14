
package lista1;
public class ArvoreBinaria 
{

    private static class No 
    {
        Item reg ;
        No esq , dir ;
    }
    private No raiz;
    private long comparacoes;
    public ArvoreBinaria()
    {
        this.raiz=null;
        this.comparacoes=0;
    }
     public boolean pesquisa(Item reg)
    {
        return this.pesquisa(reg,this.raiz)!=null;
    }
    public void insere(Item reg)
    {
        this.raiz=this.insere(reg,this.raiz);
    }
    public void retira(Item reg)
    {
        this.raiz=this.retira(reg,this.raiz);
    }
    private Item pesquisa (Item reg,No p)
    {
        if(p==null)
        {
            return null;
        }
        else if (reg.compara(p.reg)<0)
        {
           this.comparacoes++;
            return pesquisa(reg,p.esq);
        }
        else if (reg.compara(p.reg)>0)
        {
            this.comparacoes++;
            return pesquisa(reg,p.dir);
        }
        else 
        {
            this.comparacoes=0;
            return p.reg; 
        } 
    }
    private No insere (Item reg,No p)
    {
        if(p==null)
        {
            p=new No();
            p.reg=reg;
            p.esq=null;
            p.dir=null;
        }
        else if (reg.compara(p.reg)<0)
            p.esq = insere(reg,p.esq);
        else if (reg.compara(p.reg)>0)
            p.dir = insere(reg,p.dir);
        else System.out.println("Erro: Registro ja existente");
        return p;
    }
    private No antecessor(No q,No r)
    {
        if(r.dir!=null)
            r.dir=antecessor(q,r.dir);
        else
        {
            q.reg=r.reg;
            r=r.esq;
        }
        return r;
    }
    private No retira (Item reg,No p)
    {
        if(p==null)
            System.out.println("Erro: Registro nao encontrado");
        else if (reg.compara(p.reg)<0)
            p.esq=retira(reg,p.esq);
        else if (reg.compara(p.reg)>0)
            p.dir=retira(reg,p.dir);
        else
        {
            if(p.dir==null)
                p=p.esq;
            else if (p.esq==null)
                p=p.dir;
            else
                p.esq=antecessor(p,p.esq);
                 
        }
        return p;
    }
    public long getComparacoes()
    {
        return this.comparacoes;
    }
}
