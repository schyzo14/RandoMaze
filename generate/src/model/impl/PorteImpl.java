/**
 */
package model.impl;

import model.ModelPackage;
import model.Porte;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Porte</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link model.impl.PorteImpl#getIdPorte <em>Id Porte</em>}</li>
 *   <li>{@link model.impl.PorteImpl#getSituationPorte <em>Situation Porte</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PorteImpl extends MinimalEObjectImpl.Container implements Porte {
	/**
	 * The default value of the '{@link #getIdPorte() <em>Id Porte</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIdPorte()
	 * @generated
	 * @ordered
	 */
	protected static final int ID_PORTE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getIdPorte() <em>Id Porte</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIdPorte()
	 * @generated
	 * @ordered
	 */
	protected int idPorte = ID_PORTE_EDEFAULT;

	/**
	 * The default value of the '{@link #getSituationPorte() <em>Situation Porte</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSituationPorte()
	 * @generated
	 * @ordered
	 */
	protected static final String SITUATION_PORTE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSituationPorte() <em>Situation Porte</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSituationPorte()
	 * @generated
	 * @ordered
	 */
	protected String situationPorte = SITUATION_PORTE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PorteImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.PORTE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getIdPorte() {
		return idPorte;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIdPorte(int newIdPorte) {
		int oldIdPorte = idPorte;
		idPorte = newIdPorte;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.PORTE__ID_PORTE, oldIdPorte, idPorte));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSituationPorte() {
		return situationPorte;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSituationPorte(String newSituationPorte) {
		String oldSituationPorte = situationPorte;
		situationPorte = newSituationPorte;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.PORTE__SITUATION_PORTE, oldSituationPorte, situationPorte));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ModelPackage.PORTE__ID_PORTE:
				return getIdPorte();
			case ModelPackage.PORTE__SITUATION_PORTE:
				return getSituationPorte();
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
			case ModelPackage.PORTE__ID_PORTE:
				setIdPorte((Integer)newValue);
				return;
			case ModelPackage.PORTE__SITUATION_PORTE:
				setSituationPorte((String)newValue);
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
			case ModelPackage.PORTE__ID_PORTE:
				setIdPorte(ID_PORTE_EDEFAULT);
				return;
			case ModelPackage.PORTE__SITUATION_PORTE:
				setSituationPorte(SITUATION_PORTE_EDEFAULT);
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
			case ModelPackage.PORTE__ID_PORTE:
				return idPorte != ID_PORTE_EDEFAULT;
			case ModelPackage.PORTE__SITUATION_PORTE:
				return SITUATION_PORTE_EDEFAULT == null ? situationPorte != null : !SITUATION_PORTE_EDEFAULT.equals(situationPorte);
		}
		return super.eIsSet(featureID);
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
		result.append(" (idPorte: ");
		result.append(idPorte);
		result.append(", situationPorte: ");
		result.append(situationPorte);
		result.append(')');
		return result.toString();
	}

} //PorteImpl
