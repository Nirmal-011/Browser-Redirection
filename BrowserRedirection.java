package browser;
import java.util.*;

public class BrowserRedirection {

	private ArrayList<String>history;
	private int currentindex;
	
	BrowserRedirection(){
		history=new ArrayList<String>();
		history.add("www.google.com");
		currentindex=0;
	}
	
	public void implementUrlNavigation() {
	    Scanner scanner = new Scanner(System.in);
	    int choice;

	    do {
	        try {
	            System.out.println("Enter your choice:");
	            System.out.println("1. Visit new web page");
	            System.out.println("2. Go back");
	            System.out.println("3. Go forward");
	            System.out.println("4. Exit");
	            choice = scanner.nextInt();

	            switch (choice) {
	                case 1:
	                    newpage();
	                    break;
	                case 2:
	                    goback();
	                    break;
	                case 3:
	                    gofroward();
	                    break;
	                case 4:
	                    System.out.println("Exiting...");
	                    break;
	                default:
	                    System.out.println("Invalid choice. Please enter a valid option.");
	                    break;
	            }
	        } catch (Exception e) {
	            System.out.println("Invalid input. Please enter a valid option.");
	            scanner.nextLine(); // Consume invalid input
	            choice = 0; // Reset choice to force the loop to continue
	        }
	    } while (choice != 4);

	    scanner.close();
	}
	public void newpage() {
		
		Scanner in=new Scanner(System.in);
		System.out.println("Enter the URL :");
		String url= in.nextLine();
		for(int i=history.size()-1;i>0;i--) {
			history.remove(i);
		}
		history.add(url);
		currentindex++;
		System.out.println("You are in : "+ url);
		System.out.println("Current history: "+history);
		in.close();
	}
	public void goback() {
		if(currentindex>0) {
			currentindex--;
			System.out.println("You are in"+ history.get(currentindex));
			System.out.println("Current history: "+history);
		}
		else {
			System.out.println("This is the fisrt page");
		}
	}
	public void gofroward() {
		if(currentindex<history.size()-1)
		{
			currentindex++;
			System.out.println("You're in"+history.get(currentindex));
			System.out.println("Current history: "+history);
			
		}
		else {
			System.out.println("This is the last page");
		}
	}
	public static void main(String[] args) {
		BrowserRedirection BR=new BrowserRedirection();
		BR.implementUrlNavigation();
	}
	
}
