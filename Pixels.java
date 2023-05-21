public class Pixels extends Screen {

    int height;
    int width;
    static int neighbors = 0;
    static int[][] neighborBuffer = new int[Screen.HEIGHT][Screen.WIDTH];

    Pixels(int height, int width) {

        this.height = height;
        this.width = width;

    }

    static void printPixels() {

        // Print the Buffer array to the console, and check for neighboring cells at the
        // same time. Store the amount of neighbors per cell
        // in a different array. After printing all of the Buffer array, update the
        // pixels using the neighborBuffer array
        for (int i = Buffer.length - 1; i > 0; i--) {
            for (int j = 0; j < Buffer[i].length - 1; j++) {
                System.out.print(Buffer[i][j]);

                neighborBuffer[i][j] = neighborCount(i, j);

            }
            System.out.println();

        }

        Screen.updatePixel(neighborBuffer);

    }

    public static int neighborCount(int height, int width) {

        // Set the start and end points of the iteration to check for neighbors. Depends
        // on our current coordinate
        int yStart = height + 1;
        int yEnd = height - 1;

        int xStart = width - 1;
        int xEnd = width + 1;

        int neighbors = 0;

        // Check if our current coordinate contains an alive cell.
        // We do this because if our current coordinate contains an alive cell, the
        // logic below will count that as a neighbor, leading
        // to an extra unwanted neighbor addition. We subtract 1 to compensate
        if (Buffer[height][width] == cellChar) {

            neighbors--;

        }

        // For every iteration of yStart to yEnd, iterate from xStart and xEnd, and
        // check for a character

        int a = yStart;

        while (a >= yEnd) {

            int b = xStart;

            if (a == Screen.HEIGHT) {

                a = 0;

            } else if (a < 0) {

                a = Screen.HEIGHT - 1;

            }

            while (b <= xEnd) {

                if (b == Screen.WIDTH) {

                    b = 0;

                } else if (b < 0) {

                    b = Screen.WIDTH - 1;

                }

                if (Buffer[a][b] == cellChar) {

                    neighbors++;

                }

                b++;

            }

            a--;

        }

        return neighbors;

    }

    static void initScreen() {

        for (int i = 0; i <= Buffer.length - 1; i++) {
            for (int j = 0; j <= Buffer[i].length - 1; j++) {

                Buffer[i][j] = backgroundChar;

            }

        }

    }

}
