
package ep2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

@SuppressWarnings("unused")
public class Treinador_reader {
	static public ArrayList<Treinador> listadetreinadores = new ArrayList<Treinador>() ;
	// public static void main(String[] args) 
	{
		int i = 0;
        String csvFile1 = "Treinador_data.csv";
        String linha = ""; 
        String virgula = ",";
        String doispontos = ":";
        BufferedReader arquivo1 = null;
        String[] pokemons = null;

        try {//Abrindo o arquivo csv
         arquivo1 = new BufferedReader(new FileReader(csvFile1)) ;
         
         
             linha = arquivo1.readLine();
        	 while (((linha = arquivo1.readLine()) != null ) ) { //Passando os dados do arquivo csv para uma lista
        		 ArrayList<Pokemon> listaPokemons = new ArrayList<Pokemon>();
        		 String[] num = linha.split(virgula);
        		 String[] num2 = linha.split(":"); //separa os dados dos treinadores dos pokemons que ele possui
        		 if(num2.length>1) {
        			 pokemons = num2[1].split(virgula);
        			 }												//Registrando os pokemons do treinador em uma lista
        		 for(int k = 0; k<pokemons.length; k+=2) {
        			 listaPokemons.add(new Pokemon(k));
        		 }
            	 listadetreinadores.add(new Treinador(num[1], num[0], listaPokemons,Integer.toString(i)));
            	 i++;
                  	 }
        			 
        			 
        }
        
        
        catch (IOException e)
        {
        
        	JOptionPane.showMessageDialog(null, "Nenhum Treinador registrado");
           	}
        catch(NullPointerException e)
        {
            System.out.print("NullPointerException Caught"); }

        finally {
        		if( arquivo1 != null) {
        			try {
        				arquivo1.close();
        			}
        			 catch (IOException e) {
        	            e.printStackTrace();
        	        }
        			
        			}
        		
        		
        		}
	}
        
}

