package hrs.utils;
import hrs.exceptions.*;
import hrs.service.Functional;
import java.util.Scanner;
import org.omg.IOP.CodecPackage.FormatMismatch;

public class Input {
    private static final Scanner sc = new Scanner(System.in);
    private static boolean fineInp;
    
    public static String Str(String message) {
        String res = null;
        fineInp = false;
        while (!fineInp) {
            fineInp = true;
            System.out.print("Enter " + message + ": ");
            try {
                res = sc.nextLine();
                if (res.isEmpty()) throw new EmptyStringException();
            }
            catch (EmptyStringException e) {
                System.out.println("Invalid input! Try again");
                fineInp = false;
            }
        }
        return res;
    }
    
    public static String Email() {
        System.out.println(
            "Email contains at least 4 characters and ends with @gmail.com");
        String email = null;
        fineInp = false;
        while (!fineInp) {
            fineInp = true;
            System.out.print("Enter your email: "); 
            try { 
                email = sc.nextLine();
                if (!email.matches("[\\d\\w+.-]{1,64}@gmail.com")) 
                    throw new FormatMismatch();
                else if (email.length() < 14) {
                    throw new ArrayIndexOutOfBoundsException();
                }
            }
            catch (FormatMismatch e) {
                System.out.println("Invalid email format! Try again");
                fineInp = false;
            }
            catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Email too short! Try again");
                fineInp = false;                
            }
        }
        return email;
    }       

    public static String Email(String customMess) {
        String email = null;
        fineInp = false;
        while (!fineInp) {
            fineInp = true;
            System.out.print("Enter " + customMess + ": "); 
            try { 
                email = sc.nextLine();
                if (!email.matches("[\\d\\w+.-]{1,64}@gmail.com")) 
                    throw new FormatMismatch();
                else if (email.length() < 14) {
                    throw new ArrayIndexOutOfBoundsException();
                }
            }
            catch (FormatMismatch e) {
                System.out.println("Invalid email format! Try again");
                fineInp = false;
            }
            catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Email too short! Try again");
                fineInp = false;                
            }
        }
        return email;
    }  
    
    public static String PhoneNum() {
        System.out.println("Phone number "
                     + "consists of 7 or 10 numbers");
        String phone = null;
        fineInp = false;
        while (!fineInp) {
            fineInp = true;
            System.out.print("Enter your phone number: "); 
            try {
                // we will try to capture all of these example cases:
                // 1462560072
                // +341.611.7118
                // 512.826.1191
                phone = sc.nextLine();
                if (!phone.matches(
                    "\\+?(\\d{3})?\\.?\\d{3}\\.?\\d{4}"))
                    throw new FormatMismatch();
            }
            catch (FormatMismatch e) {
                System.out.println("Invalid phone number! Try again");
                fineInp = false;
            }
        }
        return phone.replaceAll("\\.", "");
    }

    public static String PhoneNum(String customMess) {
        String phone = null;
        fineInp = false;
        while (!fineInp) {
            fineInp = true;
            System.out.print("Enter " + customMess + ": "); 
            try {
                // we will try to capture all of these example cases:
                // 1462560072
                // +341.611.7118
                // 512.826.1191
                phone = sc.nextLine();
                if (!phone.matches(
                    "\\+?(\\d{3})?\\.?\\d{3,4}\\.?\\d{4}"))
                    throw new FormatMismatch();
            }
            catch (FormatMismatch e) {
                System.out.println("Invalid phone number! Try again");
                fineInp = false;
            }
        }
        return phone.replaceAll("\\.", "");
    }
    
    public static String BirthDate() {
        String BirthDate = null;
        String BDformat = "\\d{1,2}/\\d{1,2}/\\d{4}";
        
        fineInp = false;
        while (!fineInp) {
            fineInp = true;
            System.out.print("Enter your birth date (DD/MM/YYYY): "); 
            try {
                BirthDate = sc.nextLine();
                if (!BirthDate.matches(BDformat) || !Check.isValidDate(BirthDate))
                    throw new FormatMismatch();
            }
            catch (FormatMismatch e) {
                System.out.println("Invalid date! Try again");
                fineInp = false;
            }
        }
        return BirthDate;       
    }
    
    public static String BirthDate(String customMess) {
        String BirthDate = null;
        String BDformat = "\\d{1,2}/\\d{1,2}/\\d{4}";
        
        fineInp = false;
        while (!fineInp) {
            fineInp = true;
            System.out.print("Enter " + customMess + ": "); 
            try {
                BirthDate = sc.nextLine();
                if (!BirthDate.matches(BDformat) || !Check.isValidDate(BirthDate))
                    throw new FormatMismatch();
            }
            catch (FormatMismatch e) {
                System.out.println("Invalid date! Try again");
                fineInp = false;
            }
        }
        return BirthDate;       
    }
    
    public static String SSN() { 
        String res = null;
        fineInp = false;
        while (!fineInp) {
            fineInp = true;
            System.out.print("Enter employee's SSN: ");
            try {
                res = sc.nextLine();
                if (res.isEmpty()) 
                    throw new EmptyStringException();
                else if (!Check.isUniqueSSN(res, Functional.getList()))
                    throw new InputDataOverlapped();
            }
            catch (EmptyStringException e) {
                System.out.println("Invalid input! Try again");
                fineInp = false;
            }
            catch (InputDataOverlapped i) {
                System.out.println("This SSN has existed! Try again");
                fineInp = false;
            }
        }
        return res;    
    }
    
    public static String SSN(String customMess) { 
        String res = null;
        fineInp = false;
        while (!fineInp) {
            fineInp = true;
            System.out.print("Enter " + customMess + ": ");
            try {
                res = sc.nextLine();
                if (res.isEmpty()) 
                    throw new EmptyStringException();
                else if (!Check.isUniqueSSN(res, Functional.getList()))
                    throw new InputDataOverlapped();
            }
            catch (EmptyStringException e) {
                System.out.println("Invalid input! Try again");
                fineInp = false;
            }
            catch (InputDataOverlapped i) {
                System.out.println("This SSN has existed! Try again");
                fineInp = false;
            }
        }
        return res;    
    }
    // illegalarguement contains numberformatexception
    public static int Int(String message) {
        int res = Integer.MAX_VALUE;
        fineInp = false;
        while (!fineInp) {
            fineInp = true;
            System.out.print("Enter " + message + ": ");
            try { 
                res = Integer.parseInt(sc.nextLine());
                if (res < 0) throw new IllegalArgumentException();
            }
            catch (IllegalArgumentException e) {
                System.out.println("Invalid input! Try again");
                fineInp = false;
            }
        }
        return res;        
    }
    
    public static int Int(String message, int lowerEnd, int upperEnd) {
        int res = Integer.MAX_VALUE;
        fineInp = false;
        while (!fineInp) {
            fineInp = true;
            System.out.print("Enter " + message + ": ");
            try { 
                res = Integer.parseInt(sc.nextLine());
                if (res < lowerEnd || res > upperEnd) 
                    throw new IllegalArgumentException();
            }
            catch (IllegalArgumentException e) {
                System.out.println("Invalid input! Try again");
                fineInp = false;
            }
        }
        return res;        
    }
    
    public static short Shrt(String message) {
        short res = Short.MAX_VALUE;
        fineInp = false;
        while (!fineInp) {
            fineInp = true;
            System.out.print("Enter " + message + ": ");
            try { 
                res = Short.parseShort(sc.nextLine());
                if (res < 0) throw new IllegalArgumentException();
            }
            catch (IllegalArgumentException e) {
                System.out.println("Invalid input! Try again");
                fineInp = false;
            }
        }
        return res;   
    }
    
    public static short Shrt(short lowerEnd, short upperEnd) {
        short res = Short.MAX_VALUE;
        fineInp = false;
        while (!fineInp) {
            fineInp = true;
            System.out.print("Enter your choice "
                    + "(between " + lowerEnd + "-" + upperEnd + "): ");
            try { 
                res = Short.parseShort(sc.nextLine());
                if (res < lowerEnd || res > upperEnd) 
                    throw new IllegalArgumentException();
            }
            catch (IllegalArgumentException e) {
                System.out.println("Invalid input! Try again");
                fineInp = false;
            }
        }
        return res;
    }
    
    public static short Shrt(String message, short lowerEnd, short upperEnd) {
        short res = Short.MAX_VALUE;
        fineInp = false;
        while (!fineInp) {
            fineInp = true;
            System.out.print("Enter " + message 
                    + "(between " + lowerEnd + "-" + upperEnd + "): ");
            try { 
                res = Short.parseShort(sc.nextLine());
                if (res < lowerEnd || res > upperEnd) 
                    throw new IllegalArgumentException();
            }
            catch (IllegalArgumentException e) {
                System.out.println("Invalid input! Try again");
                fineInp = false;
            }
        }
        return res;
    }
    
    public static double Doub(String message) {
        double res = Double.MAX_VALUE;
        fineInp = false;
        while (!fineInp) {
            fineInp = true;
            System.out.print("Enter " + message + ": ");
            try { 
                res = Double.parseDouble(sc.nextLine());
                if (res < 0) throw new IllegalArgumentException();
            }
            catch (IllegalArgumentException e) {
                System.out.println("Invalid input! Try again");
                fineInp = false;
            }
        }
        return res;   
    }
    
    public static double Doub(int lowerEnd, int upperEnd) {
        double res = Double.MAX_VALUE;
        fineInp = false;
        while (!fineInp) {
            fineInp = true;
            System.out.print("Enter your choice "
                    + "(between " + lowerEnd + "-" + upperEnd + "): ");
            try { 
                res = Double.parseDouble(sc.nextLine());
                if (res < lowerEnd || res > upperEnd) 
                    throw new IllegalArgumentException();
            }
            catch (IllegalArgumentException e) {
                System.out.println("Invalid input! Try again");
                fineInp = false;
            }
        }
        return res;   
    }
}
