/**
 */
package model.impl;

import java.lang.reflect.InvocationTargetException;

import model.ModelPackage;
import model.Personnage;
import model.Piece;
import model.Porte;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Piece</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link model.impl.PieceImpl#getIdPiece <em>Id Piece</em>}</li>
 *   <li>{@link model.impl.PieceImpl#getNomServeur <em>Nom Serveur</em>}</li>
 *   <li>{@link model.impl.PieceImpl#getPositionX <em>Position X</em>}</li>
 *   <li>{@link model.impl.PieceImpl#getPositionY <em>Position Y</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PieceImpl extends MinimalEObjectImpl.Container implements Piece {
	/**
	 * The default value of the '{@link #getIdPiece() <em>Id Piece</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIdPiece()
	 * @generated
	 * @ordered
	 */
	protected static final int ID_PIECE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getIdPiece() <em>Id Piece</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIdPiece()
	 * @generated
	 * @ordered
	 */
	protected int idPiece = ID_PIECE_EDEFAULT;

	/**
	 * The default value of the '{@link #getNomServeur() <em>Nom Serveur</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNomServeur()
	 * @generated
	 * @ordered
	 */
	protected static final String NOM_SERVEUR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNomServeur() <em>Nom Serveur</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNomServeur()
	 * @generated
	 * @ordered
	 */
	protected String nomServeur = NOM_SERVEUR_EDEFAULT;

	/**
	 * The default value of the '{@link #getPositionX() <em>Position X</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPositionX()
	 * @generated
	 * @ordered
	 */
	protected static final int POSITION_X_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getPositionX() <em>Position X</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPositionX()
	 * @generated
	 * @ordered
	 */
	protected int positionX = POSITION_X_EDEFAULT;

	/**
	 * The default value of the '{@link #getPositionY() <em>Position Y</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPositionY()
	 * @generated
	 * @ordered
	 */
	protected static final int POSITION_Y_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getPositionY() <em>Position Y</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPositionY()
	 * @generated
	 * @ordered
	 */
	protected int positionY = POSITION_Y_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PieceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.PIECE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getIdPiece() {
		return idPiece;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIdPiece(int newIdPiece) {
		int oldIdPiece = idPiece;
		idPiece = newIdPiece;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.PIECE__ID_PIECE, oldIdPiece, idPiece));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getNomServeur() {
		return nomServeur;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNomServeur(String newNomServeur) {
		String oldNomServeur = nomServeur;
		nomServeur = newNomServeur;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.PIECE__NOM_SERVEUR, oldNomServeur, nomServeur));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getPositionX() {
		return positionX;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPositionX(int newPositionX) {
		int oldPositionX = positionX;
		positionX = newPositionX;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.PIECE__POSITION_X, oldPositionX, positionX));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getPositionY() {
		return positionY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPositionY(int newPositionY) {
		int oldPositionY = positionY;
		positionY = newPositionY;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.PIECE__POSITION_Y, oldPositionY, positionY));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void fuir(Porte porteSortie, Piece piece, Personnage user) {
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
			case ModelPackage.PIECE__ID_PIECE:
				return getIdPiece();
			case ModelPackage.PIECE__NOM_SERVEUR:
				return getNomServeur();
			case ModelPackage.PIECE__POSITION_X:
				return getPositionX();
			case ModelPackage.PIECE__POSITION_Y:
				return getPositionY();
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
			case ModelPackage.PIECE__ID_PIECE:
				setIdPiece((Integer)newValue);
				return;
			case ModelPackage.PIECE__NOM_SERVEUR:
				setNomServeur((String)newValue);
				return;
			case ModelPackage.PIECE__POSITION_X:
				setPositionX((Integer)newValue);
				return;
			case ModelPackage.PIECE__POSITION_Y:
				setPositionY((Integer)newValue);
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
			case ModelPackage.PIECE__ID_PIECE:
				setIdPiece(ID_PIECE_EDEFAULT);
				return;
			case ModelPackage.PIECE__NOM_SERVEUR:
				setNomServeur(NOM_SERVEUR_EDEFAULT);
				return;
			case ModelPackage.PIECE__POSITION_X:
				setPositionX(POSITION_X_EDEFAULT);
				return;
			case ModelPackage.PIECE__POSITION_Y:
				setPositionY(POSITION_Y_EDEFAULT);
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
			case ModelPackage.PIECE__ID_PIECE:
				return idPiece != ID_PIECE_EDEFAULT;
			case ModelPackage.PIECE__NOM_SERVEUR:
				return NOM_SERVEUR_EDEFAULT == null ? nomServeur != null : !NOM_SERVEUR_EDEFAULT.equals(nomServeur);
			case ModelPackage.PIECE__POSITION_X:
				return positionX != POSITION_X_EDEFAULT;
			case ModelPackage.PIECE__POSITION_Y:
				return positionY != POSITION_Y_EDEFAULT;
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
			case ModelPackage.PIECE___FUIR__PORTE_PIECE_PERSONNAGE:
				fuir((Porte)arguments.get(0), (Piece)arguments.get(1), (Personnage)arguments.get(2));
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
		result.append(" (idPiece: ");
		result.append(idPiece);
		result.append(", nomServeur: ");
		result.append(nomServeur);
		result.append(", positionX: ");
		result.append(positionX);
		result.append(", positionY: ");
		result.append(positionY);
		result.append(')');
		return result.toString();
	}

} //PieceImpl
