import java.util.ArrayList;

public class Usuario {
    private String nome;
    private ArrayList<Livro> livrosAlugados;

    public Usuario(String nome) {
        this.nome = nome;
        this.livrosAlugados = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Livro> getLivrosAlugados() {
        return livrosAlugados;
    }

    public void alugarLivro(Livro livro) {
        if (livro.isDisponivel()) {
            livrosAlugados.add(livro);
            livro.setDisponivel(false);
            System.out.println(nome + " alugou o livro: " + livro.getTitulo());
        } else {
            System.out.println("O livro " + livro.getTitulo() + " não está disponível.");
        }
    }

    public void devolverLivro(String titulo) {
        for (Livro livro : livrosAlugados) {
            if (livro.getTitulo().equals(titulo)) {
                livro.setDisponivel(true);
                System.out.println(nome + " devolveu o livro: " + livro.getTitulo());
                livrosAlugados.remove(livro);
                return;
            }
        }
        System.out.println(nome + " não tem o livro " + titulo + " para devolver.");
    }

    public void listarLivrosAlugados() {
        if (livrosAlugados.isEmpty()) {
            System.out.println(nome + " não tem livros alugados.");
        } else {
            System.out.println(nome + " tem os seguintes livros alugados:");
            for (Livro livro : livrosAlugados) {
                System.out.println("- " + livro.getTitulo());
            }
        }
    }
}