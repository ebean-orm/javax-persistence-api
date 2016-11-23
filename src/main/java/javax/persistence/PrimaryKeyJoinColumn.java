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

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Specifies a primary key column that is used as a foreign key to join to another table.
 * <p>
 * It is used to join the primary table of an entity subclass in the {@link InheritanceType#JOINED JOINED}
 * mapping strategy to the primary table of its superclass; it is used within a {@link SecondaryTable}
 * annotation to join a secondary table to a primary table; and it may be used in a {@link OneToOne} mapping
 * in which the primary key of the referencing entity is used as a foreign key to the referenced entity.
 * <p>
 * If no <code>PrimaryKeyJoinColumn</code> annotation is specified for a subclass in the <code>JOINED</code>
 * mapping strategy, the foreign key columns are assumed to have the same names as the primary key columns of
 * the primary table of the superclass.
 * <p>
 * <pre>
 *
 *    Example: Customer and ValuedCustomer subclass
 *
 *    &#064;Entity
 *    &#064;Table(name="CUST")
 *    &#064;Inheritance(strategy=JOINED)
 *    &#064;DiscriminatorValue("CUST")
 *    public class Customer { ... }
 *
 *    &#064;Entity
 *    &#064;Table(name="VCUST")
 *    &#064;DiscriminatorValue("VCUST")
 *    &#064;PrimaryKeyJoinColumn(name="CUST_ID")
 *    public class ValuedCustomer extends Customer { ... }
 * </pre>
 *
 * @see SecondaryTable
 * @see Inheritance
 * @see OneToOne
 * @since Java Persistence 1.0
 */
@Target({TYPE, METHOD, FIELD})
@Retention(RUNTIME)
public @interface PrimaryKeyJoinColumn {

  /**
   * (Optional) The name of the primary key column of the current table. Defaults to the same name as the
   * primary key column of the primary table of the superclass (<code>JOINED</code> mapping strategy); the
   * same name as the primary key column of the primary table (<code>SecondaryTable</code> mapping); or the
   * same name as the primary key column for the table for the referencing entity (<code>OneToOne</code>
   * mapping).
   *
   * @return name
   */
  String name() default "";

  /**
   * (Optional) The name of the primary key column of the table being joined to. Defaults to the same name
   * as the primary key column of the primary table of the superclass (<code>JOINED</code> mapping
   * strategy); the same name as the primary key column of the primary table (<code>SecondaryTable</code>
   * mapping); or the same name as the primary key column for the table for the referencing entity (
   * <code>OneToOne</code> mapping).
   *
   * @return ref col name
   */
  String referencedColumnName() default "";

  /**
   * (Optional) The SQL fragment that is used when generating the DDL for the column. This should not be
   * specified for a <code>OneToOne</code> primary key association. Defaults to the generated SQL to create
   * a column of the inferred type.
   *
   * @return column def
   */
  String columnDefinition() default "";

  /**
   * (Optional) The foreign key constraint specification for the join column. This is used only if table
   * generation is in effect. Default is provider defined.
   *
   * @return The foreign key specification
   */
  ForeignKey foreignKey() default @ForeignKey();
}
