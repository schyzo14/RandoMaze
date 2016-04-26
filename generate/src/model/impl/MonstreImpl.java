/**
 */
package model.impl;

import java.lang.reflect.InvocationTargetException;

import model.ModelPackage;
import model.Monstre;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Monstre</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class MonstreImpl extends IndividuImpl implements Monstre {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MonstreImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.MONSTRE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createMonster() {
		MonstreImpl monstre = new MonstreImpl();
		monstre.setPointVie(5);
		
		int val = 1 + ((int)Math.random() * (4 - 1));
		
		switch (val) {
			case 1:
				monstre.setId(1);
				monstre.setNom("Méchant 1");
				break;
			case 2:
				monstre.setId(2);
				monstre.setNom("Méchant 2");
				break;
			case 3:
				monstre.setId(3);
				monstre.setNom("Méchant 3");
				break;
			case 4:
				monstre.setId(4);
				monstre.setNom("Méchant 4");
				break;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case ModelPackage.MONSTRE___CREATE_MONSTER:
				createMonster();
				return null;
		}
		return super.eInvoke(operationID, arguments);
	}

} //MonstreImpl
