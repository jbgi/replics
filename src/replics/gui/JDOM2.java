package replics.gui;

import java.io.*;
import org.jdom.*;
import org.jdom.input.*;
import org.jdom.filter.*;
import java.util.List;
import java.util.Iterator;

public class JDOM2
{
   static org.jdom.Document document;
   static Element racine;

   public static void main(String[] args)
   {
      //On cr�e une instance de SAXBuilder
      SAXBuilder sxb = new SAXBuilder();
      try
      {
         //On cr�e un nouveau document JDOM avec en argument le fichier XML
         //Le parsing est termin� ;)
         document = sxb.build(new File("Exercice2.xml"));
      }
      catch(Exception e){}

      //On initialise un nouvel �l�ment racine avec l'�l�ment racine du document.
      racine = document.getRootElement();

      //M�thode d�finie dans la partie 3.2. de cet article
      afficheALL();
   }
   static void afficheALL()
   {
      //On cr�e une List contenant tous les noeuds "etudiant" de l'Element racine
      List listEtudiants = racine.getChildren("etudiant");

      //On cr�e un Iterator sur notre liste
      Iterator i = listEtudiants.iterator();
      while(i.hasNext())
      {
         //On recr�e l'Element courant � chaque tour de boucle afin de
         //pouvoir utiliser les m�thodes propres aux Element comme :
         //selectionner un noeud fils, modifier du texte, etc...
         Element courant = (Element)i.next();
         //On affiche le nom de l'element courant
         System.out.println(courant.getChild("nom").getText());
      }
   }
  
}