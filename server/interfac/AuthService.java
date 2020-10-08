package server.interfac;

public interface AuthService {
    void start();
    String getNick(String login, String password);
    void stop();
}
