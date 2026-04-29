package modelMorraCinese;
import java.util.Random;
/**
 *
 * @author Vittorio Privitera
 */
public class Model {
    private boolean inGioco;
    private String nome;
    private int puntiMax;
    private int puntiUtente;
    private int puntiPc;
    private int lanci;
    private int sceltaPc;
    
    public Model()
    {
        reset();
    }
    
    private void reset()
    {
        this.inGioco=false;
        this.nome="Sconosciuto";
        this.puntiMax=0;
        this.puntiUtente=0;
        this.puntiPc=0;
        this.lanci=0;
    }
    public boolean isInGioco() {
        return inGioco;
    }

    public String getNome() {
        return nome;
    }

    public int getPuntiMax() {
        return puntiMax;
    }

    public int getPuntiUtente() {
        return puntiUtente;
    }

    public int getPuntiPc() {
        return puntiPc;
    }

    public int getLanci() {
        return lanci;
    }

    public void setPuntiUtente(int puntiUtente) {
        this.puntiUtente = puntiUtente;
    }

    public void setPuntiPc(int puntiPc) {
        this.puntiPc = puntiPc;
    }
    
    public int getSceltaPc()
    {
        return this.sceltaPc;
    }

    @Override
    public String toString() {
        return "Model{" + "inGioco=" + inGioco + ", nome=" + nome + ", puntiMax=" + puntiMax + ", puntiUtente=" + puntiUtente + ", puntiPc=" + puntiPc + ", lanci=" + lanci + ", sceltaPc=" + sceltaPc + '}';
    }
    
    public boolean terminaPartita()
    {
        if(!this.inGioco)return false;
        this.inGioco=false;
        return true;
    }
    
    public boolean iniziaPartita(String nome,int puntiMax)
    {
        if(this.inGioco) return false;
        reset();
        if((nome.trim()).length()==0) return false;
        this.nome=nome;
        if(puntiMax<=0) return false;
        this.puntiMax=puntiMax;
        this.inGioco=true;
        return true;
    }
    /**
     * Effetua un round
     * @param num
     * num è la scelta dell'utente
     * @return 
     * -9=non siamo in gioco 
     * -8=vince l'utente
     * -7=vince il pc
     * 0=ha fatto il tentativo ed è andato a buon fine
     */
    public int gioco(int num)   // 1 sasso 2 carta 3 forbici
    {
        if(!this.inGioco) return -9;
        if(this.puntiUtente==this.puntiMax) // vince l'utente
        {
            this.inGioco=false;
            return -8;
        }
        else if(this.puntiPc==this.puntiMax) //vince il pc
        {
            this.inGioco=false;
            return -7;
        }
        this.lanci++;
        Random r=new Random();
        int sc=this.sceltaPc=r.nextInt(1,4);
        if(num==1&&sc==3)this.puntiUtente++;
        if(num==3&&sc==1)this.puntiPc++;
        if(num==1&&sc==2)this.puntiPc++;
        if(num==2&&sc==1)this.puntiUtente++;
        if(num==3&&sc==2)this.puntiUtente++;
        if(num==2&&sc==3)this.puntiPc++;
        return 0;
    }
}
