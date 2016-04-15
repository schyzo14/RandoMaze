/**
 */
package model;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Utilisateur</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link model.Utilisateur#getIdUtilisateur <em>Id Utilisateur</em>}</li>
 *   <li>{@link model.Utilisateur#getNomUtilisateur <em>Nom Utilisateur</em>}</li>
 *   <li>{@link model.Utilisateur#getMdpUtilisateur <em>Mdp Utilisateur</em>}</li>
 * </ul>
 * </p>
 *
 * @see model.ModelPackage#getUtilisateur()
 * @model
 * @generated
 */
public interface Utilisateur extends EObject {
	/**
	 * Returns the value of the '<em><b>Id Utilisateur</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id Utilisateur</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id Utilisateur</em>' attribute.
	 * @see #setIdUtilisateur(int)
	 * @see model.ModelPackage#getUtilisateur_IdUtilisateur()
	 * @model dataType="org.eclipse.uml2.types.Integer" required="true" ordered="false"
	 * @generated
	 */
	int getIdUtilisateur();

	/**
	 * Sets the value of the '{@link model.Utilisateur#getIdUtilisateur <em>Id Utilisateur</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id Utilisateur</em>' attribute.
	 * @see #getIdUtilisateur()
	 * @generated
	 */
	void setIdUtilisateur(int value);

	/**
	 * Returns the value of the '<em><b>Nom Utilisateur</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nom Utilisateur</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nom Utilisateur</em>' attribute.
	 * @see #setNomUtilisateur(String)
	 * @see model.ModelPackage#getUtilisateur_NomUtilisateur()
	 * @model dataType="org.eclipse.uml2.types.String" required="true" ordered="false"
	 * @generated
	 */
	String getNomUtilisateur();

	/**
	 * Sets the value of the '{@link model.Utilisateur#getNomUtilisateur <em>Nom Utilisateur</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Nom Utilisateur</em>' attribute.
	 * @see #getNomUtilisateur()
	 * @generated
	 */
	void setNomUtilisateur(String value);

	/**
	 * Returns the value of the '<em><b>Mdp Utilisateur</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mdp Utilisateur</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mdp Utilisateur</em>' attribute.
	 * @see #setMdpUtilisateur(String)
	 * @see model.ModelPackage#getUtilisateur_MdpUtilisateur()
	 * @model dataType="org.eclipse.uml2.types.String" required="true" ordered="false"
	 * @generated
	 */
	String getMdpUtilisateur();

	/**
	 * Sets the value of the '{@link model.Utilisateur#getMdpUtilisateur <em>Mdp Utilisateur</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mdp Utilisateur</em>' attribute.
	 * @see #getMdpUtilisateur()
	 * @generated
	 */
	void setMdpUtilisateur(String value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model idDataType="org.eclipse.uml2.types.String" idRequired="true" idOrdered="false" mdpDataType="org.eclipse.uml2.types.String" mdpRequired="true" mdpOrdered="false"
	 * @generated
	 */
	void seConnecter(String id, String mdp);

} // Utilisateur
