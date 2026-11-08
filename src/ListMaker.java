import java.util.ArrayList;
import java.util.Scanner;
public class ListMaker
{
    private static ArrayList<String> list = new ArrayList<>();
    private static Scanner in = new Scanner(System.in);
    public static void main(String[] args)
    {
        boolean quit = false;
        do
        {
            displayList();
            String command = SafeInput.getRegExString(
                    in,
                    "Menu: [A]dd, [D]elete, [I]nsert, [P]rint, [Q]uit",
                    "[AaDdIiPpQq]"
            );
            switch (command.toUpperCase())
            {
                case "A":
                    addItem();
                    break;
                case "D":
                    deleteItem();
                    break;
                case "I":
                    insertItem();
                    break;
                case "P":
                    printList();
                    break;
                case "Q":
                    if (SafeInput.getYNConfirm(in, "Are you sure you want to quit?"))
                    {
                        quit = true;
                    }
                    break;
            }
        } while (!quit);
        System.out.println("Exiting ListMaker. Goodbye!");
    }
    private static void displayList()
    {
        System.out.println("\n------------------------------");
        if (list.isEmpty())
        {
            System.out.println("Current List: [Empty]");
        }
        else
        {
            System.out.println("Current List:");
            for (int i = 0; i < list.size(); i++)
            {
                System.out.println((i + 1) + ". " + list.get(i));
            }
        }
        System.out.println("------------------------------");
    }
    private static void addItem()
    {
        String item = SafeInput.getNonZeroLenString(in, "Enter the item to add");
        list.add(item);
        System.out.println("Item added.");
    }
    private static void deleteItem()
    {
        if (list.isEmpty())
        {
            System.out.println("The list is currently empty. Nothing to delete.");
            return;
        }
        int itemNum = SafeInput.getRangedInt(in, "Enter the item number to delete", 1, list.size());
        int index = itemNum - 1;
        String removed = list.remove(index);
        System.out.println("Removed: " + removed);
    }
    private static void insertItem()
    {
        String item = SafeInput.getNonZeroLenString(in, "Enter the item to insert");
        int targetNum;
        if (list.isEmpty())
        {
            targetNum = 1;
        }
        else
        {
            targetNum = SafeInput.getRangedInt(in, "Enter the position number where you want to insert", 1, list.size() + 1);
        }
        int index = targetNum - 1;
        list.add(index, item);
        System.out.println("Item inserted at position " + targetNum + ".");
    }
    private static void printList()
    {
        displayList();
    }
}