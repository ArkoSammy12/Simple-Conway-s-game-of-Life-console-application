import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int x = 0;
        boolean exit = false;
        int height = 0, width = 0;

        ArrayList<Pixels> coordList = new ArrayList<Pixels>();

        Pixels[] newPixel = new Pixels[Screen.WIDTH * Screen.HEIGHT];

        // Ask user for an undefined amount of cells
        while (exit == false) {

            newPixel[x] = new Pixels(height, width);

            System.out.println("Input the X coordinate of the cell #" + x + 1 + ":");

            newPixel[x].width = input.nextInt();

            System.out.println("Input Y coordinate of the cell #" + x + 1 + ":");
            newPixel[x].height = input.nextInt();

            coordList.add(newPixel[x]);
            x++;

            // Prompt exit coord input part
            input.nextLine();
            boolean subExit = false;

            // Ask users if they want to input more cells
            while (subExit == false) {

                System.out.println("\n\nDo you want to input more more cells? Y/N");
                String opt = input.next();

                switch (opt) {

                    case "Y":
                        subExit = true;
                        break;
                    case "N":
                        exit = true;
                        subExit = true;
                        break;
                    default:
                        System.out.println("Invalid option.");

                }

            }

        }

        // Initialize all elements of the Buffer array as the background character
        Pixels.initScreen();

        // Get all the user inputted coordinates, and set a pixel at that coordinate in
        // the Buffer array
        for (int a = 0; a <= coordList.size() - 1; a++) {
            Screen.setPixels(coordList.get(a));
        }

        // Main program loop
        while (true) {

            Screen.clearConsole();

            Pixels.printPixels();

            System.out.print("\u001B[H");

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }

}