
import java.util.Scanner;
import static javax.swing.JOptionPane.*;
import static java.lang.Integer.parseInt;
import static java.lang.Double.parseDouble;

public class ex1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner teclado = new Scanner(System.in);

		int numprod, indprod = 0;

		System.out.println("Insira o número de produtos--> ");
		numprod = teclado.nextInt();

		Produtos[] prod = new Produtos[numprod];

		while (indprod != 5) {

			if (numprod > 10) {

				System.out.println("Máximo de 10 produtos!");
				return;

			} else {

				// dar alt+tab para janela de cadastro aparecer
				System.out.println("\nEscolha uma opção(1 até 5):");
				System.out.println("\n1. Cadastrar produto");
				System.out.println("\n2. Pesquisar produto");
				System.out.println("\n3. Listar produto");
				System.out.println("\n4. Excluir produto");
				System.out.println("\n5. Finalizar");
				indprod = teclado.nextInt();
			}

			if (indprod == 1) {

				prod = cadastrar(numprod);

			} else if (indprod == 2) {

				pesquisar(prod);

			} else if (indprod == 3) {

				listar(prod);

			} else if (indprod == 4) {

				excluir(prod);

			} else {

				System.out.println("\nOperação finalizada com sucesso!");

			}

		}

	}

	public static Produtos[] cadastrar(int numprod) {

		Produtos[] produto = new Produtos[numprod];

		for (int i = 0; i < produto.length; i++) {

			produto[i] = new Produtos();

			// dar alt+tab para janela de cadastro aparecer
			produto[i].nome = showInputDialog("Nome do produto");
			produto[i].qtd = parseInt(showInputDialog("Quantidade de itens"));
			produto[i].valor = parseDouble(showInputDialog("Preço do produto (unidade)"));
		}

		return produto;

	}

	public static void pesquisar(Produtos[] prod) {

		Scanner teclado = new Scanner(System.in);

		String aux;

		System.out.println("Insira o nome do produto que deseja pesquisar--> ");
		aux = teclado.nextLine();

		for (int i = 0; i < prod.length; i++) {

			if (aux.equalsIgnoreCase(prod[i].nome)) {

				System.out.println("\nNome do produto--> " + prod[i].nome);
				System.out.println("Quantidade do produto--> " + prod[i].qtd);
				System.out.println("Preço do produto--> " + String.format("%.2f", prod[i].valor));

				return;
			}

		}

		System.out.println("\nProduto não encontrado!");
		return;

	}

	public static void listar(Produtos[] prod) {

		for (int i = 0; i < prod.length; i++) {

			System.out.println("\nNome do produto--> " + prod[i].nome);
			System.out.println("Quantidade do produto--> " + prod[i].qtd);
			System.out.println("Preço do produto--> " + String.format("%.2f", prod[i].valor));
		}

		return;
	}

	public static void excluir(Produtos[] prod) {

		Scanner teclado = new Scanner(System.in);

		String aux2;
		String aux3 = "Produto excluído";

		System.out.println("Nome do produto que deseja excluir--> ");
		aux2 = teclado.nextLine();

		for (int i = 0; i < prod.length; i++) {

			if (aux2.equalsIgnoreCase(prod[i].nome)) {

				prod[i].nome = aux3;
				prod[i].qtd = 0;
				prod[i].valor = 0;
				System.out.println("\nProduto excluído com sucesso!!!");
				return;

			}
		}

		System.out.println("\nProduto não encontrado!");
		return;

	}

}
