/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test_encdec;

import java.io.Console;
import java.util.Scanner;

/**
 *
 * @author daniel
 */
public class Test_encdec {

    /**
     * @param args the command line arguments
     */
    
   
    
    public static void main(String[] args) {
        // TODO code application logic here
    decryption dec = new decryption();
    encryption enc = new encryption();
    Scanner console = new Scanner(System.in);
    System.out.print("Voulez-vous crypter ou décrypter (C/D) ?");
    String rep = console.nextLine();
    
        switch (rep) {
            case "C":
            case "c":
                {
                    System.out.print("Entrez le texte à crypter : \n");
                    String texteacrypter = console.nextLine();
                    System.out.print("Entrez la clé de cryptage : \n");
                    String cle = console.nextLine();
                    String textcrypte;
                    try
                    {
                        textcrypte = enc.encrypt_message(texteacrypter, cle);
                        System.out.printf(textcrypte);
                    }
                    catch(Exception e)
                    {
                        System.out.print("Une erreur est survenue : \n" + e.getLocalizedMessage());
                        
                    }           break;
                }
            case "D":
            case "d":
            {
                System.out.print("Entrez le texte à décrypter : \n");
                String texteadecrypter = console.nextLine();
                System.out.print("Entrez la clé de décryptage : \n");
                String cle = console.nextLine();
                String textedecrypte;
                try
                {
                    textedecrypte = dec.decrypt_message(texteadecrypter, cle);
                    System.out.printf(textedecrypte);
                }
                catch(Exception e)
                {
                    System.out.print("Une erreur est survenue : \n" + e.getLocalizedMessage());
            
        }           break;
                }
            default:
                System.out.print("Erreur de saisie");
                break;
        }
    
    
    
    
    
    }
    
}
