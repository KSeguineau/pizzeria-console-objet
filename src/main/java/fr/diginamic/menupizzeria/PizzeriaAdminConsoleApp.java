package fr.diginamic.menupizzeria;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import fr.diginamic.menupizzeria.model.Pizza;

public class PizzeriaAdminConsoleApp {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		boolean sortir = false;

		List<Pizza> listePizza = new ArrayList<>();
		listePizza.addAll(Arrays.asList(new Pizza("PEP", "Pépéroni", 12.50), new Pizza("Mar", "Margherita", 14.00),
				new Pizza("REIN", "La Reine", 11.50), new Pizza("Fro", "La 4 fromages", 12.00),
				new Pizza("CAN", "La cannibale", 12.50), new Pizza("SAV", "La savoyarde", 13.00),
				new Pizza("ORI", "L'orientale", 13.50), new Pizza("IND", "L'indienne", 14.00)));

		while (!sortir) {
			afficherMenu();
			int choix = scanner.nextInt();

			switch (choix) {
			case 1:
				listePizza.forEach(e -> System.out.println(e));
				break;
			case 2:
				listePizza.add(creationPizza(scanner));
				break;
			case 3:
				modifierPizza(listePizza, scanner);
				break;
			case 4:
				supprimerPizza(listePizza, scanner);
				break;
			case 99:
				System.out.println("Aurevoir :(");
				sortir = true;
				break;
			default:
				System.out.println("commande non reconnue");

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

	public static Pizza creationPizza(Scanner scan) {

		System.out.println("Veuillez saisir le code:");
		String code = scan.next();
		System.out.println("Veuillez saisir le nom (sans espace)");
		String nom = scan.next();
		System.out.println("Veuillez saisir le prix:");
		double prix = Double.parseDouble(scan.next());
		return new Pizza(code, nom, prix);
	}

	public static void modifierPizza(List<Pizza> list, Scanner scan) {
		list.forEach(e -> System.out.println(e));
		System.out.println("Veuillez choisir le code de la pizza à modifier");
		String code = scan.next();
		int indice = recherchePizzaParCode(list, code);
		if (indice >= 0) {
			list.set(indice, creationPizza(scan));
			System.out.println("la pizza " + code + " a bien été modifiée");
		} else {
			System.out.println("aucune pizza n'a été trouvée pour ce code");
		}

	}

	public static int recherchePizzaParCode(List<Pizza> list, String code) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getCode().equals(code)) {
				return i;
			}
		}
		return -1;
	}

	public static void supprimerPizza(List<Pizza> list, Scanner scan) {

		System.out.println("Veuillez choiser le code de la pizza à supprimer");
		String code = scan.next();
		int indice = recherchePizzaParCode(list, code);
		if (indice >= 0) {
			list.remove(indice);
			System.out.println("la pizza " + code + " à été supprimée");
		} else {
			System.out.println("aucune pizza n'a été trouvée pour ce code");
		}
	}
}
