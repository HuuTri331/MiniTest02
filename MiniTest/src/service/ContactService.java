package service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import model.Contact;

public class ContactService implements IService<Contact> {
    Scanner scanner;
    private static ArrayList<Contact> contacts = new ArrayList();

    public ContactService() {
        this.scanner = new Scanner(System.in);
    }

    public void addNewContacts() throws InterruptedException {
        System.out.print("Nhập số lượng liên lạc muốn thêm mới: ");
        int contactNumber = this.scanner.nextInt();
        this.scanner.nextLine();

        for(int i = 0; i < contactNumber; ++i) {
            System.out.print("Nhập mã liên lạc: ");
            int id = this.scanner.nextInt();
            this.scanner.nextLine();
            System.out.print("Nhập tên: ");
            String name = this.scanner.nextLine();
            System.out.print("Nhập số điện thoại: ");
            String phone = this.scanner.nextLine();
            System.out.print("Nhập email: ");
            String email = this.scanner.nextLine();
            System.out.print("Nhập địa chỉ: ");
            String address = this.scanner.nextLine();
            contacts.add(new Contact(id, name, phone, email, address));
        }

        System.out.println("Thêm mới liên lạc thành công.");
    }

    public void editContact() throws InterruptedException {
        System.out.print("Nhập mã liên lạc muốn sửa: ");
        int editingContactId = this.scanner.nextInt();
        this.scanner.nextLine();
        Contact contact = findExistingContact(editingContactId);
        if (contact == null) {
            System.out.println("Không tìm thấy liên lạc.");
        } else {
            System.out.print("Nhập tên mới: ");
            String name = this.scanner.nextLine();
            System.out.print("Nhập số điện thoại mới: ");
            String phone = this.scanner.nextLine();
            System.out.print("Nhập email mới: ");
            String email = this.scanner.nextLine();
            System.out.print("Nhập địa chỉ mới: ");
            String address = this.scanner.nextLine();
            contact.setName(name);
            contact.setPhone(phone);
            contact.setEmail(email);
            contact.setAddress(address);
            System.out.println("Sửa thành công!");
        }

    }

    public void deleteContact() throws InterruptedException {
        System.out.print("Nhập mã liên lạc muốn xóa: ");
        int removingContactId = this.scanner.nextInt();
        this.scanner.nextLine();
        Contact contact = findExistingContact(removingContactId);
        if (contact == null) {
            System.out.println("Không tìm thấy liên lạc.");
        } else {
            contacts.remove(contact);
            System.out.println("Xóa thành công!");
        }

    }

    public void showContacts() throws InterruptedException {
        if (contacts.isEmpty()) {
            System.out.println("Chưa có liên lạc nào trong danh sách liên lạc hiện tại.");
        } else {
            Iterator var1 = contacts.iterator();

            while(var1.hasNext()) {
                Contact contact = (Contact)var1.next();
                System.out.println(contact);
            }
        }

    }

    public void findContact() throws InterruptedException {
        System.out.print("Nhập mã liên lạc muốn tìm kiếm: ");
        int findingContactId = this.scanner.nextInt();
        this.scanner.nextLine();
        Contact contact = findExistingContact(findingContactId);
        if (contact == null) {
            System.out.println("Không tìm thấy liên lạc.");
        } else {
            showFindingContact(contact);
        }

    }

    private static Contact findExistingContact(int id) {
        Iterator var1 = contacts.iterator();

        Contact contact;
        do {
            if (!var1.hasNext()) {
                return null;
            }

            contact = (Contact)var1.next();
        } while(contact.getId() != id);

        return contact;
    }

    private static void showFindingContact(Contact contact) {
        System.out.println(contact);
    }
}
