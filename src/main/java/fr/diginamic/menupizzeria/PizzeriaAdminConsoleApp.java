package fr.diginamic.menupizzeria;

import java.util.Scanner;

public class PizzeriaAdminConsoleApp {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		boolean sortir = false;

		while (!sortir) {
			afficherMenu();
			int choix = scanner.nextInt();

			switch (choix) {
			case 1:
				System.out.println("Liste des pizzas");
				break;
			case 2:
				System.out.println("Ajout d'une nouvelle pizza");
				break;
			case 3:
				System.out.println("Mise à jour d'une pizza");
				break;
			case 4:
				System.out.println("Suppression d'une pizza");
				break;
			case 99:
				System.out.println("Aurevoir :(");
				sortir = true;
				break;

			}
		}
		scanner.close();
	}

	public static void afficherMenu() {
		System.out.println("***** Pizzeria Administration *****");
		System.out.println("1. Lister les Pizzas");
		System.out.println("2. Ajouter une nouvelle pizza");
		System.out.println("3. Mettre à jour une pizza");
		System.out.println("4. Supprimer une pizza");
		System.out.println("99. Sortir");
	}
}
