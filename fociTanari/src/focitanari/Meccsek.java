
package focitanari;
public class Meccsek {
    private int ford;
    private int veghazai;
    private int vegvendeg;
    private int felhazai;
    private int felvendeg;
    private String hazaics;
    private String vendegcs;
    private boolean megford;
    private boolean hgyoz;
    private boolean vgyoz;
    private boolean dont;
    
    
    
    public Meccsek(String[] adat){
	ford = Integer.parseInt(adat[0]); 
	veghazai = Integer.parseInt(adat[1]); 
	vegvendeg = Integer.parseInt(adat[2]); 
	felhazai = Integer.parseInt(adat[3]); 
	felvendeg = Integer.parseInt(adat[4]); 
        hazaics = adat[5];
        vendegcs = adat[6];
        
        if ((veghazai>vegvendeg && felhazai<felvendeg) || (veghazai<vegvendeg && felhazai>felvendeg))
            megford = true;
            else
            megford = false;
        if (veghazai>vegvendeg) hgyoz=true;
            else    hgyoz=false; 
        if (veghazai<vegvendeg) vgyoz=true;
            else    vgyoz=false; 
        if (veghazai==vegvendeg) dont=true;
            else    dont=false; 
    }
    
    public int getFord()
        {   return ford;        }
    public int getVeghazai()
        {   return veghazai;    }
    public int getVegvendeg()
        {   return vegvendeg;   }
    public int getFelhazai()
        {   return felvendeg;   }
    public int getFelvendeg()
        {   return felvendeg;   }
    public String getHazaics()
        {   return hazaics;     }
    public String getVendegcs()
        {   return vendegcs;    }
    public boolean getMegford()
        {   return megford;    }
    public boolean getHgyoz()
        {   return hgyoz;    }
    public boolean getVgyoz()
        {   return vgyoz;    }
    
    public String toString()
    {return ford+". "+hazaics+"-"+vendegcs+": "+veghazai+"-"+vegvendeg+" ( "+
            felhazai+"-"+felvendeg+" )";}
}
