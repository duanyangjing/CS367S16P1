
import java.util.Iterator;
import java.util.List;

/**
 * This is the user class which captures profile information of a single user
 *
 * @author jmishra
 */
public class User
{

    private String lastName;
    private String firstName;
    private String nickname;
    private String password;
    private List<Message> messages;
    private List<User> friends;
    private List<BroadcastList> broadcastLists;

    /**
     * A constructor to instantiate this class. None of the Strings passed to
     * this can be null or empty. Also any of the lists passed to this
     * constructor cannot be null. You can create empty ArrayLists and pass it
     * here. For any of the above mentioned validation issues, you must throw a
     * WhatsAppRuntimeException with the CANT_BE_EMPTY_OR_NULL message
     *
     * @param lastName last name of the user
     * @param firstName first name of the user
     * @param nickname nickname of the user. This must be unique across all
     * users
     * @param password password of the user
     * @param messages list of messages in the user's message list. This
     * includes both messages sent and received by the user.
     * @param friends list of users who are friends of this user
     * @param broadcastLists list of broadcast lists that this user owns
     * @throws WhatsAppRuntimeException if any of the strings passed to this
     * constructor are either null or empty or any of the lists passed to this
     * are null (they can be empty) throw an instance of this exception with the
     * message CANT_BE_EMPTY_OR_NULL
     */
    public User(String lastName, String firstName, String nickname,
            String password, List<Message> messages, List<User> friends,
            List<BroadcastList> broadcastLists) throws WhatsAppRuntimeException
    {
        if ((lastName == null) || (lastName.isEmpty()) || (firstName == null) || (firstName.
                isEmpty()) || (nickname == null) || (nickname.isEmpty()) || (password == null) || (password.
                isEmpty()) || (messages == null) || (friends == null) || (broadcastLists == null))
        {
            throw new WhatsAppRuntimeException(Config.CANT_BE_EMPTY_OR_NULL);
        }
        this.lastName = lastName;
        this.firstName = firstName;
        this.nickname = nickname;
        this.password = password;
        this.messages = messages;
        this.friends = friends;
        this.broadcastLists = broadcastLists;
    }

    /**
     * a getter to return the last name
     *
     * @return the last name
     */
    public String getLastName()
    {
        return lastName;
    }

    /**
     * A setter for the last name
     *
     * @param lastName - the last name of a user
     */
    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    /**
     * A getter for the first name
     *
     * @return the first name
     */
    public String getFirstName()
    {
        return firstName;
    }

    /**
     * A setter for the first name
     *
     * @param firstName the first name of a user
     */
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    /**
     * A getter for the nickname
     *
     * @return the nickname of a user
     */
    public String getNickname()
    {
        return nickname;
    }

    /**
     * A setter for the nickname
     *
     * @param nickname the nickname of a user
     */
    public void setNickname(String nickname)
    {
        this.nickname = nickname;
    }

    /**
     * A getter for the user password
     *
     * @return the user password
     */
    public String getPassword()
    {
        return password;
    }

    /**
     * A setter for the use password
     *
     * @param password the user password
     */
    public void setPassword(String password)
    {
        this.password = password;
    }

    /**
     * A getter for the list of all the user messages both sent and received
     *
     * @return the list containing all the user messages
     */
    public List<Message> getMessages()
    {
        return messages;
    }

    /**
     * A setter for the list of all the user messages
     *
     * @param messages a list of all the user messages
     */
    public void setMessages(List<Message> messages)
    {
        this.messages = messages;
    }

    /**
     * A getter for the list of friends of this user
     *
     * @return a list of all the user's friends
     */
    public List<User> getFriends()
    {
        return friends;
    }

    /**
     * A setter for the list of all friends of this user
     *
     * @param friends a list of all friends this user has
     */
    public void setFriends(List<User> friends)
    {
        this.friends = friends;
    }

    /**
     * A getter for the list of broadcast lists owned by this user
     *
     * @return the list of broadcast lists
     */
    public List<BroadcastList> getBroadcastLists()
    {
        return broadcastLists;
    }

    /**
     * A setter for the list of broadcast lists owned by this user
     *
     * @param broadcastLists the list of broadcast lists
     */
    public void setBroadcastLists(List<BroadcastList> broadcastLists)
    {
        this.broadcastLists = broadcastLists;
    }

    /**
     * this method removes a broadcast list from this user object
     *
     * @param broadcastNickname the nickname of the broadcast list to remove
     * @throws WhatsAppException throw this with BCAST_LIST_DOES_NOT_EXIST as
     * the message if the broadcast list asked to remove does not exist
     */
    public void removeBroadcastList(String broadcastNickname) throws WhatsAppException
    {
        //TODO
    }

    /**
     * this method check whether supplied nickname is a friend of this user
     * object
     *
     * @param nickname the nickname of the user to be checked whether he is a
     * friend
     * @return true if nickname is a friend of this user object
     */
    public boolean isFriend(String nickname)
    {
        //TODO
        return false;
    }

    /**
     * this method check whether supplied nickname is a broadcast list of this
     * user object
     *
     * @param nickname the nickname of the user to be checked whether it is a
     * broadcast list of this user object
     * @return true if nickname is a broadcast list of this user object
     */
    public boolean isBroadcastList(String nickname)
    {
        //TODO
        return false;
    }

    /**
     * checks if the supplied nickname is associated with this user object. It
     * can be either a friend or a broadcast list
     *
     * @param nickname the nickname to check against
     * @return true if the nickname supplied is either a friend or a broadcast
     * list of this user object
     */
    public boolean isExistingNickname(String nickname)
    {
        //TODO
        return false;
    }

    /**
     * checks whether the supplied nickname is part of the broadcastNickname
     * list both associated with this user object
     *
     * @param nickname the nickname of the user
     * @param broadcastNickname the nickname of the broadcastList
     * @return true if nickname is a part of the list represented by
     * broadcastNickname
     */
    public boolean isMemberOfBroadcastList(String nickname, String broadcastNickname)
    {
        //TODO
        return false;
    }

    /**
     * add a friend to this user
     *
     * @param nickname the nickname of the user who is to become a friend of
     * this user object
     * @throws WhatsAppException throw a new instance of this exception with one
     * of the following messages: CANT_BE_OWN_FRIEND (if trying to add the the
     * same user to itself), ALREADY_A_FRIEND (if the nickname is already a
     * friend of this user), CANT_LOCATE (if the supplied nickname is not even
     * an existing global contact)
     */
    public void addFriend(String nickname) throws WhatsAppException
    {
        //TODO        
    }

    /**
     * remove a friend from this user object
     *
     * @param nickname the nickname of the friend whom to remove as a friend of
     * this user object
     * @throws WhatsAppException throw a new instance of this exception with
     * NOT_A_FRIEND (if nickname is not a friend of this user)
     */
    public void removeFriend(String nickname) throws WhatsAppException
    {
        if (!isFriend(nickname))
        {
            throw new WhatsAppException(Config.NOT_A_FRIEND);
        }
        User friendToRemove = Helper.getUserFromNickname(friends, nickname);
        friends.remove(friendToRemove);

        Iterator<BroadcastList> bcastIterator = broadcastLists.iterator();
        while (bcastIterator.hasNext())
        {
            BroadcastList bcastList = bcastIterator.next();

            if (!isMemberOfBroadcastList(nickname, bcastList.getNickname()))
            {
                Helper.getBroadcastListFromNickname(broadcastLists, bcastList.
                        getNickname()).
                        getMembers().
                        remove(nickname);
            }

        }
    }

}
