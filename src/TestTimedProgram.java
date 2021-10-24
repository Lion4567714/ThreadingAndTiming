public class TestTimedProgram {
    public static void main(String[] args) {
        Timer timer = new Timer();

        timer.start();
        for (int i = 0; i < 10; i++) {
            testFunction();
            timer.lap();
        }
        timer.end();
        System.out.println(timer.toString());
    }

    private static void testFunction() {
        int i = 0;
        while (i <= 1000000) {
            i++;
        }
    }
}
