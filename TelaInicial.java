import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TelaInicial implements ActionListener {

	
	//tela
	JFrame tela = new JFrame();
	
	//adicionar imagens em tela
	//variaveis para backgroud
	JLabel jbl = new JLabel();
    JPanel jpl = new JPanel();
	
	//butão iniciar
	JButton play = new JButton();
	
	//frases com informações sobre sustentabilidades
	String[] frases = {
			"Entre 2004 e 2011, as emissões de gás carbônico, caíram 84,4% no setor de mudança do uso da terra e florestas.",
			"Produced and directed by QUENTIN TARANTINO",
			"o ano de 2013 apresentou o menor número de queimadas e incêndios",
			"2010, o ano com o mao numero de queimadas e incêndios",
			"Existe uma tendência de crescimento da reciclagem entre 1993 e 2012",
			"A energia renovável perdeu participação na matriz energética brasileira, registrando, em 2012",
			"A cada 10 florestas em chamas, 9 estão pegando fogo",
			"Existem 627 espécies da fauna brasileira ameaçadas de extinção",
				};
	
	
	//sistema para randomizar a aparição das frases
	int n = frases.length;
	Random aleatorio = new Random ();
	JTextField frasemotivadoras = new JTextField();
	int escolha = aleatorio.nextInt(n);
	
		
		//Classe construtora
		public TelaInicial() {	
			//configurações de tela
		tela.setSize(1080, 720);//resolução
		tela.setResizable(false);
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tela.setLayout(null);
		tela.getContentPane().setBackground(new Color(18,10,143));
		
		//selecionando imagem e setando como background
		jbl.setIcon(new ImageIcon("src//Inicial.jpg"));
		jpl.add(jbl);
		tela.setContentPane(jbl);
		
		
		//configurando aparição das frases
		frasemotivadoras.setBounds(0,360,1080,30);
		frasemotivadoras.setFont(new Font("Arial", Font.BOLD, 20));
		frasemotivadoras.setHorizontalAlignment(JTextField.CENTER);
		frasemotivadoras.setForeground(new Color(128,128,0));
		frasemotivadoras.setEditable(false);
		frasemotivadoras.setText(frases[escolha]);
		
		
		
		//config botão iniciar
		play.setBounds(400, 410, 300, 150);
		play.setFont(new Font("Arial", Font.BOLD, 28));
        play.setIcon(new ImageIcon("src//Play.jpg"));
		play.addActionListener(this);
		
		
		//adicionando componentes a tela
		tela.add(frasemotivadoras);
		tela.add(play);
		tela.setVisible(true);

	}


		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==play) {
				
				Quiz quiz = new Quiz();
		}
		}	
		}
