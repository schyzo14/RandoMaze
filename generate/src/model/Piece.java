/**
 */
package model;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Piece</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link model.Piece#getIdPiece <em>Id Piece</em>}</li>
 *   <li>{@link model.Piece#getNomServeur <em>Nom Serveur</em>}</li>
 *   <li>{@link model.Piece#getPositionX <em>Position X</em>}</li>
 *   <li>{@link model.Piece#getPositionY <em>Position Y</em>}</li>
 * </ul>
 * </p>
 *
 * @see model.ModelPackage#getPiece()
 * @model
 * @generated
 */
public interface Piece extends EObject {
	/**
	 * Returns the value of the '<em><b>Id Piece</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id Piece</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id Piece</em>' attribute.
	 * @see #setIdPiece(int)
	 * @see model.ModelPackage#getPiece_IdPiece()
	 * @model dataType="org.eclipse.uml2.types.Integer" required="true" ordered="false"
	 * @generated
	 */
	int getIdPiece();

	/**
	 * Sets the value of the '{@link model.Piece#getIdPiece <em>Id Piece</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id Piece</em>' attribute.
	 * @see #getIdPiece()
	 * @generated
	 */
	void setIdPiece(int value);

	/**
	 * Returns the value of the '<em><b>Nom Serveur</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nom Serveur</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nom Serveur</em>' attribute.
	 * @see #setNomServeur(String)
	 * @see model.ModelPackage#getPiece_NomServeur()
	 * @model dataType="org.eclipse.uml2.types.String" required="true" ordered="false"
	 * @generated
	 */
	String getNomServeur();

	/**
	 * Sets the value of the '{@link model.Piece#getNomServeur <em>Nom Serveur</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Nom Serveur</em>' attribute.
	 * @see #getNomServeur()
	 * @generated
	 */
	void setNomServeur(String value);

	/**
	 * Returns the value of the '<em><b>Position X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Position X</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Position X</em>' attribute.
	 * @see #setPositionX(int)
	 * @see model.ModelPackage#getPiece_PositionX()
	 * @model dataType="org.eclipse.uml2.types.Integer" required="true" ordered="false"
	 * @generated
	 */
	int getPositionX();

	/**
	 * Sets the value of the '{@link model.Piece#getPositionX <em>Position X</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Position X</em>' attribute.
	 * @see #getPositionX()
	 * @generated
	 */
	void setPositionX(int value);

	/**
	 * Returns the value of the '<em><b>Position Y</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Position Y</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Position Y</em>' attribute.
	 * @see #setPositionY(int)
	 * @see model.ModelPackage#getPiece_PositionY()
	 * @model dataType="org.eclipse.uml2.types.Integer" required="true" ordered="false"
	 * @generated
	 */
	int getPositionY();

	/**
	 * Sets the value of the '{@link model.Piece#getPositionY <em>Position Y</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Position Y</em>' attribute.
	 * @see #getPositionY()
	 * @generated
	 */
	void setPositionY(int value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model porteSortieRequired="true" porteSortieOrdered="false" pieceRequired="true" pieceOrdered="false" userRequired="true" userOrdered="false"
	 * @generated
	 */
	void fuir(Porte porteSortie, Piece piece, Personnage user);

} // Piece
