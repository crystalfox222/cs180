import java.util.Scanner;
public class SecretCode  {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //Sentence 1
        System.out.println("Enter the First Secret Message: ");
        String wordOne = scan.nextLine();
        String input1 = wordOne;
         if (wordOne.contains("x"))  {
             wordOne = wordOne.replace('x', 'e'); //1
         }
         else {
         }
         int length = wordOne.length();
        //2
        if (wordOne.contains("r"))  {
            int firstIndex = wordOne.indexOf('r');
            String word2 = wordOne.substring(0, firstIndex);
            String word3 = wordOne.substring(firstIndex + 1, length);
            wordOne = word2 + word3; //2
         }
        else {

         }
        //3
        length = wordOne.length();
         if (wordOne.contains("$"))  {
             length = wordOne.length();
             int secondIndex = wordOne.indexOf('$');
             String word4 = wordOne.substring(0, secondIndex);
             String word5 = wordOne.substring(secondIndex + 1, length);
             wordOne = word4 + word5; //3
         }
          else  {
          }
       //4
          if  (wordOne.contains("0"))  {
              wordOne =   wordOne.replace("0", "o");
         }
          else  {
          }  //4
        //5
        char thirdIndex = wordOne.charAt(4);
        length = wordOne.length();
        //wordOne = wordOne.substring(0, length3 + thirdIndex);
        wordOne = wordOne + thirdIndex;
        length = wordOne.length();



        //Sentence 2
        System.out.println("Enter the Second Secret Message: ");
        String wordTwo = scan.nextLine();
        String input2= wordTwo;
        int lengthTwo = wordTwo.length();
         if (wordTwo.contains(" "))  {
             int space = wordTwo.indexOf(" ");
             String pieceOne = wordTwo.substring(0, space);
             String pieceTwo = wordTwo.substring(space, lengthTwo);
             pieceTwo = pieceTwo.toLowerCase();
             wordTwo = pieceOne + pieceTwo;
         }
         else  {
        lengthTwo = wordTwo.length();
         }  // 1
         if (lengthTwo > 4)  {
             lengthTwo = wordTwo.length();
             String newWord = wordTwo.substring(3, lengthTwo);
             lengthTwo = wordTwo.length();
             wordTwo = newWord;
             lengthTwo = wordTwo.length();
         } else {

        } //3
        int last = wordTwo.lastIndexOf(' ');
         if (wordTwo.contains(" ")) {
             String sub = wordTwo.substring(0, last);
             String string = wordTwo.substring(last +1, lengthTwo);
             wordTwo = sub+string;
         } else {

         }
        lengthTwo = wordTwo.length();

         if (wordTwo.contains("z"))  {
             wordTwo = wordTwo.replace('z', 'm'); //1
         }
         else {
         }//4
         if (wordTwo.contains("w"))  {
             wordTwo = wordTwo.replace("w", " ");//1
         }
         else {
         }//5
         if (wordTwo.contains("a"))  {
             int indexFour = wordTwo.indexOf('a');
             String g = "g";
             String piece3 = wordTwo.substring(0, indexFour);
             String piece4 = wordTwo.substring(indexFour + 1, lengthTwo);
             piece4 = g + piece4;
             wordTwo = piece3  + piece4; //2
         }
        else {

         } //6

        //Sentence 3
        System.out.println("Enter the Third Secret Message: ");
        String wordThree = scan.nextLine();
        String input3 = wordThree;
        wordThree = wordThree.trim();//1
         if (wordThree.contains("asdf")) {
             String secondChar = wordThree.substring(1,2);
             wordThree = wordThree.replace("asdf", secondChar);
        }//2
         else {

         }
        int lengthThree = wordThree.length();
         if  (lengthThree > 8) {
             String echa = wordThree.substring(0, 9);
             String echo = wordThree.substring(9, lengthThree);
             String lastwordThree = echo + echa;
             wordThree = lastwordThree;
         }
         else {
         } //3

        //Sentence 4
        System.out.println("Enter the Fourth Secret Message: ");
        String wordFour = scan.nextLine();
        String input4 = wordFour;
        int lengthFour = wordFour.length();
         if (lengthFour > 30 )  {
             String index1 = wordFour.substring(0, 1);
             String index2 = wordFour.substring(10, 15);
             String index3 = wordFour.substring(20, 25);
             String index4 = wordFour.substring(30, 35);
             wordFour = index1 + index2 + index3 + index4 + "!";
         } else {

        }


        //final
        String finale = wordOne + wordTwo + wordThree + wordFour;
        System.out.println("Final Message: " + finale);
     }


 }
