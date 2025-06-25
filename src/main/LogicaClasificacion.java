package main;

import java.util.*;

public class LogicaClasificacion {

    /**
     * Invierte una cadena de texto utilizando una pila (Stack).
     *
     * @param texto Cadena original a invertir.
     * @return Cadena invertida.
     *
     *         Ejemplo:
     *         Entrada: "Hola Mundo"
     *         Salida: "odnuM aloH"
     */
    public String invertirCadena(String texto) {
       Stack<Character> stack = new Stack<>();
       String cadenaFinal = "";
        for (int i = 0; i < texto.length(); i++) {
            stack.push(texto.charAt(i));
        }
        while (!stack.isEmpty()) {
            cadenaFinal += stack.pop();
        }
        return cadenaFinal;
    }

    /**
     * Verifica si los símbolos de paréntesis, corchetes y llaves están bien
     * balanceados.
     *
     * @param expresion Cadena con símbolos.
     * @return true si está balanceada, false en caso contrario.
     *
     *         Ejemplo:
     *         Entrada: "{[()]}"
     *         Salida: true
     */
    public boolean validarSimbolos(String expresion) {
       Stack<Character> stack = new Stack<>();

        for (char c : expresion.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            }
            
            else if (c == ')' || c == ']' || c == '}') {
                if (stack.isEmpty()) return false;
                char top = stack.pop(); 
                if (!esPar(top, c)) return false; 
            }
        }
        return stack.isEmpty();
    }

    private boolean esPar(char apertura, char cierre) {
        return  (apertura == '(' && cierre == ')') ||
                (apertura == '[' && cierre == ']') ||
                (apertura == '{' && cierre == '}');
    }

    /**
     * Ordena una pila de enteros en orden ascendente usando otra pila auxiliar.
     *
     * @return Lista ordenada.
     *
     *         Ejemplo:
     *         Entrada: [3, 1, 4, 2]
     *         Salida: [1, 2, 3, 4]
     */
    public List<Integer> ordenarPila(Stack<Integer> pila) {
        Stack<Integer> aux = new Stack<>();
            while (!pila.isEmpty()) {
                int temp = pila.pop();
                while (!aux.isEmpty() && aux.peek() < temp) {
                    pila.push(aux.pop());
                }
                aux.push(temp);
            }
            Stack<Integer> resultado = new Stack<>();
            while (!aux.isEmpty()) {
                resultado.push(aux.pop());
            }
            return resultado;
    }

    /**
     * Clasifica una lista de enteros separando pares e impares.
     * Usa LinkedList para mantener el orden de inserción.
     *
     * @return Lista con pares primero, luego impares.
     *
     *         Ejemplo:
     *         Entrada: [1, 2, 3, 4, 5, 6]
     *         Salida: [2, 4, 6, 1, 3, 5]
     */
    public List<Integer> clasificarPorParidad(LinkedList<Integer> original) {
        Queue<Integer> colaPares = new LinkedList<>();
        Queue<Integer> colaImpares = new LinkedList<>();

        for (Integer num : original) {
            if (num % 2 == 0) {
                colaPares.add(num);     
            } else {
                colaImpares.add(num);   
            }
        }
        List<Integer> resultado = new ArrayList<>();
        while (!colaPares.isEmpty()) {
            resultado.add(colaPares.poll()); 
        }
        while (!colaImpares.isEmpty()) {
            resultado.add(colaImpares.poll()); 
        }
        return resultado;
    }
}
