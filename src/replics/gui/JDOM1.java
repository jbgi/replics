package replics.gui;
import java.io.*;
import org.jdom.*;
import org.jdom.output.*;
public class JDOM1
{
   //Nous allons commencer notre arborescence en cr�ant la racine XML
   //qui sera ici "personnes".
   static Element racine = new Element("recensement");
   		Element ville = new Element("place_of_census");
		Element ID = new Element("Identifiant");
		Element last_name = new Element("Last_Name");
		Element first_name = new Element("First_Name");
		Element adress = new Element("adress");
		Element place_of_birth = new Element("place_of_birth");
		Element date_of_birth = new Element("date_of_birth");
   //On cr�e un nouveau Document JDOM bas� sur la racine que l'on vient de cr�er
   static org.jdom.Document document = new Document(racine);

   	public JDOM1(){
   		racine.addContent(ville);
   		ville.addContent(ID);
   		ville.addContent(last_name);
   		ville.addContent(first_name);
   		ville.addContent(place_of_birth);
   		ville.addContent(adress);
   		ville.addContent(date_of_birth);
   		
   	}
   public static void main(String[] args)
   {
      //On cr�e un nouvel Element etudiant et on l'ajoute
      //en temps qu'Element de racine
      //JDOM1 test = new JDOM1();
      Element etudiant = new Element("etudiant");
      racine.addContent(etudiant);

      //On cr�e un nouvel Attribut classe et on l'ajoute � etudiant
     //gr�ce � la m�thode setAttribute
      Attribute classe = new Attribute("classe","P2");
      etudiant.setAttribute(classe);

      //On cr�e un nouvel Element nom, on lui assigne du texte
      //et on l'ajoute en temps qu'Element de etudiant
      Element nom = new Element("nom");
      nom.setText("CynO");
      etudiant.addContent(nom);

      //Les deux m�thodes qui suivent seront d�finies plus loin dans l'article
      affiche();
      enregistre("Exercice3.xml");
   }
   static void affiche()
   {
      try
      {
         //On utilise ici un affichage classique avec getPrettyFormat()
         XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
         sortie.output(document, System.out);
      }
      catch (java.io.IOException e){}
   }

   static void enregistre(String fichier)
   {
      try
      {
         //On utilise ici un affichage classique avec getPrettyFormat()
         XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
         //Remarquez qu'il suffit simplement de cr�er une instance de FileOutputStream
         //avec en argument le nom du fichier pour effectuer la s�rialisation.
         sortie.output(document, new FileOutputStream(fichier));
      }
      catch (java.io.IOException e){}
   }
}