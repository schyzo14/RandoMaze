/**
 */
package model.impl;

import java.lang.reflect.InvocationTargetException;

import model.ModelPackage;
import model.Personnage;
import model.Piece;
import model.Porte;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Personnage</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class PersonnageImpl extends IndividuImpl implements Personnage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PersonnageImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.PERSONNAGE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void creerPersonnage(String nom) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String toString() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void save_Perso(Personnage perso, Piece piece, int pv) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void creerPersonnage(String nom, int idUtilisateur) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void move(Piece salle, Porte porte) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case ModelPackage.PERSONNAGE___CREER_PERSONNAGE__STRING:
				creerPersonnage((String)arguments.get(0));
				return null;
			case ModelPackage.PERSONNAGE___TO_STRING:
				toString();
				return null;
			case ModelPackage.PERSONNAGE___SAVE_PERSO__PERSONNAGE_PIECE_INT:
				save_Perso((Personnage)arguments.get(0), (Piece)arguments.get(1), (Integer)arguments.get(2));
				return null;
			case ModelPackage.PERSONNAGE___CREER_PERSONNAGE__STRING_INT:
				creerPersonnage((String)arguments.get(0), (Integer)arguments.get(1));
				return null;
			case ModelPackage.PERSONNAGE___MOVE__PIECE_PORTE:
				move((Piece)arguments.get(0), (Porte)arguments.get(1));
				return null;
		}
		return super.eInvoke(operationID, arguments);
	}

} //PersonnageImpl
