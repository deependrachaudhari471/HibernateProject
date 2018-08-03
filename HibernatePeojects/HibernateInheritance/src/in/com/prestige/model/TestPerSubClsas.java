package in.com.prestige.model;

import java.util.Iterator;
import java.util.List;

import in.com.prestige_table_per_subclass.dto.ChequeDTO;
import in.com.prestige_table_per_subclass.dto.CreditCardDTO;


public class TestPerSubClsas {
	public static void addRecords() throws Exception {
		CreditCardDTO credit = new CreditCardDTO();
		credit.setPaymentId(11);
		credit.setAmount(8000.0);
		credit.setCreditCardType("Rupay");

		ChequeDTO cheq = new ChequeDTO();
		cheq.setPaymentId(10);
		cheq.setAmount(12070.0);
		cheq.setChequeType("UBI");

		TablePerClassModel model = new TablePerClassModel();
		String res = model.addRecords(cheq, credit);
		System.out.println(res);
	}
	
	//GetRecords
	public static void getResult() throws Exception{
		TablePerClassModel model = new TablePerClassModel();
		List list = model.getResultCreditCard();
		Iterator it = list.iterator();
		while(it.hasNext()){
			CreditCardDTO pay = (CreditCardDTO)it.next();
			System.out.println(pay.getPaymentId());
			System.out.println(pay.getCreditCardType());
			System.out.println(pay.getAmount());
		}
	}

	public static void main(String[] args) throws Exception{
      // addRecords();
		getResult();
	}
}
