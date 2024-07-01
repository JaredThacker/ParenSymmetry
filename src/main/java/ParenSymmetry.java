import java.util.Stack;

public class ParenSymmetry {


    private Boolean isBalanced(String s) {
        Stack Balance = new Stack();

        if(!s.contains("(") && !s.contains(")")) {
            return false;
        }

        for (char i : s.toCharArray()){
            switch(i){
                case '(':{
                    Balance.add(i);
                    break;
                }
                case ')':{
                    if (!Balance.isEmpty())
                    {
                        Balance.pop();
                    }else{
                        return false;
                    }
                    break;
                }
            }
        }
        return Balance.isEmpty();
    }

    private void checkFile(String filename) {
        // open file named filename

        // for each line in the file
            // read the line
            // print whether or not the line's parenthesis are balanced

        // CLOSE the file
    }

    public static void main(String[] args) {
        ParenSymmetry ps = new ParenSymmetry();

        Boolean b0 = ps.isBalanced("()");
        printResult(b0, true);

        String[] falseStrings = {"(", "((", ")", "", "(()())((())))"};
        Boolean falses = true;
        for (String strToTest : falseStrings) {
            falses = ps.isBalanced(strToTest);
        }
        printResult(falses, false);

        String[] trueStrings = {"()", "(())", "(((())))", "", "(()())((()))", "(   )", "( () ( ) )"};
        Boolean trues = false;
        for (String strToTest : trueStrings) {
            trues = ps.isBalanced(strToTest);
        }
        printResult(trues, true);

    }

    private static void printResult(Boolean b0, boolean b) {
        if (b0 == null) {
            System.out.println("Null Failure");
            return;
        }
        if (b0 == b) {
            System.out.println("Success");
        } else {
            System.out.println("Failure");
        }
    }
}
