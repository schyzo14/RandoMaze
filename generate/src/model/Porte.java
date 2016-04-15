/**
 */
package model;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Porte</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link model.Porte#getIdPorte <em>Id Porte</em>}</li>
 *   <li>{@link model.Porte#getSituationPorte <em>Situation Porte</em>}</li>
 * </ul>
 * </p>
 *
 * @see model.ModelPackage#getPorte()
 * @model
 * @generated
 */
public interface Porte extends EObject {
	/**
	 * Returns the value of the '<em><b>Id Porte</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id Porte</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id Porte</em>' attribute.
	 * @see #setIdPorte(int)
	 * @see model.ModelPackage#getPorte_IdPorte()
	 * @model dataType="org.eclipse.uml2.types.Integer" required="true" ordered="false"
	 * @generated
	 */
	int getIdPorte();

	/**
	 * Sets the value of the '{@link model.Porte#getIdPorte <em>Id Porte</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id Porte</em>' attribute.
	 * @see #getIdPorte()
	 * @generated
	 */
	void setIdPorte(int value);

	/**
	 * Returns the value of the '<em><b>Situation Porte</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Situation Porte</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Situation Porte</em>' attribute.
	 * @see #setSituationPorte(String)
	 * @see model.ModelPackage#getPorte_SituationPorte()
	 * @model dataType="org.eclipse.uml2.types.String" required="true" ordered="false"
	 * @generated
	 */
	String getSituationPorte();

	/**
	 * Sets the value of the '{@link model.Porte#getSituationPorte <em>Situation Porte</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Situation Porte</em>' attribute.
	 * @see #getSituationPorte()
	 * @generated
	 */
	void setSituationPorte(String value);

} // Porte
