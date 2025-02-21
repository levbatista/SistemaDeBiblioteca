import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        Scanner scanner = new Scanner(System.in);

        // Adicionando alguns livros e usuários para teste
        biblioteca.adicionarLivro(new Livro("O Hobbit", "J.R.R. Tolkien", 1937, "Fantasia"));
        biblioteca.adicionarLivro(new Livro("1984", "George Orwell", 1949, "Ficção"));
        biblioteca.adicionarUsuario(new Usuario("Alice"));
        biblioteca.adicionarUsuario(new Usuario("Bob"));

        // Interação com o usuário
        while (true) {
            System.out.println("\n=== Sistema de Biblioteca ===");
            System.out.println("Escolha uma opção:");
            System.out.println("1. Alugar Livro");
            System.out.println("2. Devolver Livro");
            System.out.println("3. Listar Livros Disponíveis");
            System.out.println("4. Listar Usuários Cadastrados");
            System.out.println("5. Sair");
            System.out.print("Opção: ");

            int opcao;
            try {
                opcao = scanner.nextInt();
                scanner.nextLine(); // Consumir a nova linha
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, insira um número.");
                scanner.nextLine(); // Limpar o buffer
                continue; // Volta para o início do loop
            }

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome do usuário: ");
                    String nomeUsuario = scanner.nextLine();
                    Usuario usuario = biblioteca.buscarUsuario(nomeUsuario);

                    if (usuario != null) {
                        System.out.print("Digite o título do livro: ");
                        String tituloLivro = scanner.nextLine();
                        Livro livro = biblioteca.buscarLivro(tituloLivro);

                        if (livro != null) {
                            usuario.alugarLivro(livro);
                        } else {
                            System.out.println("Livro não encontrado.");
                        }
                    } else {
                        System.out.println("Usuário não encontrado.");
                    }
                    break;

                case 2:
                    System.out.print("Digite o nome do usuário: ");
                    nomeUsuario = scanner.nextLine();
                    usuario = biblioteca.buscarUsuario(nomeUsuario);

                    if (usuario != null) {
                        System.out.print("Digite o título do livro que deseja devolver: ");
                        String tituloLivro = scanner.nextLine();
                        usuario.devolverLivro(tituloLivro);
                    } else {
                        System.out.println("Usuário não encontrado.");
                    }
                    break;

                case 3:
                    biblioteca.listarLivrosDisponiveis();
                    break;

                case 4:
                    biblioteca.listarUsuarios();
                    break;

                case 5:
                    System.out.println("Saindo...");
                    scanner.close();
                    return; // Encerra o programa

                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
    }
}