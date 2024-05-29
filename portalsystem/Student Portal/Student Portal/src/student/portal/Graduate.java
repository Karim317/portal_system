
package student.portal;

import java.util.Scanner;
public class Graduate  extends Person  implements User {
    String FullName,Mobile,Email,Gpa;
    Scanner sc=new Scanner(System.in);
    public Graduate(String id) {
        super(id);
    }

    @Override
    public String getId() {
        return super.ID;
    }

    @Override
    public void displayOptions() {
        System.out.println(" كارنية النقابة .1");
        
    }

    @Override
    public void handleOption(int option) {
        if (option == 1) {
            viewResearchMaterials();
        } else {
            System.out.println("Invalid option!");
        }
    }

    private void viewResearchMaterials() {
                          
        System.out.println("enter your full name");
        FullName= sc.nextLine();
        System.out.println("enter your Mobile Number");
        Mobile= sc.nextLine();
        System.out.println("enter your Email");
        Email= sc.nextLine();
        System.out.println("enter your Gpa");
        Gpa= sc.nextLine();
        System.out.println("برجاء دفع رسوم استخراج كارنيه النقابة  "+" جنية 999.9 ");
        System.out.println("طلبك قيد التنفيذ, برجاء الانتظار يومين");
    }

    public static Graduate fromString(String line) {
        String[] parts = line.split(",");
        return new Graduate(parts[0]);
    }

    @Override
    public String toString() {
        return super.ID;
    }
    
}