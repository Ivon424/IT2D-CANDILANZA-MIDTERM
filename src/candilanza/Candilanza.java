
package candilanza;

import java.util.Scanner;
public class Candilanza {

    public static void main(String[] args) {
      
         
        Scanner sc = new Scanner (System.in);
        String response;
        do{
        System.out.println("Welcome to Project:");
        System.out.println("1. ADD");
        System.out.println("2. VIEW");
        System.out.println("3. UPDATE");
        System.out.println("4. DELETE");
        System.out.println("5. EXIT");
        
        System.out.print("Enter Action: ");
        int action =  sc.nextInt();
       Candilanza Candilanza = new Candilanza(); 
        switch(action){
            case 1:
            Candilanza.addproject();    
            break;
            case 2:
             Candilanza.viewproject();
            break;
            case 3:Candilanza.viewproject();
                   Candilanza.updateproject();
                   break;
              case 4:
             Candilanza.viewproject();
             Candilanza.deleteproject();
             Candilanza.viewproject();
              break;
        }
            System.out.println("Do you want to continue? (yes/no): ");
            response = sc.next();  
            
        }while(response.equalsIgnoreCase("yes"));
        System.out.println("Thank you!"); 
    }



    public void addproject(){
        Scanner sc = new Scanner(System.in);
        config conf = new config();
        
        System.out.print(" Project ID: ");
        String pid = sc.next();
        System.out.print("Project Title: ");
        String ptitle =sc.next();
        System.out.print("Project Description: ");
        String pdesc = sc.next();
        System.out.print("Submission Date:");
        String  sdate = sc.next();
        System.out.print("Grade:");
        String pgrade = sc.next();
       
      
       
        String sql = "INSERT INTO tbl_project (p_id,p_title,p_desc,s_date,p_grade) VALUES (?,?,?,? ,?)";
       
        conf.addRecord(sql, pid ,ptitle ,pdesc,sdate,pgrade);


    }
    
    private void viewproject() {
      
      
        String qry = "SELECT * FROM tbl_project"; 
        String[] hdrs = {"pid","ptitle", "pdesc ","sdate", " pgrade"};
        String[] clmns = {"p_id","p_title","p_desc","s_date","p_grade"};
                

     config conf = new config();
     conf.viewRecords(qry,hdrs,clmns);
     
    }
    
    private void updateproject(){
    
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter the ID to Update: ");
        int npid = sc.nextInt();
        
        System.out.print("Enter new Project Title: ");
        String nptitle = sc.next();
        System.out.print("Enter new Project Description  : ");
        String npdesc = sc.next();
        System.out.print("Enter new Submission Date : ");
        String nsdate = sc.next();
        System.out.print("Enter new  Grade: ");
        String npgrade = sc.next();
       
        String qry = "UPDATE tbl_project SET p_title = ?,p_desc = ?, s_date = ?,p_grade  WHERE p_id = ?";
        
        config conf = new config();
        conf.updateRecord(qry, nptitle,npdesc,nsdate,npgrade, npid);
    }

    
 private void deleteproject(){
        
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter the ID to Delete: ");
        int id = sc.nextInt();
        
        String qry = "DELETE FROM tbl_project WHERE p_id = ?";
        
        config conf = new config();
        conf.deleteRecord(qry, id);
        
 }

   

   
    
    
}
