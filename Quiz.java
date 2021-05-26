import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.Timer;

public class Quiz implements ActionListener{
		
	//escrevendo as perguntas
		String[] perguntas = {
				"Em meio a grande metrópole, existem lixos especiais de coleta seletiva. Quais são eles? ",
				"O que é a coleta seletiva usada nas cidades?",
				"Na coleta seletiva nas cidades, são usadas cores para distinguir onde jogar o lixo, qual é a do plástico?",
				"Como separar corretamente os lixos recicláveis em casas, parques e ruas?",
				"Na coleta seletiva nas cidades, são usadas cores para distinguir onde jogar o lixo, qual é o de papel?",
				"O que é educação ambiental?",
				"Para que serve a educaçãoo ambiental?",
				"Uma das formas de colaborar com a preservação do meio ambiente é reduzir a produção de resíduos. Mas como?",
				"Qual alternativa apresenta uma vantagem da energia solar?",
				"Qual dos gases abaixo não é conhecido como um dos gases do efeito estufa (GEE)?"
				
				};
		
		//alternativas de resposta
		String[][] alternativa = {
				{"Orgânico, papel, metal, vidro e plástico.","Papel, papelão, metal e entulho","Plástico, madeira, vidro e orgânico.","Todas as anteriores."},
				{"Nome qualquer para recolhimento de lixo.","Não significa nada.","Jogar lixo em qualquer lugar ","É o nome para recolhimento dos materiais que são passíveis de serem reciclados."},
			{"Azul","Vermelha","Amarelo","Verde"},
			{"Colocar todos no mesmo saco plástico.","Separar o lixo orgânico dos resíduos sólidos","Jogar em qualquer lugar onde estiver.","Descartar todo o lixo em um ponto de coleta"},
			{"Azul","Vermelha","Amarelo","Verde"},
			{"Processo responsável por formar indivíduos preocupados com os problemas ambientais","Nome dado para quem joga lixo na rua.","Ciclo de reciclagem ","Nenhuma das anteriores."},
		{"Serve para a conscientização sobre os problemas ambientais e como ajudar a combate-los.","Serve para nada","Nome dado a algum produto","Nenhuma das anteriores"},
		{"Optando pela compra de produtos com embalagens recicláveis.","Reutilizando os materiais e objetos sempre que possível.","Apoiando iniciativas de reciclagem.","Todas as anteriores."},
		{"Não polui","Não é renovável","É eficaz em qualquer clima","É disponível a todo momento"},
		{"N2O é óxido nitroso","O2 é oxigênio","CO2 é dióxido de carbono ou gás carbônico","CH4 é metano"}
		};
		
		//alternativas corretas
		char[] respostas = {
				'A',
				'D',
				'B',
				'B',
				'A',
				'A',
				'A',
				'D',
				'A',
				'B',
		};
		
