/**
 */
package model.impl;

import java.lang.reflect.InvocationTargetException;

import model.ModelPackage;
import model.Utilisateur;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Utilisateur</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link model.impl.UtilisateurImpl#getIdUtilisateur <em>Id Utilisateur</em>}</li>
 *   <li>{@link model.impl.UtilisateurImpl#getNomUtilisateur <em>Nom Utilisateur</em>}</li>
 *   <li>{@link model.impl.UtilisateurImpl#getMdpUtilisateur <em>Mdp Utilisateur</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class UtilisateurImpl extends MinimalEObjectImpl.Container implements Utilisateur {
	/**
	 * The default value of the '{@link #getIdUtilisateur() <em>Id Utilisateur</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIdUtilisateur()
	 * @generated
	 * @ordered
	 */
	protected static final int ID_UTILISATEUR_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getIdUtilisateur() <em>Id Utilisateur</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIdUtilisateur()
	 * @generated
	 * @ordered
	 */
	protected int idUtilisateur = ID_UTILISATEUR_EDEFAULT;

	/**
	 * The default value of the '{@link #getNomUtilisateur() <em>Nom Utilisateur</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNomUtilisateur()
	 * @generated
	 * @ordered
	 */
	protected static final String NOM_UTILISATEUR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNomUtilisateur() <em>Nom Utilisateur</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNomUtilisateur()
	 * @generated
	 * @ordered
	 */
	protected String nomUtilisateur = NOM_UTILISATEUR_EDEFAULT;

	/**
	 * The default value of the '{@link #getMdpUtilisateur() <em>Mdp Utilisateur</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMdpUtilisateur()
	 * @generated
	 * @ordered
	 */
	protected static final String MDP_UTILISATEUR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMdpUtilisateur() <em>Mdp Utilisateur</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMdpUtilisateur()
	 * @generated
	 * @ordered
	 */
	protected String mdpUtilisateur = MDP_UTILISATEUR_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UtilisateurImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.UTILISATEUR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getIdUtilisateur() {
		return idUtilisateur;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIdUtilisateur(int newIdUtilisateur) {
		int oldIdUtilisateur = idUtilisateur;
		idUtilisateur = newIdUtilisateur;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.UTILISATEUR__ID_UTILISATEUR, oldIdUtilisateur, idUtilisateur));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getNomUtilisateur() {
		return nomUtilisateur;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNomUtilisateur(String newNomUtilisateur) {
		String oldNomUtilisateur = nomUtilisateur;
		nomUtilisateur = newNomUtilisateur;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.UTILISATEUR__NOM_UTILISATEUR, oldNomUtilisateur, nomUtilisateur));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMdpUtilisateur() {
		return mdpUtilisateur;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMdpUtilisateur(String newMdpUtilisateur) {
		String oldMdpUtilisateur = mdpUtilisateur;
		mdpUtilisateur = newMdpUtilisateur;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.UTILISATEUR__MDP_UTILISATEUR, oldMdpUtilisateur, mdpUtilisateur));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void seConnecter(String id, String mdp) {
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
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ModelPackage.UTILISATEUR__ID_UTILISATEUR:
				return getIdUtilisateur();
			case ModelPackage.UTILISATEUR__NOM_UTILISATEUR:
				return getNomUtilisateur();
			case ModelPackage.UTILISATEUR__MDP_UTILISATEUR:
				return getMdpUtilisateur();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ModelPackage.UTILISATEUR__ID_UTILISATEUR:
				setIdUtilisateur((Integer)newValue);
				return;
			case ModelPackage.UTILISATEUR__NOM_UTILISATEUR:
				setNomUtilisateur((String)newValue);
				return;
			case ModelPackage.UTILISATEUR__MDP_UTILISATEUR:
				setMdpUtilisateur((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ModelPackage.UTILISATEUR__ID_UTILISATEUR:
				setIdUtilisateur(ID_UTILISATEUR_EDEFAULT);
				return;
			case ModelPackage.UTILISATEUR__NOM_UTILISATEUR:
				setNomUtilisateur(NOM_UTILISATEUR_EDEFAULT);
				return;
			case ModelPackage.UTILISATEUR__MDP_UTILISATEUR:
				setMdpUtilisateur(MDP_UTILISATEUR_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ModelPackage.UTILISATEUR__ID_UTILISATEUR:
				return idUtilisateur != ID_UTILISATEUR_EDEFAULT;
			case ModelPackage.UTILISATEUR__NOM_UTILISATEUR:
				return NOM_UTILISATEUR_EDEFAULT == null ? nomUtilisateur != null : !NOM_UTILISATEUR_EDEFAULT.equals(nomUtilisateur);
			case ModelPackage.UTILISATEUR__MDP_UTILISATEUR:
				return MDP_UTILISATEUR_EDEFAULT == null ? mdpUtilisateur != null : !MDP_UTILISATEUR_EDEFAULT.equals(mdpUtilisateur);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case ModelPackage.UTILISATEUR___SE_CONNECTER__STRING_STRING:
				seConnecter((String)arguments.get(0), (String)arguments.get(1));
				return null;
		}
		return super.eInvoke(operationID, arguments);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (idUtilisateur: ");
		result.append(idUtilisateur);
		result.append(", nomUtilisateur: ");
		result.append(nomUtilisateur);
		result.append(", mdpUtilisateur: ");
		result.append(mdpUtilisateur);
		result.append(')');
		return result.toString();
	}

} //UtilisateurImpl
