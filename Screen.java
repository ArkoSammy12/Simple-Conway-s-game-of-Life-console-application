public class Screen {

    public static final int WIDTH = 100;
    public static final int HEIGHT = 50;
    public static final char backgroundChar = ' ';
    public static final char cellChar = '#';

    public static char[][] Buffer = new char[Screen.HEIGHT][Screen.WIDTH];

    public static void setPixels(Pixels thisPixel) {

        Buffer[thisPixel.height][thisPixel.width] = cellChar;

    }

    public static void updatePixel(int[][] neighborBuffer) {

        // Receive the amount of neighbors per coordinate, and apply the rules of the
        // game

        for (int i = Buffer.length - 1; i > 0; i--) {
            for (int j = 0; j < Buffer[i].length - 1; j++) {

                if (neighborBuffer[i][j] < 2 || neighborBuffer[i][j] > 3) {

                    Buffer[i][j] = backgroundChar;

                } else if (neighborBuffer[i][j] == 3) {

                    Buffer[i][j] = cellChar;

                }
            }

        }

    }

    public static void clearConsole() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                Runtime.getRuntime().exec("clear");
            }
        } catch (Exception e) {
            // Handle exceptions as needed
            e.printStackTrace();
        }
    }

}