		//variaveis utilizadas
		char guess;
		char resposta;
		int indice;
		int pontos = 0;
		int perguntas_total = perguntas.length;
		int segundos = 15;				
		int prox = 3;
		String btn = "pular";
		
		
		//sistema de contagem regressiva
		Timer tempo = new Timer(1000, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				segundos--;
				tempolabel.setText(String.valueOf(segundos));
				if(segundos<=0) {
					pontos = pontos-5;
					respostaDisplay();
				}
				}
			});
		
		
		//tela
		JFrame tela = new JFrame();
		
		
		//textos
		JTextArea areatext = new JTextArea();
		JTextField textbox = new JTextField();
		JTextField numerpontos = new JTextField();
		JLabel tempolabel = new JLabel();
		JLabel resplabelA = new JLabel();
		JLabel resplabelB = new JLabel();
		JLabel resplabelC = new JLabel();
		JLabel resplabelD = new JLabel();

		
		//label e panel para background
		JLabel jbl = new JLabel();
	    JPanel jpl = new JPanel();
	    
	    
		
		//butï¿½o de resposta
		JButton bA = new JButton();
		JButton bB = new JButton();
		JButton bC = new JButton();
		JButton bD = new JButton();
		
		
		//botao para pular questão
		JButton bProx = new JButton();

		
		//tocar sons
		Som X = new Som();
		Aplausos Y = new Aplausos();
		
		
		public Quiz() {
			tela.setSize(1080, 720);///resolução
			tela.setResizable(false);
			tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			tela.setLayout(null);
			tela.getContentPane().setBackground(new Color(18,10,143));
			
			//background
			jbl.setIcon(new ImageIcon("src//Quiz.jpg"));
			jpl.add(jbl);
			tela.setContentPane(jbl);
			
			
			//responsavel pelo numero da pergunta
			textbox.setBounds(0,0,1080,30);
			textbox.setFont(new Font("Arial", Font.BOLD, 28));
			textbox.setBorder(BorderFactory.createBevelBorder(1));
			textbox.setHorizontalAlignment(JTextField.CENTER);
			textbox.setForeground(new Color(128,128,0));
			textbox.setEditable(false);
			
			
			//responsavel por escrever a pergunta
			areatext.setBounds(0,30,1080,30);
			areatext.setFont(new Font("Arial", Font.BOLD, 20));
			areatext.setForeground(new Color(128,128,0));
			areatext.setEditable(false);
			
			
			//responsavel por mostrar a pontuação a o final do jogo
			numerpontos.setBounds(225,225,200,100);
			numerpontos.setFont(new Font("Arial", Font.BOLD, 28));
			numerpontos.setForeground(new Color(128,128,0));
			numerpontos.setEditable(false);
			
			
			//ALTERNATIVAS		
			resplabelA.setBounds(125,75,1080,100);
			resplabelA.setForeground(new Color(128,128,0));
			resplabelA.setFont(new Font("Arial", Font.BOLD, 20));
			
			resplabelB.setBounds(125,150,1080,100);
			resplabelB.setForeground(new Color(128,128,0));
			resplabelB.setFont(new Font("Arial", Font.BOLD, 20));
			
			resplabelC.setBounds(125,225,1080,100);
			resplabelC.setForeground(new Color(128,128,0));
			resplabelC.setFont(new Font("Arial", Font.BOLD, 20));
			
			resplabelD.setBounds(125,300,1080,100);
			resplabelD.setForeground(new Color(128,128,0));
			resplabelD.setFont(new Font("Arial", Font.BOLD, 20));
			
			
			
			
			//resposaveis por demostrar o tempo
			tempolabel.setBounds(930,478,50,50);
			tempolabel.setFont(new Font("Arial", Font.BOLD, 35));
			

			
			
			//configurar botões
			bA.setBounds(0, 100, 100, 50);
			bA.setFont(new Font("Arial", Font.BOLD, 28));
			bA.setFocusable(false);
			bA.addActionListener(this);
			bA.setIcon(new ImageIcon("src//Ba.jpg"));
			
			
			bB.setBounds(0, 175, 100, 50);
			bB.setFont(new Font("Arial", Font.BOLD, 28));
			bB.setFocusable(false);
			bB.addActionListener(this);
			bB.setIcon(new ImageIcon("src//Bb.jpg"));
			
			
			bC.setBounds(0, 250, 100, 50);
			bC.setFont(new Font("Arial", Font.BOLD, 28));
			bC.setFocusable(false);
			bC.addActionListener(this);
			bC.setIcon(new ImageIcon("src//Bc.jpg"));
			
			
			bD.setBounds(0, 325, 100, 50);
			bD.setFont(new Font("Arial", Font.BOLD, 28));
			bD.setFocusable(false);
			bD.addActionListener(this);
			bD.setIcon(new ImageIcon("src//Bd.jpg"));
			
			
			bProx.setBounds(10,500, 100, 100);
			bProx.setFont(new Font("Arial", Font.BOLD, 28));
			bProx.setFocusable(false);
			bProx.addActionListener(this);
			bProx.setIcon(new ImageIcon("src//"+btn+".png"));
			
			

			
			//adicionar componentes a tela
			X.Som();
			tela.add(tempolabel);
			tela.add(resplabelA);
			tela.add(resplabelB);
			tela.add(resplabelC);
			tela.add(resplabelD);
			tela.add(bA);
			tela.add(bB);
			tela.add(bC);
			tela.add(bD);
			tela.add(bProx);
			tela.add(textbox);
			tela.add(areatext);
			tela.setVisible(true);
			
			proximaQuestao();
		}
		//mudar de questão
		public void proximaQuestao() {
			
			if(indice>=perguntas_total) {
				resultado();
			}
			else {
				textbox.setText("Pergunta "+(indice+1));//numero indice da pergunta
				areatext.setText(perguntas[indice]);//pergunta
				//alternativas
				resplabelA.setText(alternativa[indice][0]);
				resplabelB.setText(alternativa[indice][1]);
				resplabelC.setText(alternativa[indice][2]);
				resplabelD.setText(alternativa[indice][3]);
				//inicia a contagem regressiva
				tempo.start();
				
			}
		}

		
		@Override
		public void actionPerformed(ActionEvent e) {
			bA.setEnabled(false);
			bB.setEnabled(false);
			bC.setEnabled(false);
			bD.setEnabled(false);
			bProx.setEnabled(false);
			
			//seleção de alternativa
			if(e.getSource()==bA) {//se botão X for selecionado resposta recebe a char referente
				resposta= 'A';
				if(resposta == respostas[indice]) {
					pontos = pontos+10;//a cada acerto são adicionados 10 pontos
				}
				else {
					pontos = pontos-5;//a cada erro são subtraidos 5 pontos
				}
			}
			if(e.getSource()==bB) {
				resposta= 'B';
				if(resposta == respostas[indice]) {
					pontos = pontos+10;
				}
				else {
					pontos = pontos-5;
				}
			}
			if(e.getSource()==bC) {
				resposta= 'C';
				if(resposta == respostas[indice]) {
					pontos = pontos+10;
				}
				else {
					pontos = pontos-5;
				}
			}
			if(e.getSource()==bD) {
				resposta= 'D';
				if(resposta == respostas[indice]) {
					pontos = pontos+10;
				}
				else {
					pontos = pontos-5;
				}
			}
			if(e.getSource()==bProx) {//pular questão (não perde nem ganha pontos)
				prox--;
				proximaQuestao();
				}
			respostaDisplay();//configura tela a o receber resposta
			
		}
		
		
		public void respostaDisplay () {
			
			tempo.stop();//parar contagem regressiva
			
			//desativar butoes para evitar conflitos
			bA.setEnabled(false);
			bB.setEnabled(false);
			bC.setEnabled(false);
			bD.setEnabled(false);
			bProx.setEnabled(false);
			
			//Mudar laybel errada para vermelho
			if(respostas[indice] != 'A')
				resplabelA.setForeground(new Color(255,0,0));
			if(respostas[indice] != 'B')
				resplabelB.setForeground(new Color(255,0,0));
			if(respostas[indice] != 'C')
				resplabelC.setForeground(new Color(255,0,0));
			if(respostas[indice] != 'D')
				resplabelD.setForeground(new Color(255,0,0));
			
			Timer pause = new Timer(2000, new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
					
					//voltar cores para o padrao
					resplabelA.setForeground(new Color(128,128,0));
					resplabelB.setForeground(new Color(128,128,0));
					resplabelC.setForeground(new Color(128,128,0));
					resplabelD.setForeground(new Color(128,128,0));
					
					//zerar variaveis para evitar erro
					resposta = ' ';
					segundos=15;
					tempolabel.setText(String.valueOf(segundos));
					
					//reativar botoes
					bA.setEnabled(true);
					bB.setEnabled(true);
					bC.setEnabled(true);
					bD.setEnabled(true);
					
					//verificar se ainda há proximos utilizaveis
					if (prox > 0) {
						bProx.setEnabled(true);
					}
					else {
						btn = "pular_off";
					}
					indice++;
					
					proximaQuestao();
				}
			});
			
			pause.setRepeats(false);
			pause.start();
		}
		//exibir resultado final
		public void resultado() {
			bA.setEnabled(false);
			bB.setEnabled(false);
			bC.setEnabled(false);
			bD.setEnabled(false);
			bProx.setEnabled(false);
			
			textbox.setText("RESULTADO !!!!!");
			areatext.setText(" ");
			resplabelA.setText(" ");
			resplabelB.setText(" ");
			resplabelC.setText(" ");
			resplabelD.setText(" ");
			
			//quantidade de acertos
			numerpontos.setText("PONTOS:"+pontos);
			
			//adicionar acertos a tela
			tela.add(numerpontos);
			
			
			
			//conteudo para estudos
			if(pontos < 50) {
			int resposta = JOptionPane.showConfirmDialog(tela,"Acho que lhe falta conhecimento! Gostaria de ter acesso a um material de estudo?", "nï¿½o", JOptionPane.YES_NO_OPTION);
				if (resposta == JOptionPane.YES_OPTION) {
					try{
				        URI link = new URI("https://periodicos.ufsm.br/reget/article/viewFile/4259/3035");
				        Desktop.getDesktop().browse(link);
				    }catch(Exception erro){
				            System.out.println(erro);
				    }
			      }
			      else {
			         JOptionPane.showMessageDialog(null, "Adeus");
			         System.exit(0);
				}
		}
			else {
				Y.Aplausos();
				
			}

		}
}

