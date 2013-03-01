package com.its.domain;

public abstract class ApplicationConstants 
{

	// If this constant is set to true, it will generate new invoce for each txn,
	// if set to false, this will keep the invoice open till payment is made,
	// and keep adding txns to currently open invoice.
	public static final Boolean GENERATE_INVOICE_ON_EACH_TXN = true;
	
	public static boolean generateInvoiceOnEachTransaction()
	{
		return GENERATE_INVOICE_ON_EACH_TXN;
	}
	
}
