/**
 */
package model.impl;

import model.Individu;
import model.Labyrinthe;
import model.ModelFactory;
import model.ModelPackage;
import model.Monstre;
import model.Partie;
import model.Personnage;
import model.Piece;
import model.Porte;
import model.Utilisateur;

import java.rmi.RemoteException;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ModelFactoryImpl extends EFactoryImpl implements ModelFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ModelFactory init() {
		try {
			ModelFactory theModelFactory = (ModelFactory)EPackage.Registry.INSTANCE.getEFactory(ModelPackage.eNS_URI);
			if (theModelFactory != null) {
				return theModelFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ModelFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case ModelPackage.INDIVIDU: return createIndividu();
			case ModelPackage.PERSONNAGE: return createPersonnage();
			case ModelPackage.PIECE: return createPiece();
			case ModelPackage.PORTE: return createPorte();
			case ModelPackage.MONSTRE: return createMonstre();
			case ModelPackage.PARTIE: return createPartie();
			case ModelPackage.LABYRINTHE: return (EObject) createLabyrinthe();
			case ModelPackage.UTILISATEUR: return createUtilisateur();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Individu createIndividu() {
		IndividuImpl individu = new IndividuImpl();
		return individu;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Personnage createPersonnage() {
		PersonnageImpl personnage = new PersonnageImpl();
		return personnage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Piece createPiece() {
		PieceImpl piece = new PieceImpl();
		return piece;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Porte createPorte() {
		PorteImpl porte = new PorteImpl();
		return porte;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Monstre createMonstre() {
		MonstreImpl monstre = new MonstreImpl();
		return monstre;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Partie createPartie() {
		PartieImpl partie = new PartieImpl();
		return partie;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @throws RemoteException 
	 * @generated
	 */
	public Labyrinthe createLabyrintheImpl() throws RemoteException {
		LabyrintheImpl labyrinthe = new LabyrintheImpl();
		return labyrinthe;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Utilisateur createUtilisateur() {
		UtilisateurImpl utilisateur = new UtilisateurImpl();
		return utilisateur;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelPackage getModelPackage() {
		return (ModelPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ModelPackage getPackage() {
		return ModelPackage.eINSTANCE;
	}

	@Override
	public Labyrinthe createLabyrinthe() {
		// TODO Auto-generated method stub
		return null;
	}

} //ModelFactoryImpl
