/**
 */
package model.impl;

import java.lang.reflect.InvocationTargetException;

import model.Individu;
import model.ModelPackage;
import model.Partie;
import model.Personnage;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Partie</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class PartieImpl extends MinimalEObjectImpl.Container implements Partie {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PartieImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.PARTIE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void jouerTour() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void quitter() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void retDemandeConfirmation() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void confirmation(boolean reponse) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void sauvegarde(Individu joueur) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void afficherJoueur(int position, Personnage id) {
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
			case ModelPackage.PARTIE___JOUER_TOUR:
				jouerTour();
				return null;
			case ModelPackage.PARTIE___QUITTER:
				quitter();
				return null;
			case ModelPackage.PARTIE___RET_DEMANDE_CONFIRMATION:
				retDemandeConfirmation();
				return null;
			case ModelPackage.PARTIE___CONFIRMATION__BOOLEAN:
				confirmation((Boolean)arguments.get(0));
				return null;
			case ModelPackage.PARTIE___SAUVEGARDE__INDIVIDU:
				sauvegarde((Individu)arguments.get(0));
				return null;
			case ModelPackage.PARTIE___AFFICHER_JOUEUR__INT_PERSONNAGE:
				afficherJoueur((Integer)arguments.get(0), (Personnage)arguments.get(1));
				return null;
		}
		return super.eInvoke(operationID, arguments);
	}

} //PartieImpl
