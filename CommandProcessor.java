
import java.util.Date;
import java.util.Iterator;

/**
 * The most important class. This processes all the commands issued by the users
 *
 * @author jmishra
 */
public class CommandProcessor
{

    // session added for saving some typing overhead and slight performance benefit
    private static final Config CONFIG = Config.getInstance();

    /**
     * A method to do login. Should show LOGIN_PROMPT for the nickname,
     * PASSWORD_PROMPT for the password. Says SUCCESSFULLY_LOGGED_IN is
     * successfully logs in someone. Must set the logged in user in the Config
     * instance here
     *
     * @throws WhatsAppException if the credentials supplied by the user are
     * invalid, throw this exception with INVALID_CREDENTIALS as the message
     */
    public static void doLogin() throws WhatsAppException
    {
        CONFIG.getConsoleOutput().printf(Config.LOGIN_PROMPT);
        String nickname = CONFIG.getConsoleInput().nextLine();
        CONFIG.getConsoleOutput().printf(Config.PASSWORD_PROMPT);
        String password = CONFIG.getConsoleInput().nextLine();

        Iterator<User> userIterator = CONFIG.getAllUsers().iterator();
        while (userIterator.hasNext())
        {
            User user = userIterator.next();
            if (user.getNickname().equals(nickname) && user.getPassword()
                    .equals(password))
            {
                CONFIG.setCurrentUser(user);
                CONFIG.getConsoleOutput().
                        printf(Config.SUCCESSFULLY_LOGGED_IN);
                return;
            }

        }
        throw new WhatsAppException(String.
                format(Config.INVALID_CREDENTIALS));
    }

    /**
     * A method to logout the user. Should print SUCCESSFULLY_LOGGED_OUT when
     * done.
     */
    public static void doLogout()
    {
        //TODO
    }

    /**
     * A method to send a message. Handles both one to one and broadcasts
     * MESSAGE_SENT_SUCCESSFULLY if sent successfully.
     *
     * @param nickname - can be a friend or broadcast list nickname
     * @param message - message to send
     * @throws WhatsAppRuntimeException simply pass this untouched from the
     * constructor of the Message class
     * @throws WhatsAppException throw this with one of CANT_SEND_YOURSELF,
     * NICKNAME_DOES_NOT_EXIST messages
     */
    public static void sendMessage(String nickname, String message) throws WhatsAppRuntimeException, WhatsAppException
    {
        //TODO
    }

    /**
     * Displays messages from the message list of the user logged in. Prints the
     * messages in the format specified by MESSAGE_FORMAT. Says NO_MESSAGES if
     * no messages can be displayed at the present time
     *
     * @param nickname - send a null in this if you want to display messages
     * related to everyone. This can be a broadcast nickname also.
     * @param enforceUnread - send true if you want to display only unread
     * messages.
     */
    public static void readMessage(String nickname, boolean enforceUnread)
    {
        //TODO
    }

    /**
     * Method to do a user search. Does a case insensitive "contains" search on
     * either first name or last name. Displays user information as specified by
     * the USER_DISPLAY_FOR_SEARCH format. Says NO_RESULTS_FOUND is nothing
     * found.
     *
     * @param word - word to search for
     * @param searchByFirstName - true if searching for first name. false for
     * last name
     */
    public static void search(String word, boolean searchByFirstName)
    {
        //TODO
    }

    /**
     * Adds a new friend. Says SUCCESSFULLY_ADDED if added. Hint: use the
     * addFriend method of the User class.
     *
     * @param nickname - nickname of the user to add as a friend
     * @throws WhatsAppException simply pass the exception thrown from the
     * addFriend method of the User class
     */
    public static void addFriend(String nickname) throws WhatsAppException
    {
       //TODO
    }

    /**
     * removes an existing friend. Says NOT_A_FRIEND if not a friend to start
     * with, SUCCESSFULLY_REMOVED if removed. Additionally removes the friend
     * from any broadcast list she is a part of
     *
     * @param nickname nickname of the user to remove from the friend list
     * @throws WhatsAppException simply pass the exception from the removeFriend
     * method of the User class
     */
    public static void removeFriend(String nickname) throws WhatsAppException
    {
        CONFIG.getCurrentUser().removeFriend(nickname);
        CONFIG.getConsoleOutput().printf(Config.SUCCESSFULLY_REMOVED);
    }

    /**
     * adds a friend to a broadcast list. Says SUCCESSFULLY_ADDED if added
     *
     * @param friendNickname the nickname of the friend to add to the list
     * @param bcastNickname the nickname of the list to add the friend to
     * @throws WhatsAppException throws a new instance of this exception with
     * one of NOT_A_FRIEND (if friendNickname is not a friend),
     * BCAST_LIST_DOES_NOT_EXIST (if the broadcast list does not exist),
     * ALREADY_PRESENT (if the friend is already a member of the list),
     * CANT_ADD_YOURSELF_TO_BCAST (if attempting to add the user to one of his
     * own lists
     */
    public static void addFriendToBcast(String friendNickname,
            String bcastNickname) throws WhatsAppException
    {
        if (friendNickname.equals(CONFIG.getCurrentUser().getNickname()))
        {
            throw new WhatsAppException(Config.CANT_ADD_YOURSELF_TO_BCAST);
        }
        if (!CONFIG.getCurrentUser().isFriend(friendNickname))
        {
            throw new WhatsAppException(Config.NOT_A_FRIEND);
        }
        if (!CONFIG.getCurrentUser().isBroadcastList(bcastNickname))
        {
            throw new WhatsAppException(String.
                    format(Config.BCAST_LIST_DOES_NOT_EXIST, bcastNickname));
        }
        if (CONFIG.getCurrentUser().
                isMemberOfBroadcastList(friendNickname, bcastNickname))
        {
            throw new WhatsAppException(Config.ALREADY_PRESENT);
        }
        Helper.
                getBroadcastListFromNickname(CONFIG.getCurrentUser().
                        getBroadcastLists(), bcastNickname).getMembers().
                add(friendNickname);
        CONFIG.getConsoleOutput().printf(Config.SUCCESSFULLY_ADDED);
    }

