package com.jasimmonsv.Simmons_HW4;

public class StudentList {
	private SingleLinkedList<Student> stuList = new SingleLinkedList<Student>();
	
	/**adds a student record to the list
	 * @param stu Student record
	 */
	public void add(Student stu){
		if (stuList.size == 0){
			stuList.addFirst(stu);
			}//end if
		else{
			stuList.add(stu);
			}
	}//end method add
	
	/**
	 * Gets the student name at index
	 * @param index Where the student is in the list
	 * @return String of student name
	 */
	public String getStu(int index){
		return (stuList.get(index).toString());
	}//end method getStu
	
	public void add(int index, Student stu){
		if (stuList.size == 0){
			stuList.addFirst(stu);
			}//end if
		else{
			stuList.add(index, stu);
			}
	}//end method add
	/**removes a student record from the beginning of the list
	 * @param stu Student record
	 */
	public void removeBeg(){
		stuList.removeFirst();
	}//end method removeBeg
	
	/**removes a student record by name
	 * @param stuName Student name
	 */
	public boolean removeName(String stuName){
		for (int i = 0; i< stuList.size;i++){
			if(stuList.get(i).toString().equalsIgnoreCase(stuName)){
				stuList.removeAfter(stuList.getNode(i-1));
			}
		}
		return false;
		//stuList.removeAfter();
	}//end method removeName
	
	/**
	 * prints text of Student List
	 */
	public void printList(){
		System.out.println(stuList.toString());
	}//end method printList
}//end class RegList
