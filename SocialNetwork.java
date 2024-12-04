import java.util.*;

class User {
    String name;

    public User(String name) {
        this.name = name;
    }
}

class SocialNetwork {
    private Map<String, Set<String>> graph;

    public SocialNetwork() {
        graph = new HashMap<>();
    }

    public void addUser(String name) {
        graph.put(name, new HashSet<>());
    }

    public void addFriendship(String user1, String user2) {
        graph.get(user1).add(user2);
        graph.get(user2).add(user1);
    }

    public void displayFriendships(String user) {
        System.out.println(user + "'s friends: " + graph.get(user));
    }

    public boolean areFriends(String user1, String user2) {
        return graph.get(user1).contains(user2);
    }

    public void displayAllUsers() {
        System.out.println("All users: " + graph.keySet());
    }

    public static void main(String[] args) {
        SocialNetwork network = new SocialNetwork();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Social Network Simulator");
            System.out.println("1. Create user");
            System.out.println("2. Add friendship");
            System.out.println("3. Display friendships");
            System.out.println("4. Check if friends");
            System.out.println("5. Display all users");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); 

            switch (option) {
                case 1:
                    System.out.print("Enter username: ");
                    network.addUser(scanner.nextLine());
                    break;
                case 2:
                    System.out.print("Enter user 1: ");
                    String user1 = scanner.nextLine();
                    System.out.print("Enter user 2: ");
                    String user2 = scanner.nextLine();
                    network.addFriendship(user1, user2);
                    break;
                case 3:
                    System.out.print("Enter username: ");
                    network.displayFriendships(scanner.nextLine());
                    break;
                case 4:
                    System.out.print("Enter user 1: ");
                    user1 = scanner.nextLine();
                    System.out.print("Enter user 2: ");
                    user2 = scanner.nextLine();
                    System.out.println(network.areFriends(user1, user2));
                    break;
                case 5:
                    network.displayAllUsers();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option. Please choose again.");
            }
        }
    }
}