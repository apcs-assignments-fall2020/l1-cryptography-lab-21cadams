import java.util.Scanner;

public class Vigenere {
    public static String encryptVigenere(String message, String key) {
        String end ="";
        String key2 = key.toUpperCase();
        int key_len= key.length();
        int c =0;
        for( int i = 0 ; i< message.length(); i++){
            if (message.charAt(i)> 64 && message.charAt(i)< 91){
                int a = ((message.charAt(i)+ (key2.charAt(c)-65)-65)%26) +65;
                end = end + (char)(a);
                c = (c+1) % key_len;
            }else if (message.charAt(i)> 96 && message.charAt(i)< 123){
                int a = ((message.charAt(i) + (key2.charAt(c)-65)-97)%26) +97;
                end = end + (char)(a);
                c = (c+1) % key_len;
            } else{
                end = end + message.charAt(i);
            }  
        }
        return end;
    }

    public static String decryptVigenere(String message, String key) {
        String end ="";
        String key2 = key.toUpperCase();
        int key_len= key.length();
        int c =0;
        for( int i = 0 ; i< message.length(); i++){
            if (message.charAt(i)> 64 && message.charAt(i)< 91){
                int a = ((message.charAt(i)- (key2.charAt(c)+65)+195)%26) +65;
                end = end + (char)(a);
                c = (c+1) % key_len;
            }else if (message.charAt(i)> 96 && message.charAt(i)< 123){
                int a = ((message.charAt(i) - (key2.charAt(c)-65)+163)%26) +97;
                end = end + (char)(a);
                c = (c+1) % key_len;
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
            System.out.println("Please enter the key for your message: ");
            String key = scan.nextLine().trim().toUpperCase();
            System.out.println("Here is your encrypted message: ");
            System.out.println(encryptVigenere(message, key));
        }
        else if (command.equals("decrypt")) {
            System.out.println("Please enter your message to be decrypted: ");
            String message = scan.nextLine();
            System.out.println("Please enter the key for your message: ");
            String key = scan.nextLine().trim().toUpperCase();
            System.out.println("Here is your decrypted message: ");
            System.out.println(decryptVigenere(message, key));
        }
        else {
            System.out.println("Unknown command; please type either \"encrypt\" or \"decrypt\"");
        }

        scan.close();
    }
}
