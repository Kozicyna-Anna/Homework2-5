public class Main {
    public static void main(String[] args)  {
        try {
            SecurityUtils.check("bxvjbxjnv428_", "25798_", "256789");
            System.out.println("Все отлично");
        } catch (WrongLoginException e) {
            System.err.println(e.getMessage());
        } catch (WrongPasswordException e) {
            System.err.println(e.getMessage());
        } finally {
            System.out.println("Finally!");
        }
    }
}