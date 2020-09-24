import java.util.Scanner;

public class Caesar {
    public static String encryptCaesar(String message) {
        String end ="";
        for( int i = 0 ; i< message.length(); i++){
            if (message.charAt(i)> 64 && message.charAt(i)< 91){
                int a = ((message.charAt(i)-62)%26) +65;
                end = end + (char)(a);
            }else if (message.charAt(i)> 96 && message.charAt(i)< 123){
                int a = ((message.charAt(i)-94)%26) +97;
                end = end + (char)(a);
            } else{
                end = end + message.charAt(i);
            }  
        }
        return end;
    }   

    public static String decryptCaesar(String message) {
        String end ="";
        for( int i = 0 ; i< message.length(); i++){
            if (message.charAt(i)> 64 && message.charAt(i)< 91){
                int a = ((message.charAt(i)-42)%26) +65;
                end = end + (char)(a);
            }else if (message.charAt(i)> 96 && message.charAt(i)< 123){
                int a = ((message.charAt(i)-48)%26) +97;
                end = end + (char)(a);
            } else{
                end = end + message.charAt(i);
            }  
        }
        return end;
    }

    public static String encryptCaesarKey(String message, int key) {
        String end ="";
        for( int i = 0 ; i< message.length(); i++){
            if (message.charAt(i)> 64 && message.charAt(i)< 91){
                int a = ((message.charAt(i)+ key-65)%26) +65;
                end = end + (char)(a);
            }else if (message.charAt(i)> 96 && message.charAt(i)< 123){
                int a = ((message.charAt(i)+key-97)%26) +97;
                end = end + (char)(a);
            } else{
                end = end + message.charAt(i);
            }  
        }
        return end;
    }

    public static String decryptCaesarKey(String message, int key) {
        String end ="";
        for( int i = 0 ; i< message.length(); i++){
            if (message.charAt(i)> 64 && message.charAt(i)< 91){
                int a = (((message.charAt(i)-key)+195)%26) +65;
                end = end + (char)(a);
            }else if (message.charAt(i)> 96 && message.charAt(i)< 123){
                int a = (((message.charAt(i)-key)+163)%26)+97;
                end = end + (char)(a);
            } else{
                end = end + message.charAt(i);
            }  
        }
        return end;
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Would you like to \"encrypt\" or \"decrypt\" a message?");
        String command = scan.nextLine().trim().toLowerCase();

        if (command.equals("encrypt")) {
            System.out.println("Please enter your message to be encrypted: ");
            String message = scan.nextLine();
            System.out.println("Here is your encrypted message: ");
            System.out.println(encryptCaesar(message));
        }
        else if (command.equals("decrypt")) {
            System.out.println("Please enter your message to be decrypted: ");
            String message = scan.nextLine();
            System.out.println("Here is your decrypted message: ");
            System.out.println(decryptCaesar(message));
        }
        else {
            System.out.println("Unknown command; please type either \"encrypt\" or \"decrypt\"");
        }

        scan.close();
    }
}
