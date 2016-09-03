package br.com.separacao.estoque;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.separacao.conexao.*;
import br.com.separacao.estoque.EstoqueClass;

import java.awt.GridLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CadastroInterfaceGrafica extends JFrame {

	private JPanel contentPane;
	private JTextField tfid;
	private JTextField tfqtd;

	/**
	 * Launch the application.
	 */

	EstoqueClass cadest = new EstoqueClass();
	Conexao conex = new Conexao();
	MetodoSalvar met = new MetodoSalvar();
	MetodoEditar upd = new MetodoEditar();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroInterfaceGrafica frame = new CadastroInterfaceGrafica();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CadastroInterfaceGrafica() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 388, 229);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

								
				cadest.setQtd(tfqtd.getText());
				met.salvar(cadest);

				 
			}
		});

		tfid = new JTextField();
		tfid.setColumns(10);

		tfqtd = new JTextField();
		tfqtd.setColumns(10);

		JLabel lblCdigo = new JLabel("C\u00F3digo");

		JLabel lblQuantidade = new JLabel("Quantidade");
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				cadest.setQtd(tfqtd.getText());
				upd.editar(cadest);
				
			}
		});
		
		JButton btnDelete = new JButton("Delete");
		
		JButton btnPesquisar = new JButton("Pesquisar");
		
		JButton btnFechar = new JButton("Fechar");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(21)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnCadastrar)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnEditar)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnDelete)
							.addGap(10)
							.addComponent(btnFechar))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblCdigo)
								.addComponent(lblQuantidade))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(tfqtd, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(tfid, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(btnPesquisar)))))
					.addContainerGap(43, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(35)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(tfid, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCdigo)
						.addComponent(btnPesquisar))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(tfqtd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblQuantidade))
					.addGap(37)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCadastrar)
						.addComponent(btnEditar)
						.addComponent(btnDelete)
						.addComponent(btnFechar))
					.addContainerGap(96, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
