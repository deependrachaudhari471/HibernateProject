package in.com.prestige.test;

import in.com.prestige.model.TablePerClassModel;
import in.com.prestige_table_per_concrete_class.dto.ChequeDTO;
import in.com.prestige_table_per_concrete_class.dto.CreditCardDTO;


public class TestPaymentTablePerConcreteClass {
    //ADD Records
	public static void addRecords() throws Exception{
		CreditCardDTO  credit = new CreditCardDTO();
		credit.setPaymentId(101);
		credit.setAmount(300.0);
		credit.setCreditCardType("MasterCard");
		
		ChequeDTO cheque = new ChequeDTO();
		cheque.setPaymentId(111);
		cheque.setAmount(600.0);
		cheque.setChequeType("ICICI");
		
		TablePerClassModel model = new TablePerClassModel();
		String res = model.addRecordsConcrete(cheque, credit);
		System.out.println(res);
	}
	
	//Main Method
	public static void main(String[] args) throws Exception {
		addRecords();
	}
}
