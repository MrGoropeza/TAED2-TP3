# Implementación del Algoritmo de Huffman

Este proyecto implementa el algoritmo de compresión de Huffman en Java. El programa permite comprimir texto utilizando codificación de Huffman y luego descomprimirlo, mostrando las estadísticas de compresión.

## Descripción

El algoritmo de Huffman es un método de compresión que asigna códigos de longitud variable a los caracteres, basándose en su frecuencia de aparición. Los caracteres más frecuentes reciben códigos más cortos, lo que resulta en una compresión efectiva del texto.

## Funcionalidades

- Lectura de texto de longitud variable
- Construcción del árbol de Huffman utilizando una lista dinámica
- Codificación del texto utilizando los códigos de Huffman generados
- Decodificación del texto comprimido
- Visualización de la tabla de códigos para cada carácter
- Cálculo y muestra de las estadísticas de compresión

## Estructura del Proyecto

- `Huffman.java`: Clase principal que implementa el algoritmo de Huffman
- `NodoHuffman.java`: Clase que representa los nodos del árbol de Huffman
- `App.java`: Programa principal con interfaz de usuario por consola

## Uso

1. Ejecutar la clase `App`
2. Ingresar el texto que se desea comprimir
3. El programa mostrará: - La tabla de códigos para cada carácter - El texto codificado - El texto decodificado - Estadísticas de compresión (bits originales vs comprimidos)

## Ejemplo de Salida

```
Introduce un texto: estamos bien
Caracteres y sus códigos:
a: 001
b: 010
e: 101
i: 011
m: 110
n: 111
s: 100
t: 000
Texto codificado: 101100000001110101100010011101111
Texto decodificado: estamos bien
Cantidad de bits del texto original: 88
Cantidad de bits del mensaje codificado: 33
El mensaje se redujo en un: 62.5%
```

## Requisitos

- Java JDK 8 o superior
- IDE Java (opcional)
