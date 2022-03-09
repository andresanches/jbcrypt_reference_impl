import org.mindrot.jbcrypt.BCrypt;

public class Main {
  
  private static String encryptData(final String plainText) {
    System.out.println("Plain text: " + plainText);

    final String salt = BCrypt.gensalt();
    System.out.println("Salt: " + salt);

    // Produce the hash
    final String fullHash = BCrypt.hashpw(plainText, salt);
    System.out.println("Full hash: " + fullHash);

    // Note: The salt is prepended to the hash. Removing it from the stored
    //   hash can be useful when using the "salt & pepper" technique.
    final String hashWithoutSalt = fullHash.replace(salt, "");
    System.out.println("Hash without salt: " + hashWithoutSalt);

    return hashWithoutSalt;
  }

  public static void main(String[] args) {
    encryptData("Foo bar baz qux");
  }
}
