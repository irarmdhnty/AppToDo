import java.util.Scanner;

class TodoItem {
    private String description;

    public TodoItem(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}

class TodoList {
    protected TodoItem[] model;
    protected int size;

    public TodoList(int initialCapacity) {
        model = new TodoItem[initialCapacity];
        size = 0;
    }

    public void showTodo() {
        System.out.println("ToDo list");
        System.out.println("---------------");
        for (int i = 0; i < size; i++) {
            TodoItem todo = model[i];
            int no = i + 1;
            System.out.println(no + ". " + todo.getDescription());
        }
    }

    public void addTodoItem(String todoDescription) {
        if (size == model.length) {
            // If the array is full, double its size
            TodoItem[] temp = model;
            model = new TodoItem[model.length * 2];
            System.arraycopy(temp, 0, model, 0, temp.length);
        }
        model[size++] = new TodoItem(todoDescription);
    }

    public boolean delTodoItem(int number) {
        if (number < 1 || number > size) {
            return false;
        }

        for (int i = number - 1; i < size - 1; i++) {
            model[i] = model[i + 1];
        }
        model[size - 1] = null;
        size--;
        return true;
    }
}

class InteractiveTodoList extends TodoList {
    public InteractiveTodoList(int initialCapacity) {
        super(initialCapacity);
    }

    public void viewTodo() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            showTodo();
            System.out.println("===============");
            System.out.println("Menu");
            System.out.println("===============");
            System.out.println("1. Menambah ToDo");
            System.out.println("2. Menghapus ToDo");
            System.out.println("x. Keluar");
            String input = input("Pilih", scanner);
            switch (input) {
                case "1":
                    viewAddTodoItem(scanner);
                    break;
                case "2":
                    viewDelTodoItem(scanner);
                    break;
                case "x":
                    break;
                default:
                    System.out.println("Pilihan anda tidak ada");
                    break;
            }

        }
    }

    private String input(String info, Scanner scanner) {
        System.out.println(info + " :");
        return scanner.nextLine();
    }

    private void viewAddTodoItem(Scanner scanner) {
        System.out.println("Menambah ToDo List");
        String todo = input("x (jika ingin batal)", scanner);
        if (!todo.equals("x")) {
            addTodoItem(todo);
        }
    }

    private void viewDelTodoItem(Scanner scanner) {
        System.out.println("Menghapus ToDo");
        String numberStr = input("Nomor yang ingin dihapus : (x) jika ingin kembali", scanner);
        if (!numberStr.equals("x")) {
            int number = Integer.parseInt(numberStr);
            boolean success = delTodoItem(number);
            if (!success) {
                System.out.println("Gagal menghapus ToDo nomor " + number);
            }
        }
    }
}

public class Todo {
    public static void main(String[] args) {
        InteractiveTodoList interactiveTodoList = new InteractiveTodoList(2);
        interactiveTodoList.viewTodo();
    }
}
