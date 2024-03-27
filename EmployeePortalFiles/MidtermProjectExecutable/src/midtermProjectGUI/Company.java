package midtermProjectGUI;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import midtermProjectGUI.FileFinder.Finder;

public class Company {
	public Finder ff;
	public static ArrayList<Employee> list = new ArrayList<>();
	public static ArrayList<File> flist = new ArrayList<>();
	private String companyName;
	PrintWriter output;
	
	Company(String companyName){
		this.companyName = companyName;
	}
	
	public String getCompanyName() {
		return this.companyName;
	}
	
	public void companyFile() throws IOException {
		ff = new Finder("Documents");
		
		String[] args = new String[] {ff.Pathing(), "\\company.txt"};
		if (args.length != 2) {
			System. out.println("Usage: java Package textFile");
		}
		
		flist.add(new File(args[0]+args[1]));
	}
	
	public void addEmployees(File sourceFile) throws IOException, Exception{
		sourceFile = flist.get(0);
		
		try (Scanner input = new Scanner(sourceFile)) {
			String line = "";
			int lvl = 0;
			String[] name = new String[] {};
			String id = "";
			double money = 0.0;
			String[] tokens = new String[] {};
			
			if (sourceFile.exists()) { 
				while(input.hasNext()) {
					line = input.nextLine();
					tokens = line.split(",");
					
					if(tokens.length == 4) {
						if(isDouble(tokens[0])) {
							lvl = Integer.valueOf(tokens[0]);
						}//close if lvl set	
						else {
							System.out.println("[Error] Invalid Input: ["+tokens[0]+"]");
						}//close else
						
						name = tokens[1].split(" ");
							
						//id set
						if(isInteger(tokens[2])) {
							id = tokens[2];
						}
						else {
							System.out.println("[Error] Invalid Input: "+lvl+","+name+",["+tokens[1]+"]");
						}//close id set
								
						//money set
						if(isDouble(tokens[3])) {
							money = Double.valueOf(tokens[3]);
							list.add(new Employee(lvl, name, id, money));
						}
						else {
							System.out.println("[Error] Invalid Input: "+lvl+","+name+","+id+",["+tokens[2]+"]");
						}//close money set
					}//close if(h == 4)
					
					else {
						if(tokens.length < 4){
							System.out.println("[Error] Invalid Input: "+lvl+","+name+","+id+","+money+",[null]");
						}//close else if(h < 4)
						else {
							System.out.println("[Error] Invalid Input: ["+line+"]");
						}//close else
					}//close else
				}//close while
			}//close if
			
			if(list.size() > 0) {
				for(int i = 0; i < list.size(); i++) {
					if(i>0) {
						if(list.get(i).getName().equals(list.get(i-1).getName())) {
							if(list.get(i).getID() == list.get(i-1).getID()) {
								list.remove(i);
							}
						}
					}
				}//close for
			}//close if
		}//close try
		catch (Exception e) {
			e.printStackTrace();
		}
	}//close addAccounts
	
	public void addEmployee(int lvl, String[] name, String id, double salary){
		list.add(new Employee(lvl, name, id, salary));
	}
	
