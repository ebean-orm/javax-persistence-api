/*
 * Copyright (c) 2008, 2009, 2011 Oracle, Inc. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 and Eclipse Distribution License v. 1.0
 * which accompanies this distribution.  The Eclipse Public License is available
 * at http://www.eclipse.org/legal/epl-v10.html and the Eclipse Distribution License
 * is available at http://www.eclipse.org/org/documents/edl-v10.php.
 */
package javax.persistence;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Applied to a persistent field or property of an entity
 * class or mapped superclass to denote a composite primary
 * key that is an embeddable class. The embeddable class
 * must be annotated as {@link Embeddable}.
 * <p>
 * <p> There must be only one <code>EmbeddedId</code> annotation and
 * no <code>Id</code> annotation when the <code>EmbeddedId</code> annotation is used.
 * <p>
 * <p> The {@link AttributeOverride} annotation may be used to override
 * the column mappings declared within the embeddable class.
 * <p>
 * <p> The {@link MapsId} annotation may be used in conjunction
 * with the <code>EmbeddedId</code> annotation to specify a derived
 * primary key.
 * <p>
 * <p> If the entity has a derived primary key, the
 * <code>AttributeOverride</code> annotation may only be used to
 * override those attributes of the embedded id that do not correspond
 * to the relationship to the parent entity.
 * <p>
 * <p> Relationship mappings defined within an embedded id class are not supported.
 * <p>
 * <pre>
 *    Example 1:
 *
 *    &#064;EmbeddedId
 *    protected EmployeePK empPK;
 *
 *
 *    Example 2:
 *
 *    &#064;Embeddable
 *    public class DependentId {
 *       String name;
 *       EmployeeId empPK;   // corresponds to primary key type of Employee
 *    }
 *
 *    &#064;Entity
 *    public class Dependent {
 *       // default column name for "name" attribute is overridden
 *       &#064;AttributeOverride(name="name", &#064;Column(name="dep_name"))
 *       &#064;EmbeddedId DependentId id;
 *       ...
 *       &#064;MapsId("empPK")
 *       &#064;ManyToOne Employee emp;
 *    }
 * </pre>
 *
 * @see Embeddable
 * @see MapsId
 * @since Java Persistence 1.0
 */
@Target({FIELD})
@Retention(RUNTIME)
public @interface EmbeddedId {
}