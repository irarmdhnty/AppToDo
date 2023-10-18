import java.util.Scanner;

public class Todo {

    public static String[] model = new String[10];

    public static void main(String[] args) {
        viewTodo();
    }

    public static void showTodo() {
        System.out.println("ToDo list");
        System.out.println("---------------");
        for (int i = 0; i < model.length; i++) {
            String todo = model[i];
            int no = i + 1;
            if (todo != null) {
                System.out.println(no + ". " + todo);
            }
        }
    }

//    public static void testShow(){
//        model[0] = "Java";
//        model[1] = "OOP";
//        showTodo();
//    }

    public static void addTodo(String todo) {

        boolean isFull = true;
        for (int i = 0; i < model.length; i++) {
            if (model[i] == null) {
                isFull = false;
                break;
            }
        }

        if (isFull) {
            String[] temp = model;
            model = new String[model.length * 2];
            for (int i = 0; i < temp.length; i++) {
                model[i] = temp[i];
            }
        }
        for (int i = 0; i < model.length; i++) {
            if (model[i] == null) {
                model[i] = todo;
                break;
            }
        }
    }

//    public static void testAdd(){
//        for (int i = 0; i < 25; i++){
//            addTodo("contoh" + i);
//        }
//    }

    public static boolean delTodo(Integer number) {
        if ((number - 1) >= model.length) {
            return false;
        } else if (model[number - 1] == null) {
            return false;
        } else {
            for (int i = (number - 1); i < model.length; i++) {
                if (i == (model.length - 1)) {
                    model[i] = null;
                } else {
                    model[i] = model[i + 1];
                }
            }
            return true;
        }
    }

//    public static void testDel(){
//        model[0] = "satu";
//        model[1] = "dua";
//        model[2] = "tiga";
//        model[3] = "empat";
//        showTodo();
//        System.out.println("hapus data ke 2");
//        delTodo(2);
//        showTodo();
//    }

    public static String input(String info) {
        String data;
        Scanner input = new Scanner(System.in);
        System.out.println(info + " :");
        data = input.nextLine();
        return data;
    }

//    public static void testInput() {
//        String nama = input("Nama");
//        System.out.println("hai " + nama);
//    }

    public static void viewTodo() {
        while (true) {
            showTodo();
            System.out.println("===============");
            System.out.println("Menu");
            System.out.println("===============");
            System.out.println("1. Menambah ToDo");
            System.out.println("2. Menghapus ToDo");
            System.out.println("x. Keluar");
            String input = input("Pilih");
            if(input.equals("1")){
                viewAddTodo();
            }else if(input.equals("2")){
                viewDelTodo();
            }else if(input.equals("x")){
                break ;
            }else {
                System.out.println("Pilihan anda tidak ada");
            }
        }
    }

    public static void viewAddTodo() {
        System.out.println("Menambah ToDo List");
        String todo = input("x (jika ingin batal)");
        if (todo.equals("x")) {

        } else {
            addTodo(todo);
        }
    }

//    public static void testViewAdd(){
//        addTodo("makan");
//        addTodo("minum ");
//        showTodo();
//        viewAddTodo();
//        showTodo();
//    }

    public static void viewDelTodo() {
        System.out.println("Menghapus ToDo");
        String number = input("Nomor yang ingin dihapus : (x) jika ingin kembali");
        if (number.equals("x")) {

        } else {
            boolean success = delTodo(Integer.valueOf(number));
            if (!success) {
                System.out.println("Gagal menghapus ToDo " + number);
            }
        }
    }

//    public static void testViewDel(){
//        addTodo("makan");
//        addTodo("minum ");
//        showTodo();
//        viewDelTodo();
//        showTodo();
//    }
}
