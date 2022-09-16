import java.util.Random;
import java.util.Scanner;

public class MyRockPaperScissors {

    public static void main(String[] args) {
        boolean continueRpsGame = false;
        
        do {    
            System.out.println("How many rounds would you like to play? ");
            
            String numberOfRoundsToPlay;
            int rounds;
            Scanner input = new Scanner(System.in);

            rounds = Integer.parseInt(input.nextLine());

            while(rounds < 1 || rounds > 10){
                System.out.println("Please input an integer between 1 and 10.");

                rounds = Integer.parseInt(input.nextLine());
            }

            int userChoice;
            Random random = new Random();
            
            int ties = 0;
            int computerWinRecords = 0;
            int userWinRecords = 0;

            for (int i = 0; i < rounds; i++){
                System.out.println("Select an option: 1 = Rock, 2 = Paper, 3 = Scissors");
                userChoice = Integer.parseInt(input.nextLine());
                while (userChoice != 1 && userChoice != 2 && userChoice != 3){
                    System.out.println("Not a valid option. Select an option: 1 = Rock, 2 = Paper, 3 = Scissors");
                    userChoice = Integer.parseInt(input.nextLine());
                }
                
                System.out.println("========================\nRound " + (i+1) + ":");
                int computerChoice = random.nextInt(3) + 1;
                

                if (userChoice == computerChoice){
                    switch(computerChoice) {
                        case 1:
                            System.out.println("User also chose Rock! It's a tie!\n========================");
                            break;
                        case 2:
                            System.out.println("User also chose Paper! It's a tie!\n========================");
                            break;
                        case 3:
                            System.out.println("User also chose Scissors! It's a tie!\n========================");
                            break;           
                    }
                    ties++;
                } else {

                    switch(userChoice){
                        case 1:
                            switch(computerChoice) {
                                case 2:
                                    System.out.println("Computer chose Paper! Paper wraps Rock; Computer wins!\n========================");
                                    computerWinRecords++;
                                    break;
                                case 3:
                                    System.out.println("User chose Scissors! Rock breaks Scissors; User win!\n========================");
                                    userWinRecords++;
                                    break;
                            }
                            break;
                        case 2:
                            switch(computerChoice) {
                                case 1:
                                    System.out.println("I chose Rock! Paper wraps Rock; User win!\n========================");
                                    userWinRecords++;
                                    break;
                                case 3:
                                    System.out.println("I chose Scissors! Scissor cuts Paper; User lose!\n========================");
                                    computerWinRecords++;
                                    break;
                            }
                            break;
                        case 3:
                            switch(computerChoice) {
                                case 1:
                                    System.out.println("I chose Rock! Rock breaks Scissors; User lose!\n========================");
                                    computerWinRecords++;
                                    break;
                                case 2:
                                    System.out.println("I chose Paper! Scissor cuts Paper; User win!\n========================");
                                    userWinRecords++;
                                    break;
                            } 
                            break;
                    }
                }    
            }

            System.out.println("\nI won " + computerWinRecords + " times, you won " + userWinRecords + " times, and we tied " + ties + " times!");
            if (computerWinRecords > userWinRecords){
                System.out.println("I won overall this time!");
            } else if (userWinRecords > computerWinRecords){
                System.out.println("You won overall this time!");
            } else {
                System.out.println("It seems we tied overall!");
            }
            
            System.out.println("\nDo you want to keep playing? Enter yes to keep playing or No to stop.");
            numberOfRoundsToPlay = input.nextLine();

            while (!numberOfRoundsToPlay.equals("Yes") && !numberOfRoundsToPlay.equals("No")){
                System.out.println("Please enter Yes to keep playing or No to stop.");
                numberOfRoundsToPlay = input.nextLine();  
            } 
            
            if (numberOfRoundsToPlay.equals("Yes")){
                continueRpsGame = true;
            } else {
                continueRpsGame = false;
                System.out.println("\nThanks for playing!");
            }
            
        } while (continueRpsGame);      
        
        
    }
}