package wordle;

import java.util.*;

    public class Word {

 

    private static final int MAX_ATTEMPTS = 6;

    private static final String[] WORDS = { "spear", "spare", "pares", "pears", "parse"};

 

     

 

    public String computerWord;

    private int attempts;

    private Scanner input;

private String userWord;


 

     

 

    public Word() {

        this.input = new Scanner(System.in);

    }

 

     

 

    public String generateWord() {

 

        Random random = new Random();

        computerWord = WORDS[random.nextInt(5)];

        attempts = 0;

       return computerWord;

    }

 

     

 

    private void feedbackFromUser(String computerWord) {

        StringBuilder feedback = new StringBuilder();

 

        for(int i = 0; i < computerWord.length(); i++) {

 

            char secretCharacter = computerWord.charAt(i);

            char guessCharacter = userWord.charAt(i);

 

            if(secretCharacter == guessCharacter) {

                feedback.append("\u001B[32m").append(secretCharacter).append("\u001B[0m");

            }

 

            else if(computerWord.contains(String.valueOf(guessCharacter))) {

                feedback.append("\u001B[33m#").append("\u001B[0m");}

            else {

                feedback.append(" - ");

            }

        }

        System.out.println("Feedback is " + feedback);

 

    }

 

     

 

    public void startGame() {

         userWord = input.nextLine();

        for(int i=0;i< 6;i++)


                {

            String s = generateWord();


            if(userWord.equalsIgnoreCase(s))

                    {

                System.out.println("Congratulations : " + userWord);

                break;

            } else {

                attempts++;

                int chances = MAX_ATTEMPTS - attempts;

 

                if(chances > 0) {

                    feedbackFromUser(s);    

                }

 

                else {

                    System.out.println("Game over. The correct Word is : " + userWord);

                }

            }

 

        }

    }
 } 