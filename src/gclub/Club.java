package gclub;
import java.util.*;
import java.text.SimpleDateFormat;

/**
 *
 * @author chaotic
 */
public class Club {
    //attribus
    private String nomClub;
    private Membre listeMembres[];
    private int nbreAbonnes = 0;
    //constructeur avec argument
    public Club(String nc ,int na){
        this.nomClub = nc;
        this.listeMembres = new Membre[na];
    }
    //ajout a la fin de la liste s'elle n'est pas pleine et si le nouveau membre est unique
    //en cas de succes ell returne true
    public int search(Membre m){
        for (int i = 0; i < this.nbreAbonnes; i++) {
            if ((this.listeMembres[i]!=null)&& (this.listeMembres[i].equals(m))) {
                return i;
            }
        }
        return -1;
    }
    public boolean addMembre(Membre m){
        if ((this.nbreAbonnes < this.listeMembres.length)&&(this.search(m) == -1)) {
            for (int i = 0; i <= this.nbreAbonnes; i++) {
                if (this.listeMembres[i] == null) {
                    this.listeMembres[i] = m;
                    this.nbreAbonnes ++;
                    return true;
                }
            }
        }
        return false;
    }
    //ajout au milieu de la liste s'elle n'est pas pleine et si le nouveau membre est unique
    //et l'index est valide.En cas de succes ell returne true
    public boolean addMembre(Membre m,int index){
        if ((this.nbreAbonnes < this.listeMembres.length)&&(this.search(m) == -1)&&(index >=0 && index <this.nbreAbonnes)) {
            for (int i = index; i <= this.nbreAbonnes; i++) {
                if(i!= this.nbreAbonnes){
                    Membre a = new Membre(this.listeMembres[i]);
                    this.listeMembres[i] = m;
                    m = new Membre(a);
                }else{
                    this.listeMembres[i] = m;
                }
            }
            this.nbreAbonnes++;
            return true;
        }
        return false;
    }
    //modifie un membre existant.si l'index est valide et le nouveau membre ne sera pas
    //redondant . En cas de succes, elle retourne l'ancien membre
    public Membre updateMembre(int index,Membre m){
        Membre a = null;
        if ((index>=0 && index <this.nbreAbonnes)&&(this.search(m) == -1)) {
            a = new Membre(this.listeMembres[index]);
            this.listeMembres[index] = new Membre(m);
        }
        return a;
    }
    
    //affichage comme suit:
    //Club : xxxxxxxxx, Liste de ses abonnes:
    //xxxxxxxx
    public void showAll(){
        System.out.println("Club : " + this.nomClub + " , Liste de ses abonnes:");;
        for (int i = 0; i < this.nbreAbonnes; i++) {
            this.listeMembres[i].showMembre();
        }
    }
    
    //Supprime un nombre selon son index et retoune le membre qui vient d'etre
    //supprime
    public Membre delMembre(int index){
        Membre a = new Membre(this.listeMembres[index]);
        for (int i = index; i < this.nbreAbonnes-1; i++) {
            this.listeMembres[i] = new Membre(this.listeMembres[i+1]);
        }
        this.listeMembres[this.nbreAbonnes-1] = null;
        this.nbreAbonnes --;
        return a;
    }
    //supprime um membre selon son ebjet et returner true en cas de succes
    public boolean delMembre(Membre m){
        if (this.search(m) != -1) {
            delMembre(this.search(m));
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        Club cc = new Club("test",4);
        Membre a = new Membre(0,"elhardouzi","anas",new Date());
        Membre b = new Membre(1,"tai","chi",new Date());
        Membre c = new Membre(2,"test","test",new Date());
        Membre d = new Membre(3,"syke","uno",new Date());
        Membre e = new Membre(4,"update","up",new Date());
        //test addMembre
        cc.addMembre(a);
        cc.addMembre(b);
        cc.addMembre(c);
        //test showAll
        cc.showAll();
        cc.addMembre(d,0);
        cc.showAll();
        //test updateMembre
        cc.updateMembre(0, e);
         cc.showAll();
        //test search
        System.out.println(cc.search(d));
        //test delMembre
        cc.delMembre(0);
        cc.delMembre(c);
        cc.showAll();
    }
}
