/**
 */
package model;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Personnage</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see model.ModelPackage#getPersonnage()
 * @model
 * @generated
 */
public interface Personnage extends Individu {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model nomDataType="org.eclipse.uml2.types.String" nomRequired="true" nomOrdered="false"
	 * @generated
	 */
	void creerPersonnage(String nom);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	String toString();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model persoRequired="true" persoOrdered="false" pieceRequired="true" pieceOrdered="false" pvDataType="org.eclipse.uml2.types.Integer" pvRequired="true" pvOrdered="false"
	 * @generated
	 */
	void save_Perso(Personnage perso, Piece piece, int pv);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model nomDataType="org.eclipse.uml2.types.String" nomRequired="true" nomOrdered="false" idUtilisateurDataType="org.eclipse.uml2.types.Integer" idUtilisateurRequired="true" idUtilisateurOrdered="false"
	 * @generated
	 */
	void creerPersonnage(String nom, int idUtilisateur);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model salleRequired="true" salleOrdered="false" porteRequired="true" porteOrdered="false"
	 * @generated
	 */
	void move(Piece salle, Porte porte);

} // Personnage
