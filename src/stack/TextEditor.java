package stack;

import java.util.Scanner;
import java.util.Stack;

public class TextEditor {
    private StringBuilder text;
    private Stack<String> undoStack;

    public TextEditor() {
        text = new StringBuilder();
        undoStack = new Stack<>();
    }

    public void type(String input) {
        undoStack.push(text.toString());
        text.append(input);
    }

    public void delete(int numChars) {
        if (numChars >= text.length()) {
            undoStack.push(text.toString());
            text.setLength(0);
        } else {
            undoStack.push(text.toString());
            text.delete(text.length() - numChars, text.length());
        }
    }

    public void paste(String clipboard) {
        undoStack.push(text.toString());
        text.append(clipboard);
    }

    public void undo() {
        if (!undoStack.isEmpty()) {
            text = new StringBuilder(undoStack.pop());
        }
    }

    public String getText() {
        return text.toString();
    }

    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter a command (type, delete, paste, undo): ");
            String command = scanner.nextLine();

            if (command.equals("type")) {
                System.out.print("Enter text to type: ");
                String input = scanner.nextLine();
                editor.type(input);
                System.out.println("Current text: " + editor.getText());
            } else if (command.equals("delete")) {
                System.out.print("Enter number of characters to delete: ");
                int numChars = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character
                editor.delete(numChars);
                System.out.println("Current text: " + editor.getText());
            } else if (command.equals("paste")) {
                System.out.print("Enter text to paste: ");
                String clipboard = scanner.nextLine();
                editor.paste(clipboard);
                System.out.println("Current text: " + editor.getText());
            } else if (command.equals("undo")) {
                editor.undo();
                System.out.println("Current text: " + editor.getText());
            } else {
                System.out.println("Invalid command. Please try again.");
            }
        }
    }
}