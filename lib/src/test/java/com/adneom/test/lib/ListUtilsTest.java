package com.adneom.test.lib;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

/**
 * Classe de test des fonctionnalités de la classe ListUtils
 */
public class ListUtilsTest {

    private ListUtils<Integer> listUtils  = new ListUtils<>();

    private List<Integer> list = Arrays.asList(1,2,3,4,5);

    @Test
    public void partitionTestValide() throws Exception {

        // Déclaration de la première partition
        List<List<Integer>> partition1 = listUtils.partition(list,2);

        // Déclaration de la deuxième partition
        List<List<Integer>> partition2 = listUtils.partition(list,3);

        // Déclaration de la troisième partition
        List<List<Integer>> partition3 = listUtils.partition(list,1);

        // Vérification de contenu de la première partition
        assertNotNull("[partition1] est nulle",partition1);
        assertEquals("[partition1] ne contient pas trois sous listes",3,partition1.size());
        assertEquals(Arrays.asList(1,2), partition1.get(0));
        assertEquals(Arrays.asList(3,4), partition1.get(1));
        assertEquals(Collections.singletonList(5), partition1.get(2));

        // Vérification de contenu de la deuxième partition
        assertNotNull("[partition2] est nulle",partition2);
        assertEquals("[partition2] ne contient pas deux sous listes",2,partition2.size());
        assertEquals(Arrays.asList(1,2,3), partition2.get(0));
        assertEquals(Arrays.asList(4,5), partition2.get(1));

        // Vérification de contenu de la troisième partition
        assertNotNull("[partition3] est nulle", partition3);
        assertEquals("[partition3] ne contient pas cinq sous listes",5,partition3.size());
        assertEquals(Collections.singletonList(1), partition3.get(0));
        assertEquals(Collections.singletonList(2), partition3.get(1));
        assertEquals(Collections.singletonList(3), partition3.get(2));
        assertEquals(Collections.singletonList(4), partition3.get(3));
        assertEquals(Collections.singletonList(5), partition3.get(4));
    }

    @Test(expected = Exception.class)
    public void partitionTestAvecListNulle() throws Exception {
        listUtils.partition(null,2);
    }

    @Test(expected = Exception.class)
    public void partitionTestAvecListVide() throws Exception {
        listUtils.partition(new ArrayList<>(),2);
    }

    @Test(expected = Exception.class)
    public void partitionTesAvecTailleInvalide() throws Exception {
        listUtils.partition(list,0);
    }
}