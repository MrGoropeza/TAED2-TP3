import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduce un texto: ");
        String text = scanner.nextLine();

        Huffman huffman = new Huffman();
        huffman.construirArbol(text);
        huffman.imprimirMapaCodigos();

        String encodedText = huffman.codificar(text);
        System.out.println("Texto codificado: " + encodedText);

        String decodedText = huffman.decodificar(encodedText);
        System.out.println("Texto decodificado: " + decodedText);

        // Calcular y comparar los bits
        int originalBits = text.length() * 8; // Cada carácter ocupa 8 bits
        int encodedBits = encodedText.length(); // Cada bit es un carácter en el mensaje codificado

        System.out.println("Cantidad de bits del texto original: " + originalBits);
        System.out.println("Cantidad de bits del mensaje codificado: " + encodedBits);
        System.out.println(
                "El mensaje se redujo en un: " + (1 - ((float) encodedBits / originalBits)) * 100 + "%");

        scanner.close();
    }
}
