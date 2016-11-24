# javax-persistence-api

This exists due to the JCP not provided an official JPA API jar via maven central. This definition of JPA API intended for 
use with Ebean ORM and is compiled to Java 8.

Refer to the JPA spec at http://java.net/projects/jpa-spec/downloads

## Differences from JPA standard

- Add @Repeatable to annotations that can be repeated (JPA_SPEC-115)
https://github.com/ebean-orm/javax-persistence-api/issues/1

- Add prefix mechanism to @Embedded (as per JPA_SPEC-23) 
https://github.com/ebean-orm/javax-persistence-api/issues/2


## Legal

Takes the published API in the JPA specification(s), so consequently we apply the following license.

Copyright (c) 2008, 2009, 2011 Oracle, Inc. All rights reserved.

This program and the accompanying materials are made available under the
terms of the Eclipse Public License v1.0 and Eclipse Distribution License v. 1.0
which accompanies this distribution.  The Eclipse Public License is available
at http://www.eclipse.org/legal/epl-v10.html and the Eclipse Distribution License
is available at http://www.eclipse.org/org/documents/edl-v10.php.

