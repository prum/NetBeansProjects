
package mozi;

public class Film {
    private String cim;
    private int jegyar;
    private int sor;
    private int oszlop;
    private int perc;
    private boolean korhatar;
    private int eladott;
    private int[][] terkep = new int [100][100];

public Film(String cim, int jegyar, int sor, int oszlop, int perc){
    this.cim=cim;
    this.jegyar=jegyar;
    this.sor=sor;
    this.oszlop=oszlop;
    this.perc=perc;
    korhatar=false;
    eladott=0;
    for (int i=0;i<sor;i++)
        for (int j=0;j<oszlop;j++)
            terkep[i][j]=0;
}
public String getCim(){
    return cim;
}
    
public int getJegyar(){
    return jegyar;
}

public int getSor(){
    return sor;
}

public int getOszlop(){
    return oszlop;
}
    

public int vesz(int db){
    if (db <=(sor*oszlop)-eladott){
        eladott+=db;
        return db*jegyar;
    }
    else
    return -1;
}

public int getMaradek(){
    return((sor*oszlop)-eladott);
}
public boolean helyvizsgal(int s,int o){
    int x=s;
    int y=o;
    if (terkep[x][y]==0) 
        return false;
    else 
        return true;
          
}
public void helybefoglal(int s, int o){
    int x=s;
    int y=o;
    terkep[x][y]=1;
}
public String toString(){
    return "Filmcím: "+cim+"Ár: "+jegyar+" Összeshely: "+(sor*oszlop)+" Maradék hely: "+((sor*oszlop)-eladott);
}


}
