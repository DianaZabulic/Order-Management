package bll;

import dao.ClientDAO;
import model.Client;

import java.util.List;
import java.util.NoSuchElementException;

public class ClientBLL {
    private ClientDAO clientDAO = new ClientDAO();

    public ClientBLL() {
    }

    public Client findClientById(int id) {
        Client client = clientDAO.findById(id);
        if (client == null) {
            throw new NoSuchElementException("The client with id =" + id + " was not found!");
        }
        return client;
    }

    public List<Client> findAll() {
        List<Client> clients = clientDAO.findAll();
        if (clients.isEmpty()) {
            throw new NoSuchElementException("Empty list!");
        }
        return clients;
    }


    public void insertClient(String name, String address) {
        Client client = new Client(name, address);
        int id = clientDAO.insert(client);
    }

    public void updateClient(int id, String name, String address) {
        Client client = new Client(id, name, address);
        if (findClientById(id) != null) {
            clientDAO.update(client);
        } else {
            throw new NoSuchElementException("Incorrect id!");
        }
    }

    public void deleteClient(int id) {
        clientDAO.delete(id);
    }
}
