package service;

public interface IService<IService> {
    void addNewContacts() throws InterruptedException;

    void editContact() throws InterruptedException;

    void deleteContact() throws InterruptedException;

    void showContacts() throws InterruptedException;

    void findContact() throws InterruptedException;
}