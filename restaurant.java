import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;


public class Restaurant {
	private static final int MAX_NUMBER_OF_TABLES = 2;
	private List<Table> mTables;
	//whenever a new customer comes we add him to the front of this queue
	private Deque<Customer> mCustomerQueue; 
	private Menu mMenu;
	private List<Bill> billStore;
	private static Restaurant mResturantObject = null; 
	private Customer currentCustomer;
	private List<Customer> customerArray;
	
	
	private Restaurant(){
		mTables = new ArrayList<Table>();
		mMenu = new Menu();
		billStore = new ArrayList<Bill>();
		mCustomerQueue = new ArrayDeque<Customer>(5);
		customerArray = new ArrayList<Customer>();
		currentCustomer = null;
		for(int i = 0; i < MAX_NUMBER_OF_TABLES; i++){
			Table t = new Table();
			mTables.add(t);
		}
	}
	
	public List<Table> getTables(){
		return mTables;
	}
	
	public boolean isAnyTableOccupied(){
		for(int i = 0; i < MAX_NUMBER_OF_TABLES; i++){
			if (mTables.get(i).isOccupied() == true){
				return true;
			}	
		}
		return false;
	}
	
	public int findTheEmptyTable(){
		for (int i = 0; i < MAX_NUMBER_OF_TABLES; i++) {
			if (mTables.get(i).isOccupied()== false) {
				return i;
			}
		}
		return -1;
	}
	
	public int DisplayOccupiedTable(){
		for (int i = 0; i < MAX_NUMBER_OF_TABLES; i++) {
			if (mTables.get(i).isOccupied()== true){
				System.out.println("Table no." + i + "is occupied");
			}
		}
	}
	
	public boolean isAllTableOccupied(){
		int val = findTheEmptyTable();
		if (val == -1) {
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public void bookATable(){
		if (isAllTableOccupied() == false) {
		int tableNumber = findTheEmptyTable();
		//get the customer from the list in the FIFO order
		//and remove him from the queue
		currentCustomer = mCustomerQueue.pollLast();
		//set the customer id same as table id, because a customer is identified
		//by the table which he occupies
		currentCustomer.setCustomerId(tableNumber);
		currentCustomer.getOrder().setOrderId(tableNumber);
		customerArray.add(tableNumber, currentCustomer);
		mTables.get(tableNumber).bookTable();
		System.out.println(currentCustomer.getCustomerName()+"has been given table number:"+ tableNumbere);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
