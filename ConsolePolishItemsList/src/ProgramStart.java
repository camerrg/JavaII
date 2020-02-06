import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;

import controller.ListItemsHelper;
import model.ListItems;


public class ProgramStart {
		
		static Scanner in = new Scanner(System.in);
		static ListItemsHelper lh = new ListItemsHelper();
		
		
		private static void addAnItem() {
			System.out.print("Enter a brand: ");
			String brand = in.nextLine();
			System.out.print("Enter an color: ");
			String color = in.nextLine();
			ListItems toAdd = new ListItems(brand,color);
			lh.insertItem(toAdd);
				
			
		}
		
		private static void deleteAnItem() {
			System.out.print("Enter the brand to delete: ");
			String brand = in.nextLine();
			System.out.print("Enter the color to delete: ");
			String color = in.nextLine();
			ListItems toDelete = new ListItems(brand,color);
			lh.deleteItem(toDelete);
		}
		
		private static void editAnItem() {
			// TODO Auto-generated method stub
			System.out.println("How would you like to search? ");
			System.out.println("1 : Search by Brand");
			System.out.println("2 : Search by Color");
			int searchBy = in.nextInt();
			in.nextLine();
			
			List<ListItems> foundItems;
			if (searchBy == 1) {
				System.out.print("Enter the brand name: ");
				String brandName = in.nextLine();
				foundItems = lh.searchForItemByBrand(brandName);
			} else {
				System.out.print("Enter the color: ");
				String colorName = in.nextLine();
				foundItems = lh.searchForItemByColor(colorName);
				

			}

			if (!foundItems.isEmpty()) {
				System.out.println("Found Results.");
				for (ListItems l : foundItems) {
					System.out.println(l.getId() + " : " + l.returnItemDetails());
				}
				System.out.print("Which ID to edit: ");
				int idToEdit = in.nextInt();

				ListItems toEdit = lh.searchForItemById(idToEdit);
				System.out.println("Retrieved " + toEdit.getColor() + " from " + toEdit.getBrand());
				System.out.println("1 : Update Brand");
				System.out.println("2 : Update Color");
				int update = in.nextInt();
				in.nextLine();

				if (update == 1) {
					System.out.print("New Brand: ");
					String newBrand = in.nextLine();
					toEdit.setBrand(newBrand);
				} else if (update == 2) {
					System.out.print("New Color: ");
					String newColor = in.nextLine();
					toEdit.setColor(newColor);
				}

				lh.updateColor(toEdit);

			} else {
				System.out.println("---- No results found");
			}

		}
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			runMenu();

		}

		public static void runMenu() {
			boolean goAgain = true;
			System.out.println("--- Welcome to our awesome nail polish list! ---");
			while (goAgain) {
				System.out.println("*  Select an color:");
				System.out.println("*  1 -- Add an color");
				System.out.println("*  2 -- Edit an color");
				System.out.println("*  3 -- Delete an color");
				System.out.println("*  4 -- View the color");
				System.out.println("*  5 -- Exit your nail color selection for today!");
				System.out.print("*  Your selection: ");
				int selection = in.nextInt();
				in.nextLine();

				if (selection == 1) {
					addAnItem();
				} else if (selection == 2) {
					editAnItem();
				} else if (selection == 3) {
					deleteAnItem();
				} else if (selection == 4) {
					viewTheList();
				} else {
					lh.cleanUp();
					System.out.println("   Goodbye!   ");
					goAgain = false;
				}

			}

		}

		private static void viewTheList() {
			List<ListItems>allItems = lh.showAllItems();
			for(ListItems singleItem : allItems) {
				System.out.println(singleItem.returnItemDetails());
			}
			

		}

		
			
		}
		


