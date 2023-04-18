package br.com.poo.interfac;

import java.sql.ResultSet;

import javax.swing.JOptionPane;

import br.com.poo.conexao.Conexao;

public class MenuLogins extends Interface {
	
	public  MenuLogins() {
		//this.setVisible(false);
		int i = 0;
		while (i < 3) {				
			
			String usuario = JOptionPane.showInputDialog(null, "Usuário:","Usuario",JOptionPane.DEFAULT_OPTION);
			String senha = JOptionPane.showInputDialog(null, "Senha:","Senha",JOptionPane.DEFAULT_OPTION);
			String cpfsenha = usuario + senha;
			Conexao con = new Conexao();
			String sql = "select * from funcionario f where cpfsenha=" + "'" + cpfsenha + "'" + ";";
			ResultSet rs = con.executaBusca(sql);
			try {
				while (rs.next()) {

					String conf = rs.getString("cpfsenha");
				    String nome1 = rs.getString("nome");
					String cargo = rs.getString("cargo");
					if (cpfsenha.equals(conf)) {
						JOptionPane.showMessageDialog(null, "              Bem-vindo!\n                   " + nome1);
						if (cargo.equalsIgnoreCase("caixa")) {
							MenuCaixa();
							break;
						}
						if (cargo.equalsIgnoreCase("Diretor")) {
							//MenuDiretor();
							break;
						}
//						if (cargo.equals("Presidente")) {
//							MenuDiretor();
//							break;
//						}
						if (cargo.equalsIgnoreCase("Gerente")) {
							MenuGerente();
							break;
						}
						if (cargo.equalsIgnoreCase("Cliente")) {
							MenuCliente();
							break;
						}

						else {
							JOptionPane.showMessageDialog(null, "Cargo invalido");

						}

					} else {
						JOptionPane.showMessageDialog(null, "Usuário ou senha incorretos!");
						i++;
					}
				}
				break;
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		int x = 5;
		while (x > 0) {
			JOptionPane.showMessageDialog(null, "Usuario ou senha incorretos!\n Clique em ok para continuar\n Tente Novamente em: "+x,"Error",JOptionPane.WARNING_MESSAGE);

			System.out.println(x);
			x--;
		}
		//MenuLogin();

	}

	

}
