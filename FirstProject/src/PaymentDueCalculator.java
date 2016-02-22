import java.util.Calendar;
import java.util.GregorianCalendar;

public class PaymentDueCalculator {
	
	int dayOfSettlementReport;
	int dayOfPaymentEligibility;
	int dayOfPaymentInitiation;
	int daysUntilPaymentInitiationDate;
	int day;
	

	
	
	
	public PaymentDueCalculator(String dayOfWeek){
		//day = dayOfWeek;
	}
	
	public int getDayOfSettlementReport(int authorisationDay){
		
		int input = authorisationDay;
		int output;
		switch (input){
			case 1: 		output = 2;
				break;
			case 2: 		output = 3;
				break;
			case 3: 		output = 4;
				break;
			case 4: 		output = 5;
				break;
			case 5: 		output = 10;
				break;
			case 6: 		output = 10;
				break;
			case 7: 		output = 10;
				break;
				
			default : 			output = 1;
		}
		
		return output;
		
	}	
	
	public int getDayOfPaymentEligibility(int settlementDay, int pendingPeriod){
		
		GregorianCalendar today = new GregorianCalendar();
		
		int input = settlementDay;
		int output;
		switch (input){
			case 2: 		output = 3;
				break;
			case 3: 		output = 4;
				break;
			case 4: 		output = 5;
				break;
			case 5: 		output = 6;
				break;
			case 10: 		output = 11;
				break;
				
			default : 			output = 3;
		}
		
		return output + pendingPeriod;
		
	}
	
	public int getDayOfPaymentIntitiation(int paymentEligibilityDay){
		
		GregorianCalendar today = new GregorianCalendar();
		
		int dayOfPaymentInitiation;
		
		if (paymentEligibilityDay < 9) 
		{ 
			dayOfPaymentInitiation = 9;
		}
		else if(paymentEligibilityDay < 12) 
		{
			dayOfPaymentInitiation = 12;
		}
		
		else if(paymentEligibilityDay < 16) 
		{
			dayOfPaymentInitiation = 16;
		}
		
		else dayOfPaymentInitiation = 19;
		
		return dayOfPaymentInitiation;
		
	}
	
	public static void main(String[] args) 
	{
		GregorianCalendar today = new GregorianCalendar();
		String dayName = "Tuesday"; 
		int pendingPeriod = 10;
		PaymentDueCalculator calc = new PaymentDueCalculator(dayName);
		StringToIntConverter numerator = new StringToIntConverter();
		IntToStringConverter namer = new IntToStringConverter();
		int authorisationDay = numerator.dayNumerator(dayName);
		int settlementDay = calc.getDayOfSettlementReport(authorisationDay);
		int paymentEligibilityDay = calc.getDayOfPaymentEligibility(authorisationDay, pendingPeriod);
		int paymentInitiationDay = calc.getDayOfPaymentIntitiation(paymentEligibilityDay);
		String paymentInitiationDayName = namer.dayNamer(paymentInitiationDay);
		int daysBetweenAuthAndInitiation = (paymentInitiationDay-authorisationDay);
		System.out.println("Authorisation Day is " + authorisationDay + " and Settlement Report day is " + settlementDay + " and Payment Eligibility Day is " + paymentEligibilityDay + " and Payment Initiation Date is next " + paymentInitiationDayName + ", which is " + daysBetweenAuthAndInitiation + " days after authorisation");

		
	}

}



