import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Pessoa> banco = new ArrayList<>();
        banco.add(new Pessoa(1, "Ana", 28));
        banco.add(new Pessoa(2, "Carlos", 35));
        banco.add(new Pessoa(3, "Beatriz", 22));
        banco.add(new Pessoa(4, "Diego", 40));

        List<Pessoa> cache = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o ID da pessoa que deseja buscar: ");
        int idBuscado = scanner.nextInt();

        Pessoa pessoaEncontrada = buscarPorId(cache, idBuscado);

        if (pessoaEncontrada != null) {
            System.out.println("Pessoa encontrada no cache: " + pessoaEncontrada);
        } else {
            pessoaEncontrada = buscarPorId(banco, idBuscado);

            if (pessoaEncontrada != null) {
                cache.add(pessoaEncontrada);
                System.out.println("Pessoa buscada no banco e adicionada ao cache: " + pessoaEncontrada);
            } else {
                System.out.println("Pessoa não encontrada nem no cache nem no banco de dados.");
            }
        }

        scanner.close();
    }

    private static Pessoa buscarPorId(List<Pessoa> lista, int id) {
        for (Pessoa p : lista) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }
}
