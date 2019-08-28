package ep2;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Treinador extends Registro {

		private String idade;
		private ArrayList<Pokemon> pokemons;
		/////////////////////CONSTRUTORES
		
		public Treinador(String nome, String idade, ArrayList<Pokemon> pokemons, String id) {
			this.name = nome;
			this.idade = idade;
			this.pokemons = pokemons;    
			this.id = id;
		}
		public Treinador(String nome, String idade, String id) {
			this.name = nome;
			this.idade = idade; 
			this.id = id;
		}
		
		////////////////GETTERS/SETTERS
		
		public String getNome() {
			return name;
		}
		public void setNome(String nome) {
			this.name = nome;
		}
		public String getIdade() {
			return idade;
		}
		public void setIdade(String idade) {
			this.idade = idade;
		}
		public ArrayList<Pokemon> getPokemons() {
			return pokemons;
		}
		public void setPokemons(ArrayList<Pokemon> pokemons) {
			this.pokemons = pokemons;
		}
		
		/////////////METODOS
		
		public void addPokemon(Pokemon pokemon)
		{
			this.pokemons.add(pokemon);
		}
		public static void cadastrar(Treinador t) 	throws IOException {

	    	StringBuilder sb = new StringBuilder();
		    	sb.append(t.getId());
		    	sb.append(",");
		    	sb.append(t.getNome());
		    	sb.append(",");
		    	sb.append(t.getIdade());
		    	sb.append(":");
		    	if(t.getPokemons() != null) {
			    	for(Pokemon poke : t.getPokemons()) {
			    		sb.append(poke.getId());
			    		sb.append(",");
			    		sb.append(poke.getName());
			    		sb.append(",");
			    	}
		    	}
		    	sb.append("\n");
	    	FileWriter cadastro = new FileWriter("Treinador_data.csv",true);
	    	cadastro.write(sb.toString());
	    	cadastro.close();
		} 
		
		public static int procurar(String nome,ArrayList<Treinador> listadetreinadores) {//Realiza a busca a do nome dado na lista
	    	int i =0;
	    	for(i=0;i<listadetreinadores.size(); i++)
	    	{    		
	    		if( nome.equalsIgnoreCase(listadetreinadores.get(i).getNome()) )
	    		{	
	
	    			return i;
	    			
	    		}
	 
	    	
	    	}
	    	return -1;
	}
		
}
