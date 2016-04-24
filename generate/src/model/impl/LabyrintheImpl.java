/**
 */
package model.impl;

import model.Labyrinthe;
import model.ModelPackage;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Labyrinthe Impl</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class LabyrintheImpl extends UnicastRemoteObject implements Labyrinthe {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4845385714813023620L;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @throws RemoteException 
	 * @generated
	 */
	protected LabyrintheImpl() throws RemoteException {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass eStaticClass() {
		return ModelPackage.Literals.LABYRINTHE;
	}

} //LabyrintheImpl
