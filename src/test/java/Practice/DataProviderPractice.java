package Practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPractice {
	
	@Test(dataProvider="getData")
	
	public void addaproductToCart(String name,int price,int qty,String model) {
		System.out.println("Phone name is- "+name+ " price -"+price+"  Qty-"+qty+" model is-"+model);
	}
	@DataProvider
	public Object[][] getData()
	{
		Object[][] data=new Object[3][4]; //3 set of data with 4 details in each set
		
		data[0][0]="Samsung";
		data[0][1]=10000;
		data[0][0]=20;
		data[0][1]="A21";
		
		data[0][0]="Oppo";
		data[0][1]=15000;
		data[0][0]=20;
		data[0][1]="Ao13";
		
		data[0][0]="Redmi";
		data[0][1]=20000;
		data[0][0]=25;
		data[0][1]="Note4";
		
		return data;
	}
}