	public void removeEmployee(String id) throws IOException, Exception {
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getID() == id) {
				//return i
				list.remove(i);
			}
		}
		PrintWriter writer = new PrintWriter(flist.get(0));
		writer.print("");
		writer.close();
		
		for(int i = 0; i < list.size(); i++) {
			list.get(i).printAccount();
		}
	}
	
	public void newEmployeesFile() throws IOException, Exception {
		PrintWriter writer = new PrintWriter(flist.get(0));
		writer.print("");
		writer.close();
		
		for(int i = 0; i < list.size(); i++) {
			list.get(i).printAccount();
		}
	}
	
	public void printEmployeesToFile() throws IOException, Exception {
		list.get(list.size()-1).printAccount();
	}
	
	public void clearEmployees() throws FileNotFoundException, IOException, Exception {
		list.clear();
		PrintWriter writer = new PrintWriter(flist.get(0));
		writer.print("");
		writer.close();
	}
	
	public int getNumberOfEmployees() {
		return list.size();
	}
	
	public void displayEmployees() {
		System.out.println("\nNumber of employees: "+list.size()+"\n");
		System.out.println("Employee name         ID (5-digit number)         Annual salary");
		
		for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i).getName()+"              #"+list.get(i).getID()+"                       $"+list.get(i).getSalary());
              //System.out.println(employees[i]+"              #"+IDs[i]+"                       $"+Salarys[i]);
        }
	}//close displayEmployees
	
	public boolean isEmployeeID(String id) {
		boolean iD = false;
		
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getID().equals(id)) {
				//return i
				iD = true;
				return iD;
			}
		}
		return iD;
	}//close isEmployeeID
	
	public String printIsEmployeeID(String id) {
		String response = "ID not recognized";
		if(isEmployeeID(id)) {
			for(int i = 0; i < list.size(); i++) {
				if(list.get(i).getID().equals(id)) {
					//return i
					response = "\n "+list.get(i).printAccountString();
					return response;
					}
				}
			}
		return response;
		}//close printIsEmployeeID
	

	public boolean inSalaryRange(int salaryHigh, int salaryLow) { 
		boolean inRange = false;
		for(int i = 0; i < list.size(); i++) { 
			if(list.get(i).getSalary() <= salaryHigh && list.get(i).getSalary() >= salaryLow) {
				inRange = true;
			} 
		}
		return inRange;
	}//close inSalaryRange

	public String printInSalaryRange(int salaryHigh, int salaryLow) {
		String response = "";
		if(inSalaryRange(salaryHigh, salaryLow)) {
			for(int i = 0; i < list.size(); i++) {
					if(list.get(i).getSalary() <= salaryHigh && list.get(i).getSalary() >= salaryLow) {
						response += "\n "+list.get(i).printAccountString();
					}
				}
			}
		else {
			response = "\nNo employees in this salary range";
		}
		return response;
	}//close printIsEmployeeID
	
	public int numberInSalaryRange(int salaryHigh, int salaryLow) {
		int response = 0;
		if(inSalaryRange(salaryHigh, salaryLow)) {
			for(int i = 0; i < list.size(); i++) {
					if(list.get(i).getSalary() <= salaryHigh && list.get(i).getSalary() >= salaryLow) {
						response += 1;
					}
				}
			}
		else {
			response = 0;
		}
		return response;
	}//close printIsEmployeeID
	
	public void sortByFirstName() { //Sort employees by employee name (alphabetical order)
		Collections.sort(list,(p1,p2)->{return p1.Name[0].compareTo(p2.Name[0]);});  
	}//close sortByName
	
	public void sortByLastName() { //Sort employees by employee name (alphabetical order)
		Collections.sort(list,(p1,p2)->{return p1.Name[1].compareTo(p2.Name[1]);});  
	}//close sortByName
	
	public void sortByID() { //Sort employees by employee ID (ascending order)
			Collections.sort(list,(p1,p2)->{return p1.Id.compareTo(p2.Id);});
	}//close sortByID
	
	public void sortBySalary() { //Sort employees by employee ID (ascending order)
		Collections.sort(list,(p1,p2)->{return Double.compare(p1.Salary, p2.Salary);});
		
//		System.out.println("\nNumber of employees: "+list.size()+"\n");
//		System.out.println("Employee name         ID (5-digit number)         Annual salary");
//		
//		for(int i = list.size() - 1; i >= 0; i--) {
//                System.out.println(list.get(i).printAccountString());
//		}
	}//close sortByID
	
	public boolean isDouble(String obj) { 
		 try { 
		   Double.valueOf(obj); 
		 } 
		 catch (Exception ex){ // Not a valid double value 
		   return (false); 
		 } 
		 return (true); 
	}//close isDouble
	
	public boolean isInteger(String obj) { 
		 try { 
		   Integer.valueOf(obj); 
		 } 
		 catch (Exception ex){ // Not a valid integer value 
		   return (false); 
		 } 
		 return (true); 
	}//close isInteger
	
	public int getClearance(String id) {
		int lvl = 0;
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getID().equals(id)) {
				lvl = list.get(i).getClearance();
			}
		}
		return lvl;
	}
	
	public String getName(String id) {
		String[] name = new String[] {};
		String w = "";
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getID().equals(id)) {
				name = list.get(i).getName();
				w = name[0]+" "+name[1];
			}
		}
		return w;
	}
	
	public String getID(String id) {
		String Num = "";
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getID().equals(id)) {
				Num = list.get(i).getID();
			}
		}
		return Num;
	}
	
	public double getSalary(String id) {
		double money = 0;
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getID().equals(id)) {
				money = list.get(i).getSalary();
			}
		}
		return money;
	}
	
}

class Employee {
	public int Clearance;
	public String[] Name;
	public String Id;
	public double Salary;
	
	public ArrayList<File> file = new ArrayList<>();
	public FileFinder ff = new FileFinder();
	public File sourceFile;
	
	Employee(){}
	
	Employee(int clearance, String[] name, String id, double salary) {
		this.Clearance = clearance;
		this.Name = name;
		this.Id = id;
		this.Salary = salary;
	}
	
	public void setName(String[] name) {
		this.Name = name;
	}
	
	public void setID(String id) {
		this.Id = id;
	}
	
	public void setSalary(int salary) {
		this.Salary = salary;
	}
	
	public void setClearance(int clearance) {
		this.Clearance = clearance;
	}
	
	public int getClearance() {
		return Clearance;
	}
	
	public String[] getName() {
		return Name;
	}
	
	public String getID() {
		return Id;
	}
	
	public double getSalary() {
		return Salary;
	}
	
	public void companyFile() throws IOException {
		Finder ff = new Finder("Documents");
		
		String[] args = new String[] {ff.Pathing(), "\\company.txt"};
		if (args.length != 2) {
			System. out.println("Usage: java Package textFile");
		}
		
		sourceFile = new File(args[0]+args[1]);
		file.add(sourceFile);
	}
	
	public void printAccount() throws IOException, Exception{
		if (file.get(0).exists()) {			
			try(FileWriter fw = new FileWriter(file.get(0), true);BufferedWriter bw = new BufferedWriter(fw); PrintWriter out = new PrintWriter(bw)){
				out.println(getClearance()+","+getName()+","+getID()+","+getSalary());
			} 
			catch (IOException e) {
				    //exception handling left as an exercise for the reader
			}
		}
		else {
			file.get(0).createNewFile();
			
			try(FileWriter fw = new FileWriter(file.get(0), true);BufferedWriter bw = new BufferedWriter(fw); PrintWriter out = new PrintWriter(bw)){
				out.println(getClearance()+","+getName()+","+getID()+","+getSalary());
				   //more code
			} catch (IOException e) {
				   //exception handling left as an exercise for the reader
			}
		}
	}//close printAccount(PrintWriter)
	
	public String printAccountString(){
		String w = Name[0]+" "+Name[1];
		String printing = (getClearance()+", "+w+", #"+getID()+", $"+getSalary());	
        return printing;
	}//close printAccount
}