public class NodoHuffman {
    char caracter;
    int frecuencia;
    NodoHuffman izquierdo;
    NodoHuffman derecho;

    public NodoHuffman(char caracter, int frecuencia) {
        this.caracter = caracter;
        this.frecuencia = frecuencia;
        this.izquierdo = null;
        this.derecho = null;
    }
}