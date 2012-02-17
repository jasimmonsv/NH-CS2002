package com.jasimmonsv.Simmons_HW3;
import java.util.ArrayList;
import java.util.Date;

public class AssignmentList {
	// Declarations
	private ArrayList<Assignment> curAssignments;

	public AssignmentList() {
		curAssignments = new ArrayList<Assignment>();
	}// end default constructor

	public void add(Assignment e) {
		for (int i = 0; i < curAssignments.size(); i++){//Test uniqueness of desc
			if(e.desc.equalsIgnoreCase(curAssignments.get(i).desc))
			{
				e.setDesc(e.desc+"~"+i);
			}//end if
		}//end for loop
		if (curAssignments.size()==0){curAssignments.add(e);return;}
		for (int i = 0; i < curAssignments.size(); i ++)
		{
			if (e.assignedDate.before(curAssignments.get(i).assignedDate)){
				curAssignments.add(i,e);
				return;
			}//end if
		}//end for
		curAssignments.add(e);
		return;
	}// end add method

	public Assignment get(int index) {
		if (index < 0 || index >= curAssignments.size()) {
			throw new ArrayIndexOutOfBoundsException(index);
		}
		return curAssignments.get(index);
	}// end get method

	public void remove(int x) {
		curAssignments.remove(x);
		return;
	}// end remove method

	public void print() {
		for (int i = 0; i < curAssignments.size(); i++) {
			System.out.println(curAssignments.get(i).print());
		}// end for loop
	}// end print method

	public int earliestDue() {
		Date dueDate = curAssignments.get(0).dueDate;
		int targetRec = 0;
		for (int i = 1; i < curAssignments.size(); i++) {
			if (dueDate.after(curAssignments.get(i).dueDate)) {
				dueDate = curAssignments.get(i).dueDate;
				targetRec = i;
			}// end if
		}// end for loop
		return targetRec;
	}// end earliest Due method

	public int size(){
		return curAssignments.size();
	}//end size method
	

}// end class AssignmentList
