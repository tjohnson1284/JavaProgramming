
public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		Bank csumbBank = new Bank("CSUMB");
		csumbBank.readData("C:\\test.txt");
		System.out.println("");
		csumbBank.bankInfo();
		System.out.println("");
		csumbBank.newCustomer("Bob Smith","123 University Center",93955,"123-45-6789");
		csumbBank.newCustomer("Unknown Smith","123 University Center",93955,"777-77-7777");
		System.out.println("");
		csumbBank.newAccount("777-77-7777", 4000, 1, 100.50);
		csumbBank.newAccount("123-45-7777", 2000, 1, 100.50);
		csumbBank.newAccount("123-45-7777", 4000, 1, 100.50);
		System.out.println("");
		csumbBank.accountInfo(7000);
		csumbBank.accountInfo(1000);
		System.out.println("");
		csumbBank.customerInfoWithSSN(7979);
		System.out.println("");
		csumbBank.customerInfoWithSSN(7777);
		System.out.println("");
		csumbBank.customerInfoWithSSN(6789);
		System.out.println("");
		csumbBank.closeAccount(7070);
		System.out.println("");
		csumbBank.closeAccount(2000);
		System.out.println("");
		csumbBank.removeCustomer("555-55-5555");
		System.out.println("");
		csumbBank.removeCustomer("777-77-7777");
		System.out.println("");
		}
	
	

}
