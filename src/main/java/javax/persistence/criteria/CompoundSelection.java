/*
 * Copyright (c) 2008, 2009, 2011 Oracle, Inc. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 and Eclipse Distribution License v. 1.0
 * which accompanies this distribution.  The Eclipse Public License is available
 * at http://www.eclipse.org/legal/epl-v10.html and the Eclipse Distribution License
 * is available at http://www.eclipse.org/org/documents/edl-v10.php.
 */
package javax.persistence.criteria;

/**
 * The <code>CompoundSelection</code> interface defines a compound selection item
 * (tuple, array, or result of constructor).
 *
 * @param <X> the type of the selection item
 * @since Java Persistence 2.0
 */
public interface CompoundSelection<X> extends Selection<X> {
}
