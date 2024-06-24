package controller;



import java.util.Scanner;
import service.ContactService;
import views.ViewMenu;

public class ContactController {
    public static void controllerContact() throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        ContactService contactService = new ContactService();
        System.out.print("Mời bạn chọn: ");
        int option = scanner.nextInt();
        System.out.println();
        boolean exit = true;

        while(exit) {
            switch (option) {
                case 1:
                    contactService.addNewContacts();
                    ViewMenu.showMenu();
                    break;
                case 2:
                    contactService.editContact();
                    ViewMenu.showMenu();
                    break;
                case 3:
                    contactService.deleteContact();
                    ViewMenu.showMenu();
                    break;
                case 4:
                    contactService.showContacts();
                    ViewMenu.showMenu();
                    break;
                case 5:
                    contactService.findContact();
                    ViewMenu.showMenu();
                    break;
                default:
                    System.out.println("Bạn đã thoát chương trình.");
                    ViewMenu.showMenu();
            }
        }

    }
}
