package com.adneom.test.lib;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * La classe ListUtils met à disposition des utilisateurs un ensemble de méthodes
 * permettant de manipuler les données d'une liste
 */
class ListUtils<T> {

    /**
     * Découper une liste à une liste de sous liste
     *
     * @param list   la liste originale
     * @param taille le nombre maximum d'éléments par sous liste
     * @return la liste de sous liste
     */
    public List<List<T>> partition(List<T> list, int taille) throws Exception {
        // Déclaration d'un compteur
        AtomicInteger compteur = new AtomicInteger();

        // Vérifier si la liste n'est pas nulle
        // n'est pas vide
        // est que la taille des listes cibles est supérieure  de 0
        if (list != null && !list.isEmpty() && taille > 0) {
            return new ArrayList<>(list
                    .stream()
                    .collect(Collectors.groupingBy(it -> compteur.getAndIncrement() / taille))
                    .values());
        } else {
            // Afficher un message d'erreur ou lever une exception
            // Ex:
            System.out.println("Paramètres invalides");
            throw new Exception("Parametres invalides");
        }
    }
}