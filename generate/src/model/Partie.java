/**
 */
package model;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Partie</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see model.ModelPackage#getPartie()
 * @model
 * @generated
 */
public interface Partie extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void jouerTour();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void quitter();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void retDemandeConfirmation();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model reponseDataType="org.eclipse.uml2.types.Boolean" reponseRequired="true" reponseOrdered="false"
	 * @generated
	 */
	void confirmation(boolean reponse);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model joueurRequired="true" joueurOrdered="false"
	 * @generated
	 */
	void sauvegarde(Individu joueur);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model positionDataType="org.eclipse.uml2.types.Integer" positionRequired="true" positionOrdered="false" idRequired="true" idOrdered="false"
	 * @generated
	 */
	void afficherJoueur(int position, Personnage id);

} // Partie
