package server.service;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import server.handler.ClientHandler;
import server.interfac.AuthService;
import server.interfac.Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;


public class ServerImpl implements Server {

    public static final Logger LOGGER = LogManager.getLogger(ServerImpl.class);
    private List<ClientHandler> clients;
    private AuthService authService = new AuthServiceImpl();;

    public ServerImpl() {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is ready");
            LOGGER.info("Server is ready");
            authService = new AuthServiceImpl();
            authService.start();
            clients = new LinkedList<>();

            while (true) {

                System.out.println("Server is waiting for clients");
                LOGGER.info("Server is waiting for clients");
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client is connected");
                LOGGER.info("Client is connected");
                new ClientHandler(this, clientSocket);
            }
        } catch (IOException e) {
            System.out.println("Server problem");
            LOGGER.log(Level.WARN, "Server problem");
            e.printStackTrace();
        } finally {
            if (authService != null) {
                authService.stop();
            }
        }
    }

    @Override

    public synchronized boolean isNickBusy(String nick) {
        for (ClientHandler c : clients) {
            if (c.getNick() != null && c.getNick().equals(nick)) {
                return true;
            }
        }
        return false;
    }

    @Override

    public void sendPrivateMsg(ClientHandler fromClient, String toClient, String msg) {
        for (ClientHandler clientHandler : clients) {
            if (clientHandler.getNick().equals(toClient)) {
                clientHandler.sendMsg("От " + fromClient.getNick() + ": " + msg);
                fromClient.sendMsg("Кому " + toClient + ": " + msg);
                return;
            } else {
                fromClient.sendMsg(toClient + " не подключен к чату.");
            }
        }
    }

    @Override

    public synchronized void broadcastMsg(String msg) {
        for (ClientHandler c : clients) {
            c.sendMsg(msg);
        }
    }


    @Override

    public synchronized void subscribe(ClientHandler client) {
        clients.add(client);
    }

    @Override

    public synchronized void unsubscribe(ClientHandler client) {
        clients.remove(client);
    }

    @Override

    public AuthService getAuthService() {
        return authService;
    }




    @Override
    public synchronized void sendMsgToClient(ClientHandler from, String toNick, String msg) {
        for (ClientHandler c : clients) {
            if (c.getNick().equals(toNick)) {
                c.sendMsg("from " + from.getNick() + ": " + msg);
                from.sendMsg("client " + toNick + ": " + msg);
                return;
            }
        }
    }

    @Override
    public synchronized void broadcastClientList() {
        StringBuilder builder = new StringBuilder("/clients");
        for (ClientHandler c : clients) {
            builder.append(c.getNick() + " ");
        }
        broadcastMsg(builder.toString());
    }
}
