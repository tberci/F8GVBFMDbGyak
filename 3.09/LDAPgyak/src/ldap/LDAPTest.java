package ldap;
import com.novell.ldap.LDAPException;
import ldap.Connection.ConnectionBuilder;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/*
public class LDAPTest {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        var ldapConnectionBuilder = new Connection.ConnectionBuilder("193.6.5.58",
                "ou=csop_HU,ou=ev2020,ou=meinfo,dc=maxcrc,dc=com", new String("H578").getBytes());
        LDAPConnection ldapConnection = new LDAPConnection();
        try {
            ldapConnection = ldapConnectionBuilder.build().getLdapConnection();
            System.out.println("Connected.");
        } catch (LDAPException e) {
            e.printStackTrace();
        }
        System.out.println("isConnected: " + ldapConnection.isConnected());
        System.out.println("isBound: " + ldapConnection.isBound());

        try {
            LDAPSearchResults searchResults = ldapConnection.search(
                    "cn=F8GVBF,ou=csop_HU,ou=ev2022,ou=meinfo,dc=maxcrc,dc=com", LDAPConnection.SCOPE_BASE, "", null,
                    false);
            while (searchResults.hasMore()) {
                try {
                    var next = searchResults.next();
                    System.out.println(next.getDN());
                    var attributeSet = next.getAttributeSet();
                    attributeSet.stream().forEach(a -> System.out.println(
                            "\t" + ((LDAPAttribute) a).getName() + "::" + ((LDAPAttribute) a).getStringValue()));

                    System.out.println("Filter for 'sn':");
                    attributeSet.stream().filter(a -> ((LDAPAttribute) a).getName().equals("sn"))
                            .forEach(a -> System.out.println("\t" + ((LDAPAttribute) a).getName() + "::"
                                    + ((LDAPAttribute) a).getStringValue()));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            ldapConnection.disconnect();
        } catch (LDAPException e) {
            e.printStackTrace();
        }

        System.out.println("After disconnect has been called:");
        System.out.println("isConnected: " + ldapConnection.isConnected());
        System.out.println("isBound: " + ldapConnection.isBound());
    }
}
*/


/* kilistázza a nodeokat.
public class LDAPTest {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        var ldapConnectionBuilder = new Connection.ConnectionBuilder("193.6.5.58",
                "ou=csop_HU,ou=ev2020,ou=meinfo,dc=maxcrc,dc=com", new String("").getBytes());
        LDAPConnection ldapConnection = new LDAPConnection();
        try {
            ldapConnection = ldapConnectionBuilder.build().getLdapConnection();
            System.out.println("Connected.");
        } catch (LDAPException e) {
            e.printStackTrace();
        }
        System.out.println("isConnected: " + ldapConnection.isConnected());
        System.out.println("isBound: " + ldapConnection.isBound());

        try {
            LDAPSearchResults searchResults = ldapConnection.search("ou=csop_HU,ou=ev2022,ou=meinfo,dc=maxcrc,dc=com",
                    LDAPConnection.SCOPE_ONE, "", null, false);
            while (searchResults.hasMore()) {
                try {
                    var next = searchResults.next();
                    System.out.println(next.getDN());
                    var attributeSet = next.getAttributeSet();
                    attributeSet.stream().forEach(a -> System.out.println(
                            "\t" + ((LDAPAttribute) a).getName() + "::" + ((LDAPAttribute) a).getStringValue()));

                    System.out.println("Filter for 'sn':");
                    attributeSet.stream().filter(a -> ((LDAPAttribute) a).getName().equals("sn"))
                            .forEach(a -> System.out.println("\t" + ((LDAPAttribute) a).getName() + "::"
                                    + ((LDAPAttribute) a).getStringValue()));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            ldapConnection.disconnect();
        } catch (LDAPException e) {
            e.printStackTrace();
        }

        System.out.println("After disconnect has been called:");
        System.out.println("isConnected: " + ldapConnection.isConnected());
        System.out.println("isBound: " + ldapConnection.isBound());
    }
}
*/

/* tree list
public class LDAPTest {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        var ldapConnectionBuilder = new Connection.ConnectionBuilder("193.6.5.58",
                "ou=csop_HU,ou=ev2020,ou=meinfo,dc=maxcrc,dc=com", new String("").getBytes());
        LDAPConnection ldapConnection = new LDAPConnection();
        try {
            ldapConnection = ldapConnectionBuilder.build().getLdapConnection();
            System.out.println("Connected.");
        } catch (LDAPException e) {
            e.printStackTrace();
        }
        System.out.println("isConnected: " + ldapConnection.isConnected());
        System.out.println("isBound: " + ldapConnection.isBound());

        try {
            LDAPSearchResults searchResults = ldapConnection.search("ou=meinfo,dc=maxcrc,dc=com",
                    LDAPConnection.SCOPE_SUB, "objectclass=person", null, false);
            while (searchResults.hasMore()) {
                try {
                    var next = searchResults.next();
                    System.out.println(next.getDN());
                    var attributeSet = next.getAttributeSet();
                    attributeSet.stream().filter(a -> ((LDAPAttribute) a).getName().equals("sn"))
                            .forEach(a -> System.out.println("\t" + ((LDAPAttribute) a).getName() + "::"
                                    + ((LDAPAttribute) a).getStringValue()));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            ldapConnection.disconnect();
        } catch (LDAPException e) {
            e.printStackTrace();
        }

        System.out.println("After disconnect has been called:");
        System.out.println("isConnected: " + ldapConnection.isConnected());
        System.out.println("isBound: " + ldapConnection.isBound());
    }
}



//good lesz

*/




//ldap authorization
public class LDAPTest {

    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        final String baseDN = "ou=csop_HU,ou=ev2022,ou=meinfo,dc=maxcrc,dc=com";
        final String neptune = readNCode();
        final String passwd = readPasswd();

        boolean connected = ldapAuth("193.6.5.58", baseDN, neptune, passwd);

        if (connected) {
            System.out.println("You are now root!");
        } else {
            System.out.println("Better luck next time, pal!");

        }
    }

    public static boolean ldapAuth(String host, String baseDN, String neptune, String passwd) {
        try {
            ConnectionBuilder ldapConnectionBuilder = new ConnectionBuilder(host, "cn=" + neptune + "," + baseDN,
                    passwd.getBytes());
            ldapConnectionBuilder.build();
            return true;
        } catch (LDAPException e) {
            return false;
        }
    }

    public static String readNCode() {
        boolean ok;
        String ncode = new String();
        Pattern ncodePattern = Pattern.compile("^[a-zA-Z\\d]{6}$", Pattern.CASE_INSENSITIVE);
        do {
            ok = true;
            System.out.println("Enter your Neptune code: ");
            ncode = input.nextLine();
            Matcher matcher = ncodePattern.matcher(ncode);
            ok = matcher.find();
            if (!ok) {
                System.out.println("Bad input format!");
            }
        } while (!ok);
        	return ncode;
        
    }

    public static String readPasswd() {
        String passwd;
        System.out.println("Enter your password: ");
        passwd = input.nextLine();
        return passwd;
    }
}
