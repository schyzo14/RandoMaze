/**
 */
package model.impl;

import model.Individu;
import model.Labyrinthe;
import model.LabyrintheImpl;
import model.ModelFactory;
import model.ModelPackage;
import model.Monstre;
import model.Partie;
import model.Personnage;
import model.Piece;
import model.Porte;
import model.Remote;
import model.UnicastRemoteObject;
import model.Utilisateur;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.uml2.types.TypesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ModelPackageImpl extends EPackageImpl implements ModelPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass individuEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass personnageEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pieceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass porteEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass monstreEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass partieEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass labyrintheImplEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass unicastRemoteObjectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass labyrintheEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass remoteEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass utilisateurEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see model.ModelPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ModelPackageImpl() {
		super(eNS_URI, ModelFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link ModelPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ModelPackage init() {
		if (isInited) return (ModelPackage)EPackage.Registry.INSTANCE.getEPackage(ModelPackage.eNS_URI);

		// Obtain or create and register package
		ModelPackageImpl theModelPackage = (ModelPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ModelPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ModelPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		TypesPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theModelPackage.createPackageContents();

		// Initialize created meta-data
		theModelPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theModelPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ModelPackage.eNS_URI, theModelPackage);
		return theModelPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIndividu() {
		return individuEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIndividu_Id() {
		return (EAttribute)individuEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIndividu_Nom() {
		return (EAttribute)individuEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIndividu_PointVie() {
		return (EAttribute)individuEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getIndividu__JeParle() {
		return individuEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPersonnage() {
		return personnageEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getPersonnage__CreerPersonnage__String() {
		return personnageEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getPersonnage__ToString() {
		return personnageEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getPersonnage__Save_Perso__Personnage_Piece_int() {
		return personnageEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getPersonnage__CreerPersonnage__String_int() {
		return personnageEClass.getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getPersonnage__Move__Piece_Porte() {
		return personnageEClass.getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPiece() {
		return pieceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPiece_IdPiece() {
		return (EAttribute)pieceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPiece_NomServeur() {
		return (EAttribute)pieceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPiece_PositionX() {
		return (EAttribute)pieceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPiece_PositionY() {
		return (EAttribute)pieceEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getPiece__Fuir__Porte_Piece_Personnage() {
		return pieceEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPorte() {
		return porteEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPorte_IdPorte() {
		return (EAttribute)porteEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPorte_SituationPorte() {
		return (EAttribute)porteEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMonstre() {
		return monstreEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getMonstre__CreateMonster() {
		return monstreEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPartie() {
		return partieEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getPartie__JouerTour() {
		return partieEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getPartie__Quitter() {
		return partieEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getPartie__RetDemandeConfirmation() {
		return partieEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getPartie__Confirmation__boolean() {
		return partieEClass.getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getPartie__Sauvegarde__Individu() {
		return partieEClass.getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getPartie__AfficherJoueur__int_Personnage() {
		return partieEClass.getEOperations().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLabyrintheImpl() {
		return labyrintheImplEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUnicastRemoteObject() {
		return unicastRemoteObjectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLabyrinthe() {
		return labyrintheEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRemote() {
		return remoteEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUtilisateur() {
		return utilisateurEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUtilisateur_IdUtilisateur() {
		return (EAttribute)utilisateurEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUtilisateur_NomUtilisateur() {
		return (EAttribute)utilisateurEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUtilisateur_MdpUtilisateur() {
		return (EAttribute)utilisateurEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getUtilisateur__SeConnecter__String_String() {
		return utilisateurEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelFactory getModelFactory() {
		return (ModelFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		individuEClass = createEClass(INDIVIDU);
		createEAttribute(individuEClass, INDIVIDU__ID);
		createEAttribute(individuEClass, INDIVIDU__NOM);
		createEAttribute(individuEClass, INDIVIDU__POINT_VIE);
		createEOperation(individuEClass, INDIVIDU___JE_PARLE);

		personnageEClass = createEClass(PERSONNAGE);
		createEOperation(personnageEClass, PERSONNAGE___CREER_PERSONNAGE__STRING);
		createEOperation(personnageEClass, PERSONNAGE___TO_STRING);
		createEOperation(personnageEClass, PERSONNAGE___SAVE_PERSO__PERSONNAGE_PIECE_INT);
		createEOperation(personnageEClass, PERSONNAGE___CREER_PERSONNAGE__STRING_INT);
		createEOperation(personnageEClass, PERSONNAGE___MOVE__PIECE_PORTE);

		pieceEClass = createEClass(PIECE);
		createEAttribute(pieceEClass, PIECE__ID_PIECE);
		createEAttribute(pieceEClass, PIECE__NOM_SERVEUR);
		createEAttribute(pieceEClass, PIECE__POSITION_X);
		createEAttribute(pieceEClass, PIECE__POSITION_Y);
		createEOperation(pieceEClass, PIECE___FUIR__PORTE_PIECE_PERSONNAGE);

		porteEClass = createEClass(PORTE);
		createEAttribute(porteEClass, PORTE__ID_PORTE);
		createEAttribute(porteEClass, PORTE__SITUATION_PORTE);

		monstreEClass = createEClass(MONSTRE);
		createEOperation(monstreEClass, MONSTRE___CREATE_MONSTER);

		partieEClass = createEClass(PARTIE);
		createEOperation(partieEClass, PARTIE___JOUER_TOUR);
		createEOperation(partieEClass, PARTIE___QUITTER);
		createEOperation(partieEClass, PARTIE___RET_DEMANDE_CONFIRMATION);
		createEOperation(partieEClass, PARTIE___CONFIRMATION__BOOLEAN);
		createEOperation(partieEClass, PARTIE___SAUVEGARDE__INDIVIDU);
		createEOperation(partieEClass, PARTIE___AFFICHER_JOUEUR__INT_PERSONNAGE);

		labyrintheImplEClass = createEClass(LABYRINTHE_IMPL);

		unicastRemoteObjectEClass = createEClass(UNICAST_REMOTE_OBJECT);

		labyrintheEClass = createEClass(LABYRINTHE);

		remoteEClass = createEClass(REMOTE);

		utilisateurEClass = createEClass(UTILISATEUR);
		createEAttribute(utilisateurEClass, UTILISATEUR__ID_UTILISATEUR);
		createEAttribute(utilisateurEClass, UTILISATEUR__NOM_UTILISATEUR);
		createEAttribute(utilisateurEClass, UTILISATEUR__MDP_UTILISATEUR);
		createEOperation(utilisateurEClass, UTILISATEUR___SE_CONNECTER__STRING_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		TypesPackage theTypesPackage = (TypesPackage)EPackage.Registry.INSTANCE.getEPackage(TypesPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		personnageEClass.getESuperTypes().add(this.getIndividu());
		monstreEClass.getESuperTypes().add(this.getIndividu());
		labyrintheImplEClass.getESuperTypes().add(this.getUnicastRemoteObject());
		labyrintheEClass.getESuperTypes().add(this.getRemote());

		// Initialize classes, features, and operations; add parameters
		initEClass(individuEClass, Individu.class, "Individu", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIndividu_Id(), theTypesPackage.getInteger(), "id", null, 1, 1, Individu.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getIndividu_Nom(), theTypesPackage.getString(), "nom", null, 1, 1, Individu.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getIndividu_PointVie(), theTypesPackage.getInteger(), "pointVie", null, 1, 1, Individu.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEOperation(getIndividu__JeParle(), null, "jeParle", 1, 1, IS_UNIQUE, !IS_ORDERED);

		initEClass(personnageEClass, Personnage.class, "Personnage", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		EOperation op = initEOperation(getPersonnage__CreerPersonnage__String(), null, "creerPersonnage", 1, 1, IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, theTypesPackage.getString(), "nom", 1, 1, IS_UNIQUE, !IS_ORDERED);

		initEOperation(getPersonnage__ToString(), null, "toString", 1, 1, IS_UNIQUE, !IS_ORDERED);

		op = initEOperation(getPersonnage__Save_Perso__Personnage_Piece_int(), null, "save_Perso", 1, 1, IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, this.getPersonnage(), "perso", 1, 1, IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, this.getPiece(), "piece", 1, 1, IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, theTypesPackage.getInteger(), "pv", 1, 1, IS_UNIQUE, !IS_ORDERED);

		op = initEOperation(getPersonnage__CreerPersonnage__String_int(), null, "creerPersonnage", 1, 1, IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, theTypesPackage.getString(), "nom", 1, 1, IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, theTypesPackage.getInteger(), "idUtilisateur", 1, 1, IS_UNIQUE, !IS_ORDERED);

		op = initEOperation(getPersonnage__Move__Piece_Porte(), null, "move", 1, 1, IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, this.getPiece(), "salle", 1, 1, IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, this.getPorte(), "porte", 1, 1, IS_UNIQUE, !IS_ORDERED);

		initEClass(pieceEClass, Piece.class, "Piece", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPiece_IdPiece(), theTypesPackage.getInteger(), "idPiece", null, 1, 1, Piece.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getPiece_NomServeur(), theTypesPackage.getString(), "nomServeur", null, 1, 1, Piece.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getPiece_PositionX(), theTypesPackage.getInteger(), "positionX", null, 1, 1, Piece.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getPiece_PositionY(), theTypesPackage.getInteger(), "positionY", null, 1, 1, Piece.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		op = initEOperation(getPiece__Fuir__Porte_Piece_Personnage(), null, "fuir", 1, 1, IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, this.getPorte(), "porteSortie", 1, 1, IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, this.getPiece(), "piece", 1, 1, IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, this.getPersonnage(), "user", 1, 1, IS_UNIQUE, !IS_ORDERED);

		initEClass(porteEClass, Porte.class, "Porte", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPorte_IdPorte(), theTypesPackage.getInteger(), "idPorte", null, 1, 1, Porte.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getPorte_SituationPorte(), theTypesPackage.getString(), "situationPorte", null, 1, 1, Porte.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(monstreEClass, Monstre.class, "Monstre", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEOperation(getMonstre__CreateMonster(), null, "createMonster", 1, 1, IS_UNIQUE, !IS_ORDERED);

		initEClass(partieEClass, Partie.class, "Partie", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEOperation(getPartie__JouerTour(), null, "jouerTour", 1, 1, IS_UNIQUE, !IS_ORDERED);

		initEOperation(getPartie__Quitter(), null, "quitter", 1, 1, IS_UNIQUE, !IS_ORDERED);

		initEOperation(getPartie__RetDemandeConfirmation(), null, "retDemandeConfirmation", 1, 1, IS_UNIQUE, !IS_ORDERED);

		op = initEOperation(getPartie__Confirmation__boolean(), null, "confirmation", 1, 1, IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, theTypesPackage.getBoolean(), "reponse", 1, 1, IS_UNIQUE, !IS_ORDERED);

		op = initEOperation(getPartie__Sauvegarde__Individu(), null, "sauvegarde", 1, 1, IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, this.getIndividu(), "joueur", 1, 1, IS_UNIQUE, !IS_ORDERED);

		op = initEOperation(getPartie__AfficherJoueur__int_Personnage(), null, "afficherJoueur", 1, 1, IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, theTypesPackage.getInteger(), "position", 1, 1, IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, this.getPersonnage(), "id", 1, 1, IS_UNIQUE, !IS_ORDERED);

		initEClass(labyrintheImplEClass, LabyrintheImpl.class, "LabyrintheImpl", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(unicastRemoteObjectEClass, UnicastRemoteObject.class, "UnicastRemoteObject", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(labyrintheEClass, Labyrinthe.class, "Labyrinthe", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(remoteEClass, Remote.class, "Remote", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(utilisateurEClass, Utilisateur.class, "Utilisateur", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getUtilisateur_IdUtilisateur(), theTypesPackage.getInteger(), "idUtilisateur", null, 1, 1, Utilisateur.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getUtilisateur_NomUtilisateur(), theTypesPackage.getString(), "nomUtilisateur", null, 1, 1, Utilisateur.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getUtilisateur_MdpUtilisateur(), theTypesPackage.getString(), "mdpUtilisateur", null, 1, 1, Utilisateur.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		op = initEOperation(getUtilisateur__SeConnecter__String_String(), null, "seConnecter", 1, 1, IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, theTypesPackage.getString(), "id", 1, 1, IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, theTypesPackage.getString(), "mdp", 1, 1, IS_UNIQUE, !IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //ModelPackageImpl
