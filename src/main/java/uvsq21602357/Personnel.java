package uvsq21602357;

import java.time.LocalDate;
import java.util.ArrayList;

public final class Personnel extends PersonnelType {
   
   private String nom;
   private String prenom;
   private ArrayList<String> telephone;
   private LocalDate dateNaissance;
   private String emploi;
   
   public static class PersonelBuilder {
   private String nom;
   private String prenom;
   private ArrayList<String> telephone = null;
   private LocalDate dateNaissance = null;
   private String emploi;
   public PersonelBuilder(
     final String nomPara, final String ValPrenom, final String ValEmploi) {
      this.nom = nomPara;
      this.prenom = ValPrenom;
      this.emploi = ValEmploi;
   }
   public PersonelBuilder dateNaissance(final LocalDate ValDate) {
   this.dateNaissance = ValDate;
      return this;
   }
   public PersonelBuilder telephone(final String ValTelephone) {
      this.telephone = new ArrayList<String>();
      this.telephone.add(ValTelephone);
      return this;
   }
   public Personnel build() {
      return new Personnel(this);
   }

   }
   private Personnel(final PersonelBuilder builder) {
   this.nom = builder.nom;
   this.prenom = builder.prenom;
   this.emploi = builder.emploi;
   }
   
   public String getNom() {
   return nom;
   }
    
   public String getPrenom() {
   return prenom;
   }
    
   public ArrayList<String> getTelephone() {
   return telephone;
   }
    
   public LocalDate getDateNaissance() {
   return dateNaissance;
   }
    
   public String getemploi() {
   return emploi;
   }
    
   @Override
   public boolean EstUnGroupe() {

   return false;
   }
   @Override
   public String toString() {
   return "name " + this.getNom();
   }
}
