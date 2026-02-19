package dataStructures.linkedList;

/**
 * Social Media Friend Connections using Singly Linked List.
 * Users are nodes in a main list. Each user has a sub-list of Friend IDs.
 */
public class SocialMediaSll {

    // Node for the list of friends (Nested List)
    class FriendNode {
        int friendId;
        FriendNode next;

        public FriendNode(int friendId) {
            this.friendId = friendId;
            this.next = null;
        }
    }

    // Node for the list of users (Main List)
    class UserNode {
        int userId;
        String name;
        int age;
        FriendNode friendsHead; // Head of the friend list
        UserNode next;

        public UserNode(int userId, String name, int age) {
            this.userId = userId;
            this.name = name;
            this.age = age;
            this.friendsHead = null;
            this.next = null;
        }
    }

    private UserNode head;

    // Add a new user
    public void addUser(int userId, String name, int age) {
        UserNode newNode = new UserNode(userId, name, age);
        if (head == null) {
            head = newNode;
        } else {
            UserNode temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
        System.out.println("User added: " + name);
    }

    // Find user node by ID
    private UserNode getUser(int userId) {
        UserNode temp = head;
        while (temp != null) {
            if (temp.userId == userId) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    // Add friend connection (Undirected: A <-> B)
    public void addFriendConnection(int userId1, int userId2) {
        UserNode user1 = getUser(userId1);
        UserNode user2 = getUser(userId2);

        if (user1 == null || user2 == null) {
            System.out.println("One or both users not found.");
            return;
        }

        // Add user2 to user1's list
        addFriendToUser(user1, userId2);
        // Add user1 to user2's list
        addFriendToUser(user2, userId1);
        System.out.println("Friend connection added between " + user1.name + " and " + user2.name);
    }

    private void addFriendToUser(UserNode user, int friendId) {
        FriendNode newFriend = new FriendNode(friendId);
        if (user.friendsHead == null) {
            user.friendsHead = newFriend;
        } else {
            FriendNode temp = user.friendsHead;
            while (temp.next != null) {
                if (temp.friendId == friendId)
                    return; // Already friend
                temp = temp.next;
            }
            if (temp.friendId == friendId)
                return;
            temp.next = newFriend;
        }
    }

    // Remove friend connection
    public void removeFriendConnection(int userId1, int userId2) {
        UserNode user1 = getUser(userId1);
        UserNode user2 = getUser(userId2);

        if (user1 != null)
            removeFriendFromUser(user1, userId2);
        if (user2 != null)
            removeFriendFromUser(user2, userId1);

        System.out.println("Friend connection removed.");
    }

    private void removeFriendFromUser(UserNode user, int friendId) {
        if (user.friendsHead == null)
            return;

        if (user.friendsHead.friendId == friendId) {
            user.friendsHead = user.friendsHead.next;
            return;
        }

        FriendNode temp = user.friendsHead;
        while (temp.next != null && temp.next.friendId != friendId) {
            temp = temp.next;
        }

        if (temp.next != null) {
            temp.next = temp.next.next;
        }
    }

    // Find mutual friends
    public void findMutualFriends(int userId1, int userId2) {
        UserNode user1 = getUser(userId1);
        UserNode user2 = getUser(userId2);

        if (user1 == null || user2 == null) {
            System.out.println("Users not found.");
            return;
        }

        System.out.println("Mutual friends between " + user1.name + " and " + user2.name + ":");
        FriendNode f1 = user1.friendsHead;
        boolean foundAny = false;
        while (f1 != null) {
            if (hasFriend(user2, f1.friendId)) {
                UserNode mutual = getUser(f1.friendId);
                if (mutual != null)
                    System.out.println(mutual.name);
                foundAny = true;
            }
            f1 = f1.next;
        }
        if (!foundAny)
            System.out.println("None.");
    }

    private boolean hasFriend(UserNode user, int friendId) {
        FriendNode temp = user.friendsHead;
        while (temp != null) {
            if (temp.friendId == friendId)
                return true;
            temp = temp.next;
        }
        return false;
    }

    // Display friends
    public void displayFriends(int userId) {
        UserNode user = getUser(userId);
        if (user == null) {
            System.out.println("User not found.");
            return;
        }
        System.out.println("Friends of " + user.name + ":");
        FriendNode temp = user.friendsHead;
        while (temp != null) {
            UserNode friendMap = getUser(temp.friendId);
            if (friendMap != null)
                System.out.print(friendMap.name + " ");
            else
                System.out.print("[" + temp.friendId + "] ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Search user
    public void searchUser(String name) {
        UserNode temp = head;
        while (temp != null) {
            if (temp.name.equalsIgnoreCase(name)) {
                System.out.println("Found User: ID " + temp.userId + ", Name " + temp.name);
                return;
            }
            temp = temp.next;
        }
        System.out.println("User not found.");
    }

    // Count friends
    public void countFriends(int userId) {
        UserNode user = getUser(userId);
        if (user == null) {
            System.out.println("User not found.");
            return;
        }
        int count = 0;
        FriendNode temp = user.friendsHead;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        System.out.println(user.name + " has " + count + " friends.");
    }

    public static void main(String[] args) {
        SocialMediaSll sm = new SocialMediaSll();
        sm.addUser(1, "Alice", 25);
        sm.addUser(2, "Bob", 27);
        sm.addUser(3, "Charlie", 22);
        sm.addUser(4, "Diana", 24);

        sm.addFriendConnection(1, 2); // Alice - Bob
        sm.addFriendConnection(1, 3); // Alice - Charlie
        sm.addFriendConnection(2, 3); // Bob - Charlie (Mutual: Alice)

        sm.displayFriends(1);
        sm.findMutualFriends(2, 3); // Should show Alice (ID 1)

        sm.countFriends(1);

        sm.removeFriendConnection(1, 2);
        sm.displayFriends(1);
    }
}
