
package ep2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Csv_reader {
	static public Pokemon listadepokemon[] = new Pokemon[721] ;
	static public int indexList[][] = new int[2][75];
		{
		String csvFile1 = "POKEMONS_DATA_1.csv";
        String csvFile2 = "POKEMONS_DATA_2.csv";
        String linha = ""; String linha2 = "";
        String virgula = ",";
        BufferedReader arquivo1 = null;
        BufferedReader arquivo2 = null;

        try {//Abrindo os arquivos csv
         arquivo1 = new BufferedReader(new FileReader(csvFile1)) ;
         arquivo2 = new BufferedReader(new FileReader(csvFile2)) ;
         
         
             linha = arquivo1.readLine();
             linha2 = arquivo2.readLine();
             int index = 0;
        	 while (((linha = arquivo1.readLine()) != null ) | ( (linha2 = arquivo2.readLine()) != null)) { //Criando uma lista a partir dos arquivos CSV
        		 String[] num = linha.split(virgula);
        		 String[] num2 = linha2.split(virgula);
        		 ArrayList<String> habilidades, movimentos;
        		 habilidades= new ArrayList<String>();
        		 movimentos = new ArrayList<String>();
        		for(int f = 8; f <= 14; f++)
        		{
        		 movimentos.add(num2[f]);
        		}
        		for(int f = 5; f <=7; f++)
        		{
        		 habilidades.add(num2[f]);
        		}
        	 listadepokemon[index] = new Pokemon(num[0], num[1],num[2], num[3], num[4], num[5], num[6], num[7],
     				num[8], num[9], num[10], num[11], num[12], num2[3], num2[4], habilidades, movimentos); 
        	 index++;
                  	 }
        	 this.setIndexList();
        }
        
        
                catch (IOException e) {
            e.printStackTrace();
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
        		if( arquivo2 != null) {
        			try {
        				arquivo2.close();
        			}
        			 catch (IOException e) {
        	            e.printStackTrace();
        	        }
        			
        			}
        		
        		}
	}
	public void setIndexList() {
		Pokemon pokemons[] = Csv_reader.listadepokemon;
		int j = 0;
		
		for(int i = 0; i < pokemons.length; i += 20) {
			Csv_reader.indexList[0][j] = Integer.parseInt(pokemons[i].getId());
			Csv_reader.indexList[1][j] = i;
			j++;
		}
	}
	
	static public Pokemon getPokemon(int id) {
		Pokemon pokemon = null;
		if(id < Csv_reader.indexList[0][0]) {
			return null;
		} else {
			int start = 0, end = 0;
			for(int i = 1; i <= Csv_reader.indexList[0].length; i++) {
				if(id < Csv_reader.indexList[0][i]) {
					start = Csv_reader.indexList[1][i - 1];
					end = Csv_reader.indexList[1][i];
					break;
				}
			}
			for(int i = start; i < end; i++) {
				if(id == Integer.parseInt(Csv_reader.listadepokemon[i].getId()))
					pokemon = Csv_reader.listadepokemon[i];
			}
		}
		return pokemon;
	}
}