    /**
     * removes a friend from a broadcast list. Says SUCCESSFULLY_REMOVED if
     * removed
     *
     * @param friendNickname the friend nickname to remove from the list
     * @param bcastNickname the nickname of the list from which to remove the
     * friend
     * @throws WhatsAppException throw a new instance of this with one of these
     * messages: NOT_A_FRIEND (if friendNickname is not a friend),
     * BCAST_LIST_DOES_NOT_EXIST (if the broadcast list does not exist),
     * NOT_PART_OF_BCAST_LIST (if the friend is not a part of the list)
     */
    public static void removeFriendFromBcast(String friendNickname,
            String bcastNickname) throws WhatsAppException
    {
        //TODO
    }

    /**
     * A method to remove a broadcast list. Says BCAST_LIST_DOES_NOT_EXIST if
     * there is no such list to begin with and SUCCESSFULLY_REMOVED if removed.
     * Hint: use the removeBroadcastList method of the User class
     *
     * @param nickname the nickname of the broadcast list which is to be removed
     * from the currently logged in user
     * @throws WhatsAppException Simply pass the exception returned from the
     * removeBroadcastList method of the User class
     */
    public static void removeBroadcastcast(String nickname) throws WhatsAppException
    {
        //TODO
    }

    /**
     * Processes commands issued by the logged in user. Says INVALID_COMMAND for
     * anything not conforming to the syntax. This basically uses the rest of
     * the methods in this class. These methods throw either or both an instance
     * of WhatsAppException/WhatsAppRuntimeException. You ought to catch such
     * exceptions here and print the messages in them. Note that this method
     * does not throw any exceptions. Handle all exceptions by catch them here!
     *
     * @param command the command string issued by the user
     */
    public static void processCommand(String command)
    {
        try
        {
            switch (command.split(":")[0])
            {
                case "logout":
                    doLogout();
                    break;
                case "send message":
                    String nickname = command.
                            substring(command.indexOf(":") + 1, command.
                                    indexOf(",")).trim();
                    String message = command.
                            substring(command.indexOf("\"") + 1, command.trim().
                                    length());
                    sendMessage(nickname, message);
                    break;
                case "read messages unread from":
                    nickname = command.
                            substring(command.indexOf(":") + 1, command.trim().
                                    length()).trim();
                    readMessage(nickname, true);
                    break;
                case "read messages all from":
                    nickname = command.
                            substring(command.indexOf(":") + 1, command.trim().
                                    length()).trim();
                    readMessage(nickname, false);
                    break;
                case "read messages all":
                    readMessage(null, false);
                    break;
                case "read messages unread":
                    readMessage(null, true);
                    break;
                case "search fn":
                    String word = command.
                            substring(command.indexOf(":") + 1, command.trim().
                                    length()).trim();
                    search(word, true);
                    break;
                case "search ln":
                    word = command.
                            substring(command.indexOf(":") + 1, command.trim().
                                    length()).trim();
                    search(word, false);
                    break;
                case "add friend":
                    nickname = command.
                            substring(command.indexOf(":") + 1, command.trim().
                                    length()).trim();
                    addFriend(nickname);
                    break;
                case "remove friend":
                    nickname = command.
                            substring(command.indexOf(":") + 1, command.trim().
                                    length()).trim();
                    removeFriend(nickname);
                    break;
                case "add to bcast":
                    String nickname0 = command.
                            substring(command.indexOf(":") + 1, command.
                                    indexOf(",")).
                            trim();
                    String nickname1 = command.
                            substring(command.indexOf(",") + 1, command.trim().
                                    length()).
                            trim();
                    addFriendToBcast(nickname0, nickname1);
                    break;
                case "remove from bcast":
                    nickname0 = command.
                            substring(command.indexOf(":") + 1, command.
                                    indexOf(",")).
                            trim();
                    nickname1 = command.
                            substring(command.indexOf(",") + 1, command.trim().
                                    length()).
                            trim();
                    removeFriendFromBcast(nickname0, nickname1);
                    break;
                case "remove bcast":
                    nickname = command.
                            substring(command.indexOf(":") + 1, command.trim().
                                    length());
                    removeBroadcastcast(nickname);
                    break;
                default:
                    CONFIG.getConsoleOutput().
                            printf(Config.INVALID_COMMAND);
            }
        } catch (StringIndexOutOfBoundsException ex)
        {
            CONFIG.getConsoleOutput().
                    printf(Config.INVALID_COMMAND);
        } catch (WhatsAppException | WhatsAppRuntimeException ex)
        {
            CONFIG.getConsoleOutput().printf(ex.getMessage());
        }
    }

}
