package ch.ismail.qrcodes.security;

import com.google.common.collect.Sets;

import java.util.Set;

import static ch.ismail.qrcodes.security.AppUserPermission.*;

public enum AppUserRole {
    USER(Sets.newHashSet()),
    ADMIN(Sets.newHashSet(QR_READ, QR_WRITE, USER_READ, USER_WRITE));

    private final Set<AppUserPermission> permissions;

    AppUserRole(Set<AppUserPermission> permissions) {
        this.permissions = permissions;
    }

    public Set<AppUserPermission> getPermissions() {
        return permissions;
    }
}
