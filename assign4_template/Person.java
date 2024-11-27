//Assign 4, Peron class.
//  Represent an applicant, or an employee

package assign4_template;

import java.util.ArrayList;
/* CIS 2168 Data Structures
 *  Section Number: 003
 *  Colden Jeanmonod tur26337@temple.edu
 *  Assignment Name: Assign 4
 *  Class Name: Person
 *  Initializes a person class that gets and sets their name degree and skilles
 *  Also has a toString to print out their skills.
 */
public class Person { //new applicants, current employees, past employees
    
    //Item 3. in Assign 4 Document.

    //define data fields: name, degree, skill list ("Java, C#, C++", etc.)
    //  skill list: must be array list or linked list
    private String Name;
    private String Degree;
    private ArrayList<String> Skills;
    

    //define the constructor with given name, degree, and skill list
    public Person() {
    	
    }
    
    public Person(String employeeName, String degreeType, ArrayList<String> allSkills) {
    	Name = employeeName;
    	Degree = degreeType;
    	Skills = allSkills;
    }
    //define getters
    
    public String getName() {
    	return this.Name;
    	
    }
    
    public String getDegree() {
    	return this.Degree;
    }
    
    public ArrayList<String> getSkills() {
    	
    	return this.Skills;
    }
    //define setters
    
    public void setName(String newName) {
    	this.Name = newName;
    }
    
    public void setDegree(String newDegree) {
    	this.Degree = newDegree;
    }
    
    public void setSkills(ArrayList<String> newSkills) {
    	this.Skills = newSkills;
    }
    //define toString()
    public String toString() {
    	
    	return "Name: " + this.getName() + ", Degree: " + this.getDegree() + ", Skills: "
    		+ this.getSkills();	
    }
    
    public static void main(String args[]) {
    	 
    	ArrayList<String> mySkills = new ArrayList<>();
    	mySkills.add("Java");
    	mySkills.add("c++");
    	mySkills.add("python");
    	Person hugh = new Person("Hugh", "Computer Science", mySkills);
    	
    	System.out.println(hugh.toString());
    	
    }
}

