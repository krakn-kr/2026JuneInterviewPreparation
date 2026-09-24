package enume.usecase6;

import java.util.EnumSet;

public class PermissionsExample {
    public enum Permission { READ, WRITE, EXECUTE, DELETE }

    public static void main(String[] args) {
        // Creates a highly optimized set containing only READ and WRITE
        EnumSet<Permission> userRoles = EnumSet.of(Permission.READ, Permission.WRITE);

        if (userRoles.contains(Permission.WRITE)) {
            System.out.println("User can write files.");
        }
    }
}