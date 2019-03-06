/*******************************************************************************
 * Copyright (c) 2019 University of Illinois and others.  All rights reserved.
 * This program and the accompanying materials are made available under the
 * terms of the Mozilla Public License v2.0 which accompanies this distribution,
 * and is available at https://www.mozilla.org/en-US/MPL/2.0/
 *
 *   Contributors:
 *   Nathan Tolbert
 *******************************************************************************/

package edu.illinois.ncsa.incore.common.auth;

import java.util.HashSet;
import java.util.Set;

public class MockAuthorizer implements IAuthorizer{

    private boolean canRead = false;
    private boolean canWrite = false;

    public MockAuthorizer(boolean canRead, boolean canWrite) {
        this.canRead = canRead;
        this.canWrite = canWrite;
    }

    @Override
    public Set<PrivilegeLevel> getPrivilegesFor(String user, Privileges spec) {
        Set<PrivilegeLevel> privs = new HashSet<>();
        if (canRead) {
            privs.add(PrivilegeLevel.READ);
        }
        if (canWrite) {
            privs.add(PrivilegeLevel.WRITE);
        }
        return privs;
    }

    @Override
    public Set<PrivilegeLevel> getPrivilegesFor(String user, String privilegeSpecJson) {
        Set<PrivilegeLevel> privs = new HashSet<>();
        if (canRead) {
            privs.add(PrivilegeLevel.READ);
        }
        if (canWrite) {
            privs.add(PrivilegeLevel.WRITE);
        }
        return privs;
    }

    @Override
    public boolean canRead(String user, Privileges privileges) {
        return canRead;
    }

    @Override
    public boolean canRead(String user, String privilegeSpecJson) {
        return canRead;
    }

    @Override
    public boolean canWrite(String user, Privileges privileges) {
        return canWrite;
    }

    @Override
    public boolean canWrite(String user, String privilegeSpecJson) {
        return canWrite;
    }
}