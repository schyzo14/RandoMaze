/**
 */
package model.util;

import model.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see model.ModelPackage
 * @generated
 */
public class ModelSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ModelPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelSwitch() {
		if (modelPackage == null) {
			modelPackage = ModelPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @parameter ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case ModelPackage.INDIVIDU: {
				Individu individu = (Individu)theEObject;
				T result = caseIndividu(individu);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.PERSONNAGE: {
				Personnage personnage = (Personnage)theEObject;
				T result = casePersonnage(personnage);
				if (result == null) result = caseIndividu(personnage);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.PIECE: {
				Piece piece = (Piece)theEObject;
				T result = casePiece(piece);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.PORTE: {
				Porte porte = (Porte)theEObject;
				T result = casePorte(porte);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.MONSTRE: {
				Monstre monstre = (Monstre)theEObject;
				T result = caseMonstre(monstre);
				if (result == null) result = caseIndividu(monstre);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.PARTIE: {
				Partie partie = (Partie)theEObject;
				T result = casePartie(partie);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.LABYRINTHE_IMPL: {
				LabyrintheImpl labyrintheImpl = (LabyrintheImpl)theEObject;
				T result = caseLabyrintheImpl(labyrintheImpl);
				if (result == null) result = caseUnicastRemoteObject(labyrintheImpl);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.UNICAST_REMOTE_OBJECT: {
				UnicastRemoteObject unicastRemoteObject = (UnicastRemoteObject)theEObject;
				T result = caseUnicastRemoteObject(unicastRemoteObject);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.LABYRINTHE: {
				Labyrinthe labyrinthe = (Labyrinthe)theEObject;
				T result = caseLabyrinthe(labyrinthe);
				if (result == null) result = caseRemote(labyrinthe);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.REMOTE: {
				Remote remote = (Remote)theEObject;
				T result = caseRemote(remote);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.UTILISATEUR: {
				Utilisateur utilisateur = (Utilisateur)theEObject;
				T result = caseUtilisateur(utilisateur);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Individu</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Individu</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIndividu(Individu object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Personnage</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Personnage</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePersonnage(Personnage object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Piece</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Piece</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePiece(Piece object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Porte</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Porte</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePorte(Porte object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Monstre</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Monstre</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMonstre(Monstre object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Partie</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Partie</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePartie(Partie object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Labyrinthe Impl</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Labyrinthe Impl</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLabyrintheImpl(LabyrintheImpl object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Unicast Remote Object</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Unicast Remote Object</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUnicastRemoteObject(UnicastRemoteObject object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Labyrinthe</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Labyrinthe</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLabyrinthe(Labyrinthe object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Remote</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Remote</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRemote(Remote object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Utilisateur</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Utilisateur</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUtilisateur(Utilisateur object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //ModelSwitch
