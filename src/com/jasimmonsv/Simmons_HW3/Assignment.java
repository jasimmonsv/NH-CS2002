package com.jasimmonsv.Simmons_HW3;
import java.util.Date;

public class Assignment {

	protected String desc;
	protected Date assignedDate;
	protected Date dueDate;

	/**
	 * @param args
	 */
	public Assignment(String idesc, Date iassignedDate, Date idueDate) {
		desc = idesc;
		assignedDate = iassignedDate;
		dueDate = idueDate;
	}// end constructor

	public String print() {
		return (desc + "\nAssigned: " +assignedDate.toString() + "\nDue: "+dueDate.toString());
	}

	public void setDesc(String idesc){
		desc = idesc;
		return;
	}
}// end class Assignment
