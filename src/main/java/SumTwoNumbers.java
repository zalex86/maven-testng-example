import javax.naming.SizeLimitExceededException;
import java.util.HashSet;
import java.util.Set;

public class SumTwoNumbers {
    String[] sArgs;
    Set<Integer> iArgs;

    public SumTwoNumbers(String[] args) {
        sArgs = args;
    }

    /**
     * Проверяем, что в класс передано строго два аргумента
     *
     * @throws Exception
     */
    private void verifyNumberOfArguments() throws Exception {
        String errorMsg = "";
        boolean result = false;
        switch (sArgs.length) {
            case 0:
            case 1:
                errorMsg = "Not enough arguments. Exactly TWO numbers should be specified";
                break;
            case 2:
                result = true;
                break;
            default:
                errorMsg = "Too many arguments! Exactly TWO numbers should be specified";

        }
        if (!result) {
            throw new IllegalArgumentException(errorMsg);
        }
    }

    /**
     * Проверяем, что аргументы могут быть превращены в int и сохраняем их в Set
     *
     * @throws NumberFormatException
     */
    private void parseArgumentsToInt() throws NumberFormatException {
        iArgs = new HashSet<Integer>();
        for (String sArg : sArgs) {
            int iArg = Integer.parseInt(sArg);
            iArgs.add(iArg);
        }
    }

    /**
     * Складываем элементы из Set и проверяем, что их сумма меньше MAX_INT
     *
     * @return int
     * @throws Exception
     */
    private int addTwoNumbers() throws Exception {
        long sum = 0L;
        for (int arg : iArgs) {
            sum += arg;
            if (sum > Integer.MAX_VALUE) {
                throw new SizeLimitExceededException(String.format("SUM of these numbers is more than Integer.MAX_VALUE(%d)", Integer.MAX_VALUE));
            }
        }

        return (int) sum;
    }

    public static void main(String[] args) throws Exception {
        String msg;

        try {
            SumTwoNumbers sum = new SumTwoNumbers(args);
            sum.verifyNumberOfArguments();
            sum.parseArgumentsToInt();
            int result = sum.addTwoNumbers();
            msg = "SUM of these two numbers is " + result;
        } catch (Exception e) {
            msg = "Error: " + e.getLocalizedMessage();
        }
        System.out.println(msg);
    }
}
