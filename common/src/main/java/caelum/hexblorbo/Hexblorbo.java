package caelum.hexblorbo;

import net.minecraft.resources.ResourceLocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ResourceBundle;

public final class Hexblorbo {
    public static final String MOD_ID = "hexblorbo";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    public static final MessageDigest digest;

    static {
        try {
            digest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public static ResourceLocation modLoc(String location) {
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, location);
    }

    public static void init() {
        // Write common init code here.
    }
}
