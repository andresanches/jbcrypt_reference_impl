import org.mindrot.jbcrypt.BCrypt;

public class Main {
  /**
    * SALT TO BE STORED AS ADMIRAL SECRET.
    *
    * Generated using `BCrypt.gensalt()`.
    */
  private static final String SALT = "$2a$10$/sYCepb03BtaCFGbgAe7ZO";

  /**
    * Perform encryption of data to be stored
    */
  private static String encryptData(final String plainText) {
    System.out.println("Salt (stored as Admiral Secret): " + SALT);

    /* Produce the hash which contains the salt. */
    final String fullHash = BCrypt.hashpw(plainText, SALT);
    System.out.println("Full hash: " + fullHash);

    /* Remove the salt from the hash. THIS IS WHAT WE'LL STORE IN CASSANDRA */
    final String hashWithoutSalt = fullHash.replace(SALT, "");
    System.out.println("Hash without salt to store in cassandra: " + hashWithoutSalt);

    return hashWithoutSalt;
  }

  private static boolean checkEncryptedMatch(final String plainText, final String encryptedText) {
    /* Prepend the salt so that bcrypt's checkpw works */
    final String hashToCheck = SALT + encryptedText;
    return BCrypt.checkpw(plainText, hashToCheck);
  }

  public static void main(String[] args) {
    final String plainText = "whatsapp:+1234567890";
    System.out.println("Plain text: " + plainText);

    final String encryptedText = encryptData(plainText);

    final boolean happyPathCheck = checkEncryptedMatch("whatsapp:+1234567890", encryptedText);
    System.out.println("\nChecking happy path. Expected: true. Actual: " + happyPathCheck);
    
    final boolean wrongCheck = checkEncryptedMatch("wrong value", encryptedText);
    System.out.println("Checking wrong string. Expected: false. Actual: " + wrongCheck);
  }
}
