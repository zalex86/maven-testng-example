public class Teenage {
    public static boolean isTeenager(int age)
    {
        String message;
        boolean result;
        if (age < 19) {
            message = age + " - это тинейджер";
            result = true;
        }
        else {
            message = age + " - это уже не тинейджер";
            result = false;
        }
        System.out.println(message);
        return result;
    }
}
