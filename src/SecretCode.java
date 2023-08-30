import java.util.Scanner;
public class SecretCode {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        //Sentence 1
        System.out.println("Enter the First Secret Message");
        String wordOne = scan.nextLine();
        if(wordOne.contains("e")) {
            wordOne = wordOne.replace('e', 'x'); //1
        }
        else{
        }
        int length = wordOne.length();
        int firstIndex = wordOne.indexOf('r');
        int secondIndex = wordOne.indexOf('$');
        //2
       if(wordOne.contains("r")) {
           String word2 = wordOne.substring(0, firstIndex);
           String word3 = wordOne.substring(firstIndex + 1, length);
           wordOne = word2 + word3; //2
        }
       else{

        }
        //3
        length = wordOne.length();
        if(wordOne.contains("$")) {
            String word4 = wordOne.substring(0, secondIndex - 1);
            String word5 = wordOne.substring(secondIndex, length);
            wordOne = word4 + word5; //3
        }
        else{
        }
       //4
        if(wordOne.contains("0")){
            wordOne =   wordOne.replace("0", "o");
        }
        else{

        } //4
        //5
        char thirdIndex = wordOne.charAt(4);
        System.out.println(thirdIndex);
        length = wordOne.length();
        //wordOne = wordOne.substring(0, length3 + thirdIndex);
        wordOne = wordOne + thirdIndex;
        length = wordOne.length();
        System.out.println(wordOne);


        //Sentence 2
        System.out.println("Enter the Second Secret Message:");
        String wordTwo = scan.nextLine();
        System.out.println(wordTwo);
        int lengthTwo = wordTwo.length();
        if(wordTwo.contains(" ")) {
            String pieceOne = wordTwo.substring(0, ' ');
            String pieceTwo = wordTwo.substring(' ' + 1, lengthTwo);
            pieceTwo = pieceTwo.toLowerCase();
            wordTwo = pieceOne + pieceTwo;
        }
        else{

        }
        if
        lengthTwo = wordTwo.length();
        System.out.println(wordTwo);
        //Sentence 3
        //Sentence 4





    }


}
