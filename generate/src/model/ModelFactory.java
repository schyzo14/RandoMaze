/**
 */
package model;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see model.ModelPackage
 * @generated
 */
public interface ModelFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ModelFactory eINSTANCE = model.impl.ModelFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Individu</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Individu</em>'.
	 * @generated
	 */
	Individu createIndividu();

	/**
	 * Returns a new object of class '<em>Personnage</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Personnage</em>'.
	 * @generated
	 */
	Personnage createPersonnage();

	/**
	 * Returns a new object of class '<em>Piece</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Piece</em>'.
	 * @generated
	 */
	Piece createPiece();

	/**
	 * Returns a new object of class '<em>Porte</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Porte</em>'.
	 * @generated
	 */
	Porte createPorte();

	/**
	 * Returns a new object of class '<em>Monstre</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Monstre</em>'.
	 * @generated
	 */
	Monstre createMonstre();

	/**
	 * Returns a new object of class '<em>Partie</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Partie</em>'.
	 * @generated
	 */
	Partie createPartie();

	/**
	 * Returns a new object of class '<em>Labyrinthe Impl</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Labyrinthe Impl</em>'.
	 * @generated
	 */
	Labyrinthe createLabyrinthe();

	/**
	 * Returns a new object of class '<em>Utilisateur</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Utilisateur</em>'.
	 * @generated
	 */
	Utilisateur createUtilisateur();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ModelPackage getModelPackage();

} //ModelFactory
