package ep2;

import java.util.ArrayList;

public class Pokemon extends Registro {

	        public String hp;
	        public String type1;
	        public String type2;
	        public String total;
	        public String attack;
	        public String defense;
	        public String spatk;
	        public String spdef;
	        public String speed;
	        public String legendary;
	        public String generation;
	        public String height;
	    	public String weight;
	    	private ArrayList<String> abilities;
	    	private ArrayList<String> moves ;
//construtor
	    	public Pokemon(String id, String name, String type1 ,String type2, String total, 
String hp, String attack, String defense, String spatk, String spdef, String speed, String generation, 
String legendary, String height, String weight, ArrayList<String> abilities, ArrayList<String> moves )
	    	{
	    		this.id = id;
	    		this.name = name;
	    		this.hp = hp;
	    		this.type1 = type1;
	    		this.type2 = type2;
	    		this.total = total;
	    		this.attack = attack;
	    		this.defense = defense;
	    		this.spatk = spatk;
	    		this.spdef = spdef;
	    		this.speed = speed;
	    		this.legendary = legendary;
	    		this.generation = generation;
	    		this.height = height;
	    		this.weight = weight;
	    		this.abilities = abilities;
	    		this.moves = moves;
	    		
	    	}
	    	public Pokemon(int indice) {
					Pokemon pokemonencontrado = Csv_reader.getPokemon(indice);
		    		this.id = pokemonencontrado.getId();
		    		this.name =pokemonencontrado.getName();
		    		this.hp = pokemonencontrado.getHp();
		    		this.type1 = pokemonencontrado.getType1();
		    		this.type2 = pokemonencontrado.getType2();
		    		this.total = pokemonencontrado.getTotal();
		    		this.attack = pokemonencontrado.getAttack();
		    		this.defense = pokemonencontrado.getDefense();
		    		this.spatk = pokemonencontrado.getSpatk();
		    		this.spdef = pokemonencontrado.getSpdef();
		    		this.speed = pokemonencontrado.getSpeed();
		    		this.legendary = pokemonencontrado.getLegendary();
		    		this.generation = pokemonencontrado.getGeneration();
		    		this.height = pokemonencontrado.getHeight();
		    		this.weight = pokemonencontrado.getWeight();
		    		this.abilities = pokemonencontrado.getAbilities();
		    		this.moves = pokemonencontrado.getMoves();
					
				}	

		public void setId(String id) {
			this.id = id;
		}
		public String getLegendary() {
			return legendary;
		}
		public void setLegendary(String num) {
			this.legendary = num;
		}
		public ArrayList<String> getAbilities() {
			return abilities;
		}
		public void setAbilities(ArrayList<String> abilities) {
			this.abilities = abilities;
		}
		public ArrayList<String> getMoves() {
			return moves;
		}
		public void setMoves(ArrayList<String> moves) {
			this.moves = moves;
		}
		public void setName(String name ) {
			this.name = name;
		}
		public void setType1(String type1) {
			this.type1 = type1;
		}
		public void setType2(String type2) {
			this.type2 = type2;
		}
		public void setTotal(String total) {
			this.total = total;
		}
		public void setHp(String hp) {
			this.hp = hp;
		}
		public void setAttack(String attack) {
			this.attack = attack;
		}
		public void setDefense(String defense) {
			this.defense = defense;
		}
		public void setSpAtk(String spatk) {
			this.spatk = spatk;
		}
		public void setSpDef(String spdef) {
			this.spdef = spdef;
		}
		public void setSpeed(String speed) {
			this.speed = speed;
		}
		public void setGeneration(String generation) {
			this.generation = generation;
		}

		public void setHeight(String height) {
			this.height = height;
		}
		public void AddMove(String move){
			this.moves.add(move);
		}
		public void setWeight(String weight) {
			this.weight = weight;
		}
		public void AddAbilities(String abilitie)
		{
			this.abilities.add(abilitie);
		}

		public String getId() {
			return id;
		}
		public String getName() {
			return name;
		}
		public String getHp() {
			return hp;
		}
		public String getType1() {
			return type1;
		}
		public String getType2() {
			return type2;
		}
		public String getTotal() {
			return total;
		}
		public String getAttack() {
			return attack;
		}
		public String getDefense() {
			return defense;
		}
		public String getSpatk() {
			return spatk;
		}
		public String getSpdef() {
			return spdef;
		}
		public String getSpeed() {
			return speed;
		}
		public String getLegenday() {
			return legendary;
		}
		public String getGeneration() {
			return generation;
		}
		public String getHeight() {
			return height;
		}
		public String getWeight() {
			return weight;
		}
		public static int visualizar(String nome) {
		    	int index = -1;
		    	for(int i = 1 ; i < Csv_reader.listadepokemon.length; i++) {
		    		System.out.println(i);
		    		try {
		    			if(nome.equalsIgnoreCase(Csv_reader.getPokemon(i).getName()) )
			    			index = i;
		    		} catch(NullPointerException e) {
		    			System.out.println(i);
		    			return -1;
		    		}
		    	}
		    	return index;
		}
}