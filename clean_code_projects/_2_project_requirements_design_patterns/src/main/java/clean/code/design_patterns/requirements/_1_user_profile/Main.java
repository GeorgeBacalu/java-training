package clean.code.design_patterns.requirements._1_user_profile;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static ArrayList<User> users;
    private static Scanner sc;
    private static int userId = 0;
    private static int messageId = 0;

    public static void main(String[] args) {
        try {
            sc = new Scanner(System.in);
            User user1 = new User.Builder(userId++, "John Doe", "john@gmail.com")
                    .city("New York")
                    .job("Full time web designer")
                    .hobbies(new String[]{"programming", "football"})
                    .hasDrivingLicense(true)
                    .build();
            User user2 = new User.Builder(userId++, "Jordan-Lee Mueller", "jordan@gmail.com")
                    .city("Washington DC")
                    .job("Android Developer")
                    .hobbies(new String[]{"basketball", "volleyball"})
                    .phoneNumber("361-293-0144")
                    .build();
            User user3 = new User.Builder(userId++, "Chris Massey", "chris@gmail.com")
                    .city("Ottawa")
                    .profileImageUrl("https://liveboldandbloom.com/wp-content/uploads/2021/09/Untitled_design_3_1.png")
                    .coverImageUrl("https://media.istockphoto.com/photos/mountains-picture-id175515475?k=20&m=175515475&s=612x612&w=0&h=TyZ_Tn6ED8mICogM8L1tX6ftCEFJnjMiADy_baak7SY=")
                    .build();
            User user4 = new User.Builder(userId++, "Henri Adkins", "henri@gmail.com")
                    .city("London")
                    .job("Accountant")
                    .hobbies(new String[]{"photography", "traveling"})
                    .hasDrivingLicense(false)
                    .build();
            User user5 = new User.Builder(userId++, "Sarah Drummond", "sarah@gmail.com")
                    .city("Chicago")
                    .job("Full time web designer")
                    .hobbies(new String[]{"reading", "cooking"})
                    .hasDrivingLicense(true)
                    .build();
            users = new ArrayList<>(List.of(new User[]{user1, user2, user3, user4, user5}));
            showInitialOptions();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sc.close();
        }
    }

    private static void showInitialOptions() {
        System.out.println("-------------------------");
        System.out.println("1. Manage users");
        System.out.println("2. Manage messages");
        System.out.println("3. Quit");
        System.out.print("Select an option: ");
        int choice = sc.nextInt();
        switch (choice) {
            case 1: manageUsers(); break;
            case 2: manageMessages(); break;
            case 3: return;
            default: showInitialOptions();
        }
    }

    private static void manageUsers() {
        System.out.println("-------------------------");
        System.out.println("1. Show all users");
        System.out.println("2. Add a new user");
        System.out.println("3. Search for a user");
        System.out.println("4. Delete a user");
        System.out.println("5. Go Back");
        System.out.print("Select an option: ");
        int choice = sc.nextInt();
        switch (choice) {
            case 1: showAllUsers(); break;
            case 2: addNewUser(); break;
            case 3: searchForUser(); break;
            case 4: deleteUser(); break;
            case 5: showInitialOptions(); break;
            default: manageUsers();
        }
    }

    private static void showAllUsers() {
        try {
            System.out.println();
            Iterator<User> iterator = users.iterator();
            if (users.size() > 0) {
                while (iterator.hasNext()) {
                    System.out.println(iterator.next());
                }
            } else System.out.println("There are no users to display!");
            manageUsers();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void addNewUser() {
        try {
            System.out.println("\nAdding a new user:"); sc.nextLine();
            System.out.print("User's name: "); String name = sc.nextLine(); name = name.trim();
            System.out.print("User's email: "); String email = sc.nextLine(); email = email.trim();

            if (name.equals("") || email.equals("")) {
                System.out.println("Please enter all of the information!");
                addNewUser();
            } else {
                String enteredName = name;
                boolean doesExist = users.stream().anyMatch(user -> enteredName.equals(user.getName()));
                if (doesExist) {
                    System.out.println("There is already a user named " + name + " saved on this platform.");
                    addNewUser();
                } else {
                    users.add(new User.Builder(userId++, name, email)
                            .city(getUserCityOrNull())
                            .job(getUserJobOrNull())
                            .phoneNumber(getUserPhoneNumberOrNull())
                            .profileImageUrl(getUserProfileImageUrlOrNull())
                            .coverImageUrl(getUserCoverImageUrlOrNull())
                            .hasDrivingLicense(getUserHasDrivingLicense())
                            .hobbies(getUserHobbiesOrNull())
                            .build());
                    System.out.println("User " + name + " was added successfully.");
                }
            }
            manageUsers();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void searchForUser() {
        try {
            sc.nextLine();
            System.out.print("\nUser's name: "); String name = sc.nextLine(); name = name.trim();
            if (name.equals("")) {
                System.out.println("Please enter the name!");
                searchForUser();
            } else {
                String enteredName = name;
                User filteredUser = users.stream().filter(user -> enteredName.equals(user.getName())).findAny().orElse(null);
                if (filteredUser != null) System.out.println("User found: " + filteredUser);
                else System.out.println("There is no user named " + name + " on this platform!");

                /*
                boolean doesExist = false;
                Iterator<User> iterator = users.iterator();
                while(iterator.hasNext()) {
                    if(name.equals(iterator.next().getName())) {
                        doesExist = true;
                        System.out.println("User found: " + iterator.next());
                        break;
                    }
                }
                if (doesExist) System.out.println("User found: " + filteredUser);
                else System.out.println("There is no user named " + name + " on this platform!");
                */
            }
            manageUsers();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void deleteUser() {
        try {
            sc.nextLine();
            System.out.print("\nUser's name: "); String name = sc.nextLine(); name = name.trim();
            if (name.equals("")) {
                System.out.println("Please enter the name");
                deleteUser();
            } else {
                String enteredName = name;
                User filteredUser = users.stream().filter(user -> enteredName.equals(user.getName())).findAny().orElse(null);
                if (filteredUser != null) {
                    users.remove(filteredUser);
                    System.out.println("User " + name + " was deleted successfully");
                } else System.out.println("There is no user named " + name + " on this platform!");

                /*
                boolean doesExist = false;
                Iterator<User> iterator = users.iterator();
                while(iterator.hasNext()) {
                    if(name.equals(iterator.next().getName())) {
                        doesExist = true;
                        users.remove(iterator.next());
                        System.out.println("User " + name + " was deleted successfully.");
                        break;
                    }
                }
                if(!doesExist) System.out.println("There is no user named " + name + " on this platform!");
                */
            }
            manageUsers();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private static String getUserCityOrNull() {
        System.out.print("Want to introduce the city? (y/n) ");
        String option = sc.nextLine();
        if (option.startsWith("y")) {
            System.out.print("User's city: ");
            return sc.next();
        }
        return null;
    }

    private static String getUserJobOrNull() {
        sc.nextLine();
        System.out.print("Want to introduce the job? (y/n) ");
        String option = sc.nextLine();
        if (option.startsWith("y")) {
            System.out.print("User's job: ");
            return sc.next();
        }
        return null;
    }

    private static String getUserPhoneNumberOrNull() {
        sc.nextLine();
        System.out.print("Want to introduce the phone number? (y/n) ");
        String option = sc.nextLine();
        if (option.startsWith("y")) {
            System.out.print("User's number: ");
            return sc.next();
        }
        return null;
    }

    private static String getUserProfileImageUrlOrNull() {
        sc.nextLine();
        System.out.print("Want to introduce the profile image url? (y/n) ");
        String option = sc.nextLine();
        if (option.startsWith("y")) {
            System.out.print("User's profile image url: ");
            return sc.next();
        }
        return null;
    }

    private static String getUserCoverImageUrlOrNull() {
        sc.nextLine();
        System.out.print("Want to introduce the cover image url? (y/n) ");
        String option = sc.nextLine();
        if (option.startsWith("y")) {
            System.out.print("User's cover image url: ");
            return sc.next();
        }
        return null;
    }

    private static boolean getUserHasDrivingLicense() {
        sc.nextLine();
        System.out.print("Want to give details about driving license? (y/n) ");
        String option = sc.nextLine();
        if (option.startsWith("y")) {
            System.out.print("Do you have a driving license? (y/n) ");
            return sc.next().startsWith("y");
        }
        return false;
    }

    private static String[] getUserHobbiesOrNull() {
        sc.nextLine();
        System.out.print("Want to introduce your hobbies? (y/n) ");
        String option = sc.nextLine();
        if (option.startsWith("y")) {
            System.out.print("User's hobbies: ");
            String hobbies = sc.next();
            sc.nextLine();
            return hobbies.split(", ");
        }
        return null;
    }


    private static void manageMessages() {
        System.out.println("-------------------------");
        System.out.println("1. Show all messages");
        System.out.println("2. Send a new message");
        System.out.println("3. Go Back");
        System.out.print("Select an option: ");
        int choice = sc.nextInt();
        switch (choice) {
            case 1: showAllMessages(); break;
            case 2: sendNewMessage(); break;
            case 3: showInitialOptions(); break;
            default: manageMessages();
        }
    }

    private static void showAllMessages() {
        try {
            System.out.println();
            ArrayList<Message> messages = new ArrayList<>();
            Iterator<User> userIterator = users.iterator();
            while (userIterator.hasNext()) {
                messages.addAll(userIterator.next().getMessages());
            }
            if (messages.size() > 0) {
                Iterator<Message> messageIterator = messages.iterator();
                while (messageIterator.hasNext()) {
                    System.out.println(messageIterator.next());
                }
            } else System.out.println("There are no messages to display!");
            manageMessages();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void sendNewMessage() {
        try {
            sc.nextLine();
            System.out.print("\nUser's name: "); String name = sc.nextLine(); name = name.trim();
            if (name.equals("")) {
                System.out.println("Please enter the name!");
                sendNewMessage();
            } else {
                String enteredName = name;
                boolean doesExist = users.stream().anyMatch(user -> enteredName.equals(user.getName()));

                /*
                boolean doesExist = false;
                for(User user : users) {
                    if(name.equals(user.getName())) {
                        doesExist = true;
                        break;
                    }
                }
                */

                if (doesExist) {
                    System.out.println("Write your message here!"); String text = sc.nextLine(); text = text.trim();
                    if (text.equals("")) {
                        System.out.println("Please enter a message!");
                        sendNewMessage();
                    } else {
                        Message newMessage = new Message(messageId++, text);
                        String finalName = name;
                        User filteredUser = users.stream().filter(user -> finalName.equals(user.getName())).findAny().orElse(null);
                        if (filteredUser != null) {
                            ArrayList<Message> newMessages = filteredUser.getMessages();
                            newMessages.add(newMessage);
                            filteredUser.setMessages(newMessages);
                            System.out.println("Message sent to " + name + " successfully.");
                        }

                        /*
                        Iterator<User> iterator = users.iterator();
                        while(iterator.hasNext()) {
                            if(name.equals(iterator.next().getName())) {
                                ArrayList<Message> newMessages = iterator.next().getMessages();
                                newMessages.add(newMessage);
                                iterator.next().setMessages(newMessages);
                                System.out.println("Message sent to " + name + " successfully.");
                            }
                        }
                        */
                    }
                } else System.out.println("There is no user named " + name + " on this platform!");
            }
            manageMessages();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
