//Assign 4, HiringApp
package assign4_template;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Deque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
/* CIS 2168 Data Structures
 *  Section Number: 003
 *  Colden Jeanmonod tur26337@temple.edu
 *  Assignment Name: Assign 4
 *  Class Name: HiringApp
 *  Runs through a menu of predetermined functions and then reacts
 *  based on the user choice whteher to hire or fire or to add an applicant.
 */
public class HiringApp {

    public static void main(String[] args) {

        //Define the data structures for 3 different groups of people:
        //  new applicants
        //  current employees (those who were hired), 
        //  past employees (those who were fired)
        //
        //Hint: for queue: Queue<Person>,  ArrayDeque, LinkedList
        //      for stack: Deque<Person>   ArrayDeque, LinkedList
        Queue<Person> applicants = new ArrayDeque<>();
        ArrayDeque<Person> curEmployees = new ArrayDeque<>();
        ArrayDeque<Person> oldEmployees = new ArrayDeque<>();
        
        
        int stopCondition =0;
        //display the menu
        
        //get the menu choice
        
        //A do while to at least run through the menu at least once
        do {
        	displayMenu();
        	
        	//if statement in case one of the Deques is empty
        	if(curEmployees.isEmpty()) {
        		System.out.println("Memo to supervisor: No one to fire currently");
        	}
        	else if(applicants.isEmpty() && oldEmployees.isEmpty()) {
        		System.out.println("No one to hire currently");
        		
        	}
        	
        	int hrChoice = getChoice();
        //process user selected service request.
        	
        	//if statement to check what the user input is
        	if(hrChoice == 1) {
        		Person potential = getApplication();
        		applicants.add(potential);
        	}
        	else if(hrChoice == 2) {
        		hireEmployees(oldEmployees, applicants, curEmployees);
        	}
        	else if(hrChoice == 3) {
        		fireEmployee(curEmployees);
        	}
        	else if (hrChoice == 4) {
        		System.out.println("Exiting");
        		stopCondition = 1;
        	}
        //loop until the user decides to quit.
        }while(stopCondition == 0);
    }

    //other methods for code modularization
    //method for getting user choice
    public static int getChoice() {
        Scanner userChoice = new Scanner(System.in);
        int finalChoice = 0;
        //display the menu 
        //get user choice
        //return user choice as an integer
        System.out.print("Please enter a number for your choice");
        finalChoice = userChoice.nextInt();
        //while loop to loop through when the userchoice doesnt match up to predetermined choices
        while(finalChoice != 1 && finalChoice != 2 && finalChoice != 3) {
        	System.out.println("Please enter a valid number: ");
        	finalChoice = userChoice.nextInt();
        }
        return finalChoice;
    }

    //method for accepting an applicant and reurn this applicant as a Person object
    public static Person getApplication() {
        //display prompt for user to enter an applicant's name
        //get user input
        Scanner applicant = new Scanner(System.in);
        
        System.out.println("Please enter applicant name");
        String applicantName = applicant.nextLine();
        //display prompt for user to enter an applicant's degree
        //get user input
        System.out.println("What is their degree?");
        String applicantDegree = applicant.nextLine();
        
        //display prompt for user to enter an applicant's skill list
        //  (first how many skills, then enter skill one by one)
        //use a loop to get each skill
        System.out.println("How many skills do they have, please enter a numerical value");
        int amountSkills = applicant.nextInt();
        ArrayList<String> skills = new ArrayList<>();
        applicant.nextLine();
        
        //for loop to get the correct amount of skills
        for(int i = 0; i < amountSkills; i++) {
        	System.out.print("What is skill " + (i+1));
        	skills.add(applicant.nextLine());
        }
        //create a Person object using the name, degree, skill list
        //and return this Person object
        Person finalApplicant = new Person(applicantName, applicantDegree, skills);
        return finalApplicant;
    }
    
    public static void displayMenu() {
    	System.out.println("What would you like to do?");
        System.out.println("1 to accept an application");
        System.out.println("2 to hire an employee");
        System.out.println("3 to fire an employee");
        System.out.println("4 to quit");
    }
    
    public static void fireEmployee(Deque<Person> currentEmployees) {
    	//if statement for if there are no current employees
    	if (currentEmployees.isEmpty()) {
    	        System.out.println("Deque is empty, no current employees");
    	       
    	    }

    	 Person firedEmployee = currentEmployees.poll();
        oldEmployees.push(firedEmployee);
    	 System.out.println("Fired employee: " + firedEmployee);
    	   
    }
    
    public static void hireEmployees(Deque<Person> oldEmployees, Queue<Person> applicants, Deque<Person> currentEmployees) {
    	//if statement to check if there are no old employees, if so it goes to the applicants
    	if(oldEmployees.isEmpty()) {
    		System.out.println("Hired: " + applicants.peek().toString());
    		currentEmployees.push(applicants.poll());
    		
    	}
    	else {
    		System.out.println("Hired: " + oldEmployees.peek().toString());
    		currentEmployees.push(oldEmployees.poll());
    		
    	}
    }

    //You can either implement hire and fire functionalities in main(...),
    //   or implement them here as separate methods:
    //hire method
    //fire method
}
