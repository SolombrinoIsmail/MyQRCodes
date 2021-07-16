package ch.ismail.qrcodes.security;

public enum AppUserPermission {
    USER_READ("user:read"),
    USER_WRITE("user:write"),
    QR_READ("qr:read"),
    QR_WRITE("qr:write");

    private final String permission;

    AppUserPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
