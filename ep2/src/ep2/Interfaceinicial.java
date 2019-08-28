package ep2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

class Interfaceinicial extends JFrame
{

	private static final long serialVersionUID = 1L;

	 JButton bot_buscar, bot_cadastrar, bot_visualizar;
    public Interfaceinicial()
    {
        setTitle("Pokedex");
        setSize(600,600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
      
        
        getContentPane().setLayout(new BorderLayout());
        setContentPane(new JLabel(new ImageIcon("background.jpg")));
        getContentPane().setLayout(null);
        bot_buscar = new JButton("Buscar");
        getContentPane().add(bot_buscar);
        bot_buscar.setBounds(250,150,100,35);
        bot_buscar.setBackground(new java.awt.Color(103,26,3));
        bot_buscar.setForeground(new java.awt.Color(255,241,202));
        
        bot_buscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int indice;
				String[] opcoes = {"Nome","Tipo"};
				String nome = null;
				int op = JOptionPane.showOptionDialog(null, "Deseja pesquisar por nome ou tipo?", "Pesquisa", 
						JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null,opcoes , 0);
				if(op == 0) {						
					nome = JOptionPane.showInputDialog(null);
				}
				else {
					ArrayList<String> nomesPokemons = new ArrayList<String>();
					String tipo = JOptionPane.showInputDialog(getParent(), "Qual tipo de pokemon deseja pesquisar?");
					for(Pokemon poke : Csv_reader.listadepokemon) {
							if(poke.getType1().equalsIgnoreCase(tipo ) || poke.getType2().equalsIgnoreCase(tipo)) {
								nomesPokemons.add(poke.getName());
							}
						}
					if(nomesPokemons.size() == 0) {
						JOptionPane.showMessageDialog(null, "Nenhum pokemon com esse tipo foi encontrado!!!");
					}
					else {
						Object [] opcoesNome = nomesPokemons.toArray();
						Object opcaoSelecionada = JOptionPane.showInputDialog(null, 
		                            "Qual pokemon deseja pesquisar?", 
		                            "Selecione um pokemon", 
		                             JOptionPane.QUESTION_MESSAGE, 
		                             null,
		                             opcoesNome, 
		                             opcoesNome[0]);
							nome = opcaoSelecionada.toString();
					}
				}

				if(nome!=null) {
					indice = Pokemon.visualizar(nome);
					if(Pokemon.visualizar(nome) != -1) {
						Pokemon pokemonencontrado = Csv_reader.getPokemon(indice);
						Icon img_pokemon = new ImageIcon("images/" +pokemonencontrado.getName().toLowerCase() + ".png");
						String atributos = "Nome - " + pokemonencontrado.getName() + "\n" + "Hp - " + pokemonencontrado.getHp() + "\n" + "Tipo 1 - " + 
								pokemonencontrado.getType1() + "\n" + "Tipo 2 - " + pokemonencontrado.getType2() + "\n" + "Total - " + pokemonencontrado.getTotal() + "\n" + "Ataque - " + 
							pokemonencontrado.getAttack() + "\n" + "Defesa - " + pokemonencontrado.getDefense() + "\n" + "Velocidade - " + pokemonencontrado.getSpeed() + "\n" + "Geração - "
							+ pokemonencontrado.getGeneration() + "\n" +  "Ataque Especial - " + pokemonencontrado.getSpatk() + "\n" + "Defesa Especial - " + pokemonencontrado.getSpdef() + "\n"
							+ "Lendário - " + pokemonencontrado.getLegendary() + "\n" + "Altura - " + pokemonencontrado.getHeight() + "\n" + "Peso - " + pokemonencontrado.getWeight() + "\n" + 
							"Habilidades - " + pokemonencontrado.getAbilities() + "\n" + "Movimentos - " + pokemonencontrado.getMoves();
							JOptionPane.showMessageDialog(getParent(), atributos, "Pokemon", op, img_pokemon);;
					}	
					else
					{
					JOptionPane.showMessageDialog(getParent(), "Pokemon nao encontrado");
					}
				}
			}													
		});
        

        
        bot_visualizar = new JButton("Visualizar");
        getContentPane().add(bot_visualizar);
        bot_visualizar.setBounds(400,400,100,35);
        bot_visualizar.setBackground(new java.awt.Color(169,44,12));
        
        bot_visualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nomeT = JOptionPane.showInputDialog(getParent(), "Qual o nome do treinador?", "Pesquisa treinador");
					if(nomeT!=null) {
						int indice = Treinador.procurar(nomeT,Treinador_reader.listadetreinadores);
						if(indice>-1) {
							Treinador treinadorEncontrado = Treinador_reader.listadetreinadores.get(indice);
							String treinador = "Nome - " + treinadorEncontrado.getNome() + "\n" + "Id - "  + treinadorEncontrado.getId() + "\n" + "Idade - " +
									treinadorEncontrado.getIdade() + "\n" + "Pokemons que possue : \n" ;
							for(Pokemon P : treinadorEncontrado.getPokemons())
							{
								treinador +="  Id: " + P.getId() + " | " + "Nome: " + P.getName() + "\n";
								
							}
							JOptionPane.showMessageDialog(getParent(), treinador );
			
						}
						else JOptionPane.showMessageDialog(null, "Treinador nao encontrado");
					}
				}	});

        
        
        bot_cadastrar = new JButton("Cadastrar");
        getContentPane().add(bot_cadastrar);
        bot_cadastrar.setBounds(100,400,100,35);
        bot_cadastrar.setBackground(new java.awt.Color(255,241,202));
        bot_cadastrar.addActionListener(new ActionListener() {
        	ArrayList<Pokemon> listaPoke = new ArrayList<Pokemon>();
			public void actionPerformed(ActionEvent e) {
				String nome = JOptionPane.showInputDialog(null,"Digite o nome do treinador");
				if(nome != null)
				{
					String idade = null;
					boolean i = true;
					while(i)
					{

					    idade = (JOptionPane.showInputDialog(null,"Digite a idade do treinador"));
					    if(idade == null)
					    {
					    	break;
					    }
						try
						{
							Integer.parseInt(idade);
							i = false;
						}
						catch(NumberFormatException e2)
						{
							JOptionPane.showMessageDialog(null,"Digite uma idade valida");
							i = true;
						}
							while(JOptionPane.showConfirmDialog(null, "Deseja registrar mais algum pokemon?" )==0) {
							String nomePokemon = JOptionPane.showInputDialog(getParent(),"Qual o nome do pokemon?");
							if(nomePokemon != null)
							{
								int indice = Pokemon.visualizar(nomePokemon);
								if(indice>=0) {
									listaPoke.add(Csv_reader.getPokemon(indice));
											}
								else {
									JOptionPane.showMessageDialog(getParent(), "Pokemon nao encontrado");
									}
								Treinador_reader.listadetreinadores.add(new Treinador(nome,idade,listaPoke,Integer.toString(Treinador_reader.listadetreinadores.size())));
								try {
										Treinador.cadastrar(new Treinador(nome,idade,listaPoke,Integer.toString(Treinador_reader.listadetreinadores.size())));
									}
								catch (FileNotFoundException e1) {
										e1.printStackTrace();
										}
								catch (IOException e1) {
									e1.printStackTrace();
										}
							}
						}
					}			
					
				}
			}
		});

        setSize(599,599);
        setSize(600,600);
    }

    public static void main(String args[])
    {
    	new Csv_reader();
   		new Treinador_reader();
    	new Interfaceinicial();
    } 

}