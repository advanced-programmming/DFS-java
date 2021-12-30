package com.co.pa;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

// Busqueda por profundidad -> (DFS -> depth-first search)
public class Main {

    static int MAX = 5;
    static int MIN = 0;
    static List<List<Integer>> listAdjacent = getDataFake(); // La adjacent list
    static long visited[] = new long[MAX + 1];

    public static void main(String[] args) {
        ThreadLocalRandom tlr = ThreadLocalRandom.current();
        int startNode = tlr.nextInt(MIN, (MAX + 1)); // se genera un numero aleatorio para el nodo inicial
        dfs(startNode); // llamado de la busqueda en profundidad
    }

    //receive de start node
    static void dfs(int startNode){
        visited[startNode] = 1; // startNode in there moment was visited

        int nextNode; // este va ser el proximo nodo de adyacencia del nodo inicial
        for(int i = 0; i < listAdjacent.get(startNode).size(); i++){ // itera sólo los nodos de adyacencia del nodo de inicio
            nextNode = listAdjacent.get(startNode).get(i); // asigna el siguiente nodo.
            if(visited[nextNode] != 1) dfs(nextNode); // Si el nodo de adyacencia no ha sido marcado, entonces, enviamos como nodo incial al nodo next (adyacente del nodo inicial)
        }
    }

    public static List<List<Integer>> getDataFake(){
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list0 = new ArrayList<>();
        list0.add(1);
        list0.add(5);

        List<Integer> list1 = new ArrayList<>();
        list1.add(0);
        list1.add(4);

        List<Integer> list2 = new ArrayList<>();
        list2.add(4);
        list2.add(5);
        list2.add(3);

        List<Integer> list3 = new ArrayList<>();
        list3.add(2);
        list3.add(5);
        list3.add(4);

        List<Integer> list4 = new ArrayList<>();
        list4.add(1);
        list4.add(2);
        list4.add(3);

        List<Integer> list5 = new ArrayList<>();
        list5.add(0);
        list5.add(3);
        list5.add(2);

        result.add(list0);
        result.add(list1);
        result.add(list2);
        result.add(list3);
        result.add(list4);
        result.add(list5);
        return result;
    }
}