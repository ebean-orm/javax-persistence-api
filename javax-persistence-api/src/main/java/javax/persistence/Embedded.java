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
 * Specifies a persistent field or property of an entity whose
 * value is an instance of an embeddable class. The embeddable
 * class must be annotated as {@link Embeddable}.
 * <p>
 * <p> The <code>AttributeOverride</code>, <code>AttributeOverrides</code>,
 * <code>AssociationOverride</code>, and <code>AssociationOverrides</code>
 * annotations may be used to override mappings declared or defaulted
 * by the embeddable class.
 * <p>
 * <pre>
 *   Example:
 *
 *   &#064;Embedded
 *   &#064;AttributeOverrides({
 *       &#064;AttributeOverride(name="startDate", column=&#064;Column("EMP_START")),
 *       &#064;AttributeOverride(name="endDate", column=&#064;Column("EMP_END"))
 *   })
 *   public EmploymentPeriod getEmploymentPeriod() { ... }
 * </pre>
 *
 * @see Embeddable
 * @see AttributeOverride
 * @see AttributeOverrides
 * @see AssociationOverride
 * @see AssociationOverrides
 * @since Java Persistence 1.0
 */
@Target({FIELD})
@Retention(RUNTIME)
public @interface Embedded {

  /**
   * WARNING: This is an Ebean extension (not yet part of JPA standard, refer to JPA_SPEC-23).
   * <p>
   * When specified all the properties in the embedded bean have a prefix applied to their DB column name.
   * </p>
   * <h3>Example:</h3>
   * <p/>
   * <pre>{@code
   *
   *  @Entity
   *  public class Invoice {
   *    ...
   *
   *    @Embedded(prefix="ship_")
   *    Address shipAddress;
   *
   *    @Embedded(prefix="bill_")
   *    Address billAddress;
   *
   * }</pre>
   * <p>
   * Without this extension we need to specify AttributeOverride on each property like:
   * </p>
   * <pre>{@code
   *
   *  @Entity
   *  public class Invoice {
   *    ...
   *
   *    @Embedded
   *    @AttributeOverride(name = "street", column = @Column(name = "ship_street"))
   *    @AttributeOverride(name = "suburb", column = @Column(name = "ship_suburb"))
   *    @AttributeOverride(name = "city", column = @Column(name = "ship_city"))
   *    @AttributeOverride(name = "status", column = @Column(name = "ship_status"))
   *    Address shipAddress;
   *
   *
   *    @Embedded
   *    @AttributeOverride(name = "street", column = @Column(name = "bill_street"))
   *    @AttributeOverride(name = "suburb", column = @Column(name = "bill_suburb"))
   *    @AttributeOverride(name = "city", column = @Column(name = "bill_city"))
   *    @AttributeOverride(name = "status", column = @Column(name = "bill_status"))
   *    Address billAddress;
   *
   * }</pre>
   */
  String prefix() default "";
}
