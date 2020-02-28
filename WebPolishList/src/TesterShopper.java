import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import controller.ListDetailsHelper;
import controller.ShopperHelper;
import model.ListDetails;
import model.ListItems;
import model.Shopper;

public class TesterShopper {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*Shopper bill  = new Shopper("Bill");
		ShopperHelper sh = new ShopperHelper();
		sh.insertShopper(bill);
		
		List<Shopper> allShoppers = sh.showAllShoppers();
		for(Shopper a : allShoppers) {
			System.out.println(a.toString());
		}*/
		
	/*	Shopper stark = new Shopper("Stark");
		ShopperHelper sh = new ShopperHelper();
		sh.insertShopper(stark);
		
		ListDetailsHelper dh = new ListDetailsHelper();
		ListDetails starkList = new ListDetails("Stark's List", LocalDate.now(),stark);
		dh.insertNewListDetails(starkList);
		List<ListDetails> allLists = dh.getLists();
		for(ListDetails a: allLists) {
			System.out.println(a.toString());
		}*/
	Shopper tony = new Shopper("Hulk");
	
	
	ListDetailsHelper dl = new ListDetailsHelper();
	ListItems cc = new ListItems ("MAC", "Muscles");
	ListItems al = new ListItems("Almay", "Green");
	List<ListItems> hulkItems =new ArrayList<ListItems>();
	hulkItems.add(cc);
	hulkItems.add(al);
	
	ListDetails HulkList  = new ListDetails("Tony's List", LocalDate.now(),tony);
	HulkList.setListOfItems(hulkItems);
	dl.insertNewListDetails(HulkList);
	List<ListDetails> allLists = dl.getLists();
	for(ListDetails a: allLists) {
		System.out.println(a.toString());
	}
	}
}
