package views;

import controller.ContactController;

public class ViewMenu {
    public ViewMenu() {
    }

    public static void showMenu() throws InterruptedException {
        System.out.println("1. Thêm mới liên lạc");
        System.out.println("2. Sửa thông tin liên lạc");
        System.out.println("3. Xóa thông tin liên lạc");
        System.out.println("4. Hiển thị danh sách liên lạc");
        System.out.println("5. Tìm kiếm liên lạc theo mã liên lạc");
        System.out.print("Mời bạn chọn chức năng [1->5] hoặc nhấn số 0 để thoát chương trình: ");
        ContactController.controllerContact();
    }
}
