package gclub;
import java.util.*;
import java.text.SimpleDateFormat;

public class Membre {
    //attributs
    private int code;
    private String nom,prenom;
    private Date dateNais;
    
    SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");

    //constructeur d'initialisation
    public Membre(int c,String n,String p,Date dn){
        this.code = c;
        this.nom = n;
        this.prenom = p;
        this.dateNais = dn;
    }
    //constructeur de copie
    public Membre(Membre m){
        this.code = m.code;
        this.nom = m.nom;
        this.prenom = m.prenom;
        this.dateNais = m.dateNais;
    }
    //accesseur
    public int getCode(){
        return this.code;
    }
    public void showMembre(){
        
        System.out.println("Membre[code :"+this.code+",nom complet :"+this.prenom+" "+ this.nom +",date Nais :" +f.format(this.dateNais) +"]");
    }
    //comparaison de deux membre
    public boolean equals(Membre m){
        if((this.code == m.code)){
            return true;
        }
        else{
            return false;
        }
    }
    public static void main(String[] args) {
        SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
        Date d = new Date();
        Membre a = new Membre(1,"elhardouzi","anas",d);
        Membre b = new Membre(2,"test","test",d);
        Membre c = new Membre(1,"test","test",d);
        Membre g = new Membre(c);
        g.showMembre();
        System.out.println(a.getCode());
        System.out.println(a.equals(b));
        System.out.println(a.equals(c));
    }
}
