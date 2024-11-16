import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Huffman {
    private NodoHuffman raiz;
    private Map<Character, String> mapaCodigosHuffman = new HashMap<>();

    // Construir el árbol de Huffman
    public void construirArbol(String texto) {
        // Calcular frecuencias
        Map<Character, Integer> mapaFrecuencias = new HashMap<>();
        for (char caracter : texto.toCharArray()) {
            mapaFrecuencias.put(caracter, mapaFrecuencias.getOrDefault(caracter, 0) + 1);
        }

        // Crear una lista para almacenar los nodos
        List<NodoHuffman> listaNodos = new ArrayList<>();
        for (Map.Entry<Character, Integer> entrada : mapaFrecuencias.entrySet()) {
            listaNodos.add(new NodoHuffman(entrada.getKey(), entrada.getValue()));
        }

        // Construir el árbol de Huffman
        while (listaNodos.size() > 1) {
            // Ordenar nodos por frecuencia
            listaNodos.sort(Comparator.comparingInt(nodo -> nodo.frecuencia));

            // Combinar los dos nodos con menor frecuencia
            NodoHuffman izquierdo = listaNodos.remove(0);
            NodoHuffman derecho = listaNodos.remove(0);
            NodoHuffman nuevoNodo = new NodoHuffman('\0', izquierdo.frecuencia + derecho.frecuencia);
            nuevoNodo.izquierdo = izquierdo;
            nuevoNodo.derecho = derecho;

            // Agregar el nuevo nodo a la lista
            listaNodos.add(nuevoNodo);
        }

        // El último nodo restante es la raíz del árbol
        raiz = listaNodos.get(0);

        // Construir el mapa de códigos
        construirMapaCodigos(raiz, "");
    }

    // Codificar un texto
    public String codificar(String texto) {
        StringBuilder textoCodificado = new StringBuilder();
        for (char caracter : texto.toCharArray()) {
            textoCodificado.append(mapaCodigosHuffman.get(caracter));
        }
        return textoCodificado.toString();
    }

    // Decodificar un texto codificado
    public String decodificar(String textoCodificado) {
        StringBuilder textoDecodificado = new StringBuilder();
        NodoHuffman nodoActual = raiz;
        for (char bit : textoCodificado.toCharArray()) {
            nodoActual = (bit == '0') ? nodoActual.izquierdo : nodoActual.derecho;

            if (nodoActual.izquierdo == null && nodoActual.derecho == null) {
                textoDecodificado.append(nodoActual.caracter);
                nodoActual = raiz;
            }
        }
        return textoDecodificado.toString();
    }

    public void imprimirMapaCodigos() {
        System.out.println("Caracteres y sus códigos:");
        for (Map.Entry<Character, String> entrada : mapaCodigosHuffman.entrySet()) {
            System.out.println(entrada.getKey() + ": " + entrada.getValue());
        }
    }

    // Construir el mapa de códigos recursivamente
    private void construirMapaCodigos(NodoHuffman nodo, String codigo) {
        if (nodo == null)
            return;

        if (nodo.caracter != '\0') {
            mapaCodigosHuffman.put(nodo.caracter, codigo);
        }

        construirMapaCodigos(nodo.izquierdo, codigo + "0");
        construirMapaCodigos(nodo.derecho, codigo + "1");
    }
}